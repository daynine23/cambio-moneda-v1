package com.cambiomoneda.conversion;

import com.cambiomoneda.conversion.service.ConversionService;
import com.cambiomoneda.currencyconversion.CurrencyConversion;
import com.cambiomoneda.currencyconversion.CurrencyConversionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ConversionServiceImpl implements ConversionService {

    @Autowired
    private ConversionRepository conversionRepository;

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    public Conversion convertCurrecyAmount(Conversion c) throws Exception {
        CurrencyConversion cc = this.currencyConversionRepository.
                findByOriginCurrencyCodeAndDestinyCurrencyCode(c.getInitialCurrencyCode(), c.getFinalCurrencyCode());

        if (cc == null) {
            throw new Exception("No existe registrada la conversion de moneda");
        } else {
            if(c.getInitialAmount() == null){
                throw new Exception("Monto inicial ingresado no valido");
            } else {
                BigDecimal ecr = cc.getExchangeRate();
                BigDecimal initialAmount = c.getInitialAmount();
                BigDecimal finalAmount = initialAmount.multiply(ecr);

                c.setFinalAmount(finalAmount);
                c.setExchangeRate(ecr);
                return c;
            }
        }
    }
}
