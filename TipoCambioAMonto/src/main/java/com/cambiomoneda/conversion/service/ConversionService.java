package com.cambiomoneda.conversion.service;

import com.cambiomoneda.conversion.Conversion;
import org.springframework.stereotype.Service;

@Service
public interface ConversionService {

    Conversion convertCurrecyAmount(Conversion c) throws Exception;
}
