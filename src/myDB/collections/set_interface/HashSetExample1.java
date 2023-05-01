package myDB.collections.set_interface;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample1 {
    /* Set - коллекция, хранящая только уникальные элементы, его методы очень быстры.
       HashSet, как и HashMap не запоминает порядок добавления элементов. В основе HashSet
       лежит HashMap, у элементов данного HashMap: ключи - это элементы HashMap,
       значение - константа-заглушка*/
    public static void main(String[] args) {

        Set<String> set = new HashSet<>();

        set.add("zaur");
        set.add("oleg");
        set.add("marina");
        set.add("igor");
        set.add("igor"); // ничего не произойдет, он просто не добавится, т.к. является дубликатом

        System.out.println(set);

        set.remove("zaur");

        System.out.println(set);

        System.out.println(set.size());

        System.out.println(set.isEmpty());

        System.out.println(set.contains("marina"));

    }
}
