package myDB.multithreading;

import java.util.Date;

public class SomeSituation {
    /*
    * Различные ситуации возникающие в многопоточном программировании:
    *
    * Deadlock - ситуация, когда 2 или более потока залочены навсегда, ожидают друг друга и
    * ничего не делают(возникает когда потоки используют синхронизацию на нескольких объектах
    * и эти потоки используют синхронизацию не в одинаковом порядке).
    *
    * В примере ниже есть высокий шанс получить Deadlock, поток4 может захватить лок1, а
    * поток5 может захватить лок2, что в итоге даст то что 2 потока ждут друг друга
    * до бесконечности. Чтобы исправить эту ситуацию нужно просто локи указывать
    * в одинаковом порядке
    *
    * Livelock - ситуация, когда 2 или более потока залочены навсегда, ожидают друг друга,
    * проделывают какую-то работу, но без прогресса(например один поток вносит изменения
    * в документ, а второй стирает все изменения, работа будет бесконечной, т.к. результат
    * не достижим)
    *
    * Lock starvation(голодание) - ситуация, когда менее приоритетные потоки ждут долгое
    * время или все время для того, чтобы могли запуститься(например, есть несколько потоков
    * с высоким приоритетом и с низким или средним и при этом у нас попутно создаются еще
    * новые высокоприоритетные потоки, в результате всего этого не понятно, а будут ли
    * вообще работать потоки с более низким приоритетом)
    * */

    public static final Object lock1 = new Object();
    public static final Object lock2 = new Object();

    public static void main(String[] args) {
        Thread4 thread4 = new Thread4();
        Thread5 thread5 = new Thread5();
        thread4.start();
        thread5.start();
    }

}

class Thread4 extends Thread {
    public void run() {
        System.out.println("Thread4: попытка захватить монитор объекта lock1");
        synchronized (SomeSituation.lock1) {
            System.out.println("Thread4: монитор объекта lock1 захвачен");
            System.out.println("Thread4: попытка захватить монитор объекта lock2");
            synchronized (SomeSituation.lock2) {
                System.out.println("Thread4: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}

class Thread5 extends Thread {
    public void run() {
        System.out.println("Thread5: попытка захватить монитор объекта lock2");
        synchronized (SomeSituation.lock2) {
            System.out.println("Thread5: монитор объекта lock2 захвачен");
            System.out.println("Thread5: попытка захватить монитор объекта lock1");
            synchronized (SomeSituation.lock1) {
                System.out.println("Thread5: мониторы объектов lock1 и lock2 захвачены");
            }
        }
    }
}
