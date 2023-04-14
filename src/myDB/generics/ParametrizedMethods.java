package myDB.generics;

import java.util.ArrayList;

public class ParametrizedMethods {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>();

        integers.add(10);
        integers.add(20);
        integers.add(5);

        int a = GenMethod.getSecondElement(integers);
        System.out.println(a);

        ArrayList<String> strings = new ArrayList<>();

        strings.add("abc");
        strings.add("def");
        strings.add("ghi");

        String b = GenMethod.getSecondElement(strings);
        System.out.println(b);
    }
}

class GenMethod {
    public static <T> T getSecondElement(ArrayList<T> al) {
        return al.get(1);
    }
}
