package com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise;

import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.EmailNotification;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.notification.Notification;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender.EmailNotificationSender;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.sender.NotificationSender;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template.EmailNotificationTemplate;
import com.practice.designpatterns.creational.factory.abstractfactory.notificationexercise.template.NotificationTemplate;

public class EmailNotificationFactory extends NotificationFactory {

    @Override
    public NotificationType notificationType() {
        return NotificationType.EMAIL;
    }

    @Override
    public Notification createNotification(String recipient, String sender, NotificationTemplate template) {
        return new EmailNotification(recipient, sender, template);
    }

    @Override
    public NotificationTemplate createTemplate(String message) {
        return new EmailNotificationTemplate(message);
    }

    @Override
    public NotificationSender createNotificationSender(Notification notification) {
        return new EmailNotificationSender(notification);
    }
}
