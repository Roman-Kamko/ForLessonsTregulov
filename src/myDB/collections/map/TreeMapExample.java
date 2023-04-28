package myDB.collections.map;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapExample {
//    Элементами TreeMap являются пары ключ-значение. В TreeMap элементы хранятся
//    в отсортированном по возрастанию порядке. В основе TreeMap лежит красно-черное
//    дерево, это позволяет работать методам быстро, но не быстрее чем в HashMap.
//    Основная цель TreeMap - нахождение рэнджей(отрезков). Красно-черное дерево - является двоичным самобалансирующимся деревом
    public static void main(String[] args) {
        TreeMap<Double, Student> map = new TreeMap<>();
        Student st1 = new Student("zaur", "tregulov", 3);
        Student st2 = new Student("mariya", "ivaniva", 1);
        Student st3 = new Student("sergey", "petrov", 4);
        Student st4 = new Student("igor", "tregulov", 3);
        Student st5 = new Student("vasiliy", "ivaniva", 1);
        Student st6 = new Student("sasha", "petrov", 4);
        Student st7 = new Student("elena", "petrov", 4);
        map.put(5.8, st1);
        map.put(6.4, st2);
        map.put(7.2, st3);
        map.put(7.5, st4);
        map.put(7.9, st5);
        map.put(8.2, st6);
        map.put(9.1, st7);

        System.out.println(map);
        System.out.println(map.get(6.4));
        map.remove(5.8);
        System.out.println(map);
        map.descendingMap(); // обратный порядок сортировки(по убыванию)
        map.tailMap(7.3); // найти значения со значением больше указанного
        map.headMap(7.3); // найти значения со значением меньше указанного
        map.lastEntry(); // вернет последние значение
        map.firstEntry(); // вернет первое значение

        TreeMap<Student, Double> map2 = new TreeMap<>(Comparator.comparing(o -> o.name));
        // в данном случае если в Student не будет имплементирован интерфейс Comparable,
        // то мы получим ClassCastException, т.к. в TreeMap хранит элементы в отсортированном
        // порядке и дерево просто не знает ка отсортировать класс Student, либо можно указать
        // компаратор при создании дерева при помощи анонимного класса или лямбда выражения
        // new TreeMap<>(Comparator.comparing(o -> o.name))
        // в TreeMap необязательно переропределять equals и hashCode при поиске по ключам так
        // как поиск и добавление осуществляется при помощи метода compareTo(), но их переопределение
        // считается хорошим тоном
        map2.put(st3, 7.2);
        map2.put(st2, 6.4);
        map2.put(st7, 9.1);
        map2.put(st1, 5.8);
        map2.put(st4, 7.5);
        map2.put(st6, 8.2);
        map2.put(st5, 7.9);
        System.out.println(map2);

    }
}
