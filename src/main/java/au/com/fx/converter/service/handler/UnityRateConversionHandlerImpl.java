package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.ConversionChart;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;


/**
 * This class will be responsible for Handling Conversion related to Unity (1:1) Currencies Rate Calculations.
 *
 * @author senthurshanmugalingm.
 * @see BaseRateConversionHandler
 * @see RateConversionHandler
 *
 */
public class UnityRateConversionHandlerImpl extends BaseRateConversionHandler {

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public BigDecimal process(ConversionChart matrix, BigDecimal currentRate) {
        return rateConversionHandler.process(null, currentRate.multiply(new BigDecimal(1), MathContext.DECIMAL128));
    }

}
