package org.example.task4;

public class DeadlockExample {
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();

    public void methodA() {
        synchronized (lock1) {
            System.out.println(Thread.currentThread().getName() + " locked lock1");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName() + " locked lock2");
            }
        }
    }

    public void methodB() {
        synchronized (lock2) {
            System.out.println(Thread.currentThread().getName() + " locked lock2");
            try { Thread.sleep(100); } catch (InterruptedException ignored) {}
            synchronized (lock1) {
                System.out.println(Thread.currentThread().getName() + " locked lock1");
            }
        }
    }

    public static void runDemo() {
        DeadlockExample example = new DeadlockExample();
        Thread t1 = new Thread(example::methodA, "Thread-1");
        Thread t2 = new Thread(example::methodB, "Thread-2");

        t1.start();
        t2.start();
    }
}
