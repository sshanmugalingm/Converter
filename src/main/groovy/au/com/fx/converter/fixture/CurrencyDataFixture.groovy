package au.com.fx.converter.fixture

import au.com.fx.converter.domain.Currency
import au.com.fx.converter.repository.CurrencyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
@Component
class CurrencyDataFixture {

    @Autowired
    private CurrencyRepository currencyRepository

    static final List currencyData = [
            [code: 'AUD', decimalPlaces: 2, description: 'Australian Dollar', country: 'Australia'],
            [code: 'CAD', decimalPlaces: 2, description: 'Canadian Dollar', country: 'Canada'],
            [code: 'CNY', decimalPlaces: 2, description: 'Chinese yuan renminbi', country: 'China'],
            [code: 'CZK', decimalPlaces: 2, description: 'Czech koruna', country: 'Czech'],
            [code: 'DKK', decimalPlaces: 2, description: 'Danish krone', country: 'Danish'],
            [code: 'EUR', decimalPlaces: 2, description: 'EU Euro', country: 'EU'],
            [code: 'GBP', decimalPlaces: 2, description: 'Great Britain Pound', country: 'Great Britain'],
            [code: 'JPY', decimalPlaces: 0, description: 'Japanese Yen', country: 'Japan'],
            [code: 'NOK', decimalPlaces: 2, description: 'Norwegian Krone', country: 'Norway'],
            [code: 'NZD', decimalPlaces: 2, description: 'New Zealand Dollar', country: 'New Zealand'],
            [code: 'USD', decimalPlaces: 2, description: 'US Dollar', country: 'USA']
    ]

    void createCurrencyData() {
        currencyData.each {data ->
            currencyRepository.save(new Currency(code: data.code, description: data.description, country: data.country, decimalPlaces: data.decimalPlaces))
        }
    }
}
