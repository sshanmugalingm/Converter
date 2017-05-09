package au.com.fx.converter.service.handler;


import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.repository.ConversionChartRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * This class will be responsible for Handling Conversion related to Cross Currencies Rate Calculations.
 *
 * @author senthurshanmugalingm.
 * @see BaseRateConversionHandler
 * @see RateConversionHandler
 *
 */
public class CrossRateConversionHandlerImpl extends BaseRateConversionHandler {

    @Autowired
    ConversionChartRepository conversionChartRepository;

    @Autowired
    RateConversionHandler rateConversionHandler;

    @Override
    public BigDecimal process(ConversionChart chart, BigDecimal currentRate) {

        ConversionChart crossReferenceChart = conversionChartRepository.findBySourceCurrencyAndDestinationCurrency(chart.getSourceCurrency(), chart.getReferenceCurrency());
        BigDecimal calculatedRate = currentRate.multiply(rateConversionHandler.process(crossReferenceChart, new BigDecimal(1)), MathContext.DECIMAL128);
        crossReferenceChart = conversionChartRepository.findBySourceCurrencyAndDestinationCurrency(chart.getReferenceCurrency(), chart.getDestinationCurrency());

        return rateConversionHandler.process(crossReferenceChart, calculatedRate);
    }
}
