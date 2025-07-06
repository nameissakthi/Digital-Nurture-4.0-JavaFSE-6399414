package com.cognizant.ormlearn.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"department", "skillList"})
@EqualsAndHashCode(exclude = "skillList")
public class Employee {
    @Id
    private int id;
    private String name;
    private double salary;
    private boolean permanent;

    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToMany
    @JoinTable(name = "employee_skill",
            joinColumns = @JoinColumn(name = "es_em_id"),
            inverseJoinColumns = @JoinColumn(name = "es_sk_id"))
    private Set<Skill> skillList;
}