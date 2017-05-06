package au.com.fx.converter.repository;

import au.com.fx.converter.domain.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
public interface CurrencyRepository extends JpaRepository<Currency, Long> {

    Currency findByCode(String code);

}
