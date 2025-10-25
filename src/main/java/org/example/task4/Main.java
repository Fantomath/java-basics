package org.example.task4;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("DEADLOCK EXAMPLE");
        DeadlockExample.runDemo();

        Thread.sleep(2000);

        System.out.println("\nLIVELOCK EXAMPLE");
        LivelockExample.runDemo();

        Thread.sleep(2000);

        System.out.println("\nALTERNATING THREADS EXAMPLE");
        AlternatingThreads.runDemo();
    }
}
