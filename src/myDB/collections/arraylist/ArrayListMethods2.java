package myDB.collections.arraylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListMethods2 {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("a");
        StringBuilder sb2 = new StringBuilder("b");
        StringBuilder sb3 = new StringBuilder("c");
        StringBuilder sb4 = new StringBuilder("d");
        StringBuilder[] array = {sb1, sb2, sb3, sb4};
        List<StringBuilder> list = new ArrayList<>(Arrays.asList(array));
        System.out.println(list);
        array[0].append("!!!");                 // todo не понял почему изменения внесенные в массив после создания листа вносят в этот лист изменения
        array[0] = new StringBuilder("f");      // todo а тут не вносят
        System.out.println(list);

        List<String> arrList1 = new ArrayList<>();
        arrList1.add("Roman");
        arrList1.add("Mariya");
        arrList1.add("Ivan");
        arrList1.add("Kolya");
        System.out.println(arrList1);

        List<String> arrList2 = new ArrayList<>();
        arrList2.add("Ivan");
        arrList2.add("Mariya");
        arrList2.add("Igor");

//        arrList1.removeAll(arrList2); // --> удалит все элементы в первом листе, совпадающие со вторым листом
//        arrList1.retainAll(arrList2);  --> оставит в первом листе только те элементы которые совпадают с элементами второго листа

//        arrList1.containsAll(arrList2); --> возврат булеан, проверка содержит ли первый лист все элементы которые есть во втором листе

//        List<String> list1 = new ArrayList<>(arrList1.subList(1, 3)); --> создаст лист из указанного диапазона имеющегося листа,
//        но он является всего лишь представлением исходного листа и если добавить в подлист новый элемент он добавится и в исходный
//        лист на позицию после последнего элемента в подлисте. И еще, если мы модифицируем исходный лист который имеет уже саб лист,
//        а после пытаемся например распечатать саб лист выйдет ошибка ConcurrentModificationException, поэтому все модификации нужно
//        производить в саблисте, если мы собираемся использовать этот саб лист

        Object[] arr1 = arrList1.toArray();  // .toArray() -> Object[]
        String[] arr2 = arrList2.toArray(new String[0]); // .toArray(new String[]) -> String[],
                                                         // [0] - java сама создаст массив нужного размера, можно указать 0

        List<Integer> list1 = List.of(1, 2, 3, 4, 5); // через List.of создаются не изменяемые списки, если попытаться внести
                                                      // изменения получим ошибку UnsupportedOperationException, а так же такие
                                                      // листы не могут содержать в себе значение null, если записать null,
                                                      // то в рантайме получим NullPointerException

        List<String> list2 = List.copyOf(arrList1);  // то же создаст не изменяемый список на основе имеющегося


    }
}
