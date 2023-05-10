package myDB.multithreading;

public class MonitorSynchronizedBlocks2 {
    /*
    * В данном примере вешать synchronized просто на методы не поможет, они все равно
    * начнут выполняться одновременно, т.к. по умолчанию при указании synchronized
    * в не статичном методе синхронизация идет по этому объекту(this), но у всех трех
    * методов объекты будут разными. Поэтому нам нужно использовать synchronized блоки
    * и явно указать по какому объекту синхронизироваться. Для этого создадим объект
    * класса Object его принято называть lock.
    * */
    static final Object lock = new Object();

    void mobileCall() {
        System.out.println("mobile call starts");
        synchronized (lock) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("mobile call ends");
        }
    }

    void skypeCall() {
        synchronized (lock) {
            System.out.println("mobile call starts");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("mobile call ends");
        }
    }

    void whatsappCall() {
        synchronized (lock) {
            System.out.println("mobile call starts");
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("mobile call ends");
        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableImplMobile());
        Thread thread2 = new Thread(new RunnableImplSkype());
        Thread thread3 = new Thread(new RunnableImplWhatsapp());

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class RunnableImplMobile implements Runnable {
    @Override
    public void run() {
        new MonitorSynchronizedBlocks2().mobileCall();
    }
}

class RunnableImplSkype implements Runnable {
    @Override
    public void run() {
        new MonitorSynchronizedBlocks2().skypeCall();
    }
}

class RunnableImplWhatsapp implements Runnable {
    @Override
    public void run() {
        new MonitorSynchronizedBlocks2().whatsappCall();
    }
}