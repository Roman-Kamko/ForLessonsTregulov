package myDB.multithreading;

public class SleepJoin  extends Thread{
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
//          InterruptedException - появляется, когда другой поток просит этот поток
//          остановится(прервать), когда он находится в спячке, подробнее позже
                throw new RuntimeException(e);
            }
            // обработать исключение придется в методе ран, пробросить выше мы его не можем,
            // т.к. мы переопределяем метод который ничего не имплементирует
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        for (int i = 5; i > 0; i--) {
//            System.out.println(i);
//            Thread.sleep(1000); // усыпить поток значения в мс
//            // в данном случае усыпляем поток main, после каждой итерации поток будет
//            // засыпать на 1 сек
//        }
//        System.out.println("Поехали!!!");
        Thread thread1 = new Thread(new MyRunnable1());
        SleepJoin thread2 = new SleepJoin();
        thread1.start();
        thread2.start();
//        System.out.println("End");
        // эта строка выйдет первой в консоле, т.к. поток main запустил два других потока
        // и продолжил свою работу и он не спит в отличие от двух других, при этом после
        // вывода строки поток main завершится, но программа продолжит работать пока
        // не завершится работа других потоков
        // Если же мы хотим чтобы вывод строки "End" происходил после завершения работы
        // двух других потоков, то в этом поможет метод join()
        thread1.join(); // поток main будет ждать окончания работы потока thread1
        thread2.join(); // поток main будет ждать окончания работы потока thread2
        System.out.println("End");

        Thread thread3 = new Thread(new Worker());
        System.out.println(thread3.getState()); // информация о состоянии потока
        thread3.start();
        System.out.println(thread3.getState()); // информация о состоянии потока
        thread3.join(4000); // поток main будет ждать что наступит быстрее:
                                 // либо завершения потока Thread3,
                                 // либо пока не пройдет 1,5сек.
        System.out.println(thread3.getState()); // информация о состоянии потока
        System.out.println("Method main ends");
        /*
        * Thread states(состояния потока):
        * 1. new - после создания потока, до вызова start()
        * 2. runnable - после вызова start(), делится на 2 сотояния:
        *   2.1. ready - состояние готовности, ждет ОС которая запустит его
        *   2.2. running - процесс выполнения потока
        * 3. terminated - работа потока завершена
        *
        * .getState() - с выводом состояния нужно быть очень аккуратным, если наш поток
        * очень быстрый(а не как в примере, из-зи того что мы усыпляем поток), то мы можем
        * получать не актуальную информацию
        *  */
    }
}

class MyRunnable1 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // обработать исключение придется в методе ран, пробросить выше мы его не можем,
            // т.к. мы переопределяем метод который ничего не имплементирует
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }
}

class Worker implements Runnable {
    @Override
    public void run() {
        System.out.println("Work begins");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work done");
    }
}