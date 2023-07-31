// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package lesson2.homework;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class pr2 {
    private static final String file = "./lesson2/homework/pr2.log";
    private static final Random rand = new Random();

    public static void main(String[] args) {
        int[] num = create(100, 20);
        String data = "create:\t" + Arrays.toString(num) + "\nresult:\t" + Arrays.toString(sort(num)) + "\n";
        System.out.println(data);
        saveToFile(data);
    }

    private static int[] create(int max, int count) {
        var num = new int[count];
        for (int i = 0; i < count; i++) {
            num[i] = rand.nextInt(max);
        }
        return num;
    }

    private static int[] sort(int[] num) {
        int tmp = 0;
        for (int i = 0; i + 1 < num.length; i++) {
            for (int j = 0; j + 1 < num.length - i; j++) {
                if (num[j] > num[j + 1]) {
                    tmp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = tmp;
                    saveToFile(Arrays.toString(num));
                }
            }
        }
        return num;
    }

    private static void saveToFile(String text) {
        try {
            DataInputStream dis = new DataInputStream(new FileInputStream(file));
            byte[] bytes = new byte[dis.available()];
            dis.readFully(bytes);
            String data = new String(bytes, 0, bytes.length);
            var fw = new FileWriter(file);
            fw.append(data).append("\n").append(text).flush();
            fw.close();
        } catch (Exception e) {
            // TODO добавить логирование
        }
    }
}
