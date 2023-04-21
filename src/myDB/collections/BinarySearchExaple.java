package myDB.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchExaple {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-3);
        list.add(8);
        list.add(12);
        list.add(-8);
        list.add(0);
        list.add(5);
        list.add(10);
        list.add(1);
        list.add(150);
        list.add(-30);
        list.add(19);

        int index1 = Collections.binarySearch(list, 12); // вернет -9, если binarySearch выдает отрицательное
                                                             // значение, то искомый элемент не найден, а все потому
                                                             // что коллекцию необходимо сначала отсортировать
        System.out.println(index1);                          // -> -9

        Collections.sort(list);
        System.out.println(list);
        int index2 = Collections.binarySearch(list, 12);
        System.out.println(index2);

        Employee emp1 = new Employee(100, "Roman", 2_313);
        Employee emp2 = new Employee(15, "Ivan", 56_465);
        Employee emp3 = new Employee(123, "Petr", 233_221);
        Employee emp4 = new Employee(15, "Mariya", 844);
        Employee emp5 = new Employee(182, "kolya", 32_154);
        Employee emp6 = new Employee(15, "Sasha", 84_513);
        Employee emp7 = new Employee(250, "Elena", 2_135);

        List<Employee> employees = new ArrayList<>();
        employees.add(emp1);
        employees.add(emp2);
        employees.add(emp3);
        employees.add(emp4);
        employees.add(emp5);
        employees.add(emp6);
        employees.add(emp7);
        System.out.println(employees);

/*        Collections.sort(employees); --> ошибка компиляции, если не создан Comparator, либо не имплементирован
                                           Comparable в класс Employee, т.к. .sort() не будет знать как сортировать
                                           работников, чтобы это исправить нужно либо */
        Collections.sort(employees);
        System.out.println(employees);

        System.out.println(Collections.binarySearch(employees, new Employee(182, "kolya", 32_154)));
    }
}

class Employee implements Comparable<Employee>{
    int id;
    String name;
    int salary;

    public Employee(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        int result = this.id - o.id;
        if (result == 0) {
            result = this.name.compareTo(o.name);
        }
        return result;
    }

}
