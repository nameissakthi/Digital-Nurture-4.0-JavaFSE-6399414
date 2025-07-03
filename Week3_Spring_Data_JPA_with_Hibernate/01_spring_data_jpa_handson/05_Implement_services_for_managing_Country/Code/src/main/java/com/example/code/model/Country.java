package com.example.code.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "country")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Id
    @Column(name = "co_code")
    private String code;
    @Column(name = "co_name")
    private String name;
}
