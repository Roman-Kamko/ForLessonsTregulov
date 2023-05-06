package myDB.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class OtherMethods {
    /*
      .concat() СТАТИЧЕСКИЙ метод и возвращает стрим и не может быть использован в цепочке.

      .distinct() возвращает стрим уникальных элементов, сравнивая их через equals().

      .count() считает количество эл в стриме и возвращает long

      .distinct().count() вернет количество уникальных элементов long

      .peek() позволяет посмотреть что происходит на разных этапах метод чейнинга,
      очень похож на .forEach, но является lazy(intermediate) методом

      .findFirst() вернуть первый элемент стрима, возвращает Optional

      .min() - вернет минимальный элемент

      .max() - вернет максимальный элемент

      .limit() - возвращает стрим, ограничивает количество элементов

      .skip() - пропустит энное количество элементов, остальные вернет в виде стрима
    */
    public static void main(String[] args) {

        Stream<Integer> stream1 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        Stream<Integer> stream2 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> stream3 = Stream.of(6, 7, 8, 9, 10);
        System.out.println("---------------------------------------------------------");

        Stream<Integer> stream4 = Stream.concat(stream2, stream3);
        stream4.forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        stream1.distinct().forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        Stream<Integer> stream5 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println(stream5.count());
        //System.out.println(stream5.distinct().count()); -> IllegalStateException
        //т.к. стрим после обработки нельзя переиспользовать
        System.out.println("---------------------------------------------------------");

        Stream<Integer> stream6 = Stream.of(1, 2, 3, 4, 5, 1, 2, 3);
        System.out.println(stream6.distinct().peek(System.out::println).count());
        System.out.println("---------------------------------------------------------");

        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("petr", 'm', 35, 4, 7);
        Student st5 = new Student("maria", 'f', 23, 3, 7.4);

        List<Student> arrayList = new ArrayList<>();

        arrayList.add(st1);
        arrayList.add(st2);
        arrayList.add(st3);
        arrayList.add(st4);
        arrayList.add(st5);

        System.out.println("---------------------------------------------------------");

        Student student = arrayList.stream()
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .filter(e -> e.getSex() == 'f')
                .sorted(Comparator.comparing(Student::getAge))
                .findFirst()
                .get();
        System.out.println(student);
        System.out.println("---------------------------------------------------------");

        Student min = arrayList.stream()
                .min(Comparator.comparing(Student::getAge))
                .get();
        System.out.println(min);

        Student max = arrayList.stream()
                .max(Comparator.comparing(Student::getAge))
                .get();
        System.out.println(max);
        System.out.println("---------------------------------------------------------");

        arrayList.stream()
                .filter(e-> e.getAge()>20)
                .limit(2)
                .forEach(System.out::println);
        System.out.println("---------------------------------------------------------");

        arrayList.stream()
                .filter(e-> e.getAge()>20)
                .skip(2)
                .forEach(System.out::println);
    }
}
