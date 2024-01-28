package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.Notification;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender.NotificationSender;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template.NotificationTemplate;

public abstract class NotificationFactory {
    public abstract NotificationType notificationType();
    public abstract Notification createNotification(String recipient, String sender, NotificationTemplate template);
    public abstract NotificationTemplate createTemplate(String message);
    public abstract NotificationSender createNotificationSender(Notification notification);
}
