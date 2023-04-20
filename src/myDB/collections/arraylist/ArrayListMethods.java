package myDB.collections.arraylist;

import java.util.ArrayList;
import java.util.List;

public class ArrayListMethods {
    public static void main(String[] args) {
        List<String> list2 = new ArrayList<>();
        list2.add("!!!");
        list2.add("???");
        List<String> arrList = new ArrayList<>();
        arrList.add("Roman");
        arrList.add("Mariya");
        arrList.add("Ivan");                   // добавление в конец
        arrList.add(1, "Misha");  // добавление по индексу, но нельзя указывать индекс больше чем (size - 1)
                                               // иначе получим OutOfBoundException

        arrList.get(2);                        // получить элемент по индексу
        arrList.set(1, "Masha");               // заменить элемент по индексу
        arrList.remove(0);               // удалить элемент по индексу, элементы стоящие после, сместятся влево
        arrList.remove("Ivan");             // удалить по элементу, для сравнения используется equals
        arrList.addAll(list2);                 // добавить все элементы другого листа в конец
        arrList.addAll(0, list2);         // добавить все элементы другого листа в указанное место, уже имеющиеся
                                               // значения сдвинутся вправо
        arrList.clear();                       // удалить все элементы
        arrList.indexOf("Ivan");               // вернет индекс объекта(первое совпадение) или -1 если такого нет,
                                               // для сравнения используется equals
        arrList.lastIndexOf("Ivan");        // вернет индекс объекта(последнее совпадение) или -1 если такого нет,
                                               // для сравнения используется equals
        arrList.size();                         // вернет размер
        arrList.isEmpty();                      // вернет булеан, проверяет лист пуст или нет
        arrList.contains("Ivan");               // вернет булеан, проверяет есть ли этот объект в листе



        for (String s : arrList) {
            System.out.print(s + " ");
        }
        System.out.println();                  // --> способ вывода
        System.out.println(arrList);           // --> способ вывода
    }
}
