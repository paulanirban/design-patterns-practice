package com.practice.designpatterns.creational.factory.simplefactory.emailnotification;

public abstract class Notification {
    protected String recipient;
    protected String message;
    public abstract String getRecipient();
    public abstract String getMessage();
    public abstract void sendNotification();
    public abstract NotificationType notificationType();
}
