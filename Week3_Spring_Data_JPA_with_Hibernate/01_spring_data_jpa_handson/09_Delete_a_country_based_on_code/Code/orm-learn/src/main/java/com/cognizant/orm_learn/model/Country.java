package com.cognizant.orm_learn.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

	@Id
	@Column(name="co_code")
	private String code;
	@Column(name="co_name")
	private String name;
}
