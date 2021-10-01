package com.dots.kd_model.model.notification;

public enum NotificationStatus {
    NEW,
    CANCELED,
    ERROR,
    SENT,
    NOONE;

    public static NotificationStatus findByName(String name) {
        for (NotificationStatus value : NotificationStatus.values()) {
            if (value.name().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return NOONE;
    }
}
