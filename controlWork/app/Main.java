package controlWork.app;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем объект счетчика и животное
        try (Counter counter = new Counter()) {
            Animal animal = new Animal("Собака");

            // Заведение нового животного
            counter.add();

            // Определение животного в правильный класс
            // В данном примере не будет реализовано определение класса животного

            // Добавление и выполнение команд
            animal.teachCommand("Сидеть");
            animal.teachCommand("Лежать");
            animal.teachCommand("Дай лапу");

            List<String> commands = animal.getCommands();
            System.out.println("Список команд для " + animal.getSpecies() + ": " + commands);

            // Обучение новых команд
            animal.teachCommand("Фас");
            animal.teachCommand("Кушать");

            // Вывод обновленного списка команд
            commands = animal.getCommands();
            System.out.println("Обновленный список команд для " + animal.getSpecies() + ": " + commands);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}