package org.example.task4;

public class AlternatingThreads {
    private static final Object lock = new Object();
    private static boolean turnOne = true;

    public static void runDemo() {
        Thread t1 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (!turnOne) {
                        try { lock.wait(); } catch (InterruptedException ignored) {}
                    }
                    System.out.println("1");
                    turnOne = false;
                    lock.notifyAll();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            while (true) {
                synchronized (lock) {
                    while (turnOne) {
                        try { lock.wait(); } catch (InterruptedException ignored) {}
                    }
                    System.out.println("2");
                    turnOne = true;
                    lock.notifyAll();
                }
            }
        });

        t1.start();
        t2.start();
    }
}