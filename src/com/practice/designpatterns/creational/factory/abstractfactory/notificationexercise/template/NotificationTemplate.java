package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.NotificationType;

public abstract class NotificationTemplate {
    private String message;

    public NotificationTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public abstract String applyTemplate();
    public abstract NotificationType notificationType();
}
