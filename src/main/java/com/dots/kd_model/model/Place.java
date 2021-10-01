package com.dots.kd_model.model;

import com.dots.kd_model.model.user.Employee;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "place", schema = "public")
public class Place implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "PLACE_SEQ_GEN")
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String address;

    /**
     * Сотрудники, которые работают в салоне
     */
    @ToString.Exclude
    @ManyToMany(
            targetEntity = Employee.class,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "place_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "place_id")
    )
    private Set<Employee> employees;
}
