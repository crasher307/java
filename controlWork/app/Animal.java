package controlWork.app;

import java.util.ArrayList;
import java.util.List;

// Класс Животное
class Animal {
    private String species;
    private List<String> commands;

    public Animal(String species) {
        this.species = species;
        this.commands = new ArrayList<>();
    }

    public String getSpecies() {
        return species;
    }

    public List<String> getCommands() {
        return commands;
    }

    public void executeCommand(String command) {
        System.out.println(species + " выполняет команду: " + command);
    }

    public void teachCommand(String newCommand) {
        commands.add(newCommand);
    }
}





