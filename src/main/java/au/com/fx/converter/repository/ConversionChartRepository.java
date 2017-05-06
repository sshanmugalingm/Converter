package au.com.fx.converter.repository;

import au.com.fx.converter.domain.ConversionChart;
import au.com.fx.converter.domain.Currency;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface ConversionChartRepository extends CrudRepository<ConversionChart, Long>{

    ConversionChart findBySourceCurrencyAndDestinationCurrency(Currency sourceCurrency, Currency destinationCurrency);

}
