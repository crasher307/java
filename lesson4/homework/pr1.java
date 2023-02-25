// Реализовать алгоритм пирамидальной сортировки (HeapSort)

package lesson4.homework;

import java.util.Arrays;
import java.util.Random;

public class pr1 {
    private static final boolean viewLog = false;
    private static Random rand = new Random();
    private static final int[] arr = create(0, 99, 10);
    // private static final int[] arr = {6, 44, 94, 18, 55, 12, 42, 67};

    public static void main(String[] args) {
        System.out.println("Стартовый: " + Arrays.toString(arr));
        sort();
        System.out.println("Результат: " + Arrays.toString(arr));
    }

    private static int[] create(int min, int max, int count) {
        var num = new int[count];
        for (int i = 0; i < count; i++) num[i] = min + rand.nextInt(max - min + 1);
        return num;
    }

    private static void sort() {
        if (viewLog) System.out.println("Построение:");
        for (int i = arr.length / 2 - 1; i >= 0; i--) three(i, arr.length); // Построение
        if (viewLog) System.out.println("Сортировка:");
        for (int i = arr.length - 1; i >= 0; i--) { // Сортировка
            move(i, 0, "\t");
            three(0, i);
        }
    }

    private static void three(int i, int len) {
        int e_idx = i; // Корень
        int l_idx = i * 2 + 1;
        int r_idx = i * 2 + 2;
        if (l_idx < len && arr[l_idx] > arr[e_idx]) e_idx = l_idx; // Левый больше
        if (r_idx < len && arr[r_idx] > arr[e_idx]) e_idx = r_idx; // Правый больше
        if (e_idx != i) { // Больший эл-т изменился
            move(i, e_idx, "\t\t");
            three(e_idx, len); // Трогаем листву
        }
    }

    private static void move(int left, int right, String pre) {
        if (viewLog) System.out.printf("%s%s idx: %d <--> %d\n", pre, Arrays.toString(arr), left, right);
        move(left, right);
    }

    private static void move(int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}