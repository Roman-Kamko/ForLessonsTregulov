package myDB.collections.set_interface;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
    public static void main(String[] args) {

        Set<Integer> set1 = new HashSet<>();

        set1.add(5);
        set1.add(2);
        set1.add(3);
        set1.add(1);
        set1.add(8);

        Set<Integer> set2 = new HashSet<>();

        set2.add(7);
        set2.add(4);
        set2.add(5);
        set2.add(3);
        set2.add(8);

        Set<Integer> union = new HashSet<>(set1);
        union.addAll(set2);         // объеденит сеты
        System.out.println(union);

        Set<Integer> intersect = new HashSet<>(set1);
        intersect.retainAll(set2);         // оставит только совпадающие элементы
        System.out.println(intersect);

        Set<Integer> subtract = new HashSet<>(set1);
        subtract.removeAll(set2);         // оставит только не совпадающие элементы
        System.out.println(subtract);
    }
}
