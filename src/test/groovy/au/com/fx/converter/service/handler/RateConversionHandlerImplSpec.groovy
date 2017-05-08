package au.com.fx.converter.service.handler

import au.com.fx.converter.commons.enums.ConversionType
import au.com.fx.converter.domain.ConversionChart
import au.com.fx.converter.domain.Currency
import au.com.fx.converter.service.factory.RateConversionHandlerFactory
import spock.lang.Specification

/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class RateConversionHandlerImplSpec extends Specification {

    RateConversionHandler rateConversionHandler

    def setup() {
        rateConversionHandler = new RateConversionHandlerImpl()
    }

    def cleanup() {

    }

    def "process, should return the data passed, when the Conversion Chart is null"() {
        expect :
        rateConversionHandler.process(null, 100D) == 100D
    }

    def "process, should pass the processing to the relevant handler based on the Conversion Type, when a valid Conversion Chart and amount is passed"() {
        when :
        rateConversionHandler.process(new ConversionChart(sourceCurrency: new Currency(code: 'AUD'), destinationCurrency: new Currency(code: 'USD'), conversionType: ConversionType.INVERSE), 100D)

        then :
        rateConversionHandler.rateConversionHandlerFactory = Spy(RateConversionHandlerFactory) {
            1* getConversionHandler(_) >> {ConversionType conversionType ->
                return Mock(InvertRateConversionHandlerImpl) {
                   1 * process(*_) >> {ConversionChart conversionChart, Double amount ->
                       return 1D
                   }
                }
            }
        }
    }
}