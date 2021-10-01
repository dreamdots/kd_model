package com.dots.kd_model.model;

public interface IEntity<T> {
    T getId();

    void setId(T id);

    default void removeId() {
        this.setId(null);
    }
}
