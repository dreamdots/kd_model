package com.dots.kd_model.model;

import com.dots.kd_model.model.user.Employee;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "massage", schema = "public")
public class Massage implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "MASSAGE_SEQ_GEN")
    private Long id;

    /**
     * Название процедуры
     */
    @Column(length = 1000, nullable = false)
    private String description;

    /**
     * Цена
     */
    @Column(nullable = false)
    private BigDecimal price;

    /**
     * Продолжительность
     */
    @Column(nullable = false)
    private Long duration;

    /**
     * Сотрудники, которые могут делать этот массаж
     */
    @ToString.Exclude
    @ManyToMany(
            targetEntity = Employee.class,
            fetch = FetchType.EAGER)
    @JoinTable(
            name = "massage_employees",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "massage_id")
    )
    private Set<Employee> employees;
}
