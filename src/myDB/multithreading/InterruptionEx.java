package myDB.multithreading;

public class InterruptionEx {
    //    interrupt() - не прерывает поток, а посылает сигнал потоку, что его хотят прервать.
    //    isInterrupted() - возможность в самом потоке проверить, хотят ли его прервать. Что
    //    делать, если данная проверка показала, что поток хотят прервать, должен решать сам
    //    программист.
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main starts");

        InterruptionThread interruptionThread = new InterruptionThread();

        interruptionThread.start();
        Thread.sleep(2000);
        interruptionThread.interrupt();
        interruptionThread.join();

        System.out.println("main ends");
    }
}

class InterruptionThread extends Thread {
    public void run() {
        double sqrtSum = 0;
        for (int i = 0; i < 1_000_000_000; i++) {
            if (isInterrupted()) {
                System.out.println("поток хотят прервать");
                System.out.println("убедились, что состояние всех объектов нормальное " +
                        "и решили завершить работу потока");
                System.out.println(sqrtSum);
                return;
            }
            sqrtSum += Math.sqrt(i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                System.out.println("поток хотят прервать во время сна. " +
                        "давайте завершим его работу");
                System.out.println(sqrtSum);
                return;
            }
        }
        System.out.println(sqrtSum);
    }
}