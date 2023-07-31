// Реализовать алгоритм сортировки слиянием

package lesson3.homework;

import java.util.Arrays;
import java.util.Random;

public class pr1 {
    private static final Random rand = new Random();

    public static void main(String[] args) {
        int[] num = create(10, 100, 20);
        String data = "create:\t" + Arrays.toString(num) + "\nresult:\t" + Arrays.toString(mergeSort(num)) + "\n";
        System.out.println(data);
    }

    private static int[] create(int min, int max, int count) {
        var num = new int[count];
        for (int i = 0; i < count; i++) num[i] = min + rand.nextInt(max - min + 1);
        return num;
    }

    private static int[] mergeSort(int[] array) {
        return mergeSort(array, new int[array.length], 0, array.length, false);
    }

    private static int[] mergeSort(int[] array, boolean log) {
        return mergeSort(array, new int[array.length], 0, array.length, log);
    }

    private static int[] mergeSort(int[] buf1, int[] buf2, int start, int end, boolean log) {
        if (start >= end - 1) return buf1;
        // Разбиение
        int mid = start + (end - start) / 2;
        int[] b1 = mergeSort(buf1, buf2, start, mid, log);
        int[] b2 = mergeSort(buf1, buf2, mid, end, log);
        // Сортировка
        int[] result = b1 == buf1 ? buf2 : buf1;
        int i1 = start, i2 = mid, i3 = start;
        while (true) {
            if (i1 < mid && i2 < end) result[i3++] = b1[i1] < b2[i2] ? b1[i1++] : b2[i2++];
            else if (i1 < mid) result[i3++] = b1[i1++];
            else if (i2 < end) result[i3++] = b2[i2++];
            else break;
        }
        if (log) System.out.println("Res: " + Arrays.toString(result));
        return result;
    }
}
