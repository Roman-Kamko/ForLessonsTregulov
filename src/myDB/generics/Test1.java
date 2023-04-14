package myDB.generics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        List list = new ArrayList<>();
//        данный способ называется RawType (сырой тип), так писать нельзя,
//        рассмотрено в качестве примера

//        без дженерика в коллекцию можно положить любой объект,
//        все они будут считаться объектами класса Object

//        list.add("ok");
//        list.add(5);
//        list.add(new StringBuilder("sfadfa"));

        list.add("privet");
        list.add("poka");
        list.add("ok");
        list.add("aDDFsdfsd");
        for (Object o : list) {
            System.out.println(o + " длина " + ((String)o).length());
        }

//        Работать с листом сможем (придется даункастить в String),
//        но есть вероятность, что в эту коллекцию кто-то случайно
//        может положить объект другого класса и мы получим ClassCastException

//        Одна из главнейших причин создания дженериков это TYPE_SAFE (типобезопасность),
//        вторая причина - это REUSABLE_CODE (т.е. без дженериков для каждого типа
//        (String, Integer, Car) должен был бы существовать свой лист)

        List<String> otherList = new ArrayList<>();
//                                            <>   ->  название символа Diamond,
//                                                     если его пропустить, то получим список типа RawType
        list.add("privet");
        list.add("poka");
        list.add("ok");
//        list.add(new Car());    -> будет ошибка компиляции, благодаря тому, что лист параметризирован
    }
}
