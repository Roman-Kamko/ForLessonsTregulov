package myDB.multithreading;

public class DaemonThread {
    /*
    * Все потоки которые мы вызывали до этого были User потоками, т.е. несмотря на то, что
    * main поток закончил свою работу, программа продолжала работать до тех пор пока остальные
    * потоки не завершат работу(user потоки), но порграмма не будет ждать завершения daemon
    * потока и прекратит свою работу как только завершится робота всех user потоков.
    *
    * Daemon потоки предназначены для выполнения фоновых задач и оказания различных сервисов
    * user потокам.
    *
    * setDemon() - делает поток демоном, но поток необходимо объявить демоном до начала
    * работы потока.
    *
    * isDaemon - позволяет узнать поток является демон потоком или нет
    * */
    public static void main(String[] args) {
        System.out.println("main thread starts");

        User user = new User();
        user.setName("user_thread");

        Daemon daemon = new Daemon();
        daemon.setName("daemon_thread");
        daemon.setDaemon(true);

        user.start();
        daemon.start();

        System.out.println("main thread ends");
    }
}

class User extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (int i = 'A'; i <= 'j'; i++) {
            try {
                sleep(300);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Daemon extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is daemon: " + isDaemon());
        for (char i = 1; i <= 1000; i++) {
            try {
                sleep(100);
                System.out.println(i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}