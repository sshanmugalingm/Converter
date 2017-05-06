package au.com.fx.converter.handler.impl;


import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.handler.BaseRateConversionHandler;
import au.com.fx.converter.handler.RateConversionHandler;
import au.com.fx.converter.repository.ConversionChartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Component("crossRateConversionHandler")
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
