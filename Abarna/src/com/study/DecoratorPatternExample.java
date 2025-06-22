package com.study;
interface Notifier {
    void send(String message);
}

// Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending Email notification: " + message);
    }
}

// Abstract Decorator
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappee;

    public NotifierDecorator(Notifier notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message) {
        wrappee.send(message);
    }
}

// Concrete Decorator - SMS
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // send via wrapped notifier first
        sendSMS(message);     // add SMS notification
    }

    private void sendSMS(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// Concrete Decorator - Slack
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);  // send via wrapped notifier first
        sendSlack(message);   // add Slack notification
    }

    private void sendSlack(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}

// Test class with main method
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Basic email notifier
        Notifier emailNotifier = new EmailNotifier();

        System.out.println("=== Email Only ===");
        emailNotifier.send("Hello User!");

        System.out.println("\n=== Email + SMS ===");
        Notifier emailPlusSMS = new SMSNotifierDecorator(emailNotifier);
        emailPlusSMS.send("Hello User!");

        System.out.println("\n=== Email + SMS + Slack ===");
        Notifier emailSMSSlack = new SlackNotifierDecorator(emailPlusSMS);
        emailSMSSlack.send("Hello User!");

        System.out.println("\n=== SMS + Slack (No Email) ===");
        Notifier smsSlack = new SlackNotifierDecorator(new SMSNotifierDecorator(new Notifier() {
            @Override
            public void send(String message) {
                // No base notifier (empty implementation)
            }
        }));
        smsSlack.send("Hello User!");
    }
}
