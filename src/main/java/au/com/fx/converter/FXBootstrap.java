package au.com.fx.converter;

import au.com.fx.converter.config.AppConfig;
import au.com.fx.converter.ui.console.FxConsole;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Bootstrap class to Spin Up the Application.
 * @author senthurshanmugalingm.
 */
public class FXBootstrap {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        FxConsole console = ctx.getBean(FxConsole.class);
        console.startConsole();
    }
}
