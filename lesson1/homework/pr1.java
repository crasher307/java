// Написать программу вычисления n-ого треугольного числа. https://ru.wikipedia.org/wiki/Треугольное_число

package lesson1.homework;

import java.util.Scanner;

public class pr1 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(triangle(getInt()));
    }

    public static int getInt() {
        try {
            System.out.print("Введите число: ");
            return scanner.nextInt();
        } catch (Exception e) {
            // TODO добавить логирование ошибок
            return 0;
        }
    }

    private static int triangle(int n) {
        return n <= 1 ? n : n + triangle(n - 1);
    }
}
