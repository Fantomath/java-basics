package org.example.task3.decorator;

public class BaseNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Отправка базового уведомления: " + message);
    }
}
