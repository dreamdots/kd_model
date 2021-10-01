package com.dots.kd_model.model.order;

public enum OrderStatus {
    NEW,
    INCLUDE_IN_SCHEDULE,
    IN_WORK,
    CANCELED,
    COMPLETE,
    NOONE;

    public static OrderStatus findByName(String name) {
        for (OrderStatus value : OrderStatus.values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return NOONE;
    }
}
