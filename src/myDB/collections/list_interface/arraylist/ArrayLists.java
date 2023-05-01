package myDB.collections.list_interface.arraylist;

import java.util.*;

public class ArrayLists {
    //    ArrayList - реализует интерфейс List - это структура данных реализующая динамический массив
    //    Когда мы создаем новый arraylist, создается массив размером 10(default), размер(size) будет = 0, т.к.
    //    мы еще ничего не добавили, а вот вместимоcть(capacity) = 10. При заполнении массива автоматически
    //    создастся новый массив размером 1,5 от старого + 1 и в него копируется старый(достаточно долгая операция),
    //    но мы можем указать начальную вместимость при создании если мы точно знаем что элементов будет больше.
    //
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("sdfs");
        list1.add("qew");
        list1.add("das");

        ArrayList<String> list2 = new ArrayList<>(30); // --> лист с заданной начальной вместимостью
        list2.add("sdfs");
        list2.add("qew");
        // capacity(вместимость) = 30, но размер листа(size) = 2

        List<String> list3 = new ArrayList<>(); // --> наиболее приемлемый способ создания

        List<String> list4 = new ArrayList<>(list1); // --> еще один способ создания

        List<String> list5 = new ArrayList<>(List.of("фывф", "фывфы")); // --> еще один способ создания
    }
}
