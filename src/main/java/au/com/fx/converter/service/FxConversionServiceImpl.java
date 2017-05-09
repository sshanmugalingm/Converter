package au.com.fx.converter.service;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.service.handler.RateConversionHandler;
import au.com.fx.converter.repository.ConversionChartRepository;
import au.com.fx.converter.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * An implementation of {@link FxConversionService}.
 *
 * @author senthurshanmugalingm.
 * @see FxConversionService
 */
public class FxConversionServiceImpl implements FxConversionService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ConversionChartRepository conversionMatrixRepository;

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public BigDecimal convert(String baseCurrencyCode, String termCurrencyCode, BigDecimal amount) {
        Assert.notNull(baseCurrencyCode, "Base Currency Code cannot be null.");
        Assert.notNull(termCurrencyCode, "Term Currency Code cannot be null.");
        Assert.notNull(amount, "Conversion Amount cannot be null.");

        Currency baseCurrency = getCurrency(baseCurrencyCode, "Unable to find Base Currency");
        Currency termCurrency = getCurrency(termCurrencyCode, "Unable to find Term Currency");

        return (amount.multiply(getExchangeRate(baseCurrency, termCurrency),MathContext.DECIMAL128)).setScale(termCurrency.getDecimalPlaces(), BigDecimal.ROUND_HALF_UP);
    }

    private Currency getCurrency(String currencyCode, String message) {
        Currency baseCurrency = currencyRepository.findByCode(currencyCode);
        Assert.notNull(baseCurrency, message + " : " + currencyCode);

        return baseCurrency;
    }

    private BigDecimal getExchangeRate(Currency baseCurrency, Currency termCurrency) {
        ConversionChart chart = getConversionChart(baseCurrency, termCurrency);
        return rateConversionHandler.process(chart, new BigDecimal(1));
    }

    private ConversionChart getConversionChart(Currency baseCurrency, Currency termCurrency) {
        ConversionChart chart = conversionMatrixRepository.findBySourceCurrencyAndDestinationCurrency(baseCurrency, termCurrency);
        Assert.notNull(chart, String.format("Unable to find Rate for %1$2s/%2$2s", baseCurrency.getCode(), termCurrency.getCode()));

        return chart;
    }

}
