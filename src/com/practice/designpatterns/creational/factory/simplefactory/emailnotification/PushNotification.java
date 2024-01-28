package com.practice.designpatterns.creational.factory.simplefactory.emailnotification;

public class PushNotification extends Notification {
    private final String recipient;
    private final String message;

    public PushNotification(String recipient, String message) {
        this.recipient = recipient;
        this.message = message;
    }

    @Override
    public String getRecipient() {
        return recipient;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void sendNotification() {
        // Logic to send a push notification
        System.out.println("Push notification sent to device " + recipient);
        System.out.println("Message: " + message);
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.PUSH;
    }
}
