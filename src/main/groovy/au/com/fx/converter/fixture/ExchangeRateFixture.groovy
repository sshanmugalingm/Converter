package au.com.fx.converter.fixture

import au.com.fx.converter.domain.Currency
import au.com.fx.converter.domain.ExchangeRate
import au.com.fx.converter.repository.CurrencyRepository
import au.com.fx.converter.repository.ExchangeRateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import org.springframework.util.Assert

/**
 * Created by senthurshanmugalingm on 4/05/2017.
 */
@Component
class ExchangeRateFixture {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository

    @Autowired
    private CurrencyRepository currencyRepository

    static final List exchangeRateCodeCombinations = [
            [base: 'AUD', term : 'USD', rate: 0.8371],
            [base: 'CAD', term : 'USD', rate: 0.8711],
            [base: 'USD', term : 'CNY', rate: 6.1715],
            [base: 'EUR', term : 'USD', rate: 1.2315],
            [base: 'GBP', term : 'USD', rate: 1.5683],
            [base: 'NZD', term : 'USD', rate: 0.7750],
            [base: 'USD', term : 'JPY', rate: 119.95],
            [base: 'EUR', term : 'CZK', rate: 27.6028],
            [base: 'EUR', term : 'DKK', rate: 7.4405],
            [base: 'EUR', term : 'NOK', rate: 8.6651]
    ]
    
    void createExchangeRates() {
        exchangeRateCodeCombinations.each { exchangeRateCombination ->
            Currency baseCurrency = currencyRepository.findByCode(exchangeRateCombination.base)
            Currency termCurrency = currencyRepository.findByCode(exchangeRateCombination.term)

            Assert.notNull(baseCurrency, "Base Currency cannot be null.")
            Assert.notNull(termCurrency, "Term Currency cannot be null.")

            exchangeRateRepository.save(new ExchangeRate(baseCurrency:  baseCurrency, termCurrency: termCurrency, rate: exchangeRateCombination.rate))
        }
    }
    
}
