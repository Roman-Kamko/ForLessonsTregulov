package myDB.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MapToIntMethod {
    /*
    * .mapToInt() - возвращает не просто стрим после себя, а стрим int'ов, не Integer'ов!
    * .boxed() - конвертирует все значения int в Integer и вернет в виде стрима
    * */
    public static void main(String[] args) {
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

        List<Integer> courses = students.stream()
                .mapToInt(Student::getCourse)
                .boxed()
                .toList();
        System.out.println(courses);

        // Есть методы которые могут работать со стримом int'ов:

        int sum = students.stream().mapToInt(Student::getCourse).sum();
        System.out.println(sum);

        double avg = students.stream().mapToInt(Student::getCourse).average().getAsDouble();
        System.out.println(avg);

        int min = students.stream().mapToInt(Student::getCourse).min().getAsInt();
        System.out.println(min);

        int max = students.stream().mapToInt(Student::getCourse).max().getAsInt();
        System.out.println(max);
    }
}
