package comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {

        List<Employee> list = new ArrayList<>();
        Employee empl1 = new Employee(100, "zaur", "tregulov", 10_000);
        Employee empl2 = new Employee(15, "ivan", "petrov", 15_000);
        Employee empl3 = new Employee(152, "ivan", "sidorov", 12_000);
        list.add(empl1);
        list.add(empl2);
        list.add(empl3);

        System.out.println("До сортировки\n" + list);

//        Collections.sort(list); -> так отсортировать не получится(если нет имплементации Comparable),
//        java не знает по какому параметру сортировать

        Collections.sort(list);
        System.out.println("После сортировки\n" + list);

    }
}

class Employee implements Comparable<Employee> {
    int id;
    String name;
    String surname;
    int salary;

    public Employee(int id, String name, String surname, int salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
//        if (this.id == o.id) {
//            return 0;
//        } else if (this.id < o.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//         return this.id - o.id;         -> тоже самое(в основном все пишут так)
//         return this.id.compareTo(o.id) -> тоже самое, но id должен быть обернут в Integer

        int result = this.name.compareTo(o.name);
        if (result == 0) {
            result = this.surname.compareTo(o.surname);
        }
        return result;
    }
}
