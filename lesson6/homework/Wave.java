package lesson6.homework;

public class Wave {
    public static void way(Map map) {
        setRaw(map, map.start, 1);
        setView(map, map.end);
    }

    private static void setRaw(Map map, Point point, int step) {
        if (!empty(map, point)) map.set(point, step);
        for (Point p : check(point)) {
            if (empty(map, p)) continue;
            if (map.get(p).data != Symbols.clear.data && map.get(p).data != Symbols.end.data) continue;
            setRaw(map, p, step + 1);
        }
    }

    private static void setView(Map map, Point point) {
        if (!empty(map, point) && map.get(point).item.equals(Symbols.clear.item)) map.set(point, Symbols.way.item);
        for (Point p : check(point)) {
            if (empty(map, p)) continue;
            if (map.get(point).data < map.get(p).data || map.get(p).data <= Symbols.clear.data) continue;
            setView(map, p);
        }
    }

    private static boolean empty(Map map, Point point) {
        return !(point.x >= 0 && point.x < map.size.x && point.y >= 0 && point.y < map.size.y); // empty x or y
    }

    private static Point[] check(Point point) {
        return new Point[]{
                new Point(point.x, point.y - 1), // top
                new Point(point.x + 1, point.y), // right
                new Point(point.x, point.y + 1), // bottom
                new Point(point.x - 1, point.y), // left
        };
    }
}