package myDB.collections.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLinkedListExample {
    /* Queue - это коллекция хранящая последовательность элементов. Добавляется элемент в конец очереди,
       используется из начала - принцип FIFO.
       LinkedList имплементирует не только List, а еще и Deque, который в свою очередь расширяет Queue. */
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("zaur");
        queue.add("oleg");
        queue.add("ivan");
        queue.add("maria");
        queue.offer("aleksandr");
        /* .offer() метод который тоже добавляет элемент в очередь, но при использовании очередей с
           ограниченной вместимостью метод .add() при заполненной очереди выкинет эксепшн,
           а .offer() - нет, элемент просто не добавится */
        System.out.println(queue);

        System.out.println(queue.remove()); // удалит первого FIFO
        /* если очередь пуста и мы вызовем .remove(), то получим эксепшн NoSuchElementException,
           метод .poll(), с ним исключений не будет, он вернет null */
        System.out.println(queue.poll());

        System.out.println(queue);

        System.out.println(queue.element()); // показать первый элемент
        /* при пустой очереди, метод .element() выкинет NoSuchElementException,
           .peek(), если очередь пуста вернет null */
        queue.remove("maria"); // можно удалять любой элемент, но если такие удаления
                                  // производятся часто, то лучше выбрать другую коллекцию
    }
}
