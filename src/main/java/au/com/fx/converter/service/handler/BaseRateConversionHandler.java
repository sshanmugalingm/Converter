package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.domain.ExchangeRate;
import au.com.fx.converter.repository.ExchangeRateRepository;
import au.com.fx.converter.service.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public abstract class BaseRateConversionHandler implements RateConversionHandler {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    protected ExchangeRate getExchangeRate(Currency baseCurrency, Currency termCurrency) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByBaseCurrencyAndTermCurrency(baseCurrency, termCurrency);
        Assert.notNull(exchangeRate, String.format("Could not find Exchange Rate for %1s/%2s", baseCurrency.getCode(), termCurrency.getCode()));

        return exchangeRate;
    }

}
