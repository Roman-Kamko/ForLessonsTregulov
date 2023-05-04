package myDB.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortedMethod {
    // .sorted() - сортирует поток, принимает компаратор, возвращает стрим
    public static void main(String[] args) {

        int[] arr = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};
        arr = Arrays.stream(arr)
                .sorted() // .sorted() знает как сортировать интеджеры
                .toArray();
        System.out.println(Arrays.toString(arr));

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

//        students = students.stream()
//                .sorted()               не указали компаратор
//                .toList();
//        System.out.println(students);   получим ClassCastException, потому что java не знает как сортировать студентов

        students = students.stream()
                .sorted((x,y) -> x.getName().compareTo(y.getName()))
                .toList();
        System.out.println(students);

        //             ИЛИ

        students = students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
        System.out.println(students);
    }
}
