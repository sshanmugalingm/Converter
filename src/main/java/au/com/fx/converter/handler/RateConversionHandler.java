package au.com.fx.converter.handler;

import au.com.fx.converter.domain.ConversionChart;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@FunctionalInterface
public interface RateConversionHandler {

    Double process(ConversionChart chart, Double currentRate);
}
