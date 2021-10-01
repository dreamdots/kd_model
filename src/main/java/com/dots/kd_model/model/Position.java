package com.dots.kd_model.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "position", schema = "public")
public class Position implements IEntity<String> {

    @Id
    private String description;

    @Override
    public String getId() {
        return description;
    }

    @Override
    public void setId(String id) {
        this.description = description;
    }
}
