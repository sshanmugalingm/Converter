package au.com.fx.converter.service;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface FxConversionService {

    Double convert(String baseCurrency, String termCurrency, Double amount);
}
