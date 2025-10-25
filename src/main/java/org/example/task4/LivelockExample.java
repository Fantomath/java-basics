package org.example.task4;

public class LivelockExample {
    public static void runDemo() {
        final Worker w1 = new Worker();
        final Worker w2 = new Worker();

        new Thread(() -> {
            while (w1.isActive()) {
                if (w2.isActive()) {
                    System.out.println("Worker 1: waiting for Worker 2");
                    try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                    continue;
                }
                w1.work();
                System.out.println("Worker 1: working");
            }
        }).start();

        new Thread(() -> {
            while (w2.isActive()) {
                if (w1.isActive()) {
                    System.out.println("Worker 2: waiting for Worker 1");
                    try { Thread.sleep(100); } catch (InterruptedException ignored) {}
                    continue;
                }
                w2.work();
                System.out.println("Worker 2: working");
            }
        }).start();
    }
}
