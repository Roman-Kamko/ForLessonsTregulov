package myDB.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceMethod {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();

        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        int result = list.stream()
                .reduce((accumulator, element) -> accumulator * element)
                .get();
        System.out.println(result); // -> 960
        // accumulator - это то, что что-то накапливает,
        // accumulator'у сразу присваивается первое значение потока,
        // element'у - присваивается второе значение, пример того как это работает:
        // accumulator = 5 -> 40 -> 80 -> 320 -> 960 - .get() возвращает его
        // element =     8 ->  2 ->  4 ->   3
//      reduce() - возвращает Optional. Optional оборачивает собой возвращаемый объект, он может содержать
//      null и not null значения. Существует куча ситуаций когда reduce() возвращает null,
//      тут как раз и пригодится Optional. Например мы можем проверить на присутствие значения с помощью isPresent()

//        List<Integer> list2 = new ArrayList<>();
//        int result2 = list2.stream()
//                .reduce((accumulator, element) -> accumulator * element)
//                .get(); // -> null, list2 пуст -> NoSuchElementException
        List<Integer> list2 = new ArrayList<>();
        Optional<Integer> o = list2.stream()
                .reduce((accumulator, element) -> accumulator * element);
        if (o.isPresent()) {
            System.out.println(o);
        } else {
            System.out.println("Not present");
        }

//        Еще один способ использования reduce()

        int result3 = list.stream()
                .reduce(1, (accumulator, element) -> accumulator * element);
//                .get(); метод использовать нет необходимости т.к. в данном случае
//                reduce() точно вернет int, т.к. мы указали стартовое значение аккумулятора в виде int
        System.out.println(result3); // -> 960
        // accumulator = 1 -> 5 -> 40 -> 80 -> 320 -> 960 - .get() возвращает его
        // element =     5 -> 8 ->  2 ->  4 ->   3

        // конкатенация строк при помощи reduce()

        List<String> list4 = new ArrayList<>();
        list4.add("privet");
        list4.add("rfr dela");
        list4.add("ok");
        list4.add("poka");

        String result4 = list4.stream()
                .reduce((a, e) -> a + " " + e)
                .get();
        System.out.println(result4);
    }
}
