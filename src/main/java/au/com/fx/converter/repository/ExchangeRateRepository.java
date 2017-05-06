package au.com.fx.converter.repository;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.domain.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    ExchangeRate findByBaseCurrencyAndTermCurrency(Currency baseCurrency, Currency termCurrency);
}
