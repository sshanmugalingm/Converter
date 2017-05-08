package au.com.fx.converter;

import au.com.fx.converter.ui.console.FxConsole;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
public class FXBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");
        FxConsole console = ctx.getBean(FxConsole.class);
        console.startConsole();
    }
}
