package v2.domain.animals;

import v2.domain.base.Entity;
import v2.domain.commands.Command;
import v2.domain.titles.Title;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

public class Animal extends Entity<AnimalId> {
    private final AnimalName animalName;
    private final Title title;
    private final Date birthday;
    private final HashSet<Command> learnedCommands;
    private Animal(AnimalId id, AnimalName animalName, Date birthday, Title title) {
        super(id);
        this.animalName = animalName;
        this.birthday = birthday;
        this.learnedCommands = new HashSet<>();
        this.title = title;
    }

    public List<Command> getLearnedCommands(){
        return learnedCommands.stream().toList();
    }

    public boolean addNewCommand(Command command){
        if(learnedCommands.contains(command)){
            return false;
        }
        learnedCommands.add(command);
        return true;
    }

    public String getName(){
        return animalName.toString();
    }

    public String getAnimalTitle(){
        return title.getName();
    }

    public static Animal create(String animalName, Date birthday, Title title){
        Animal animal = new Animal(new AnimalId(UUID.randomUUID()), new AnimalName(animalName), birthday, title);
        title.addNewAnimal(animal);
        return animal;
    }

    public Date getBirthday() {
        return birthday;
    }
}