package myDB.nested_classes.anonymous_classes;

public class AnonymousClass1 {
    /*Анонимные классы не имеют имени.
      Анонимный класс - это объявление класса и одновременное создание объекта.
      В Анонимных классах невозможно создать конструктор.
      Анонимный класс может обращаться даже к private переменным внешнего класса, но нужно будет создать объект
      внешнего класса внутри анонимного.
      Lambda Expressions - это краткая форма написания анонимных классов.
      Анонимные классы могут использоваться практически в любой ситуации когда используются LocalInner классы.
      Мы не можем использовать анонимный класс более 1 раза, т.е. мы не можем создать еще объект анонимного класса.
      Анонимный класс используется когда нужно создать на ходу объект какого - либо класса, который видоизменяет его метод */
    public static void main(String[] args) {
        Math m = new Math() {  // анонимный класс, объектом которого является m
            @Override
            public int doOperation(int a, int b) {
                return a + b;
            }
        };

        Math m2 = new Math() {  // анонимный класс, объектом которого является m2
            @Override
            public int doOperation(int a, int b) {
                return a * b;
            }
        };

        System.out.println(m.doOperation(5, 3));
        System.out.println(m.doOperation(1, 6));
        System.out.println(m2.doOperation(5, 3));
        System.out.println(m2.doOperation(1, 6));

        Math2 m3 = new Math2() {  // анонимный класс, объектом которого является m3. Это можно проделывать не
                                  // только с интерфейсом, но и с другим классом, который уже содержит какую-то логику
            @Override
            public int doSomething(int a, int b) {
                return a - b;
            }
        };
    }
}

interface Math {
    int doOperation(int a, int b);
}

class Math2 {
    public int doSomething(int a, int b) {
        return a % b;
    }
}
