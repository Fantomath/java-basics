package org.example.task3.decorator;

public class EmailDecorator implements Notifier {
    private final Notifier notifier;

    public EmailDecorator(Notifier notifier) {
        this.notifier = notifier;
    }

    @Override
    public void send(String message) {
        notifier.send(message);
        System.out.println("Отправка email: " + message);
    }
}
