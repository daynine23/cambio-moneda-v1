package com.cambiomoneda.currencyconversion;

import com.cambiomoneda.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {
    //User findByUsername(String username);

    CurrencyConversion findByOriginCurrencyCode(String originCurr);

    CurrencyConversion findByOriginCurrencyCodeAndDestinyCurrencyCode(String originCurr, String destinyCurr);
}
