package myDB.generics;

import java.util.ArrayList;
import java.util.List;

public class Subtyping {
    public static void main(String[] args) {
        X x = new Y();
//        List<X> list1 = new ArrayList<Y>();
//        --->  Будет ошибка компиляции, не смотря на то что ArrayList это подкласс List'a, а Y это подкласс X,
//        т.к. совокупность ArrayList<Y> не является подтипом List<Y>, на это есть веские причины,
//        рассмотрим следующую ситуацию:
//        List<Number> list = new ArrayList<Integer>();
//        list.add(2);
//        list.add(3.14);
//        --->  Integer явл подклассом Number как и Double и в случае если бы можно было бы так делать мы бы все
//        равно получали ошибку на уровне RunTime, т.к. ArrayList типизирован Integer'ами. А благодаря дженерикам
//        мы получаем эту ошибку на уровне компилятора и мы сразу же среагируем на нее, а не получим неожиданно.
    }
}

class X {

}

class Y extends X{

}
