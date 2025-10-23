package org.example.task3.chain;

public class AuthHandler extends Handler {
    @Override
    public void handle(String request) {
        System.out.println("Проверка авторизации...");
        if (next != null) next.handle(request);
    }
}
