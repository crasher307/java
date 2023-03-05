package lesson6.homework;

public class pr1 {
    static Map map = new Map();

    public static void main(String[] args) {
        Wave.way(map); // Поиск пути
        map.view(); // Вывод лабиринта (+ найденый путь)
        // map.viewRaw(); // Вывод данных (+ волна)
    }
}