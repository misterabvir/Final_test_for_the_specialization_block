package v1.application.Services;

import v1.application.base.Service;
import v1.domain.base.Animal;
import v1.domain.pets.Hamster.Hamster;

import java.util.List;
import java.util.Optional;

public class StudyHamsterService extends Service {

    //#region study hamsters
    public List<String> getAvailableHamsterNames() {
        return farm.getHamsters().stream()
                .map(Animal::getName)
                .toList();
    }

    public String educateHamsterCommandHide(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandHide();
            db.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandRoll(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandRoll();
            db.save(farm);
        }
        return output;
    }

    public String educateHamsterCommandSpin(String name) {
        Optional<Hamster> result = farm.getHamsters().stream().filter(animal -> animal.getName().equals(name)).findFirst();
        String output = "";
        if (result.isPresent()) {
            output = result.get().commandSpin();
            db.save(farm);
        }
        return output;
    }
    //#endregion

}
