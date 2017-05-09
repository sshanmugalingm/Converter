package au.com.fx.converter.repository;

import au.com.fx.converter.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Data Repository to handle CRUD Operations related to Currency Entities.
 *
 * @author senthurshanmugalingm.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    /**
     * Returns the {@link Currency} for a given code.
     * If no {@link Currency} is found null will be returned.
     *
     * @param code {@link String} The Currency code.
     * @return {@link Currency}
     *
     * */
    Currency findByCode(String code);

}
