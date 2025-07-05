package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "stock")
@ToString
public class Stock {

    @Id
    @Column(name = "st_id")
    @ToString.Exclude
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "st_code")
    private String code;
    @Column(name = "st_date")
    private LocalDate date;
    @Column(name = "st_open")
    private BigDecimal open;
    @Column(name = "st_close")
    private BigDecimal close;
    @Column(name = "st_volume")
    private BigDecimal volume;
}
