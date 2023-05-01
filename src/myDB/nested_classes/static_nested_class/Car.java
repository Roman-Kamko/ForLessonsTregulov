package myDB.nested_classes.static_nested_class;

public class Car {
    String color;
    int doorCount;
    Engine engine;
    private static int a;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    void method() {
        System.out.println(Engine.count); // и наоборот, внешний класс может обратиться к статичной
                                          // переменной внутреннего класса даже если он приватный
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public static class Engine {
        /*если добавить private, то экземпляр этого класса можно будет создать только внутри класса Car
        * также можно его делать final, abstract и т.д. он может наследовать другой класс(и быть родителем)
        * и имплементировать интерфейсы, может содержать static и nonStatic элементы.
        * Может обращаться даже к private переменным внешнего класса, но только к static переменным*/
        int horsePower;
        private static int count;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
            System.out.println(a); // обращаемся к приватной статичной переменной внешнего класса
            ++count;
        }

        @Override
        public String toString() {
            return "My engine: {" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test {
    public static void main(String[] args) {
        Car.Engine engine = new Car.Engine(256);
        System.out.println(engine);
        /* Таким образом статичный нестед класс ничем не отличается от обычного класса,
           кроме того что он находится внутри другого класса и экземпляр этого класса
           можно создать только с указание в каком классе он находится Car.Engine */

        Car car = new Car("Red", 2, engine);
        System.out.println(car);
    }
}
