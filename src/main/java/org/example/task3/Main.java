package org.example.task3;

import org.example.task3.strategy.*;
import org.example.task3.chain.*;
import org.example.task3.builder.*;
import org.example.task3.proxy.*;
import org.example.task3.decorator.*;
import org.example.task3.adapter.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n--- STRATEGY ---");
        PaymentContext context = new PaymentContext(new PayPalPayment());
        context.pay(1000);
        context.setStrategy(new CreditCardPayment());
        context.pay(500);

        System.out.println("\n--- CHAIN ---");
        Handler chain = new AuthHandler();
        chain.setNext(new DataHandler()).setNext(new LoggingHandler());
        chain.handle("User request");

        System.out.println("\n--- BUILDER ---");
        User user = new UserBuilder()
                .setName("Alice")
                .setEmail("alice@example.com")
                .setAge(25)
                .build();
        System.out.println(user);

        System.out.println("\n--- PROXY ---");
        Image image = new ProxyImage("photo.png");
        image.display();
        image.display();

        System.out.println("\n--- DECORATOR ---");
        Notifier notifier = new SMSDecorator(new EmailDecorator(new BaseNotifier()));
        notifier.send("Hello World!");

        System.out.println("\n--- ADAPTER ---");
        AudioPlayer player = new AudioPlayer();
        player.play("mp3", "song.mp3");
        player.play("mp4", "video.mp4");
    }
}
