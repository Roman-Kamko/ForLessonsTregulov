package myDB.collections.map_interface;

import java.util.Hashtable;

public class HashTableExample {
    /* HashTable устаревший класс, который работает по тем же принципам, что и hashMap,
       но в отличии от HashMap является synchronized, поэтому его методы не такие быстрые
       и его ключи и значения не могут быть null. Даже если нужна многопоточность его лучше
       не использовать, а взять ConcurrentHashMap*/
    public static void main(String[] args) {
        Hashtable<Double, Student> ht = new Hashtable<>();
        Student st1 = new Student("zaur", "tregulov", 3);
        Student st2 = new Student("mariya", "ivaniva", 1);
        Student st3 = new Student("sergey", "petrov", 4);
        Student st4 = new Student("igor", "tregulov", 3);

        ht.put(5.8, st1);
        ht.put(6.4, st2);
        ht.put(7.2, st3);
        ht.put(7.5, st4);

        System.out.println(ht);
    }
}
