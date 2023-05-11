package myDB.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolAndExecutorService {
    /*
    * Thread pool - это множество потоков, каждый из которых предназначен для выполнения
    * той или иной задачи.
    *
    * С thread pool'ами удобнее всего работать посредством ExecutorService
    *
    * Thread pool удобнее создавать, используя factory методы класса Executors:
    * Executors.newFixedThreadPool(int count) - пул с указанным числом потоков
    * Executors.newSingleThreadExecutors() - пул с одним потоком
    *
    * ExecutorService - передает задание в thread pool
    * shutdown() - дает понять ExecutorService, что новых заданий больше не будет
    * awaitTermination() - принуждает поток в котором он вызвался подождать до тех пор,
    * пока не выполниться одно из двух событий: либо ExecutorService прекратит свою работу,
    * либо пройдет указанное время в параметре метода.
    * */
    public static void main(String[] args) throws InterruptedException {
//        ExecutorService executorService = new ThreadPoolExecutor() - напрямую почти
//        никогда не создают, а используют один их фэктори методов класса Executors

        ExecutorService executorService = Executors.newFixedThreadPool(5);
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImpl100());
            // прогр не закончится до тех пор пока не завершить работу экзекьютер сервиса
        }
        executorService.shutdown(); // завершает работу экзекьютер сервиса
        // если мы не намерены давать новую работуэкзекьютер сервису,
        // то его обязательно нужно закрыть
        executorService.awaitTermination(5, TimeUnit.SECONDS);
        System.out.println("main ends");

    }
}

class RunnableImpl100 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}
