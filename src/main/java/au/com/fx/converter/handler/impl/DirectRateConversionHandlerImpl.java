package au.com.fx.converter.handler.impl;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.ExchangeRate;
import au.com.fx.converter.handler.BaseRateConversionHandler;
import au.com.fx.converter.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("directRateConversionHandler")
public class DirectRateConversionHandlerImpl extends BaseRateConversionHandler {

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public Double process(ConversionChart chart, Double currentRate) {

        ExchangeRate exchangeRate = getExchangeRate(chart.getSourceCurrency(), chart.getDestinationCurrency());
        return rateConversionHandler.process(null, currentRate * (exchangeRate).getRate().doubleValue());
    }
}
