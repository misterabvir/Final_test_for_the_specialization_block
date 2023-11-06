package v2.domain.titles;

import v2.domain.animals.Animal;
import v2.domain.base.Entity;
import v2.domain.commands.Command;
import v2.domain.kinds.Kind;

import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Title extends Entity<TitleId> {
    private final TitleName titleName;
    private final Kind kind;
    private final HashSet<Animal> existsAnimals;
    private final HashSet<Command> availableCommands;

    private Title(TitleId id, TitleName titleName, Kind kind) {
        super(id);
        this.titleName = titleName;
        this.kind = kind;
        this.existsAnimals = new HashSet<>();
        this.availableCommands = new HashSet<>();
    }

    public String getName(){
        return titleName.toString();
    }

    public String getKindName(){
        return kind.getName();
    }

    public List<Animal> getExistsAnimals(){
        return existsAnimals.stream().toList();
    }

    public void addNewAnimal(Animal animal){
        existsAnimals.add(animal);
    }

    public List<Command> getAvailableCommands(){
        return availableCommands.stream().toList();
    }

    public void addNewCommand(Command command){
        availableCommands.add(command);
    }

    public static Title create(String titleName, Kind kind){
        Title title = new Title(new TitleId(UUID.randomUUID()), new TitleName(titleName), kind);
        kind.addNewTitle(title);
        return title;
    }
}
