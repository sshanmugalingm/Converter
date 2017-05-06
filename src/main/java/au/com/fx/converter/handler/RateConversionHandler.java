package au.com.fx.converter.handler;

import au.com.fx.converter.domain.Currency;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
public interface RateConversionHandler {

    Double convert(Currency baseCurrency, Currency termCurrency, boolean skipCalculation);

}
