package myDB.multithreading;

public class DataRaceAndSynchronized {
    /*
    * synchronised - позволяет избежать data race, не разрешая обращаться другим потокам к
    * методу, пока его использует один из потоков. Поток заходя в метод вешает замок и снимает
    * его только после выхода, давая возможность зайти другому потоку.
    * */
    public static void main(String[] args) {
        MyRunnableImpl runnable = new MyRunnableImpl();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread3.start();
        // Такая ситуация называется Data Race, тут каждый поток старается побыстрее
        // выполнить свою работу и из-за этого мы будем постоянно получать разные
        // результаты переменной count
    }
}

class Counter {
    static int count = 0;
}

class MyRunnableImpl implements Runnable {
    public synchronized void increment() {
        Counter.count++;
        System.out.print(Counter.count + " ");
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            increment();
        }
    }
}
