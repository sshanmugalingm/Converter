package au.com.fx.converter.factory

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@ContextConfiguration(locations = ["classpath:spring/applicationContext.xml"])
class RateConversionHandlerFactorySpec extends Specification {

    @Autowired
    RateConversionHandlerFactory rateConversionHandlerFactory

    def "rateConversionHandlerFactory, instance should not be null"() {
        expect :
        rateConversionHandlerFactory
    }

}
