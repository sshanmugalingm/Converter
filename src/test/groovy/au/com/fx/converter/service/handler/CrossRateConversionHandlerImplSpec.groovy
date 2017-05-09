package au.com.fx.converter.service.handler

import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import au.com.fx.converter.repository.ConversionChartRepository
import spock.lang.Specification


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class CrossRateConversionHandlerImplSpec extends Specification {

    RateConversionHandler crossRateConversionHandler

    def setup() {
        crossRateConversionHandler = new CrossRateConversionHandlerImpl()
    }

    def cleanup() {

    }

    def "process, should calculate the Cross Currency Exchange Rate, when a valid Conversion chart and amount is passed"() {
        when :
        Double calculatedRate = crossRateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'JPY'), destinationCurrency: new Currency(code: 'NOK'), referenceCurrency: new Currency(code: 'USD')), 100D)

        then :
        crossRateConversionHandler.conversionChartRepository = Mock(ConversionChartRepository) {
            2 * findBySourceCurrencyAndDestinationCurrency(*_) >> {Currency sourceCurrency, Currency destinationCurrency ->
                return destinationCurrency.code == 'USD' ? new ConversionChart(sourceCurrency: new Currency(code: 'JPY'), destinationCurrency: new Currency(code: 'USD')) :
                        new ConversionChart(sourceCurrency: new Currency(code: 'USD'), destinationCurrency: new Currency(code: 'NOK'))
            }
        }

        and :
        crossRateConversionHandler.rateConversionHandler = Mock(RateConversionHandlerImpl) {
            2 * process(*_) >> {ConversionChart chart, BigDecimal amount ->
                return chart.destinationCurrency.code == 'USD' ? new BigDecimal(0.0083) : new BigDecimal(10)
            }
        }

        and :
        calculatedRate == new BigDecimal(10)
    }
}