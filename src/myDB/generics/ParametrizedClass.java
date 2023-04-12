package myDB.generics;

public class ParametrizedClass {
    public static void main(String[] args) {
        Info<String> info1 = new Info<>("privet");
        String s = info1.getValue();
        System.out.println(info1);

        Info<Integer> info2 = new Info<>(123);
        System.out.println(info2);
        Integer x = info2.getValue();
    }

}

class Info<T> {
//    T -> TypePlaceHolder (заполнитель типа)
    private T value;

    public Info(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{[" + value + "]}";
    }

    public T getValue() {
        return value;
    }
}
