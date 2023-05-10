package myDB.multithreading;

public class Volatile extends Thread{
    /*
     * При решении задач упорядоченность потоков очень важна, это достигается за счет
     * синхронизации.
     * volatile - делает так, что переменная будет храниться только в общей памяти и не
     * будет помещаться в кеш ядер, что позволит избежать ситуации описанной ниже. Т.е.
     * когда CPU1 и CPU2 требуется поработать с переменной, они будут обращаться напрямую к
     * main memory, а не к кешу.
     * */

//    boolean b = true;
    volatile boolean b = true;
//    Следует учесть, что volatile переменная работает корректно, когда только один поток
//    ее изменяет, а другие только читают

    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished, counter = " + counter);
    }
    public static void main(String[] args) throws InterruptedException {
        Volatile thread = new Volatile();
        thread.start();
        Thread.sleep(3000);
        System.out.println("After 3 seconds it is time to wake up");
        thread.b = false;
        System.out.println("End of programme");
        // В данном случае программа не закончит свою работу, не смотря на то, что мы меняем
        // значение переменной b на false. Происходит это потому что потоки работают на разных
        // ядрах, а у каждого ядра свой кеш, потоки скопировали значение переменной b как true
        // из общей памяти(main memory) в свои кеши. Потом мы изменили переменную b, но ее новое
        // значение находится в кеше ядра с потоком main и мы не знаем когда новое значение
        // попадет в main memory после чего кеш ядра с потоком thread прочитает это значение
        // и изменит значение у себя тоже и только после этого произойдет остановка программы.
        // Для того чтобы избежать такой ситуции используется ключ. слово volatile.
    }
}
