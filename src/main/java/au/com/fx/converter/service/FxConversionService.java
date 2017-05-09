package au.com.fx.converter.service;

import java.math.BigDecimal;


/**
 * This will be responsible for Orchestrating the Overall Conversion.
 *
 * @author senthurshanmugalingm.
 */
public interface FxConversionService {

    /**
     * This will convert the Base Currency into it's Term Currency and multiply the amount.
     *
     * @param baseCurrencyCode {@link String} the Base Currency Code
     * @param termCurrencyCode {@link String} the Term Currency Code
     * @param amount {@link Double} the amount to be converted
     *
     * @return {@link BigDecimal} the converted amount.
     * */
    BigDecimal convert(String baseCurrencyCode, String termCurrencyCode, BigDecimal amount);
}
