package com.dots.kd_model.model.user;

import com.dots.kd_model.model.IEntity;
import com.dots.kd_model.model.notification.NotificationThroughType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Collections;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Table(name = "user", schema = "public")
public class User extends org.springframework.security.core.userdetails.User implements IEntity<String> {

    public User() {
        this(null, null, Collections.emptyList());
    }

    public User(String username, String password, List<GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Id
    private String username;

    @Column(nullable = false, length = 500)
    private String password;

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

    @Column(nullable = false, name = "account_not_expired")
    private boolean accountNonExpired;

    @Column(nullable = false, name = "account_non_locked")
    private boolean accountNonLocked;

    @Column(nullable = false, name = "credentials_non_expired")
    private boolean credentialsNonExpired;

    @Column(nullable = false)
    private boolean enabled;

    @Column(nullable = false, name = "through_type")
    private NotificationThroughType throughType;

    @Column(name = "telegram_id")
    private Long telegramId;

    @Column(name = "vk_id")
    private Long vkId;

    @Override
    public String getId() {
        return username;
    }

    @Override
    public void setId(String id) {
        this.username = id;
    }
}
