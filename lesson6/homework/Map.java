package lesson6.homework;

public class Map implements iMap {
    protected SymItem[][] data; // Данные карты
    protected Point size; // Размер
    protected Point start; // Точка старта
    protected Point end; // Точка выхода

    public Map() {
        var H = Symbols.wall; // wall
        var o = Symbols.clear; // clear
        var i = Symbols.start; // start
        var v = Symbols.end; // end
        this.set(new SymItem[][]{
                {H, H, H, H, H, H, H, H, H},
                {i, o, H, o, o, o, o, o, H},
                {H, o, H, o, H, H, H, H, H},
                {H, o, o, o, o, o, o, o, H},
                {H, H, H, H, H, H, H, o, H},
                {H, o, o, o, o, o, o, o, H},
                {H, o, H, o, H, H, H, H, H},
                {H, H, H, o, H, o, H, o, v},
                {H, o, H, o, o, o, H, o, H},
                {H, o, o, o, H, o, o, o, H},
                {H, H, H, H, H, H, H, H, H},
        });
    }

    public Map(String file) {
        // TODO Добавить генерацию карты из файла
    }

    public Map(int width, int height) {
        // TODO Добавить генерацию карты по алгоритму
    }

    @Override
    public SymItem get(int x, int y) {
        return this.data[y][x];
    }

    @Override
    public void set(SymItem[][] data) {
        this.data = data;
        this.size = new Point(data[0].length, data.length);
        for (int x = 0; x < this.size.x; x++) {
            for (int y = 0; y < this.size.y; y++) {
                if (this.get(x, y).data == Symbols.start.data) this.start = new Point(x, y);
                if (this.get(x, y).data == Symbols.end.data) this.end = new Point(x, y);
            }
        }
    }

    @Override
    public void set(int x, int y, SymItem data) {
        this.data[y][x] = data;
    }

    @Override
    public void setItem(int x, int y, String data) {
        this.data[y][x] = new SymItem(data, this.data[y][x].data);
    }

    @Override
    public void setData(int x, int y, int data) {
        this.data[y][x] = new SymItem(this.data[y][x].item, data);
    }

    @Override
    public void view(boolean viewRaw) {
        for (SymItem[] row : this.data) {
            for (SymItem item : row) System.out.printf(viewRaw ? "%3d" : "%s", viewRaw ? item.data : item.item);
            System.out.print("\n");
        }
    }

    @Override
    public void searchWay() {
        Wave.way(this);
    }
}