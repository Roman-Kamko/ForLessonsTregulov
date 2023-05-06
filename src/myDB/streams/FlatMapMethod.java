package myDB.streams;

import java.util.ArrayList;
import java.util.List;

public class FlatMapMethod {
//    .flatMap() - используется когда нужно работать не с элементами коллекции,
//    а с элементами элементов коллекции
    public static void main(String[] args) {
        Student st1 = new Student("ivan", 'm', 22, 3, 8.3);
        Student st2 = new Student("nikolay", 'm', 28, 2, 6.4);
        Student st3 = new Student("elena", 'f', 19, 1, 8.9);
        Student st4 = new Student("petr", 'm', 35, 4, 7);
        Student st5 = new Student("maria", 'f', 23, 3, 7.4);

        Faculty f1 = new Faculty("economics");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.add(st1);
        f1.add(st2);
        f1.add(st3);
        f2.add(st4);
        f2.add(st5);

        List<Faculty> faculties = new ArrayList<>();

        faculties.add(f1);
        faculties.add(f2);
//        создали листы в листе

        faculties.stream().flatMap(faculty -> faculty.getStudentOnFaculty().stream())
                .forEach(e -> System.out.println(e.getName()));
//      создается сначала поток факультетов, потом поток студентов первого факультета для них
//      вызывается метод распечатывающий имена всех студентов для этого факультета, а потом
//      создается поток студентов второго факультета и т.д.
    }
}

class Faculty {
    String name;
    List<Student> studentOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentOnFaculty = new ArrayList<>();
    }

    public List<Student> getStudentOnFaculty() {
        return studentOnFaculty;
    }

    public void add(Student student) {
        studentOnFaculty.add(student);
    }
}
