package v1.application.Services;

import v1.application.base.Service;
import v1.domain.base.Animal;
import v1.infrastructure.shared.DateService;

public class DetailAnimalService extends Service {

    //#region details
    public String getAnimalDetail() {
        StringBuilder builder = new StringBuilder();
        String format = "\n %-8s | %-10s | %-7s | %-12s | %-20s ";
        builder.append(String.format(format, "NAME", "BIRTHDAY", "TYPE", "CATEGORY", "COMMANDS"));
        builder.append("\n-------------------------------------------------------------------");
        for (Animal animal : farm.getAllAnimals()) {
            builder.append(String.format(format,
                    animal.getName(),
                    DateService.dateToString(animal.getBirthday()),
                    animal.getType().getName(),
                    animal.getType().getCategory().getName(),
                    animal.getLearnedCommands()));
        }

        return builder.toString();
    }

    public String getAnimalStatistic() {
        return String.format("dogs: %d, cats: %d, hamsters: %d, horses: %d, donkeys: %d, camels: %d, total:%d",
                farm.getDogs().size(),
                farm.getCats().size(),
                farm.getHamsters().size(),
                farm.getHorses().size(),
                farm.getCamels().size(),
                farm.getDonkeys().size(),
                farm.getAllAnimals().size());
    }
    //#endregion
}
