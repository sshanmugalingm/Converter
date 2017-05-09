package au.com.fx.converter.repository;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.Currency;
import org.springframework.data.repository.CrudRepository;

/**
 * Data Repository to handle CRUD Operations related to Conversion Chart.
 *
 * @author senthurshanmugalingm.
 */
public interface ConversionChartRepository extends CrudRepository<ConversionChart, Long>{

    /**
     * Finds a {@link ConversionChart} by Source Currency and Destination Currency.
     * If no {@link ConversionChart} is found null will be returned.
     *
     * @param sourceCurrency {@link Currency} Source Currency
     * @param destinationCurrency {@link Currency} Destination Currency
     *
     * @return {@link ConversionChart}
     * */
    ConversionChart findBySourceCurrencyAndDestinationCurrency(Currency sourceCurrency, Currency destinationCurrency);

}
