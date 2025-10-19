package org.example.task3.strategy;

public class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Оплата " + amount + "₽ через PayPal.");
    }
}
