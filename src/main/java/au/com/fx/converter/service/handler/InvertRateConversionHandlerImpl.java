package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class will be responsible for Handling Conversion related to Inverted Currencies Rate Calculations.
 *
 * @author senthurshanmugalingm.
 * @see BaseRateConversionHandler
 * @see RateConversionHandler
 *
 */
public class InvertRateConversionHandlerImpl extends BaseRateConversionHandler {

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public Double process(ConversionChart chart, Double currentRate) {

        ExchangeRate exchangeRate = getExchangeRate(chart.getDestinationCurrency(), chart.getSourceCurrency());
        return rateConversionHandler.process(null, currentRate * (1/exchangeRate.getRate().doubleValue()));
    }
}
