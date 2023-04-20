package myDB.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorExample {
    // ListIterator расширяет интерфейс Iterator, может идти не только вперед, но еще и назад
    public static void main(String[] args) {
        String s = "madam";

        List<Character> list = new LinkedList<>();

        for (Character ch : s.toCharArray()) {
            list.add(ch);
        }

        ListIterator<Character> iterator = list.listIterator();

        ListIterator<Character> reversIterator = list.listIterator(list.size());

        boolean isPalindrome = true;

        while (iterator.hasNext() && reversIterator.hasPrevious()) {
            if (iterator.next() != reversIterator.previous()) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("NOT Palindrome");
        }

    }
}
