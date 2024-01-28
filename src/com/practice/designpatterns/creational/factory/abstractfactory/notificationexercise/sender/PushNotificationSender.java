package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.NotificationType;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.Notification;

public class PushNotificationSender extends NotificationSender {

    public PushNotificationSender(Notification notification) {
        super(notification);
    }

    @Override
    public void send() {
        System.out.println("Sending Push notification to " + getNotification().getRecipient());
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
