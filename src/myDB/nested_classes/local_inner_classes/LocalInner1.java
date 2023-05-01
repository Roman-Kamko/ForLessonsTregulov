package myDB.nested_classes.local_inner_classes;

public class LocalInner1 {
    public static void main(String[] args) {
        Math math = new Math();
        math.getResult();
    }
}

class Math {
    public void getResult() {
        class Divide {
            /* LocalInner классы располагаются внутри блоков кода таких, как метод или конструктор.
            *  LocalInner классы не могут быть static.
            *  Область видимости LocalInner класса - это блок в котором он находится.
            *  LocalInner классы могут обращаться даже к private переменным внешнего класса.
            *  LocalInner класс может обращаться к элементам блока в котором он находится при условии,
            *  что они final effectively final. */
            private int dividend;
            private int divisor;

            public int getDividend() {
                return dividend;
            }

            public void setDividend(int dividend) {
                this.dividend = dividend;
            }

            public int getDivisor() {
                return divisor;
            }

            public void setDivisor(int divisor) {
                this.divisor = divisor;
            }

            public int getQuotient() {
                return dividend / divisor;
            }

            public int getRemainder() {
                return dividend % divisor;
            }
        }
        Divide divide = new Divide();
        divide.setDividend(21);
        divide.setDivisor(4);
        System.out.println(divide.getDividend());
        System.out.println(divide.getDivisor());
        System.out.println(divide.getQuotient());
        System.out.println(divide.getRemainder());
    }
}
