package myDB.nested_classes.inner_class;


public class Car {
    String color;
    private int doorCount;
    Engine engine;

    public Car(String color, int doorCount) {
        this.color = color;
        this.doorCount = doorCount;
//        this.engine = this.new Engine(horsePower); // создание иннер класса Engine, есть и другой способ, см. далее

    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "My car: {" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    public class Engine {
        /*Каждый объект inner класса всегда ассоциируется с объектом внешнего класса.
         * Создавая объект inner класса, нужно перед этим создать объект внешнего класса
         * inner класс может содержать только nonStatic элементы(можно создать только статичную константу)
         * inner класс может обращаться к private элементам внешнего класса
         * Внешний класс может обращаться даже к private элементам inner класс прежде создав его объект*/
        int horsePower;

        public Engine(int horsePower) {
            System.out.println(doorCount); // nonStatic doorCount доступен в inner классе в отличие от static nested класса
            this.horsePower = horsePower;
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
//        Car.Engine engine = new Car.Engine(256); теперь такое не проканает, теперь у нас Engine - inner класс
//        Car car = new Car("Black", 4, 300);
//        создание экземпляра Car сразу с экземпляром Engine,
//        т.к. в конструкторе Car есть this.engine = this.new Engine(horsePower)
//        System.out.println(black);
        Car car2 = new Car("Brown", 4);
//        убрав this.engine = this.new Engine(horsePower) из конструктора можем так создать,
//        а Engine тут будет со значением null
        Car.Engine engine1 = car2.new Engine(150);
//        так создается объект Engine если его создание не указанно в конструкторе внешнего класса
        car2.setEngine(engine1);
//        воспользовались созданным сеттером для добавления двигателя в машину
        System.out.println(engine1);
        System.out.println(car2);

//        одновременное создание экземпляров и внутреннего и внешнего класса(в случае если создание Engine нет в конструкторе):
        Car.Engine engine2 = new Car("White", 2).new Engine(400);
//        но тогда теряется ссылка на машину и какой машине принадлежит двигатель неясно(редкий способ создания)


    }
}