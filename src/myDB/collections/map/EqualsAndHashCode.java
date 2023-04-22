package myDB.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EqualsAndHashCode {
    // переопределил equals переопредели и hasCode!
    public static void main(String[] args) {
        Map<Student, Double> map = new HashMap<>();
        Student st1 = new Student("zaur", "tregulov", 3);
        Student st2 = new Student("mariya", "ivaniva", 1);
        Student st3 = new Student("Sergey", "petrov", 4);
        map.put(st1, 7.5);
        map.put(st2, 8.7);
        map.put(st3, 9.2);
        System.out.println(map);

        Student st4 = new Student("zaur", "tregulov", 3);
        boolean result = map.containsKey(st4);  // получим false если не переопределили hashCode,
                                                // тк HashMap использует хэширование при поиске и сравнении
        /* Хэширование - преобразование любого объекта с помощью метода hashCode в int */
        System.out.println("result = " + result);
        System.out.println(st1.equals(st4));


    }
}

final class  Student { // зафиналили стобы не мог иметь наследников
    final String name; // крайне желательно иметь имутабельные объекты в качестве ключа, поэтому зафиналим все поля
    final String surName;
    final int course;

    public Student(String name, String surName, int course) {
        this.name = name;
        this.surName = surName;
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", course=" + course +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return course == student.course && Objects.equals(name, student.name) && Objects.equals(surName, student.surName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, course);
    }
}
