package au.com.fx.converter.service.handler

import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import au.com.fx.converter.domain.ExchangeRate
import au.com.fx.converter.repository.ExchangeRateRepository
import spock.lang.Specification


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class InvertRateConversionHandlerImplSpec extends Specification {

    RateConversionHandler invertRateConversionHandler

    def setup() {
        invertRateConversionHandler = new InvertRateConversionHandlerImpl()
    }

    def cleanup() {

    }

    def "process, should calculate the Inverted Exchange Rate, when a valid Conversion Chart and Amount is passed"() {

        when :
        BigDecimal convertedAmount = invertRateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'USD'), destinationCurrency: new Currency(code: 'AUD')), new BigDecimal(10))

        then :
        invertRateConversionHandler.exchangeRateRepository = Mock(ExchangeRateRepository) {
            1 * findByBaseCurrencyAndTermCurrency(*_) >> {Currency baseCurrency, Currency termCurrency ->
                return new ExchangeRate(baseCurrency: baseCurrency, termCurrency: termCurrency, rate: new BigDecimal(0.8371))
            }
        }

        and :
        invertRateConversionHandler.rateConversionHandler = Mock(RateConversionHandlerImpl) {
            1 * process(*_) >> {ConversionChart chart, BigDecimal amount ->
                return amount
            }
        }

        and :
        convertedAmount.setScale(2, BigDecimal.ROUND_HALF_UP) == new BigDecimal(11.946).setScale(2, BigDecimal.ROUND_HALF_UP)
    }


}