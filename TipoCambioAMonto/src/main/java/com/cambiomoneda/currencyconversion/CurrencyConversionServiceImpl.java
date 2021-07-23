package com.cambiomoneda.currencyconversion;

import com.cambiomoneda.currencyconversion.service.CurrencyConversionService;
import com.cambiomoneda.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    public CurrencyConversion create(CurrencyConversion currencyConversion) throws Exception {
        CurrencyConversion cc = this.currencyConversionRepository.save(currencyConversion);

        if (cc == null) {
            throw new Exception("ocurrio un error al crear conversion de moneda");
        } else {
            return cc;
        }
    }

    public CurrencyConversion findByOriginCurrencyCode(String code) throws Exception{
        CurrencyConversion cc = this.currencyConversionRepository.findByOriginCurrencyCode(code);

        if (cc == null) {
            throw new Exception("No se encontro registro de conversion de moneda de origen : " + code);
        } else {
            return cc;
        }
    }

    public CurrencyConversion updateExchangeRate(CurrencyConversion cc) throws Exception{
        CurrencyConversion occ = this.currencyConversionRepository
                .findByOriginCurrencyCodeAndDestinyCurrencyCode(
                        cc.getOriginCurrencyCode(), cc.getDestinyCurrencyCode());

        if (occ == null) {
            throw new Exception("No se encontro registro de conversion");
        } else {
            if(cc.getExchangeRate() == null){
                throw new Exception("Porfavor ingresar un tipo de cambio valido");
            } else {
                occ.setExchangeRate(cc.getExchangeRate());
                this.currencyConversionRepository.save(occ);
                return occ;
            }
        }
    }
}
