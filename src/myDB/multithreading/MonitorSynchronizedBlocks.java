package myDB.multithreading;

public class MonitorSynchronizedBlocks {
    /*
    * Монитор - это сущность благодаря которой достигается корректная работа при
    * синхронизации. В java у каждого класса и объекта есть привязанный к нему монитор.
    * */

    public static void main(String[] args) {
        MyRunnableImpl2 runnable = new MyRunnableImpl2();
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

class Counter2 {
    static int count = 0;
}

class MyRunnableImpl2 implements Runnable {

    public void doWork2() {
        System.out.println("Ura!!!");
    }
    public void doWork1() {
        doWork2();               //не синхронизированная часть кода
        synchronized (this) {                       // синхронизированный блок кода
            Counter2.count++;                       // в скобках после synchronized
            System.out.println(Counter2.count);     // указывается объект по которому
        }                                           // синхронизироваться
    }
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            doWork1();
        }
    }
}
