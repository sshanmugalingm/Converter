package au.com.fx.converter.service.handler;

import au.com.fx.converter.domain.ConversionChart;

import java.math.BigDecimal;

/**
 * This will be responsible for transforming the rates based on different {@link au.com.fx.converter.commons.enums.ConversionType}
 * @author senthurshanmugalingm.
 *
 */
public interface RateConversionHandler {

    /**
     * Will process the rate for a given conversion type using the {@link ConversionChart}
     *
     * @param chart {@link ConversionChart} the chart containing the convertion details of two currencies.
     * @param currentRate {@link Double} the initial rate.  Normally starts from 1D.
     *
     * @return {@link Double} the converted rate.
     * */
    BigDecimal process(ConversionChart chart, BigDecimal currentRate);
}
