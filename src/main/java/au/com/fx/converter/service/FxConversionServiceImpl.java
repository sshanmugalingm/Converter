package au.com.fx.converter.service;

import au.com.fx.converter.domain.Currency;
import au.com.fx.converter.repository.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by senthurshanmugalingm on 6/05/2017.
 */
@Service
public class FxConversionServiceImpl implements FxConversionService {

    @Autowired
    CurrencyRepository currencyRepository;

    @Override
    public double convert(String baseCurrencyCode, String termCurrencyCode) {
        Currency baseCurrency = currencyRepository.findByCode(baseCurrencyCode);
        Currency termCurrency = currencyRepository.findByCode(termCurrencyCode);



        return 0;
    }
}
