package myDB.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> arrList1 = new ArrayList<>();
        arrList1.add("Roman");
        arrList1.add("Mariya");
        arrList1.add("Ivan");
        arrList1.add("Kolya");
        arrList1.add("Elena");

        Iterator<String> iterator = arrList1.iterator();
        while (iterator.hasNext()) {                        // .hasNext проверка есть ли следующий элемент
            iterator.next();                                // .next выдает элемент
            iterator.remove();
        }
//        Основным отличием Iterator от ForEach - это возможность удалить элемент
        System.out.println(arrList1);
    }
}
