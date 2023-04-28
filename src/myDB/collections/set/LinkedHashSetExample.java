package myDB.collections.set;

import java.util.LinkedHashSet;

public class LinkedHashSetExample {
    /* LinkedHashSet является наследником HashSet. Хранит информацию о порядке добавления элементов.
       Производительность немного ниже чем у HashSet. В основе LinkedHashSet лежит HashMap, а не LinkedHashMap,
       и в нем не реализованна возможность запоминать последовательность элементов в зависимости от их использования.
       У элементов данного HashMap: ключи - это элементы LinkedHashSet, значения - константа заглушка. */
    public static void main(String[] args) {
        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.add(5);
        lhs.add(3);
        lhs.add(1);
        lhs.add(8);
        lhs.add(10);
        System.out.println(lhs);
        lhs.remove(8);
        System.out.println(lhs);
        System.out.println(lhs.contains(8));
    }
}
