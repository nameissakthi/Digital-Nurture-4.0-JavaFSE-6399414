package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "department")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employeeList")
public class Department {

    @Id
    private int id;

    private String name;

    @OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
    private List<Employee> employeeList;
}