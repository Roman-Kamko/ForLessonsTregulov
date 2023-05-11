package myDB.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolEx2 {
    public static void main(String[] args) {
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
//        scheduledExecutorService.schedule(new RunnableImpl200(), 3, TimeUnit.SECONDS);
//        scheduledExecutorService.shutdown();
//        выполнение задания по расписанию

//        scheduledExecutorService.scheduleAtFixedRate(new RunnableImpl200(),
//                3,1,TimeUnit.SECONDS);
//        выполнение по расписанию с переодичностью 1с в данном случае(1сек от начала
//        выполнения задачи, а не от конца)

        scheduledExecutorService.scheduleWithFixedDelay(new RunnableImpl200(),
                3, 1, TimeUnit.SECONDS);
//        выполнение по расписанию с переодичностью 1с в данном случае(1сек c момента окончания
//        выполнения задачи, а не от начала)

        ExecutorService executorService = Executors.newCachedThreadPool();
//        будет создавать потоки в пуле по надобности, если все треды заняты, то он создаст
//        новый тред, если тред не используется 60сек, то он удаляется

    }
}
class RunnableImpl200 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " begins work");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " ends work");
    }
}