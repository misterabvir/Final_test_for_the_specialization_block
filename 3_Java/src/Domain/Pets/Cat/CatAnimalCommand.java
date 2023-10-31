package Domain.Pets.Cat;

import Domain.Base.AnimalCommand;

import java.util.UUID;

public class CatAnimalCommand extends AnimalCommand {
    public static final String SIT = "Sit";
    public static final String POUNCE = "Pounce";
    public static final String SCRATCH = "Scratch";
    public static final String JUMP = "Jump";
    public static final String MEOW = "Meow";

    private CatAnimalCommand(UUID id, UUID animalId, String title) {
        super(id, animalId, title);
    }

    public static CatAnimalCommand commandSit(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, SIT);
    }

    public static CatAnimalCommand commandPounce(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, POUNCE);
    }

    public static CatAnimalCommand commandScratch(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, SCRATCH);
    }

    public static CatAnimalCommand commandMeow(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, MEOW);
    }

    public static CatAnimalCommand commandJump(UUID animalId){
        return new CatAnimalCommand(UUID.randomUUID(), animalId, JUMP);
    }
}
