package myDB.lambda_expressions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Function_interface {
    /*Function - это функциональный интерфейс, который принимает два значения, его метод
    * R apply(T t): T - принимаемый тип, R - возвращаемый */
    public static void main(String[] args) {
        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("petr", 'm', 35, 5, 7);
        Student st5 = new Student("maria", 'f', 23, 4, 9.1);

        ArrayList<Student> students = new ArrayList<>();

        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        // допустим перед нами стоит задача находить среднее арифметическое для всех студентов по разным показателям.
        // Нужен код который будет принимать любой из показателей(возраст, курс, и т.д.)

//        Function<Student, Double> function = student -> student.avgGrade;
        double result1 = averageSomething(students, stud -> stud.avgGrade);
        // средняя оценка всех студентов
        System.out.println(result1);

        double result2 = averageSomething(students, stud -> (double)stud.course);
        // средний курс всех студентов
        System.out.println(result2);

        double result3 = averageSomething(students, stud -> (double)stud.age);
        // средний возраст всех студентов
        System.out.println(result3);
    }

    private static double averageSomething(List<Student> list, Function<Student, Double> function) {
        double result = 0;
        for (Student student : list) {
            result += function.apply(student); //к result добавить какой-то дабл, который даст нам Function
        }
        return result / list.size();
    }
}
