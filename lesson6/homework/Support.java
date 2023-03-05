package lesson6.homework;

interface iMap {
    SymItem get(int x, int y);

    default SymItem get(Point point) {
        return get(point.x, point.y);
    }

    void set(SymItem[][] data);

    void set(int x, int y, SymItem data);

    default void set(Point point, SymItem data) {
        set(point.x, point.y, data);
    }

    void setItem(int x, int y, String data);

    default void set(int x, int y, String data) {
        setItem(x, y, data);
    }

    default void set(Point point, String data) {
        setItem(point.x, point.y, data);
    }

    void setData(int x, int y, int data);

    default void set(int x, int y, int data) {
        setData(x, y, data);
    }

    default void set(Point point, int data) {
        setData(point.x, point.y, data);
    }

    void view(boolean viewRaw);

    default void view() {
        view(false);
    }

    default void viewRaw() {
        view(true);
    }

    void searchWay();
}

class Symbols {
    protected static SymItem clear = new SymItem("   ", 0); // Пустое поле
    protected static SymItem start = new SymItem(" ■ ", -1); // Начало
    protected static SymItem end = new SymItem(" ¤ ", -2); // Конец
    protected static SymItem way = new SymItem(" · ", -3); // Путь
    protected static SymItem wall = new SymItem("░░░", -9); // Стена
}

class SymItem {
    protected int data; // Числовое значение
    protected String item; // Символьное значение

    public SymItem(String item, int data) {
        this.item = item;
        this.data = data;
    }
}

class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
