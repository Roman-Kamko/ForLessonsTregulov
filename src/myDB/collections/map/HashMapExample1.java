package myDB.collections.map;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample1 {
    // HashMap - не является коллекцией, но тесно с ними связан. Хранит в себе значения в виде
    // пары ключ - значение, не запоминает порядок добавления, его методы работают очень быстро,
    // ключи не могут дублироваться, значения могут
    // если по простому, то в основе HashMap лежит массив, а элементами данного массива являются
    // структуры LinkedList, эти структуры и заполняются элементами которые мы добавляем в HashMap

    public static void main(String[] args) {
        Map<Integer, String> map1= new HashMap<>();
        map1.put(12345, "Zaur");
        map1.put(23154, "Ivan");
        map1.put(21483, "Marya");
        map1.putIfAbsent(12345, "Nikolay"); // добавляет элемент если еще нет элемента с таким ключом
        map1.put(12345, "Roman");    // т.к. ключи не могут повторяться, то тут просто произойдет перезапись значения
        System.out.println(map1);
        System.out.println(map1.get(12345)); // вывести значение по ключу
        System.out.println(map1.get(1000));   // вернет null, тк нет такого ключа
        map1.remove(23154);         // удалить элемент по ключу
        System.out.println(map1);
        map1.containsValue("Roman");   // проверяет есть ли элемент с указанным значением
        map1.containsKey(500);   // проверяет есть ли элемент с указанным ключом
        System.out.println(map1.keySet()); // возвращает все ключи
        System.out.println(map1.values()); // возвращает все значения

        for (Map.Entry<Integer, String> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
//        Entry это внутренний интерфейс Map, который имплементируется в Node, а Node является внутренним классом HashMap
//        Entry позволяет итерироваться по хэшмапе
    }
}
