package myDB.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ChainingMethodsInStream {
    /*Работа чейнинг в стриме:
     * Source(коллекция, массив) -> IntermediateMethods(lazy) -> Terminal methods(eager)
     * Промежуточные методы обрабатывают поток и возвращают поток и таких методов может
     * быть много, но они не будут исполнены пока не будет вызвана терминальная операция,
     * отсюда и название lazy - лейзи операции не сработают, пока что-то не произойдет.
     * Терминальные операции никогда не возвращают поток, поэтому после них нельзя вызвать
     * lazy операцию.*/
    public static void main(String[] args) {


        int[] ints = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        int result = Arrays.stream(ints)
                .filter(e -> e % 2 == 1)
                .map(e -> {
                    if (e % 3 == 0) {
                        e = e / 3;
                    }
                    return e;
                })
                .reduce(Integer::sum)
                .getAsInt();

        System.out.println(result);
        System.out.println("-------------------------------------------------------------");

        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("petr", 'm', 35, 4, 7);
        Student st5 = new Student("maria", 'f', 23, 3, 7.4);

        List<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        students.stream()
                .map(e -> {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                .filter(e -> e.getSex() == 'f')
                .sorted(Comparator.comparing(Student::getAge))
                .forEach(System.out::println);
        System.out.println("-------------------------------------------------------------");

        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        stream.filter(e -> {
            System.out.println("!!!");
            return e % 2 == 0;
        });
        // По идеи мы должны были бы увидеть в консоли 5 выводов "!!!",
        // но т.к. терминальной операции нет, то lazy операции не будут выполнены
        // и соответственно в консоль нам ничего не выйдет, до тех пор пока не добавим
        // какую нибудь терминальную операцию
    }
}
