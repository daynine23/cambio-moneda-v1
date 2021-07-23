package com.cambiomoneda.currencyconversion.service;

import com.cambiomoneda.currencyconversion.CurrencyConversion;
import org.springframework.stereotype.Service;

@Service
public interface CurrencyConversionService {

    CurrencyConversion updateExchangeRate(CurrencyConversion cc) throws Exception;
}
