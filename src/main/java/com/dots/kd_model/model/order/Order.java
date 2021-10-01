package com.dots.kd_model.model.order;

import com.dots.kd_model.model.*;
import com.dots.kd_model.model.user.Employee;
import com.dots.kd_model.model.user.MUser;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "order", schema = "public")
public class Order implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "ORDER_SEQ_GEN")
    private Long id;

    /**
     * Дата и время начала массажа
     */
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;

    /**
     * Дата и время окончания массажа
     */
    @Column(nullable = false, name = "end_time")
    private LocalDateTime endTime;

    /**
     * Статус заказа
     */
    @Column(nullable = false, name = "status")
    private OrderStatus status;

    /**
     * Вид массажа
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = Massage.class,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "massage_id", referencedColumnName = "id", nullable = false)
    private Massage massage;

    /**
     * Тот, кому делается массаж
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = MUser.class,
            cascade = {CascadeType.ALL},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private MUser client;

    /**
     * Сотрудник, исполняющий массаж
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = Employee.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employee;

    /**
     * Место массажа
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = Place.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "place_id", referencedColumnName = "id", nullable = false)
    private Place place;
}
