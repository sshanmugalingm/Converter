package au.com.fx.converter;

import au.com.fx.converter.repository.CurrencyRepository;
import au.com.fx.converter.repository.ExchangeRateRepository;
import au.com.fx.converter.service.FxConversionService;
import au.com.fx.converter.service.FxConversionServiceImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
public class FXBootstrap {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/spring/applicationContext.xml");

        //TODO Clean up this after adding test cases
        CurrencyRepository repo = ctx.getBean(CurrencyRepository.class);
        System.out.println("Finding ALL Currencies ::: " + repo.findAll());

        ExchangeRateRepository exchangeRateRepository = ctx.getBean(ExchangeRateRepository.class);
        System.out.println("Find ALl Rates::: " + exchangeRateRepository.findAll());

        FxConversionService fxConversionService = ctx.getBean(FxConversionServiceImpl.class);
        Double exchangeRate = fxConversionService.convert("JPY", "NOK", 1D);
        //Double exchangeRate = fxConversionService.convert("AUD", "USD", 200D);
        //Double exchangeRate = fxConversionService.convert("AUD", "JPY");
        //Double exchangeRate = fxConversionService.convert("USD", "NOK");
        //Double exchangeRate = fxConversionService.convert("JPY", "AUD", 100D);

        //Double exchangeRate = fxConversionService.convert("PPK", "AUD", 1D);

        System.out.println("Exchange Rate :: " + exchangeRate);


    }
}
