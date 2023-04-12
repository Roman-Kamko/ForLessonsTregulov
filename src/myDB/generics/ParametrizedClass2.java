package myDB.generics;

public class ParametrizedClass2 {
    public static void main(String[] args) {
        Pair<String, Integer> pair1 = new Pair<>("privet", 20);
        System.out.println(pair1.getFirstValue() + " " + pair1.getSecondValue());

        Pair<Double, Integer> pair2 = new Pair<>(3.14, 156);
        System.out.println(pair2.getFirstValue() + " " + pair2.getSecondValue());

        OtherPair<String> pair3 = new OtherPair<>("poka", "ok");
        System.out.println(pair3.getFirstValue() + " " + pair3.getSecondValue());
    }
}

class OtherPair<V> {
    private V value1;
    private V value2;

    public OtherPair(V value1, V value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V getFirstValue() {
        return value1;
    }

    public V getSecondValue() {
        return value2;
    }
}
class Pair<V1, V2> {
    private V1 value1;
    private V2 value2;

    public Pair(V1 value1, V2 value2) {
        this.value1 = value1;
        this.value2 = value2;
    }

    public V1 getFirstValue() {
        return value1;
    }

    public V2 getSecondValue() {
        return value2;
    }
}
