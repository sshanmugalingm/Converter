package au.com.fx.converter.repository;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.domain.ExchangeRate;
import org.springframework.data.repository.CrudRepository;

/**
 * Data Repository to handle CRUD Operations related to Exchange Entities.
 *
 * @author senthurshanmugalingm.
 */
public interface ExchangeRateRepository extends CrudRepository<ExchangeRate, Long> {

    /**
     * Finds a {@link ExchangeRate} by Base Currency and Term Currency
     * If no {@link ExchangeRate} is found null will be returned.
     *
     * @param baseCurrency {@link Currency} Base Currency
     * @param termCurrency {@link Currency} Term Currency
     *
     * @return {@link ExchangeRate}
     * */
    ExchangeRate findByBaseCurrencyAndTermCurrency(Currency baseCurrency, Currency termCurrency);
}
