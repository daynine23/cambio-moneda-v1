package com.cambiomoneda.conversion;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<Conversion, Long> {
    //User findByUsername(String username);
}
