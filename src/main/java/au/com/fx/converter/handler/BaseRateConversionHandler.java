package au.com.fx.converter.handler;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.domain.ExchangeRate;
import au.com.fx.converter.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public abstract class BaseRateConversionHandler implements RateConversionHandler {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    protected ExchangeRate getExchangeRate(Currency baseCurrency, Currency termCurrency) {
        return exchangeRateRepository.findByBaseCurrencyAndTermCurrency(baseCurrency, termCurrency);
    }

}
