package v2.ui.menus;

import v2.application.FarmService;
import v2.ui.ConsoleUi;
import v2.ui.base.Menu;
import v2.ui.base.MenuItem;

import java.util.ArrayList;

public class MainMenu extends Menu {

    FarmService service;

    public MainMenu(FarmService service) {

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showAnimals, "Show animals"));
        menuItems.add(new MenuItem(this::studyAnimals, "Study animal"));
        menuItems.add(new MenuItem(this::addEntity, "Add new entity"));
        menuItems.add(new MenuItem(this::quit, "Quit"));
        this.service = service;
    }

    public void showAnimals() {
        ConsoleUi.println(service.getDetails());
    }

    public void studyAnimals() {
        ConsoleUi.println("Select kind name:");
        String kindName = ConsoleUi.getChoose(service.getKindList());

        ConsoleUi.println("Select title name:");
        String titleName = ConsoleUi.getChoose(service.getTitleList(kindName));

        ConsoleUi.println("Enter animal name:");
        String animalName = ConsoleUi.getChoose(service.getAnimalList(titleName));

        ConsoleUi.println("List of learned commands for '" + animalName + "': "
                + service.getLearnedCommandList(animalName).toString());

        ConsoleUi.println("Enter available command:");
        String commandName = ConsoleUi.getChoose(service.getAvailableCommandList(titleName));

        if (service.educate(animalName, commandName)) {
            ConsoleUi.println("Animal '" + animalName + "' was learned new command '" + commandName + "' successful");
        } else {
            ConsoleUi.println("Animal '" + animalName + "' already known command '" + commandName + "'");
        }

        ConsoleUi.println("List of learned commands for '" + animalName + "': "
                + service.getLearnedCommandList(animalName).toString());
    }

    public void addEntity() {
        ConsoleUi.setMenu(new AddNewEntityMenu(service));
    }

    public void quit() {
        ConsoleUi.close();
    }
}
