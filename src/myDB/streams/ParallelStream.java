package myDB.streams;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    /*
    * Когда мы работаем со стримами по умолчанию используется последовательные потоки,
    * для параллельного стрима нужно указывать вручную.
    * ParallelStream - это возможность использования нескольких ядер процессора при
    * выполнении каких-либо операций со stream
    * */
    public static void main(String[] args) {
        List<Double> doubles = new ArrayList<>();
        doubles.add(10.0);
        doubles.add(5.0);
        doubles.add(1.0);
        doubles.add(0.25);

        double someResult = doubles.parallelStream()
                .reduce((a, e) -> a + e)
                .get();
        System.out.println(someResult);

        double divisionResult = doubles.parallelStream()
                .reduce((a, e) -> a / e)
                .get();
        System.out.println(divisionResult); // -> 0.5
        // когда порядок действий важен нельзя использовать параллельные стримы,
        // т.к. это отразится на результате как в примере выше,
        // должны были получить 8, а получили 0.5
    }
}
