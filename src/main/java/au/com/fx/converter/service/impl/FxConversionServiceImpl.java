package au.com.fx.converter.service.impl;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.handler.RateConversionHandler;
import au.com.fx.converter.repository.ConversionChartRepository;
import au.com.fx.converter.repository.CurrencyRepository;
import au.com.fx.converter.service.FxConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public double convert(String baseCurrencyCode, String termCurrencyCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCurrencyCode);
        Currency termCurrency = currencyRepository.findByCode(termCurrencyCode);

        ConversionChart chart = conversionMatrixRepository.findBySourceCurrencyAndDestinationCurrency(baseCurrency, termCurrency);


        //This method should calculate the final value

        return rateConversionHandler.process(chart, 1D);
    }
}
