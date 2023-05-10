package myDB.multithreading;

public class Intro {

    /*
    * Многопоточность - это принцип построения программы, при котором несколько блоков кода
    * могут выполняться одновременно. Основные цели многопоточности:
    * - производительность
    * - выполнение нескольких задач одновременно
    * */
    public static void main(String[] args) {

//        В этом коде все выполняется последовательно, работает 1 поток:
//        System.out.println("privet");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(i);
//        }
//        System.out.println("poka");

//        Варианты создания потока:
        MyThread1 myThread1 = new MyThread1();
        MyThread2 myThread2 = new MyThread2();

        myThread1.start(); // метод run() автоматически запускается JVM'ом после вызова метода start()
        myThread2.start();
//        между этими потоками нет никакой синхронизации и мы не знаем какой из потоков раньше начнет и закончит
//        и каждый раз результат вывода будет разным. На самом деле тут работают 3 потока, а не 2.
//        Поток main автоматически создается, а от него отделяются 2 потока, но поток main продолжает работать.
//        Даже если main поток завершил работу, программа не остановится до тех пор,
//        пока остальные потоки не завершат свою работу.
//        Так же не обязательно запускать два разных потока, мы можем запустить два первых потока, они просто будут
//        выполнять одинаковую работу.

//        class MyThread1 extends Thread - 1й вариант создания потока, но т.к. в джаве нет множественного наследования,
//        а нам нужно чтобы класс отнаследовался от другого класса, то мы можем использовать интерфейс Runnable,
//        он же и является наиболее часто используемым

        Thread thread1 = new Thread(new MyThread3());
        Thread thread2 = new Thread(new MyThread4());

        thread1.start();
        thread2.start();

//        Если нам нужно выполнять параллельно две задачи еще можно просто сделать класс наследником Thread
//        или имплементировать Runnable, и создать в нем метод main. В наследнике Thread переопределить метод run(),
//        а тело второго потока просто написать в методе main. Т.к. как мы уже выяснили что main это тоже поток,
//        мы получим параллельное выполнение двух задач.

        // 3ий ВАРИАНТ СОЗДАНИЯ ПОТОКА:

//        Так же потоки можно создавать на скорую руку без использования имплементаций Runnable или наследования Thread
//        при помощи анонимных классов:
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("privet"); // "privet" выведет этот поток, а не поток main
            }
        }).start();

//        Так же можно при этом использовать лямбда выражения:
        new Thread(() -> System.out.println("privet")).start();

    }
}

// 1й ВАРИАНТ СОЗДАНИЯ ПОТОКА:
class MyThread1 extends Thread {
    public void run() {  // переопределяем метод, прописываем логику потока
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
    // если run() не переопределить, то поток не запустится, т.к. byDefault он пустой
}

class MyThread2 extends Thread {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}

// 2ой ВАРИАНТ СОЗДАНИЯ ПОТОКА:
class MyThread3 implements Runnable {
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i);
        }
    }
}

class MyThread4 implements Runnable {
    public void run() {
        for (int i = 1000; i > 0; i--) {
            System.out.println(i);
        }
    }
}