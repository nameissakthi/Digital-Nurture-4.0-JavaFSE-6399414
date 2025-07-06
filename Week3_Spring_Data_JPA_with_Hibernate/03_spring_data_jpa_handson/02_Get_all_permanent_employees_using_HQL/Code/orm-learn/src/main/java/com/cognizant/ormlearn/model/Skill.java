package com.cognizant.ormlearn.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.*;

import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "employeeList")
@EqualsAndHashCode(exclude = "employeeList")
public class Skill {
    @Id
    private int id;
    private String name;

    @ManyToMany(mappedBy = "skillList")
    private Set<Employee> employeeList;
}