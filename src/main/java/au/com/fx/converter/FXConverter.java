package au.com.fx.converter;

import au.com.fx.converter.fixture.FxDataFixture;
import au.com.fx.converter.repository.CurrencyRepository;
import au.com.fx.converter.repository.ExchangeRateRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
public class FXConverter {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:/config.xml");

        FxDataFixture fixture = ctx.getBean(FxDataFixture.class);
        fixture.createFxData();

        //TODO Clean up this after adding test cases
        CurrencyRepository repo = ctx.getBean(CurrencyRepository.class);
        System.out.println("Finding ALL Currencies ::: " + repo.findAll());

        ExchangeRateRepository exchangeRateRepository = ctx.getBean(ExchangeRateRepository.class);
        System.out.println("Find ALl Rates::: " + exchangeRateRepository.findAll());

    }
}
