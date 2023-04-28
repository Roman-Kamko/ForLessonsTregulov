package myDB.enums;

import java.util.Arrays;

public class Enum1 {
    public static void main(String[] args) {
        Today today = new Today(WeekDays.MONDAY);
        today.daysInfo();
        WeekDays w1 = WeekDays.FRIDAY;
        WeekDays w2 = WeekDays.FRIDAY;
        WeekDays w3 = WeekDays.MONDAY;
        System.out.println(w1 == w2); // true
        System.out.println(w1 == w3); // false
//        System.out.println(WeekDays.FRIDAY == WeekDays2.FRIDAY);        нельзя так сравнивать
//        System.out.println(WeekDays.FRIDAY.equals( WeekDays2.FRIDAY));  всегда false т.к. типы разные
        WeekDays w15 = WeekDays.valueOf("MONDAY");
        System.out.println(w15);
        WeekDays[] arr = WeekDays.values();

        System.out.println(Arrays.toString(arr));
    }
}

class Today {
    WeekDays weekDays;

    public Today(WeekDays weekDays) {
        this.weekDays = weekDays;
    }

    void daysInfo() {
        switch (weekDays) {
            case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY -> System.out.println("Иди на работу");
            case SATURDAY, SUNDAY -> System.out.println("Можно отдохнуть");
        }
        System.out.println("Настроение в этот день " + weekDays.getMood());
    }
}

enum WeekDays {
    MONDAY("bad"),
    TUESDAY("bad"),
    WEDNESDAY("so-so"),
    THURSDAY("so-so"),
    FRIDAY,                     // благодаря конструктору без параметров
    SATURDAY("great"),
    SUNDAY("good");
    private String mood;

    WeekDays(String mood) { // конструктор всегда private, срабатывает автоматически, ключ. слово new не нужно, нельзя наследоваться
        this.mood = mood;
    }

    WeekDays() {               // создали конструктор без параметров
    }

    public String getMood() {
        return mood;
    }
}
enum WeekDays2 {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY;
}
