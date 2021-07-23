package com.cambiomoneda.currencyconversion;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Table(name = "currencyconversion")
public class CurrencyConversion {

    @Id
    @JsonIgnore
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "currcon_seq")
    @SequenceGenerator(name = "currcon_seq", sequenceName = "currcon_seq", allocationSize = 1)
    private Long id;

    @Column(name = "EXCHANGERATE", length = 5)
    @NotNull
    private BigDecimal exchangeRate;

    @Column(name = "ORICURRENCYCODE", length = 3)
    @NotNull
    @Size(min = 3, max = 3)
    private String originCurrencyCode;

    @Column(name = "DESCURRENCYCODE", length = 3)
    @NotNull
    @Size(min = 3, max = 3)
    private String destinyCurrencyCode;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public BigDecimal getExchangeRate() { return exchangeRate; }

    public void setExchangeRate(BigDecimal exchangeRate) { this.exchangeRate = exchangeRate; }

    public String getOriginCurrencyCode() { return originCurrencyCode; }

    public void setOriginCurrencyCode(String originCurrencyCode) { this.originCurrencyCode = originCurrencyCode; }

    public String getDestinyCurrencyCode() { return destinyCurrencyCode; }

    public void setDestinyCurrencyCode(String destinyCurrencyCode) { this.destinyCurrencyCode = destinyCurrencyCode; }

}
