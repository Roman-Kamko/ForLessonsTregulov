package myDB.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterface2 {
//    tryLock() - возвращает булеан, позволяет что-то делать когда ресурс свободен
//    или что-то другое когда ресурс занят другим потоком
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee("zaur", lock);
        new Employee("oleg", lock);
        new Employee("elena", lock);
        Thread.sleep(5000);
        new Employee("victor", lock);
        new Employee("marina", lock);
    }
}
class Employee extends Thread {
    private String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start(); // можно сунуть в конструктор, что бы не создавать новый поток
    }

    public void run() {
        if (lock.tryLock()) {
//            System.out.println(name + " ждет...");
//            lock.lock();
            System.out.println(name + " пользуется банкоматом");
            try {
                Thread.sleep(2000);
                System.out.println(name + " завершил свои дела");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
        } else {
            System.out.println(name + " не хочет ждать в очереди");
        }
    }
}
