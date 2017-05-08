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
        thrown(IllegalArgumentException)

        where :
        paramUnderTest       | baseCurrency   | termCurrency   | amount
        'Base Currency Code' | null           | 'USD'          | new Double(10)
        'Term Currency Code' | 'AUD'          | null           | new Double(10)
        'Amount'             | 'AUD'          | 'USD'          | null

    }

    def "convert, should throw exception, when the System cannot find the currency for #paramUnderTest"() {
        given :
        fxConversionService.currencyRepository = Mock(CurrencyRepository) {
            1 * findByCode(_) >> {String currencyCode ->
                return null
            }
        }

        when :
        fxConversionService.convert(baseCurrency, termCurrency, 10D)

        then :
        thrown(IllegalArgumentException)

        where :
        paramUnderTest       | baseCurrency   | termCurrency
        'Base Currency Code' | 'AUD'          | 'USD'
        'Term Currency Code' | 'AUD'          | 'USD'
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
        thrown(IllegalArgumentException)
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
            process(*_) >> {ConversionChart conversionChart, Double amount ->
                return new Double(78.665865)
            }
        }

        when :
        BigDecimal convertedRate = fxConversionService.convert('AUD', 'USD', 10D)

        then :
        convertedRate.toPlainString() == '786.65'
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
            process(*_) >> {ConversionChart conversionChart, Double amount ->
                return new Double(1.1568856)
            }
        }

        when :
        BigDecimal convertedRate = fxConversionService.convert('AUD', termCurrencyCode, 1D)

        then :
        convertedRate.toPlainString() == expectedResult

        where :
        termCurrencyCode | precision | expectedResult
        'USD'            | 2         | '1.15'
        'JPY'            | 0         | '1'
    }


    def "c"() {
        when :
        String pattern = "[A-Z]{3}\\s+\\d*(\\.\\d+)?+\\s+in+\\s[A-Z]{3}"


        then :
        "USD 123.00 in USD".matches(pattern)
        println (String.format("Unable to find Rate for %1s %2s", "DF", "dffd"))
    }

}