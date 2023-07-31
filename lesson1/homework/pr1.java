// Написать программу вычисления n-ого треугольного числа. https://ru.wikipedia.org/wiki/Треугольное_число

package lesson1.homework;

import java.util.Scanner;

public class pr1 {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(triangle(getInt()));
    }

    public static int getInt() {
        System.out.print("Введите число: ");
        int result = 0;
        try {
            result = scanner.nextInt();
        } catch (Exception e) {
            // TODO добавить логирование ошибок
        }
        return result;
    }

    private static int triangle(int n) {
        return n < 2 ? n : n-- + triangle(n);
    }
}
