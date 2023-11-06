package v2.application.factories;

import v2.application.utils.DateUtils;
import v2.domain.animals.Animal;
import v2.domain.titles.Title;

import java.util.HashSet;
import java.util.Set;

public class AnimalFactory {
    public static HashSet<Animal> getAnimals(Set<Title> titles) {
        HashSet<Animal> animals = new HashSet<>();
        animals.add(Animal.create("Fido", DateUtils.stringToDate("2020-01-01"), SearchService.getTitleByName("Dog", titles)));
        animals.add(Animal.create("Buddy", DateUtils.stringToDate("2019-05-15"), SearchService.getTitleByName("Dog", titles)));
        animals.add(Animal.create("Bella", DateUtils.stringToDate("2021-03-10"), SearchService.getTitleByName("Dog", titles)));
        animals.add(Animal.create("Whiskers", DateUtils.stringToDate("2018-12-10"), SearchService.getTitleByName("Cat", titles)));
        animals.add(Animal.create("Smudge", DateUtils.stringToDate("2020-02-20"), SearchService.getTitleByName("Cat", titles)));
        animals.add(Animal.create("Oliver", DateUtils.stringToDate("2021-08-01"), SearchService.getTitleByName("Cat", titles)));
        animals.add(Animal.create("Hammy", DateUtils.stringToDate("2019-11-11"), SearchService.getTitleByName("Hamster", titles)));
        animals.add(Animal.create("Peanut", DateUtils.stringToDate("2020-06-30"), SearchService.getTitleByName("Hamster", titles)));
        animals.add(Animal.create("Thunder", DateUtils.stringToDate("2015-07-21"), SearchService.getTitleByName("Horse", titles)));
        animals.add(Animal.create("Storm", DateUtils.stringToDate("2016-11-03"), SearchService.getTitleByName("Horse", titles)));
        animals.add(Animal.create("Blaze", DateUtils.stringToDate("2017-09-18"), SearchService.getTitleByName("Horse", titles)));
        animals.add(Animal.create("Sandy", DateUtils.stringToDate("2014-05-05"), SearchService.getTitleByName("Camel", titles)));
        animals.add(Animal.create("Dune", DateUtils.stringToDate("2018-12-12"), SearchService.getTitleByName("Camel", titles)));
        animals.add(Animal.create("Sahara", DateUtils.stringToDate("2019-01-23"), SearchService.getTitleByName("Camel", titles)));
        animals.add(Animal.create("Eeyore", DateUtils.stringToDate("2016-02-29"), SearchService.getTitleByName("Donkey", titles)));
        animals.add(Animal.create("Burro", DateUtils.stringToDate("2015-08-14"), SearchService.getTitleByName("Donkey", titles)));
        return animals;
    }

    private AnimalFactory() {
    }
}
