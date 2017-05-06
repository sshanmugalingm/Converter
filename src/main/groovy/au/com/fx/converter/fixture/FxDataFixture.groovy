package au.com.fx.converter.fixture

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
@Component
class FxDataFixture {

    @Autowired
    private CurrencyDataFixture currencyDataFixture

    @Autowired
    private ExchangeRateFixture exchangeRateFixture

    void createFxData() {
        //currencyDataFixture.createCurrencyData()
        //exchangeRateFixture.createExchangeRates()
    }

}
