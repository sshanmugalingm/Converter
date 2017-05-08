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
        baseCurrency | termCurrency | amountToConvert | convertedAmount | conversionType
        'AUD'        | 'USD'        | 1D              | '0.83'          | 'Direct Conversion'
        'USD'        | 'AUD'        | 1D              | '1.19'          | 'Inverse Conversion'
        'AUD'        | 'USD'        | 1D              | '0.83'          | 'Cross Conversion'
        'AUD'        | 'USD'        | 1D              | '0.83'          | 'Combined Conversion (Cross, Invert and Direct) with Invert and Direct'
        'AUD'        | 'AUD'        | 100D            | '100.00'        | 'Unity Conversion'
    }
}