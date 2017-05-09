package au.com.fx.converter.service.handler;


import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.repository.ConversionChartRepository;
import org.springframework.beans.factory.annotation.Autowired;

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
    public Double process(ConversionChart chart, Double currentRate) {

        ConversionChart crossReferenceChart = conversionChartRepository.findBySourceCurrencyAndDestinationCurrency(chart.getSourceCurrency(), chart.getReferenceCurrency());
        Double calculatedRate = currentRate * rateConversionHandler.process(crossReferenceChart, 1.0D);
        crossReferenceChart = conversionChartRepository.findBySourceCurrencyAndDestinationCurrency(chart.getReferenceCurrency(), chart.getDestinationCurrency());

        return rateConversionHandler.process(crossReferenceChart, calculatedRate);
    }
}
