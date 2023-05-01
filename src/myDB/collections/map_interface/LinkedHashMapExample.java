package myDB.collections.map_interface;

import java.util.LinkedHashMap;

public class LinkedHashMapExample {
    /* LinkedHashMap наследник HashMap хранит информацию о порядке добавления элементов
    или порядке их использования производительность немного хуже, чем у HashMap */
    public static void main(String[] args) {
        LinkedHashMap<Double, Student> lhm = new LinkedHashMap<>(16, 0.75f, true);
        /* initialCapacity и loadFactor нам уже знакомы, а вот accessOrder отвечает за порядок элементов в LinkedHashMap
        *  false - в порядке добавления, true - в порядке использования, после использования элемента он, отправляется в конец */
        Student st1 = new Student("zaur", "tregulov", 3);
        Student st2 = new Student("mariya", "ivaniva", 1);
        Student st3 = new Student("sergey", "petrov", 4);
        Student st4 = new Student("igor", "tregulov", 3);

        lhm.put(5.8, st1);
        lhm.put(6.4, st2);
        lhm.put(7.2, st3);
        lhm.put(7.5, st4);

        System.out.println(lhm);

        System.out.println(lhm.get(6.4)); // использование переместит элемент в конец
        System.out.println(lhm.get(5.8)); // использование переместит элемент в конец,
                                          // а элемент с ключом 6.4 станет предпоследним

        System.out.println(lhm);
    }
}
