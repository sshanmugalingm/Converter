package au.com.fx.converter.service.factory;

import au.com.fx.converter.commons.enums.ConversionType;
import au.com.fx.converter.service.handler.RateConversionHandler;

/**
 * A Factory to help retrieve the appropriate handler {@link RateConversionHandler} based on the {@link ConversionType}
 * @author senthurshanmugalingm.
 *
 */
public interface RateConversionHandlerFactory {

    /**
     * Returns the relevant handler {@link RateConversionHandler}  based on the {@link ConversionType}
     *
     * @param conversionType {@link ConversionType}
     * @return {@link RateConversionHandler}
     *
     * */
    RateConversionHandler getConversionHandler(ConversionType conversionType);

}
