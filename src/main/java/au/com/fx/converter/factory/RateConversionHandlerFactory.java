package au.com.fx.converter.factory;

import au.com.fx.converter.commons.enums.ConversionType;
import au.com.fx.converter.handler.RateConversionHandler;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface RateConversionHandlerFactory {

    RateConversionHandler getConversionHandler(ConversionType conversionType);

}
