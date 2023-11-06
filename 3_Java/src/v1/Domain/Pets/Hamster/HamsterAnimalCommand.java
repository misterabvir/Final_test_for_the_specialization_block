package v1.domain.pets.Hamster;

import java.util.UUID;

import v1.domain.base.AnimalCommand;

public class HamsterAnimalCommand extends AnimalCommand {

    public static final String ROLL = "Roll";
    public static final String HIDE = "Hide";
    public static final String SPIN = "Spin";
    private HamsterAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static HamsterAnimalCommand commandRoll(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, ROLL);
    }

    public static HamsterAnimalCommand commandHide(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, HIDE);
    }

    public static HamsterAnimalCommand commandSpin(UUID animalId){
        return new HamsterAnimalCommand(UUID.randomUUID(), animalId, SPIN);
    }

}
