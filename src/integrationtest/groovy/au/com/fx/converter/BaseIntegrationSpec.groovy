package au.com.fx.converter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification
import spock.lang.Stepwise


/**
 * Created by senthurshanmugalingm on 7/05/2017.
 */

@ContextConfiguration(locations = 'classpath:/spring/applicationContext.xml')
@Stepwise
class BaseIntegrationSpec extends Specification {

    @Autowired
    ApplicationContext context

    def "should bootup without any errors"() {
        expect : "Context exists"
        context != null
    }

}