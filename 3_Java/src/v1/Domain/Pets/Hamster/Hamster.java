package v1.domain.pets.Hamster;

import java.util.Date;
import java.util.UUID;

import v1.domain.base.Animal;
import v1.domain.base.PetsType;

public class Hamster extends Animal {
    protected Hamster(String name, Date birthday) {
        super(UUID.randomUUID(), name, PetsType.HAMSTER, birthday);
    }

    public static Hamster create(String name, Date birthday){
        return new Hamster(name, birthday);
    }

    public String commandRoll() {
        return learnOrExecute(HamsterAnimalCommand.commandRoll(this.id));
    }

    public String commandHide() {
        return learnOrExecute(HamsterAnimalCommand.commandHide(this.id));
    }

    public String commandSpin() {
        return learnOrExecute(HamsterAnimalCommand.commandSpin(this.id));
    }
}
