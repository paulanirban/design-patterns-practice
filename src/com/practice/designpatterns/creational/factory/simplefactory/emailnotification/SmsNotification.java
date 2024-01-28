package com.practice.designpatterns.creational.factory.simplefactory.emailnotification;

public class SmsNotification extends Notification {
    private final String recipient;
    private final String message;

    public SmsNotification(String recipient,  String message) {
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
        // Logic to send an SMS
        System.out.println("SMS sent to " + recipient);
        System.out.println("Message: " + message);
    }

    @Override
    public NotificationType notificationType() {
        return NotificationType.SMS;
    }
}
