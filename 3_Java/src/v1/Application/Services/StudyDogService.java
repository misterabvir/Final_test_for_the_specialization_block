package v1.application.Services;

import v1.application.base.Service;
import v1.domain.base.Animal;
import v1.domain.pets.Dog.Dog;

import java.util.List;
import java.util.Optional;

public class StudyDogService extends Service {

    //#region study dogs
    public List<String> getAvailableDogNames() {
        return farm.getDogs().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateDogCommandBark(String name) {
        Optional<Dog> animal = farm.getDogs().stream().filter(dog -> dog.getName().equals(name)).findFirst();
        String output = "";
        if (animal.isPresent()) {
            output = animal.get().commandBark();
            db.save(farm);
        }
        return output;
    }

    public String educateDogCommandSit(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSit();
            db.save(farm);
        }
        return output;
    }

    public String educateDogCommandStay(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandStay();
            db.save(farm);
        }
        return output;
    }

    public String educateDogCommandFetch(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandFetch();
            db.save(farm);
        }
        return output;
    }

    public String educateDogCommandPaw(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandPaw();
            db.save(farm);
        }
        return output;
    }

    public String educateDogCommandRoll(String name) {
        Optional<Dog> result = farm.getDogs().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRoll();
            db.save(farm);
        }
        return output;
    }
    //#endregion

}
