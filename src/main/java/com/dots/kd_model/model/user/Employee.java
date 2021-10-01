package com.dots.kd_model.model.user;

import com.dots.kd_model.model.IEntity;
import com.dots.kd_model.model.Massage;
import com.dots.kd_model.model.Place;
import com.dots.kd_model.model.Position;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "employee", schema = "public")
public class Employee implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "EMPLOYEE_SEQ_GEN")
    private Long id;

    @Column(nullable = false, length = 1000)
    private String email;

    @Column(nullable = false, name = "first_name")
    private String firstName;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(nullable = false)
    private String patronymic;

    @Column(nullable = false, name = "phone_number")
    private String phoneNumber;

    @Column(name = "telegram_id")
    private Long telegramId;

    @Column(name = "vk_id")
    private Long vkId;

    /**
     * Должность
     */
    @ToString.Exclude
    @OneToOne(
            targetEntity = Position.class,
            fetch = FetchType.EAGER)
    @JoinColumn(name = "position_id", referencedColumnName = "id", nullable = false)
    private Position position;

    /**
     * Виды массажа
     */
    @ToString.Exclude
    @ManyToMany(
            mappedBy = "employees",
            targetEntity = Massage.class,
            fetch = FetchType.EAGER)
    private Set<Massage> massages;

    /**
     * Салоны, где работает сотрудник
     */
    @ToString.Exclude
    @ManyToMany(
            mappedBy = "employees",
            targetEntity = Place.class,
            fetch = FetchType.EAGER)
    private Set<Place> places;
}
