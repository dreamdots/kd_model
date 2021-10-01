package com.dots.kd_model.model;

import com.dots.kd_model.model.order.Order;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "day", schema = "public")
public class Day implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DAY_SEQ_GEN")
    private Long id;

    /**
     * День по календарю
     */
    @Column(nullable = false, name = "day")
    private LocalDateTime day;

    /**
     * Начало рабочего дня
     */
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;

    /**
     * Окончание рабочего дня
     */
    @Column(nullable = false, name = "end_time")
    private LocalDateTime endTime;

    /**
     * Все заказы на этот день
     */
    @ToString.Exclude
    @OneToMany(
            targetEntity = Order.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    private Set<Order> orders;

    /**
     * Салон, для которого установлено расписание
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = Place.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;
}
