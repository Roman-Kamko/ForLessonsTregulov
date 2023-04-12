package myDB.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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

//        Collections.sort(list);
//        System.out.println("После сортировки\n" + list);      // -> для примера с интерфейсом Comparable

        Collections.sort(list, new SalaryComparator());
//        в случае использования в качестве параметра и коллекцию и компаратор
//        сортировка будет по компаратору, а не по переопределенному методу compareTo()
        System.out.println(list);
//        Если КОМПАРОТОР используется только один раз, то лучше использовать анонимный класс или лямбда выражение,
//        а не создавать отдельный класс для компаратора
    }
}

class Employee
        implements Comparable<Employee> {
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
    public int compareTo(Employee o) {
        if (this.id == o.id) {
            return 0;
        } else if (this.id < o.id) {
            return -1;
        } else {
            return 1;
        }
////         return this.id - o.id;                               -> тоже самое(в основном все пишут так)
////         return this.id.compareTo(o.id)                       -> тоже самое, но id должен быть обернут в Integer
//
////        int result = this.name.compareTo(o.name);             -> для строк
////        if (result == 0) {
////            result = this.surname.compareTo(o.surname);
////        }
////        return result;
//    }
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
}

//class IdComparator implements Comparator<Employee> {
//    @Override
//    public int compare(Employee o1, Employee o2) {
//        if (o1.id == o2.id) {
//            return 0;
//        } else if (o1.id < o2.id) {
//            return -1;
//        } else {
//            return 1;
//        }
//    }
//}

class NameComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        int result = o1.name.compareTo(o2.name);
        if (result == 0) {
            result = o1.surname.compareTo(o2.surname);
        }
        return result;
    }
}
class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.salary - o2.salary;
    }
}
