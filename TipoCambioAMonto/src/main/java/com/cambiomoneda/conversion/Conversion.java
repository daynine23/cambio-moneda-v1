package com.cambiomoneda.conversion;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;


@Entity
public class Conversion {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private BigDecimal initialAmount;

    private BigDecimal finalAmount;

    private String initialCurrencyCode;

    private String finalCurrencyCode;

    private BigDecimal exchangeRate;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public BigDecimal getInitialAmount() { return initialAmount; }

    public void setInitialAmount(BigDecimal initialAmount) { this.initialAmount = initialAmount; }

    public BigDecimal getFinalAmount() { return finalAmount; }

    public void setFinalAmount(BigDecimal finalAmount) { this.finalAmount = finalAmount; }

    public String getInitialCurrencyCode() { return initialCurrencyCode; }

    public void setInitialCurrencyCode(String initialCurrencyCode) { this.initialCurrencyCode = initialCurrencyCode; }

    public String getFinalCurrencyCode() { return finalCurrencyCode; }

    public void setFinalCurrencyCode(String finalCurrencyCode) { this.finalCurrencyCode = finalCurrencyCode; }

    public BigDecimal getExchangeRate() { return exchangeRate; }

    public void setExchangeRate(BigDecimal exchangeRate) { this.exchangeRate = exchangeRate; }

}
