package myDB.lambda_expressions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*Лямбда выражения работают с интерфейсом, в котором есь только 1 абстрактный метод(функциональный интерфейс)*/
public class StudentInfo {
//    void printStudentsOverGrade(ArrayList<Student> students, double grade) {
//        for (Student s : students) {
//            if (s.avgGrade > grade) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsUnderAge(ArrayList<Student> students, int age) {
//        for (Student s : students) {
//            if (s.age < age) {
//                System.out.println(s);
//            }
//        }
//    }
//
//    void printStudentsMixCondition(ArrayList<Student> students, int age, double grade, char sex) {
//        for (Student s : students) {
//            if (s.avgGrade < grade && s.age > age && s.sex == sex) {
//                System.out.println(s);
//            }
//        }
//    }

    /*Теперь если мы захотим создать какую-то новую фильтрацию, нам нужно будет создавать новый метод,
      что не очень удобно.
      Закоментируем все эти методы и создадим интерфейс*/
    void testStudents(ArrayList<Student> students, StudentChecks sc) {
        for (Student s : students) {
            if (sc.check(s)) {
                System.out.println(s);
            }
        }
    }
}

class Test {
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

        StudentInfo studentInfo = new StudentInfo();
//      сортировка:
//        Collections.sort(students, Comparator.comparing(s -> s.course));
////        Collections.sort(students, (s1, s2) -> s1.course - s2.course); то же самое что и строчкой выше
//        System.out.println(students);

//        studentInfo.testStudents(students, new CheckOverGrade());
//        System.out.println("----------------------------------");
//        studentInfo.testStudents(students, new StudentChecks() { // анонимный класс
//            @Override
//            public boolean check(Student s) {
//                return s.age < 30;
//            }
//        });
        System.out.println("----------------------------------");
        // Способы написания лямбда выражений:
        // 1й способ:

        studentInfo.testStudents(students, (Student s) -> {
            return s.age < 30;
        });

        System.out.println("----------------------------------");
        //2й способ:

        studentInfo.testStudents(students, s -> s.age > 20 && s.avgGrade < 9.5 && s.sex == 'f');

        System.out.println("----------------------------------");


//        studentInfo.printStudentsOverGrade(students, 8);
//        System.out.println("----------------------------------");
//        studentInfo.printStudentsUnderAge(students, 30);
//        System.out.println("----------------------------------");
//        studentInfo.printStudentsMixCondition(students, 20, 9.5, 'f');
    }
}

interface StudentChecks {
    boolean check(Student s);
}

class CheckOverGrade implements StudentChecks { // этот класс можно заменить на анонимный класс
    @Override
    public boolean check(Student s) {
        return s.avgGrade > 8;
    }
}
