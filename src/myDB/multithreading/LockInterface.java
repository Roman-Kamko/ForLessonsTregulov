package myDB.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterface {
    /*
    * Lock - интерфейс, который имплементируется классом ReentranLock.
    * Так же как и ключевое слово synchronised, Lock нужен для достижения синхронизации
    * между потоками.
    *
    * В примере ниже следующая ситуация, как только один из потоков начнет обрабатывать
    * какой-то метод, то другие потоки в этот же момент не смогут обработать другие методы,
    * они будут ждать обработки метода. По сути все тоже самое что и с синхронайзд блоком,
    * только другая реализация.
    * */
    public static void main(String[] args) {
        Call call = new Call();
        Thread thread1 =new Thread(call::mobileCall);
        Thread thread2 =new Thread(call::skypeCall);
        Thread thread3 =new Thread(call::whatsappCall);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobileCall() {
        lock.lock();
        try {
            System.out.println("mobile call starts");
            Thread.sleep(3000);
            System.out.println("mobile call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
            // unlock() писать нужно всегда в блоке finally, чтобы наш замок открывался в любом случае
        }
    }
    void skypeCall() {
        lock.lock();
        try {
            System.out.println("skype call starts");
            Thread.sleep(5000);
            System.out.println("skype call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    void whatsappCall() {
        lock.lock();
        try {
            System.out.println("whatsapp call starts");
            Thread.sleep(7000);
            System.out.println("whatsapp call ends");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}
