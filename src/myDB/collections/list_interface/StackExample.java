package myDB.collections.list_interface;

import java.util.Stack;

public class StackExample {
    // не рекомендован к использованию, устаревшая структура данных, является
    // наследником класса Vector и так же является synchronized классом. Использует
    // принцип LIFO(последним пришел, первым вышел)
    public static void main(String[] args) {
        System.out.println("main starts"); // --> LIFO
        abc3();
        System.out.println("main ends");

        Stack<String> strings = new Stack<>();
        strings.push("Zaur");
        strings.push("Misha");
        strings.push("Oleg");
        strings.push("Katya");
        System.out.println(strings);
        strings.pop();                      // удалит элемент последним пришедшим ("Katya")
        System.out.println(strings);
        System.out.println(strings.pop());
        System.out.println(strings.pop());
        System.out.println(strings.pop());  // тут наш стек стал пустым
        System.out.println(strings.pop());  // получим ошибку EmptyStackException
        // поэтому перед удалением элемента лучше проверить пуст стек или нет при помощи метода .isEmpty()
        strings.isEmpty();
        strings.peek();                     // возвращает последний элемент, но не удаляет

    }

    static void abc1() {
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }
    static void abc2() {
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }
    static void abc3() {
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }
}
