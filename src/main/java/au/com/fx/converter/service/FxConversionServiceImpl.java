package au.com.fx.converter.service;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.service.handler.RateConversionHandler;
import au.com.fx.converter.repository.ConversionChartRepository;
import au.com.fx.converter.repository.CurrencyRepository;
import org.apache.commons.math3.util.Precision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;

import java.math.BigDecimal;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Service
public class FxConversionServiceImpl implements FxConversionService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    ConversionChartRepository conversionMatrixRepository;

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public BigDecimal convert(String baseCurrencyCode, String termCurrencyCode, Double amount) {
        Assert.notNull(baseCurrencyCode, "Base Currency Code cannot be null.");
        Assert.notNull(termCurrencyCode, "Base Currency Code cannot be null.");
        Assert.notNull(amount, "Conversion Amount cannot be null.");

        Currency baseCurrency = getBaseCurrency(baseCurrencyCode);
        Currency termCurrency = getTermCurrency(termCurrencyCode);

        ConversionChart chart = getConversionChart(baseCurrency, termCurrency);
        Double processedExchangeRate = rateConversionHandler.process(chart, 1D);

        return new BigDecimal(amount * processedExchangeRate).setScale(termCurrency.getDecimalPlaces(), BigDecimal.ROUND_FLOOR);
    }

    private Currency getBaseCurrency(String baseCurrencyCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCurrencyCode);
        Assert.notNull(baseCurrency, "Unable to find Base Currency : " + baseCurrencyCode);

        return baseCurrency;
    }

    private Currency getTermCurrency(String termCurrencyCode) {
        Currency termCurrency = currencyRepository.findByCode(termCurrencyCode);
        Assert.notNull(termCurrency, "Unable to find Term Currency : " + termCurrencyCode);

        return termCurrency;
    }

    private ConversionChart getConversionChart(Currency baseCurrency, Currency termCurrency) {
        ConversionChart chart = conversionMatrixRepository.findBySourceCurrencyAndDestinationCurrency(baseCurrency, termCurrency);
        Assert.notNull(chart, String.format("Unable to find Rate for %1$2s/%2$2s", baseCurrency.getCode(), termCurrency.getCode()));

        return chart;
    }

}
