// Реализовать задание и печать карты для волнового алгоритма

package lesson5.homework;

public class pr1 {
    public static void main(String[] args) {
        var lab = new Labyrinth();
        lab.getMap(true);
    }
}

class Labyrinth {
    private final int[][] map = this.createMapStatic();
    private int steps = 0;
    private int[] posPlayer;
    private static final int clear = 0;
    private static final String symClear = "   ";
    private static final int player = -1;
    private static final String symPlayer = " ■ ";
    private static final int exit = -2;
    private static final String symExit = " ¤ ";
    private static final int wall = -9;
    private static final String symWall = "░░░";
    private static final int way = -3;
    private static final String symWay = " · ";

    public Labyrinth() {
        try {
            this.posPlayer = searchPoint(player, "Player");
            searchPoint(exit, "Exit");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Вывод карты
    public void getMap() {
        getMap(false);
    }

    public void getMap(boolean showWay) {
        if (showWay) searchWay(true); // Поиск пути с отображением
        var response = new StringBuilder();
        String d;
        for (int[] rows : map) {
            for (int data : rows) {
                d = switch (data) {
                    default -> showWay ? symClear : symWay; // clear
                    case player -> symPlayer; // player
                    case exit -> symExit; // cookie
                    case way -> symWay; // way
                    case wall -> symWall; // wall
                };
                response.append(d);
            }
            response.append("\n");
        }
        if (showWay) response.append("Шагов: ").append(steps);
        System.out.println(response);
//        return response.toString();
    }

    public void getRawMap() {
        getRawMap(false);
    }

    public void getRawMap(boolean showWay) {
        if (showWay) searchWay(false); // Поиск пути с отображением
        var response = new StringBuilder();
        for (int[] rows : map) {
            for (int data : rows) {
                response.append(String.format("%3d", data));
            }
            response.append("\n");
        }
        System.out.println(response);
//        return response.toString();
    }

    // Генератор карт
    private int[][] createMap(int x, int y) {
//        for (int i = 0; i < y * 2 + 1; i++) {
//            for (int k = 0; k < x * 2 + 1; k++) {
//                //
//            }
//        }
        return null; // TODO генерация карты заданных размеров
    }

    private int[][] createMapStatic() {
        return new int[][]{
                {-9, -9, -9, -9, -9, -9, -9, -9, -9},
                {-1, 00, -9, 00, 00, 00, 00, 00, -9},
                {-9, 00, -9, 00, -9, -9, -9, -9, -9},
                {-9, 00, 00, 00, 00, 00, 00, 00, -9},
                {-9, -9, -9, -9, -9, -9, -9, 00, -9},
                {-9, 00, 00, 00, 00, 00, 00, 00, -9},
                {-9, 00, -9, 00, -9, -9, -9, -9, -9},
                {-9, -9, -9, 00, -9, 00, -9, 00, -2},
                {-9, 00, -9, 00, 00, 00, -9, 00, -9},
                {-9, 00, 00, 00, -9, 00, 00, 00, -9},
                {-9, -9, -9, -9, -9, -9, -9, -9, -9},
        };
//        return new int[][]{
//                {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9},
//                {-1, 00, 00, 00, -9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, 00, 00, 00, -9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, 00, -9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, -9, -9, -9, -9, 00, 00, 00, 00, -9, -9, -9, -9, -9, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, -9, 00, 00, -9, 00, 00, 00, 00, -9, 00, -9, 00, -9, 00, 00, 00, 00, -9},
//                {-9, -9, -9, 00, -9, 00, -9, 00, 00, -9, 00, 00, 00, 00, -9, 00, -9, 00, -9, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, -9, 00, 00, -9, -9, -9, 00, 00, -9, 00, -9, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, 00, 00, 00, -9, 00, 00, 00, 00, -9, 00, 00, 00, -9, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, 00, 00, 00, 00, -9, 00, 00, 00, 00, -9, 00, 00, 00, -9, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, -9, -9, -9, -9, -9, 00, 00, 00, 00, -9, -9, -9, -9, -9, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, -9, -9, -9, -9, -9, -9, -9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -9},
//                {-9, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, 00, -2},
//                {-9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, -9}
//        };
    }

    private int[][] createMapFile() {
        return null; // TODO считывание карты из файла
    }

    // Поиск точки
    private int[] searchPoint(int value, String pointName) throws Exception {
        for (int y = 0; y < map.length; y++)
            for (int x = 0; x < map[y].length; x++)
                if (map[y][x] == value)
                    return new int[]{x, y};
        throw new Exception(String.format("Point \"%s\" not found", pointName));
    }

    // Поиск пути
    private void searchWay(boolean showWay) {
        // TODO ищет первый доступный путь, переделать на самый короткий
        try {
            searchWay(posPlayer[0], posPlayer[1], 0, showWay);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean searchWay(int x, int y, int step, boolean showWay) {
        boolean isWay = false;
        int[][] check = {{x, y - 1}, {x + 1, y}, {x, y + 1}, {x - 1, y}};
        if (map[y][x] == clear) map[y][x] = showWay ? way : step;
        int data;
        for (int[] p : check) {
            try {
                data = map[p[1]][p[0]];
                if (data == clear) isWay = isWay || searchWay(p[0], p[1], step + 1, showWay);
                if (data == exit) {
                    steps = step;
                    isWay = true;
                }
            } catch (Exception e) {
                //
            }
        }
        if (!isWay && showWay) map[y][x] = clear;
        return isWay;
    }
}
