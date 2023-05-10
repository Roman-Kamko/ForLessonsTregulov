package myDB.multithreading;

public class ConcurrencyParallelism {
    /*
     * Concurrency - совпадение, согласованный, параллельный
     *
     * Parallelism - параллелизм
     *
     * Concurrency - это выполнение нескольких задач, но не обязательно в одно и то же время,
     * как это достигается - зависит от процессора компьютера. Например: петь и кушать, выполнять
     * одновременно не возможно, как будто процессор одноядерный(одноядерный процессоры тоже
     * на самом деле имеют многопоточность за счет context switch технологии,
     * идет постоянное прерывание одного потока и переход в другой(чуть-чуть кушаем - поем,
     * опять чуть-чуть кушаем и поем и т.д.))
     *
     * Parallelism - готовить и говорить по телефону - это на самом деле тоже Concurrency,
     * но достигается с помощью Parallelism, можно делать и то и то одновременно(многоядерный
     * процессор).
     *
     * Т.е. Concurrency и Parallelism - это не одно и тоже, но и не являются взаимоисключащими.
     *
     * Подытожим:
     *
     * Concurrency - выполнение нескольких задач.
     * Parallelism - выполнение нескольких задач в одно и то же время. В многоядерных
     * процессорах Concurrency может достигаться за счет Parallelism.
     * */
}
