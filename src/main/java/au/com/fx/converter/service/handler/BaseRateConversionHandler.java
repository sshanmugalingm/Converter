package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.domain.ExchangeRate;
import au.com.fx.converter.repository.ExchangeRateRepository;
import au.com.fx.converter.service.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * An intermediate Abstraction of the {@link RateConversionHandler}.  Will be used to get Exchange Rates.
 * @author senthurshanmugalingm.
 *
 * @see RateConversionHandler
 *
 */
public abstract class BaseRateConversionHandler implements RateConversionHandler {

    @Autowired
    ExchangeRateRepository exchangeRateRepository;

    /**
     * Returns the {@link ExchangeRate} for the provided currencies.
     * if no {@link ExchangeRate} could be found null will be returned.
     *
     * @param baseCurrency {@link Currency} the Base Currency
     * @param termCurrency {@link Currency} the Term Currency
     *
     * @return {@link ExchangeRate}
     * */
    protected ExchangeRate getExchangeRate(Currency baseCurrency, Currency termCurrency) {
        ExchangeRate exchangeRate = exchangeRateRepository.findByBaseCurrencyAndTermCurrency(baseCurrency, termCurrency);
        Assert.notNull(exchangeRate, String.format("Could not find Exchange Rate for %1s/%2s", baseCurrency.getCode(), termCurrency.getCode()));

        return exchangeRate;
    }

}
