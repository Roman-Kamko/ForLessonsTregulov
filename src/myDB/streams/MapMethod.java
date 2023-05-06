package myDB.streams;

import java.util.*;
import java.util.stream.Collectors;

public class MapMethod {
    /*Stream - это последовательность элементов поддерживающих последовательные и параллельные операции над ними
    * Stream не меняет саму коллекцию, поэтому полученный поток нужно вернуть или поместить в новую коллекцию*/
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("rfr dela");
        list.add("ok");
        list.add("poka");

//        Допустим мы хотим заменить слова на длины строк. Как мы делали это раньше:
//        for (int i = 0; i < list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }
//        System.out.println(list);

        List<Integer> list2 = list.stream()         // создали поток данных String
                .map(element -> element.length())   // преобразовали поток String'ов в поток Integer'ов
                .collect(Collectors.toList());      // записали поток Integer'ов в лист

        System.out.println(list2);
        System.out.println("----------------------------------------------------------------------------");

//        Код со стримом выше можно записать еще короче:

        List<Integer> list3 = list.stream()
                .map(String::length)
                // еще одна форма записи лямбды, lambda reference, справа указываем метод который нужно применить
                // к каждому элементу потока, а слева класс откуда нужно взять этот метод
                .toList();
                // краткая форма .collect(Collectors.toList())

        System.out.println(list3);
        System.out.println("----------------------------------------------------------------------------");

        // Стрим с массивами:

        int[] arr = {5, 9, 3, 8, 1};
        arr = Arrays.stream(arr).map(element-> {
            if (element % 3 == 0) {
                element = element / 3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------------------------------------------------------");

        // Стрим с сетом:

        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("rfr dela");
        set.add("ok");
        set.add("poka");

        System.out.println(set);

        List<Integer> list4 = set.stream()
                .map(e -> e.length())
//                .collect(Collectors.toSet());
                .toList();
        // любой поток можно присвоить любой коллекции и не важно, что на входе был Set

        System.out.println(list4);
        System.out.println("----------------------------------------------------------------------------");
    }
}
