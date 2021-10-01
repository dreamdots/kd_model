package com.dots.kd_model.model.notification;

import com.dots.kd_model.model.IEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "notification_message", schema = "public")
public class NotificationMessage implements IEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "NOTIFICATION_MESSAGE_SEQ_GEN")
    private Long id;

    @Column(nullable = false, length = 1000)
    private String text;
}
