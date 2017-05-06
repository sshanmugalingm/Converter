package au.com.fx.converter.factory.impl;

import au.com.fx.converter.enums.ConversionType;
import au.com.fx.converter.factory.RateConversionHandlerFactory;
import au.com.fx.converter.handler.RateConversionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("rateConversionHandlerFactory")
public class RateConvertionHandlerFactoryImpl implements RateConversionHandlerFactory {

    @Autowired
    RateConversionHandler crossRateConversionHandler;

    @Autowired
    RateConversionHandler invertRateConversionHandler;

    @Autowired
    RateConversionHandler directRateConversionHandler;

    @Autowired
    RateConversionHandler unityRateConversionHandler;

    @Override
    public RateConversionHandler getConversionHandler(ConversionType conversionType) {
        RateConversionHandler rateConversionHandler = null;
        switch (conversionType) {
            case CROSSCURRENCY:
                rateConversionHandler = crossRateConversionHandler;
                break;
            case INVERSE:
                rateConversionHandler = invertRateConversionHandler;
                break;
            case DIRECT:
                rateConversionHandler = directRateConversionHandler;
                break;
            case UNITY:
                rateConversionHandler = unityRateConversionHandler;
        }
        return rateConversionHandler;
    }
}
