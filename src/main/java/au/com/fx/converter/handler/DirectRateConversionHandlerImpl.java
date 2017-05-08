package au.com.fx.converter.handler;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.ExchangeRate;
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
