package org.example.task3.chain;

public class LoggingHandler extends Handler {
    @Override
    public void handle(String request) {
        System.out.println("Запись в лог: " + request);
    }
}
