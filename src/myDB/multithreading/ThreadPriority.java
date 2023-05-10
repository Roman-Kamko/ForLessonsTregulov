package myDB.multithreading;

public class ThreadPriority {
    // Если мы не зададим имя и приоритет потока, то он получит дефолтные значения
    // имя: Thread-0...n, приоритет: 5.
    // Приоритет можно изменить от 1 до 10, где 10 наивысший приоритет, но никакой
    // гарантии нет, что поток с наивысшим приоритетом запустится раньше потока с
    // меньшим приоритетом.
    // .currentThread() показывает текущий поток, т.е. если внутри метода run()
    // запуская этот метод он показывает в каком потоке мы находимся
    public static void main(String[] args) {
        MyThread myThread = new MyThread();

        myThread.setName("MyThread");
        myThread.setPriority(10); //или
        myThread.setPriority(Thread.MAX_PRIORITY); // для читабельности лучше указывать так
        System.out.println(myThread.getName() + " " + myThread.getPriority());

        Thread thread = new Thread(new MyThread5());
        thread.start();
//        thread.run(); так запускать нельзя, т.к. в этом случае он будет выполняться как
//        часть потока main
        System.out.println("Method main. Thread name = " + Thread.currentThread().getName());
    }
}

class MyThread extends Thread {
    @Override
    public void run(){
        System.out.println("privet");
    }
}

class MyThread5 implements Runnable {

    @Override
    public void run() {
        System.out.println("Method run. Thread name = " + Thread.currentThread().getName());
    }
}
