package v2.domain.commands;

import v2.domain.animals.Animal;
import v2.domain.base.Entity;
import v2.domain.titles.Title;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Command extends Entity<CommandId> {
    private final CommandName commandName;
    private final Title title;
    private final HashSet<Animal> trainedAnimals;

    private Command(CommandId id, CommandName titleName, Title title) {
        super(id);
        this.commandName = titleName;
        this.title = title;
        this.trainedAnimals = new HashSet<>();
    }

    public String getName() {
        return commandName.toString();
    }

    public String getTitleName(){
        return title.getName();
    }

    public List<Animal> getTrainedAnimals(){
        return trainedAnimals.stream().toList();
    }

    public void addNewAnimal(Animal animal){
        trainedAnimals.add(animal);
    }

    public static Command create(String titleName, Title title) {
        Command command = new Command(new CommandId(UUID.randomUUID()), new CommandName(titleName), title);
        title.addNewCommand(command);
        return command;
    }

    @Override
    public String toString(){
        return commandName.toString();
    }
}