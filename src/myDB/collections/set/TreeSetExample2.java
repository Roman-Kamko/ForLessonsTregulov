package myDB.collections.set;

import java.util.Comparator;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetExample2 {
    public static void main(String[] args) {

        TreeSet<Student> treeSet = new TreeSet<>();

        Student st1 = new Student("zaur", 3);
        Student st2 = new Student("mariya", 2);
        Student st3 = new Student("sergey", 4);
        Student st4 = new Student("igor", 5);
        Student st5 = new Student("egor", 1);

        treeSet.add(st1);
        treeSet.add(st2);
        treeSet.add(st3);
        treeSet.add(st4);
        treeSet.add(st5);

        System.out.println(treeSet);

        Student st6 = new Student("oleg", 2);
        Student st7 = new Student("ivan", 4);

        System.out.println(treeSet.headSet(st6)); // вернет студентов, которые учатся на курсе ниже чем олег
        System.out.println(treeSet.tailSet(st6)); // вернет студентов, которые учатся на том же курсе или выше чем олег

        System.out.println(treeSet.subSet(st6, st7)); // вернет студентов курсов >=2, но <4
    }
}

class Student implements Comparable<Student> {
    String name;
    int course;

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public int compareTo(Student s) {
        return this.course - s.course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course;
//                && Objects.equals(name, student.name);
//                в данном случае не нужен т.к. нужно придерживаться правила,
//     !!!!!!!!   если a.equals(b) = true, то должно быть и a.compareTo(b) = 0   !!!!!!!!!!
    }

    @Override
    public int hashCode() {
        return Objects.hash(course); // и тут нужно убрать name, т.к. compareTo у нас сравнивает по курсу
    }
}
