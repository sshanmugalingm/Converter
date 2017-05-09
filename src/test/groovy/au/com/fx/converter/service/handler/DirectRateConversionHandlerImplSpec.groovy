package au.com.fx.converter.service.handler

import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import au.com.fx.converter.domain.ExchangeRate
import au.com.fx.converter.repository.ExchangeRateRepository
import spock.lang.Specification


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class DirectRateConversionHandlerImplSpec extends Specification {

    RateConversionHandler directRateConversionHandler

    def setup() {
        directRateConversionHandler = new DirectRateConversionHandlerImpl()
    }

    def cleanup() {

    }

    def "process, should throw exception, when the Exchange rate is null"() {
        given :
        directRateConversionHandler.exchangeRateRepository = Mock(ExchangeRateRepository) {
            1 * findByBaseCurrencyAndTermCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return null
            }
        }

        when :
        directRateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'AUD'), destinationCurrency: new Currency(code: 'USD')), new BigDecimal(10))

        then :
        thrown(IllegalArgumentException)
    }

    def "process, should calculate the Direct Exchange Rate, when a valid Conversion Chart and Amount is passed"() {

        when :
        BigDecimal convertedAmount = directRateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'AUD'), destinationCurrency: new Currency(code: 'USD')), new BigDecimal(10))

        then :
        directRateConversionHandler.exchangeRateRepository = Mock(ExchangeRateRepository) {
            1 * findByBaseCurrencyAndTermCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return new ExchangeRate(baseCurrency: baseCurrency, termCurrency: termCurrency, rate: new BigDecimal(0.8371))
            }
        }

        and :
        directRateConversionHandler.rateConversionHandler = Mock(RateConversionHandlerImpl) {
            1 * process(*_) >> {ConversionChart chart, BigDecimal amount ->
                return amount
            }
        }

        and :
        convertedAmount.setScale(2, BigDecimal.ROUND_HALF_UP) == new BigDecimal(8.370999).setScale(2, BigDecimal.ROUND_HALF_UP)
    }


}