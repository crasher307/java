// Написать программу вычисления n-ого треугольного числа. https://ru.wikipedia.org/wiki/Треугольное_число

package lesson1.homework;

public class pr1 extends lib.base {
    public static void main(String[] args) {
        System.out.println(triangle(getInt("Введите число")));
    }

    private static int triangle(int n) {
        return n < 2 ? n : n-- + triangle(n);
    }
}
