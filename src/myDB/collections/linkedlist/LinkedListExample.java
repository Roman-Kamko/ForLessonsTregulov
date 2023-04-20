package myDB.collections.linkedlist;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
//    В основе LinkedList листа лежит не массив, а узлы, которые ссылаются на предыдущий и следующий узел,
//    образуя цепочку. У него есть голова и хвост, если последний элемент ссылается на следующий и там null
//    то так LinkedList понимает что этот узел последний и является хвостом, с головой по аналогии...
//    Получение элемента(например с индексом 2) происходит переходом от первого элемента ко второму,
//    и только потом мы получим 3й элемент, т.к. второй знает где он находится. Т.е. время получения элемента
//    составляет O(n), а не O(1) как в ArrayList
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 3);
        Student st2 = new Student("Nikolay", 2);
        Student st3 = new Student("Elena", 1);
        Student st4 = new Student("Petr", 4);
        Student st5 = new Student("Mariya", 3);

        List<Student> list = new LinkedList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);
        System.out.println(list);
    }
}

class Student {
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
}
