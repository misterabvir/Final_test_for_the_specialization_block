package v1.domain.pets.Cat;

import java.util.Date;
import java.util.UUID;

import v1.domain.base.Animal;
import v1.domain.base.PetsType;

public class Cat extends Animal {
    private Cat(String name, Date birthday) {
        super(UUID.randomUUID(), name, PetsType.CAT, birthday);
    }

    public static Cat create(String name, Date birthday){
        return new Cat(name, birthday);
    }

    public String commandSit() {
        return learnOrExecute(CatAnimalCommand.commandSit(this.id));
    }

    public String commandJump() {
        return learnOrExecute(CatAnimalCommand.commandJump(this.id));
    }

    public String commandMeow() {
        return learnOrExecute(CatAnimalCommand.commandMeow(this.id));
    }

    public String commandPounce() {
        return learnOrExecute(CatAnimalCommand.commandPounce(this.id));
    }

    public String commandScratch() {
        return learnOrExecute(CatAnimalCommand.commandScratch(this.id));
    }

}
