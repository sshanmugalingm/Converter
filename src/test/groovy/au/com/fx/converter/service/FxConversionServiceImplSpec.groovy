package au.com.fx.converter.service

import au.com.fx.converter.commons.enums.ConversionType
import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import au.com.fx.converter.repository.ConversionChartRepository
import au.com.fx.converter.repository.CurrencyRepository
import au.com.fx.converter.service.handler.RateConversionHandler
import spock.lang.Specification
import spock.lang.Unroll


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class FxConversionServiceImplSpec extends Specification {


    FxConversionService fxConversionService

    def setup() {
        fxConversionService = new FxConversionServiceImpl()
    }

    def cleanup() {

    }

    @Unroll
    def "convert, should throw exception, when #paramUnderTest is null"() {
        when :
        fxConversionService.convert(baseCurrency, termCurrency, amount)

        then :
        IllegalArgumentException e = thrown()
        e.message == errorMessage

        where :
        paramUnderTest       | baseCurrency   | termCurrency   | amount               | errorMessage
        'Base Currency Code' | null           | 'USD'          | new Double(10) | 'Base Currency Code cannot be null.'
        'Term Currency Code' | 'AUD'          | null           | new Double(10) | 'Term Currency Code cannot be null.'
        'Amount'             | 'AUD'          | 'USD'          | null                 | 'Conversion Amount cannot be null.'

    }

    @Unroll
    def "convert, should throw exception, when the System cannot find the currency for #paramUnderTest"() {
        given :
        fxConversionService.currencyRepository = Mock(CurrencyRepository) {
            interactions * findByCode(_) >> {String currencyCode ->
                return currencyCode == 'EUR' ? new Currency() : null
            }
        }

        when :
        fxConversionService.convert(baseCurrency, termCurrency, 10D)

        then :
        IllegalArgumentException e = thrown()
        e.message == errorMessage

        where :
        paramUnderTest       | baseCurrency   | termCurrency | errorMessage                         | interactions
        'Base Currency Code' | 'AUD'          | 'USD'        | 'Unable to find Base Currency : AUD' | 1
        'Term Currency Code' | 'EUR'          | 'USD'        | 'Unable to find Term Currency : USD' | 2
    }

    def "convert, should throw exception, when the System cannot find the Conversion Chart for Base Currency and Term Currency"() {
        given :
        fxConversionService.currencyRepository = Mock(CurrencyRepository) {
            2 * findByCode(_) >> {String currencyCode ->
                return new Currency(code: currencyCode)
            }
        }

        and :
        fxConversionService.conversionMatrixRepository = Mock(ConversionChartRepository) {
            findBySourceCurrencyAndDestinationCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return null
            }
        }

        when :
        fxConversionService.convert('AUD', 'USD', 10D)

        then :
        IllegalArgumentException e = thrown()
        e.message == 'Unable to find Rate for AUD/USD'
    }

    def "convert, should convert the Amount from Base Currency to Term Currency, when Base and Term Currency codes are valid"() {
        given :
        fxConversionService.currencyRepository = Mock(CurrencyRepository) {
            2 * findByCode(_) >> {String currencyCode ->
                return new Currency(code: currencyCode, decimalPlaces: 2)
            }
        }

        and :
        fxConversionService.conversionMatrixRepository = Mock(ConversionChartRepository) {
            findBySourceCurrencyAndDestinationCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return new ConversionChart(sourceCurrency: baseCurrency, destinationCurrency: termCurrency, conversionType: ConversionType.DIRECT)
            }
        }

        and :
        fxConversionService.rateConversionHandler = Mock(RateConversionHandler) {
            process(*_) >> {ConversionChart conversionChart, BigDecimal amount ->
                return new BigDecimal(78.665865)
            }
        }

        when :
        BigDecimal convertedRate = fxConversionService.convert('AUD', 'USD', new BigDecimal(10))

        then :
        convertedRate.toPlainString() == '786.66'
    }

    @Unroll
    def "convert, should convert the amount to the provided precision(#precision) of the Term Currency(#termCurrencyCode), when Base and Term Currency codes are valid"() {
        given :
        fxConversionService.currencyRepository = Mock(CurrencyRepository) {
            2 * findByCode(_) >> {String currencyCode ->
                return new Currency(code: currencyCode, decimalPlaces: precision)
            }
        }

        and :
        fxConversionService.conversionMatrixRepository = Mock(ConversionChartRepository) {
            findBySourceCurrencyAndDestinationCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return new ConversionChart(sourceCurrency: baseCurrency, destinationCurrency: termCurrency, conversionType: ConversionType.DIRECT)
            }
        }

        and :
        fxConversionService.rateConversionHandler = Mock(RateConversionHandler) {
            process(*_) >> {ConversionChart conversionChart, BigDecimal amount ->
                return new BigDecimal(1.1568856)
            }
        }

        when :
        BigDecimal convertedRate = fxConversionService.convert('AUD', termCurrencyCode, new BigDecimal(1D))

        then :
        convertedRate.toPlainString() == expectedResult

        where :
        termCurrencyCode | precision | expectedResult
        'USD'            | 2         | '1.16'
        'JPY'            | 0         | '1'
    }

}