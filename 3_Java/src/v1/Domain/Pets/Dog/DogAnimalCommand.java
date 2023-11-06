package v1.domain.pets.Dog;



import java.util.UUID;

import v1.domain.base.AnimalCommand;

public class DogAnimalCommand extends AnimalCommand {

    public static final String SIT = "Sit";
    public static final String STAY = "Stay";
    public static final String FETCH = "Fetch";
    public static final String PAW = "Paw";
    public static final String BARK = "Bark";
    public static final String ROLL = "Roll";

    private DogAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static DogAnimalCommand commandSit(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, SIT);
    }

    public static DogAnimalCommand commandStay(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, STAY);
    }

    public static DogAnimalCommand commandFetch(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, FETCH);
    }

    public static DogAnimalCommand commandPaw(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, PAW);
    }

    public static DogAnimalCommand commandBark(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, BARK);
    }
    public static DogAnimalCommand commandRoll(UUID animalId){
        return new DogAnimalCommand(UUID.randomUUID(), animalId, ROLL);
    }
}
