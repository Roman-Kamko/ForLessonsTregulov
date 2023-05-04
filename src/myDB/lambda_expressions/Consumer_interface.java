package myDB.lambda_expressions;

import java.util.ArrayList;
import java.util.function.Supplier;
import java.util.function.Consumer;

public class Consumer_interface {
    /*Consumer(потребитель) - функциональный интерфейс, противоположен интерфейсу Supplier, его метод
     * void accept(T t);
     * под потреблением мы понимаем, что мы хотим что-то сделать с объектом*/
    public static ArrayList<Car> createThreeCars(Supplier<Car> carSupplier) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            cars.add(carSupplier.get());
        }
        return cars;
    }

    public static void changeCar(Car car, Consumer<Car> carConsumer) {
        carConsumer.accept(car);
    }

    public static void main(String[] args) {
        ArrayList<Car> ourCars = createThreeCars(() -> new Car("nissan tiida", "silver", 1.6));
        //Supplier поставляет объекты
        System.out.println(ourCars);

        changeCar(ourCars.get(0), car -> {
            car.color = "red";
            car.engine = 2.4;
        });
        System.out.println(ourCars);
    }
}

//class Car2 {
//    String model;
//    String color;
//    double engine;
//
//    public Car(String model, String color, double engine) {
//        this.model = model;
//        this.color = color;
//        this.engine = engine;
//    }
//
//    @Override
//    public String toString() {
//        return "Car{" +
//                "model='" + model + '\'' +
//                ", color='" + color + '\'' +
//                ", engine=" + engine +
//                '}';
//    }
//}

