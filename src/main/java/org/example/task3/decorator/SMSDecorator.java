package org.example.task3.decorator;

public class SMSDecorator implements Notifier {
    private final Notifier notifier;

    public SMSDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Отправка SMS: " + message);
    }
}
