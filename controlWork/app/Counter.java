package controlWork.app;

class Counter implements AutoCloseable {
    private int count;

    public Counter() {
        this.count = 0;
    }

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() {
        // Здесь можно реализовать логику проверки, был ли счетчик использован в блоке try-with-resources.
        // Если нет, то можно бросить исключение или предупреждение.
        // В данном примере не будет реализована такая проверка.
    }
}