package Domain.PackAnimals.Camel;

import Domain.Base.AnimalCommand;

import java.util.UUID;

public class CamelAnimalCommand extends AnimalCommand {

    public static final String WALK = "Walk";
    public static final String CARRY_LOAD = "Carry Load";
    public static final String SIT = "Sit";
    public static final String RUN = "Run";

    private CamelAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static CamelAnimalCommand commandWalk(UUID animalId) {
        return new CamelAnimalCommand(UUID.randomUUID(), animalId, WALK);
    }

    public static CamelAnimalCommand commandCarryLoad(UUID animalId) {
        return new CamelAnimalCommand(UUID.randomUUID(), animalId, CARRY_LOAD);
    }

    public static CamelAnimalCommand commandSit(UUID animalId) {
        return new CamelAnimalCommand(UUID.randomUUID(), animalId, SIT);
    }

    public static CamelAnimalCommand commandRun(UUID animalId) {
        return new CamelAnimalCommand(UUID.randomUUID(), animalId, RUN);
    }
}
