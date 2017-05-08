package au.com.fx.converter.handler;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.factory.RateConversionHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("rateConversionHandler")
public class RateConversionHandlerImpl implements RateConversionHandler {

    @Autowired
    RateConversionHandlerFactory rateConversionHandlerFactory;

    @Override
    public Double process(ConversionChart chart, Double currentRate) {
        if (chart == null)
            return currentRate;

        RateConversionHandler rateConversionHandler = rateConversionHandlerFactory.getConversionHandler(chart.getConversionType());
        return rateConversionHandler.process(chart, currentRate);
    }


}
