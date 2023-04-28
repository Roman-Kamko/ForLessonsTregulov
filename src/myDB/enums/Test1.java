package myDB.enums;

public class Test1 {
    // есть ситуации, когда нужно чтобы пользователь указывал что-то конкретное,
    // а не то что ему придет в голову. Для таких ситуаций и нужен Enum. Т.е. это
    // способ ограничения определенного рода информации конкретным списком возможных
    // вариантов. enum является дочерним классом java.lang.Enum
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.method("privet");
    }

    void method(String dayOfWeek) {
        System.out.println("today is " + dayOfWeek);
    }
}
