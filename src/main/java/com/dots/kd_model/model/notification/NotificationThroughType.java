package com.dots.kd_model.model.notification;

public enum NotificationThroughType {
    TELEGRAM,
    VK,
    EMAIL,
    NOONE;

    public static NotificationThroughType findByName(String name) {
        for (NotificationThroughType value : NotificationThroughType.values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return NOONE;
    }
}
