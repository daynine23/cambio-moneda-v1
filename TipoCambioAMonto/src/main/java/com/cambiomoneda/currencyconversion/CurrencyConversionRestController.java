package com.cambiomoneda.currencyconversion;

import java.util.List;

import com.cambiomoneda.currencyconversion.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/currencyConversion")
public class CurrencyConversionRestController {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<CurrencyConversion> findAll() {
        return currencyConversionRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{currencyConversionId}")
    public CurrencyConversion findOne(@PathVariable Long currencyConversionId) {
        return currencyConversionRepository.findOne(currencyConversionId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public CurrencyConversion add(@RequestBody CurrencyConversion currencyConversion) {
        return currencyConversionRepository.save(currencyConversion);
    }

	@RequestMapping(method = RequestMethod.POST, value = "/updateExchangeRate")
    public CurrencyConversion update(@RequestBody CurrencyConversion currencyConversion) throws Exception {
        return currencyConversionService.updateExchangeRate(currencyConversion);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{currencyConversionId}")
    public void delete(@PathVariable Long currencyConversionId) {
        currencyConversionRepository.delete(currencyConversionId);
    }
	
}

