package v1.application.Services;

import v1.application.base.Service;
import v1.domain.base.Animal;
import v1.domain.packanimals.Camel.Camel;
import v1.domain.packanimals.Donkey.Donkey;
import v1.domain.packanimals.Horse.Horse;
import v1.domain.pets.Cat.Cat;
import v1.domain.pets.Dog.Dog;
import v1.domain.pets.Hamster.Hamster;

import java.util.Date;

public class AddAnimalService extends Service {

    //#region add animals
    public void addCat(String name, Date birthday) {
        addAnimal(Cat.create(name, birthday));
    }

    public void addDog(String name, Date birthday) {
        addAnimal(Dog.create(name, birthday));
    }

    public void addHamster(String name, Date birthday) {
        addAnimal(Hamster.create(name, birthday));
    }

    public void addHorse(String name, Date birthday) {
        addAnimal(Horse.create(name, birthday));
    }

    public void addCamel(String name, Date birthday) {
        addAnimal(Camel.create(name, birthday));
    }

    public void addDonkey(String name, Date birthday) {
        addAnimal(Donkey.create(name, birthday));
    }

    private void addAnimal(Animal animal) {
        farm.addAnimal(animal);
        db.save(farm);
    }
    //#endregion

}
