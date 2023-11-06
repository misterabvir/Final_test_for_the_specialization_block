package v2.ui.menus;

import java.util.Date;

import java.util.ArrayList;

import v2.application.FarmService;
import v2.ui.ConsoleUi;
import v2.ui.base.Menu;
import v2.ui.base.MenuItem;

public class AddNewEntityMenu extends Menu {
    FarmService service;

    public AddNewEntityMenu(FarmService service) {

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::addNewKind, "Add new kind"));
        menuItems.add(new MenuItem(this::addNewTitle, "Add new title"));
        menuItems.add(new MenuItem(this::addNewAnimal, "Add new animal"));
        menuItems.add(new MenuItem(this::addNewCommand, "Add new command"));
        menuItems.add(new MenuItem(this::back, "back"));
        this.service = service;
    }

    private void addNewKind() {
        ConsoleUi.println("Enter kind name:");
        String kindName = ConsoleUi.getStringInput(3);
        if (service.createNewKind(kindName)) {
            ConsoleUi.println("New kind '" + kindName + "' was created successful");
        } else {
            ConsoleUi.println("New kind '" + kindName + "' was not created");
        }
        ConsoleUi.println("List of kinds: " 
            + service.getKindList().toString());
    }

    private void addNewTitle() {
        ConsoleUi.println("Select kind name:");
        String kindName = ConsoleUi.getChoose(service.getKindList());

        ConsoleUi.println("Enter title name:");
        String titleName = ConsoleUi.getStringInput(3);

        if (service.createNewTitle(titleName, kindName)) {
            ConsoleUi.println("New title '" + titleName + "' was created successful");
        } else {
            ConsoleUi.println("New title '" + titleName + "' was not created");
        }
        ConsoleUi.println("List of titles for '" + kindName + "': " 
            + service.getTitleList(kindName).toString());
    }

    private void addNewAnimal() {
        ConsoleUi.println("Select kind name:");
        String kindName = ConsoleUi.getChoose(service.getKindList());

        ConsoleUi.println("Select title name:");
        String titleName = ConsoleUi.getChoose(service.getTitleList(kindName));

        ConsoleUi.println("Enter animal name:");
        String animalName = ConsoleUi.getStringInput(3);

        ConsoleUi.println("Enter animal birthday(yyyy-mm-dd):");
        Date birthday = ConsoleUi.getDateInput();

        if (service.createNewAnimal(animalName, birthday, titleName)) {
            ConsoleUi.println("New animal '" + animalName + "' was created successful");
        } else {
            ConsoleUi.println("New animal '" + animalName + "' was not created");
        }

        ConsoleUi.println("List of animals: for '" + titleName + "': " 
            + service.getAnimalList(titleName).toString());
    }

    private void addNewCommand() {
        ConsoleUi.println("Select kind name:");
        String kindName = ConsoleUi.getChoose(service.getKindList());

        ConsoleUi.println("Select title name:");
        String titleName = ConsoleUi.getChoose(service.getTitleList(kindName));

        ConsoleUi.println("Enter command name:");
        String commandName = ConsoleUi.getStringInput(3);

        if (service.createNewCommand(commandName, titleName)) {
            ConsoleUi.println("New command '" + commandName + "' was created successful");
        } else {
            ConsoleUi.println("New command '" + commandName + "'' was not created");
        }

        ConsoleUi.println("List of available commands for '" + titleName + "': "
            + service.getAvailableCommandList(titleName).toString());
    }

    private void back() {
        ConsoleUi.setMenu(new MainMenu(service));
    }
}
