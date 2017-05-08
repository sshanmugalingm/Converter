package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.ConversionChart;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface RateConversionHandler {

    Double process(ConversionChart chart, Double currentRate);
}