package com.dots.kd_model.model.notification;

import com.dots.kd_model.model.IEntity;
import com.dots.kd_model.model.order.Order;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "notification", schema = "public")
public class Notification implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTIFICATION_SEQ_GEN")
    private Long id;

    @Column(nullable = false, name = "notify_time")
    private LocalDateTime notifyTime;

    @Column(nullable = false, name = "status")
    private NotificationStatus status;

    @Column(nullable = false, name = "through_type")
    private NotificationThroughType throughType;

    @OneToOne(
            targetEntity = NotificationMessage.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "notification_message_id", referencedColumnName = "id", nullable = false)
    private NotificationMessage message;

    @ToString.Exclude
    @OneToOne(
            targetEntity = Order.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id", referencedColumnName = "id", nullable = false)
    private Order order;
}
