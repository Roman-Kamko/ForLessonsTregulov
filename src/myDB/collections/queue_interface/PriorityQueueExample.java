package myDB.collections.queue_interface;

import java.util.Objects;
import java.util.PriorityQueue;

public class PriorityQueueExample {
    /* PriorityQueue - возвращает первый элемент с наивысшим приоритетом, поэтому в случае если
       у нас очередь из элементов класса у которого не переопределен метод compareTo, то необходимо
       имплементировать интерфейс Comparable и переопределить метод, либо указать comparator() при
       создании очереди, что бы java понимал какой элемент больше. Наивысший приоритет у элемента,
       который стоит первый в очереди. При этом, если просто вывести все элементы этой очереди,
       то у них никакой сортировки не будет, но при использовании элементов она есть. */
    public static void main(String[] args) {
        PriorityQueue<Integer> integerPriorityQueue = new PriorityQueue<>();
        integerPriorityQueue.add(4);
        integerPriorityQueue.add(1);
        integerPriorityQueue.add(7);
        integerPriorityQueue.add(10);
        integerPriorityQueue.add(8);
        System.out.println(integerPriorityQueue.peek()); // => 1

        Student st1 = new Student("zaur", 3);
        Student st2 = new Student("mariya", 2);
        Student st3 = new Student("sergey", 4);
        Student st4 = new Student("igor", 5);
        Student st5 = new Student("egor", 1);

        PriorityQueue<Student> studentPriorityQueue = new PriorityQueue<>();
        studentPriorityQueue.add(st1);
        studentPriorityQueue.add(st2);
        studentPriorityQueue.add(st3);
        studentPriorityQueue.add(st4);
        studentPriorityQueue.add(st5);

        System.out.println(studentPriorityQueue.remove());
        System.out.println(studentPriorityQueue.remove());
        System.out.println(studentPriorityQueue.remove());
        System.out.println(studentPriorityQueue.remove());
        System.out.println(studentPriorityQueue.remove());
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
