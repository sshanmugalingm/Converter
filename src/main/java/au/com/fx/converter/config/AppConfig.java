package au.com.fx.converter.config;

import au.com.fx.converter.service.FxConversionService;
import au.com.fx.converter.service.FxConversionServiceImpl;
import au.com.fx.converter.service.factory.RateConversionHandlerFactory;
import au.com.fx.converter.service.factory.RateConvertionHandlerFactoryImpl;
import au.com.fx.converter.service.handler.*;
import au.com.fx.converter.ui.console.FxConsole;
import au.com.fx.converter.ui.console.FxConsoleImpl;
import au.com.fx.converter.ui.handler.ExceptionHandler;
import au.com.fx.converter.ui.handler.ExceptionHandlerImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by senthurshanmugalingm on 9/05/2017.
 */
@Configuration
@Import(PersistenceConfig.class)
@EnableJpaRepositories("au.com.fx.converter.repository")
public class AppConfig {

    @Bean
    public FxConsole fxConsole() {
        return new FxConsoleImpl();
    }

    @Bean
    @Transactional
    public FxConversionService fxConversionService() {
        return new FxConversionServiceImpl();
    }

    @Bean
    public RateConversionHandlerFactory rateConversionHandlerFactory() {
        return new RateConvertionHandlerFactoryImpl();
    }

    @Bean
    public RateConversionHandler rateConversionHandler() {
        return new RateConversionHandlerImpl();
    }

    @Bean
    public RateConversionHandler crossRateConversionHandler() {
        return new CrossRateConversionHandlerImpl();
    }

    @Bean
    public RateConversionHandler directRateConversionHandler() {
        return new DirectRateConversionHandlerImpl();
    }

    @Bean
    public RateConversionHandler invertRateConversionHandler() {
        return new InvertRateConversionHandlerImpl();
    }

    @Bean
    public RateConversionHandler unityRateConversionHandler() {
        return new UnityRateConversionHandlerImpl();
    }

    @Bean
    public ExceptionHandler exceptionHandler() {
        return new ExceptionHandlerImpl();
    }
}
