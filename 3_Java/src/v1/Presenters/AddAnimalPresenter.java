package v1.presenters;

import java.util.Date;

import v1.application.Services.AddAnimalService;

public class AddAnimalPresenter{

    private final AddAnimalService service = new AddAnimalService();
    public void addDog(String name, Date birthday) {
        service.addDog(name, birthday);
    }

    public void addCat(String name, Date birthday) {
        service.addCat(name, birthday);
    }

    public void addHamster(String name, Date birthday) {
        service.addHamster(name, birthday);
    }

    public void addHorse(String name, Date birthday) {
        service.addHorse(name, birthday);
    }

    public void addCamel(String name, Date birthday) {
        service.addCamel(name, birthday);
    }

    public void addDonkey(String name, Date birthday) {
        service.addDonkey(name, birthday);
    }


}
