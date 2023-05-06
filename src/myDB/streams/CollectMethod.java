package myDB.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectMethod {
    /*.collect() при использовании этого метода мы использовали Collectors класс у которого
     * есть 2 интересных метода:
     *
     * groupingBy - сгруппирует элементы по указанному параметру, возвращает Map,
     * ключом будет указанный параметр группировки, а значением - List элементов
     * у которых значение группировки одинаковое.
     *
     * partitioningBy - разделить элементы по параметру, принимает predicate,
     * вернет Map, ключом будет boolean, значением - List элементов
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
        System.out.println("------------------------------------------------------------");

        Map<Integer, List<Student>> map1 = students.stream()
                .map(student -> {
                    student.setName(student.getName().toUpperCase());
                    return student;
                })
                .collect(Collectors.groupingBy(Student::getCourse));
        // сгруппировали студентов по курсу, ключ - курс, значение - лист студентов на курсе

        for (Map.Entry<Integer, List<Student>> entry : map1.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("------------------------------------------------------------");

        Map<Boolean, List<Student>> map2 = students.stream()
                .collect(Collectors.partitioningBy(el -> el.getAvgGrade() > 7));
//        получим мапу с ключами true и false, и два листа со студентами
//        true: чей бал выше 7 и false: чей бал ниже 7

        for (Map.Entry<Boolean, List<Student>> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
