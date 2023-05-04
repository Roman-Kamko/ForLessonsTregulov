package myDB.lambda_expressions;

import java.util.ArrayList;
import java.util.List;

public class ForEach {
    //метод .forEach() принимает в качестве параметра Consumer
    public static void main(String[] args) {
        List<String> list = List.of("privet", "kak dela", "normalno", "poka");
        for (String s : list) {
            System.out.println(s);
        }

        list.forEach(s -> System.out.println(s));

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);

        integers.forEach(integer -> {
            System.out.println(integer);
            integer *= 2;
            System.out.println(integer);
        });
    }
}
