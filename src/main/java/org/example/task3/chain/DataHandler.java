package org.example.task3.chain;

public class DataHandler extends Handler {
    @Override
    public void handle(String request) {
        System.out.println("Обработка данных...");
        if (next != null) next.handle(request);
    }
}
