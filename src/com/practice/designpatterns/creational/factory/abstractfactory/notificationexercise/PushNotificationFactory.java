package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.Notification;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.PushNotification;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender.NotificationSender;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender.PushNotificationSender;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template.NotificationTemplate;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template.PushNotificationTemplate;

public class PushNotificationFactory extends NotificationFactory {
    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }

    @Override
    public Notification createNotification(String recipient, String sender, NotificationTemplate template) {
        return new PushNotification(recipient, template);
    }

    @Override
    public NotificationTemplate createTemplate(String message) {
        return new PushNotificationTemplate(message);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new PushNotificationSender(notification);
    }
}
