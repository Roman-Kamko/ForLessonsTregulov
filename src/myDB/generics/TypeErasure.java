package myDB.generics;

import java.util.ArrayList;
import java.util.List;

public class TypeErasure {
    // TypeErasure - стирание типов, код который написан с использованием дженериков
    // должен нормально работать как и код без их использования
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        ---> когда мы так пишем о дженериках знает только компилятор для необходимых проверок,
//        но в рантайме вся информация удаляется и JVM видит этот лист как список RawType'ов,
//        в качестве типа получается самый высокий родительский класс, если не указанно
//        <T extends (например)Numbers>, то это Object


    }

//    public void abc(Information<String> information) {
//        String s = information.getValue();
//    }
//    public void abc(Information<Integer> information) {
//        int i = information.getValue();
//    }
//    --->  Мы смоем использовать только один из этих двух методов,
//    т.к. для JVM они выглядят совершенно одинаково, после стирания типов они будут выглядеть
//    вот так:
//          public void abc(Information information),
//    поэтому мы не можем перегружать методы таким способом.

}


class Information<T> {
    //    T -> TypePlaceHolder (заполнитель типа)
    private T value;

    public Information(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}

// Оверрайдинг мы так же не сможем сделать, потому что компилятор понимает,
// что при кастинге в сабклассе будут возникать проблемы:
//   class Parent {
//           public void abc(Information<String> information) {
//           String s = information.getValue();
//       }
//   }
//      class Child extends Parent {
//          @Override
//          public void abc(Information<Integer> information) {
//              Integer s = information.getValue();
//          }
//      }