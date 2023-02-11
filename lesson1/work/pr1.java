// Дан массив чисел, нужно сформировать новую выборку только из четных чисел

package lesson1.work;

import java.util.Arrays;
import java.util.Random;

public class pr1 {
    private static final Random rand = new Random();
    private static final int[] num = createRandom(30, 10, 20);
    private static final int[] numEven = getEven(num);

    public static void main(String[] args) {
        print("Стартовый", num);
        print("Конечный", numEven);
    }

    private static int[] createRandom(int size, int min, int max) {
        numArr arr = new numArr();
        for (int i = 0; i < size; i++) arr.append(rand.nextInt(max - min) + min);
        return arr.data;
    }

    private static int[] getEven(int[] num) {
        numArr numbersEven = new numArr();
        for (int item : num) if (item % 2 == 0) numbersEven.append(item);
        return numbersEven.data;
    }

    private static void print(int[] num) {
        print("Вывод", num);
    }

    private static void print(String message, int[] num) {
        message += ":\t";
        System.out.println(message + Arrays.toString(num));
    }
}

class numArr {
    int[] data = new int[0];

    public int get(int idx) {
        return data[idx];
    }

    public int count() {
        return data.length;
    }

    public void append(int item) {
        int size = data.length;
        int[] temp = new int[size + 1];
        System.arraycopy(data, 0, temp, 0, size);
        temp[size] = item;
        data = temp;
    }
}
