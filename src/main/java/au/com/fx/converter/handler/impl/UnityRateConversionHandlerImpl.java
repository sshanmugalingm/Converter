package au.com.fx.converter.handler.impl;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.handler.BaseRateConversionHandler;
import au.com.fx.converter.handler.RateConversionHandler;
import au.com.fx.converter.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("unityRateConversionHandler")
public class UnityRateConversionHandlerImpl extends BaseRateConversionHandler {

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public Double process(ConversionChart matrix, Double currentRate) {
        return rateConversionHandler.process(null, currentRate * 1);
    }

}
