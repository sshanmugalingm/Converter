package au.com.fx.converter.handler

import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import spock.lang.Specification


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class UnityRateConversionHandlerImplSpec extends Specification {

    RateConversionHandler unityRateConversionHandler

    def setup() {
        unityRateConversionHandler = new UnityRateConversionHandlerImpl()
    }

    def cleanup() {

    }

    def "process, should calculate the Unity Exchange Rate, when a valid Conversion chart and amount is passed"() {
        when :
        Double calculatedRate = unityRateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'AUD'), destinationCurrency: new Currency(code: 'AUD')), 100D)

        then :
        unityRateConversionHandler.rateConversionHandler = Mock(RateConversionHandlerImpl) {
            1 * process(*_) >> {ConversionChart chart, Double amount ->
                return amount
            }
        }

        and :
        calculatedRate == new Double(100)
    }
}