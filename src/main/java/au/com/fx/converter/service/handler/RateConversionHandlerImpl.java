package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.service.factory.RateConversionHandlerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * This class will be responsible for finding the appropriate handler and delegate the Rate Conversion.
 * This class will use the {@link RateConversionHandlerFactory} to obtain the Delegate.
 *
 * @author senthurshanmugalingm.
 * @see RateConversionHandler
 * @see RateConversionHandlerFactory
 *
 */
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
