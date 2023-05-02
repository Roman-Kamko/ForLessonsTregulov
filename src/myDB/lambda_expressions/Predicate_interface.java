package myDB.lambda_expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Predicate_interface {
    /*Predicate - это функциональный интерфейс, благодаря ему мы можем не создавать свои функциональные интерфейсы
      как в классе StudentInfo интерфейс StudentCheck*/

    //Было:
//    void testStudents(ArrayList<Student> students, StudentChecks sc) {
//        for (Student s : students) {
//            if (sc.check(s)) {
//                System.out.println(s);
//            }
//        }
//    }

    /* У Predicate один абстрактный метод:
       boolean test(T t);
       его и будем использовать вместо метода check*/

    //Стало:
    void testStudents(ArrayList<Student> students, Predicate<Student> predicate) {
        for (Student student : students) {
            if (predicate.test(student)) {  // будем что-то проверять, а что мы пока не знаем
                System.out.println(student);
            }
        }
    }

    public static void main(String[] args) {
        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("petr", 'm', 35, 4, 7);
        Student st5 = new Student("maria", 'f', 23, 3, 9.1);

        ArrayList<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        Predicate_interface predicateInterface = new Predicate_interface();
        predicateInterface.testStudents(students, s -> s.age > 30);
        System.out.println("----------------------------------------------------");
        // все работает точно так же как и в классе StudentInfo, но нам не пришлось создавать
        // свой функциональный интерфейс

        //Метод removeIf()
        students.removeIf(s -> s.age > 30); // удали если элемент прошел тест предиката
        System.out.println(students);
        System.out.println("----------------------------------------------------");

        //В Predicate можно засунуть несколько проверок:
        Predicate<Student> p1 = s -> s.age < 25;
        Predicate<Student> p2 = s -> s.course > 2;
        predicateInterface.testStudents(students, p1.and(p2)); // элемент должен пройти обе проверки
        System.out.println("----------------------------------------------------");
        predicateInterface.testStudents(students, p1.or(p2)); // элемент должен пройти хотя бы одну проверку
        System.out.println("----------------------------------------------------");
        predicateInterface.testStudents(students, p1.negate()); // .negate() - отрицание(аналог !=)
        System.out.println("----------------------------------------------------");

        //Офф топ. Еще не проходил стримы, но теперь знаю что за херню принимает .filter XD
        List<Student> filteredStudents = students.stream()
                                                 .filter(s -> s.avgGrade > 9)
                                                 .toList();
        System.out.println(filteredStudents);
    }
}
