package myDB.collections.queue_interface;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeExample {
    /* Deque - Double Ended Queue - двунапрвленная очередь.
       В такой очереди элементы могут использоваться с обоих концов.
       Здесь работают оба правила - FIFO и LIFO.
       Интерфейс Deque реализуется классами LinkedList и ArrayDeque */
    public static void main(String[] args) {

        Deque<Integer> integers = new ArrayDeque<>();

        integers.addFirst(3);
        integers.addFirst(5);
        integers.addLast(7);
        integers.offerFirst(1);
        integers.offerLast(8);
        System.out.println(integers);

        System.out.println(integers.getFirst());
        System.out.println(integers.getLast());
        System.out.println(integers.peekFirst());
        System.out.println(integers.peekLast());

        System.out.println(integers.removeFirst());
        System.out.println(integers);
        System.out.println(integers.removeLast());
        System.out.println(integers);
        System.out.println(integers.pollFirst());
        System.out.println(integers);
        System.out.println(integers.pollLast());
        System.out.println(integers);
    }
}
