package au.com.fx.converter.service.factory;

import au.com.fx.converter.commons.enums.ConversionType;
import au.com.fx.converter.service.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * @see RateConversionHandlerFactory
 * @author senthurshanmugalingm.
 */
public class RateConvertionHandlerFactoryImpl implements RateConversionHandlerFactory {

    private Map<String, RateConversionHandler> rateConversionHandlerMap;

    @Autowired
    public void setRateConversionHandlerMap(Map<String, RateConversionHandler> rateConversionHandlerMap) {
        this.rateConversionHandlerMap = rateConversionHandlerMap;
    }

    @Override
    public RateConversionHandler getConversionHandler(ConversionType conversionType) {
        return (conversionType == null) ? null : rateConversionHandlerMap.get(conversionType.getHandlerName());
    }
}
