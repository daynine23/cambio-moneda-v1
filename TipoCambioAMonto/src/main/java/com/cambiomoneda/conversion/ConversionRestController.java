package com.cambiomoneda.conversion;

import java.util.List;

import com.cambiomoneda.conversion.service.ConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/conversion")
public class ConversionRestController {

    @Autowired
    private ConversionRepository conversionRepository;

    @Autowired
    private ConversionService conversionService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Conversion> findAll() {
        return conversionRepository.findAll();
    }
    
	@RequestMapping(method = RequestMethod.GET, value = "/{conversionId}")
    public Conversion findOne(@PathVariable Long conversionId) {
        return conversionRepository.findOne(conversionId);
    }
    
	@RequestMapping(method = RequestMethod.POST)
    public Conversion add(@RequestBody Conversion conversion) {
        return conversionRepository.save(conversion);
    }

	@RequestMapping(method = RequestMethod.PUT)
    public Conversion update(@RequestBody Conversion conversion) {
        return conversionRepository.save(conversion);
    }
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{conversionId}")
    public void delete(@PathVariable Long conversionId) {
        conversionRepository.delete(conversionId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/convertCurrencyAmount")
    public Conversion convertCurrencyAmount(@RequestBody Conversion conversion) throws Exception {
        return conversionService.convertCurrecyAmount(conversion);
    }
	
}

