package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.NotificationType;

public class PushNotificationTemplate extends NotificationTemplate {
    public PushNotificationTemplate(String message) {
        super(message);
    }
    @Override
    public String applyTemplate() {
        System.out.println("Applying Push notification template");
        return getMessage();
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
