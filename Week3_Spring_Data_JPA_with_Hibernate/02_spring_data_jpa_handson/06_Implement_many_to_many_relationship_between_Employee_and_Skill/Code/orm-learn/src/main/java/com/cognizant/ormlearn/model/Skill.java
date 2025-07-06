package com.cognizant.ormlearn.model;

import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employeeList")
public class Skill {

    @Id
    private int id;

    private String name;

    @ManyToMany(mappedBy = "skillList")
    private List<Employee> employeeList;
}