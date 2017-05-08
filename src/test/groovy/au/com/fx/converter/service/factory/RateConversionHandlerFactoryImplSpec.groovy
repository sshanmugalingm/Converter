package au.com.fx.converter.service.factory

import au.com.fx.converter.commons.enums.ConversionType
import au.com.fx.converter.service.handler.CrossRateConversionHandlerImpl
import au.com.fx.converter.service.handler.DirectRateConversionHandlerImpl
import au.com.fx.converter.service.handler.InvertRateConversionHandlerImpl
import au.com.fx.converter.service.handler.UnityRateConversionHandlerImpl
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */

class RateConversionHandlerFactoryImplSpec extends Specification {

    RateConversionHandlerFactory rateConversionHandlerFactory

    def setup() {
        Map conversionHandlers = [
                'crossRateConversionHandler'  : new CrossRateConversionHandlerImpl(),
                'directRateConversionHandler' : new DirectRateConversionHandlerImpl(),
                'invertRateConversionHandler' : new InvertRateConversionHandlerImpl(),
                'unityRateConversionHandler'  : new UnityRateConversionHandlerImpl()
        ]

        rateConversionHandlerFactory = new RateConvertionHandlerFactoryImpl()
        rateConversionHandlerFactory.setRateConversionHandlerMap(conversionHandlers)
    }

    def cleanup() {

    }

    def "getConversionHandler, should return null, when the passed conversion type is null"() {
        expect :
        !rateConversionHandlerFactory.getConversionHandler(null)
    }

    @Unroll
    def "getConversionHandler, should return the #expectedClassName, when the passed parameter is #conversionType"() {
        expect :
        rateConversionHandlerFactory.getConversionHandler(conversionType)?.class.name == expectedClassName

        where :
        conversionType               | expectedClassName
        ConversionType.CROSSCURRENCY | CrossRateConversionHandlerImpl.class.name
        ConversionType.DIRECT        | DirectRateConversionHandlerImpl.class.name
        ConversionType.UNITY         | UnityRateConversionHandlerImpl.class.name
        ConversionType.INVERSE       | InvertRateConversionHandlerImpl.class.name
    }

}
