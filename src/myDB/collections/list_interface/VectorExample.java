package myDB.collections.list_interface;

import java.util.Vector;

public class VectorExample {
    // не рекомендуется к использованию, устаревшая структура данных, схожа с arrayList'ом, но все его методы помечены как synchronized(потокобезопасны)
    public static void main(String[] args) {
        Vector<String> vector = new Vector<>();
        vector.add("Misha");
        vector.add("Oleg");
        vector.add("Katya");
        System.out.println(vector);
        System.out.println(vector.firstElement());
        System.out.println(vector.lastElement());
        vector.remove(2);
        System.out.println(vector);
        System.out.println(vector.get(0));
    }
}
