package myDB.streams;

import java.util.Arrays;

public class ForEachMethod {
    // forEach() метод возвращает void, поэтому после его вызова не возможно создать коллекцию
    public static void main(String[] args) {
        int[] arr = {5, 9, 3, 8, 1};
        //Умножим каждый элемент на 2 и выведем на экран
        Arrays.stream(arr).forEach(element -> {
            element *= 2;
            System.out.println(element);
        });
        System.out.println("----------------------------------------------------------------------------");

        //Можем просто вывести на экран все элементы:
        Arrays.stream(arr).forEach(element -> System.out.println(element));
        System.out.println("----------------------------------------------------------------------------");
        //Более краткая форма:
        Arrays.stream(arr).forEach(System.out::println); //референс
        System.out.println("----------------------------------------------------------------------------");
    }
}
