package myDB.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCard {
    public static void main(String[] args) {
//        List<Number> list = new ArrayList<Integer>(); ---> вспомним, что так писать нельзя
//        List<Object> list = new ArrayList<Integer>(); ---> должно быть очевидно, что и так нельзя

//                                                  <?> ---> wildCard, супер тип

        List<?> list = new ArrayList<Integer>();
//        list.add(10); ---> не разрешит добавить, т.к. компилятор не знает какого типа лист и соотв
//                           не может проверить правильный ли ты тип добавляешь, т.е. в таких листах
//                           компилятор запрещает вызывать методы, которые изменяют объект

//        bounded wildCards ---> ограничивать сверху или снизу
//        <? extend Number> ---> примет Number и всех его потомков
//        <? super Number>  ---> примет Number и все классы выше по иерархии

        List<? extends Number> list1 = new ArrayList<Integer>();

        List<String> list2 = new ArrayList<>();
        list2.add("privet");
        list2.add("poka");
        list2.add("ok");
        showListInfo(list2);

        List<Double> list3 = new ArrayList<>();
        list3.add(3.14);
        list3.add(3.15);
        list3.add(3.16);
        showListInfo(list3);

        System.out.println(sum(list3));

        List<Integer> list4 = new ArrayList<>();
        list4.add(3);
        list4.add(4);
        list4.add(5);

        System.out.println(sum(list4));

    }

    static void showListInfo(List<?> list) {
        System.out.println(list);
    }

    static double sum(List<? extends Number> list) {
        double sum = 0;
        for (Number n : list) {
            sum += n.doubleValue();
        }
        return sum;
    }
}

