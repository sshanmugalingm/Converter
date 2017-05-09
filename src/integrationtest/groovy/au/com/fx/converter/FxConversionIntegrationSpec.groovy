package au.com.fx.converter

import au.com.fx.converter.service.FxConversionService
import org.springframework.beans.factory.annotation.Autowired
import spock.lang.Unroll


/**
 * Created by senthurshanmugalingm on 8/05/2017.
 */
class FxConversionIntegrationSpec extends BaseIntegrationSpec {

    @Autowired
    FxConversionService fxConversionService

    @Unroll
    def "(#conversionType) Convert #baseCurrency to #termCurrency, should convert #amountToConvert and return a valid Result of #convertedAmount"() {
        expect :
        fxConversionService.convert(baseCurrency, termCurrency, amountToConvert)?.toPlainString() == convertedAmount

        where :
        baseCurrency | termCurrency | amountToConvert          | convertedAmount | conversionType
        'AUD'        | 'USD'        | new BigDecimal(1)    | '0.84'          | 'Direct Conversion'
        'USD'        | 'AUD'        | new BigDecimal(0.84) | '1.00'          | 'Inverse Conversion'
        'AUD'        | 'JPY'        | new BigDecimal(1)    | '100'           | 'Combined Conversion (Cross and Direct)'
        'JPY'        | 'AUD'        | new BigDecimal(100)  | '1.00'           | 'Combined Conversion (Cross and Direct)'
        'JPY'        | 'NOK'        | new BigDecimal(1)    | '0.06'          | 'Combined Conversion (Cross, Invert and Direct) with Invert and Direct'
        'AUD'        | 'AUD'        | new BigDecimal(100)  | '100.00'        | 'Unity Conversion'
    }
}