/*
Даны два Deque, представляющие два целых числа. Цифры хранятся в обратном порядке и каждый из их узлов содержит одну цифру.
Даны два Deque, цифры в обратном порядке.
[3,2,1,-] - пример Deque
[5,4,3]- пример второго Deque
1) -123 * 345 = -42 435
Ответ всегда - связный список, в обычном порядке
[-,4,2,4,3,5] - пример ответа
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class program_1 {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in, "cp866");
    System.out.println("Первое число Deque: ");
    Deque<Integer> deque_1 = Str_to_deq(sc.nextLine());
    System.out.println(deque_1);
    System.out.println("Второе число Deque: ");
    Deque<Integer> deque_2 = Str_to_deq(sc.nextLine());
    System.out.println(deque_2);
    sc.close();
    Product(deque_1, deque_2);
 }

public static Deque<Integer> Str_to_deq(String input) {
    Deque<Integer> deque = new ArrayDeque<>();
    char[] inChar = input.toCharArray();
    if (input.charAt(0) != '-') {
        
        for (char a : inChar) {
             deque.addFirst(Integer.parseInt(String.valueOf(a)));
        }
    } else {
        deque.addFirst(Integer.parseInt(String.valueOf(input.charAt(1))) * -1);
        if (inChar.length > 2) {
            for (int i = 2; i < inChar.length; i++) {
                deque.addFirst(Integer.parseInt(String.valueOf(inChar[i])));
            }
        }
    }
    return deque;
}
    

    public static Integer Deq_to_int(Deque<Integer> deque) {
    int result = 0;
    if (deque.getLast() > 0) {
        for (int i = deque.size() - 1; i >= 0; --i) {
            int pos = (int) Math.pow(10, i);
            result += deque.pollLast() * pos;
        }
    } else {
        result += deque.pollLast() * Math.pow(10, deque.size());
        for (int i = deque.size() - 1; i >= 0; --i) {
            int pos = (int) Math.pow(10, i);
            result += (deque.pollLast() * -1) * pos;
        }
    }
    return result;
    }


    public static void Product(Deque<Integer> deque_1, Deque<Integer> deque_2) {
        LinkedList<Integer> resLinkedList = new LinkedList<>();
        Integer Itog = Deq_to_int(deque_1) * Deq_to_int(deque_2);
        while (Itog != 0) {
            resLinkedList.addFirst(Itog % 10);
            Itog /= 10;
        }
        System.out.print("Результат: ");
        System.out.println(resLinkedList);
    }
 }