package v1.infrastructure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import v1.domain.base.Animal;
import v1.domain.packanimals.Camel.Camel;
import v1.domain.packanimals.Donkey.Donkey;
import v1.domain.packanimals.Horse.Horse;
import v1.domain.pets.Cat.Cat;
import v1.domain.pets.Dog.Dog;
import v1.domain.pets.Hamster.Hamster;


public class Farm implements Serializable {
    private final List<Animal> animals;


    public Farm(){
        animals = new ArrayList<>();
    }
    public List<Animal> getAllAnimals() {
        return animals;
    }

    public List<Cat> getCats() {
        return animals.stream()
                .filter(Cat.class::isInstance)
                .map(Cat.class::cast)
                .toList();
    }

    public List<Dog> getDogs() {
        return animals.stream()
                .filter(Dog.class::isInstance)
                .map(Dog.class::cast)
                .toList();
    }

    public List<Hamster> getHamsters() {
        return animals.stream()
                .filter(Hamster.class::isInstance)
                .map(Hamster.class::cast)
                .toList();
    }

    public List<Horse> getHorses() {
        return animals.stream()
                .filter(Horse.class::isInstance)
                .map(Horse.class::cast)
                .toList();
    }

    public List<Camel> getCamels() {
        return animals.stream()
                .filter(Camel.class::isInstance)
                .map(Camel.class::cast)
                .toList();
    }

    public List<Donkey> getDonkeys() {
        return animals.stream()
                .filter(Donkey.class::isInstance)
                .map(Donkey.class::cast)
                .toList();
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
}

