package au.com.fx.converter.service;

import java.math.BigDecimal;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface FxConversionService {

    BigDecimal convert(String baseCurrency, String termCurrency, Double amount);
}
