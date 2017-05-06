package au.com.fx.converter.factory.impl;

import au.com.fx.converter.enums.ConversionType;
import au.com.fx.converter.factory.RateConversionHandlerFactory;
import au.com.fx.converter.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("rateConversionHandlerFactory")
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
