package v1.ui.menus;

import java.util.ArrayList;

import v1.ui.ConsoleUi;
import v1.ui.base.Menu;
import v1.ui.base.MenuItem;

public class StudyMenu extends Menu {
    public StudyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyDogs, "Study Dogs"));
        menuItems.add(new MenuItem(this::studyCats, "Study Cats"));
        menuItems.add(new MenuItem(this::studyHamsters, "Study Hamsters"));
        menuItems.add(new MenuItem(this::studyHorses, "Study Horses"));
        menuItems.add(new MenuItem(this::studyCamels, "Study Camels"));
        menuItems.add(new MenuItem(this::studyDonkeys, "Study Donkeys"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    public void studyDogs() {
        ConsoleUi.setMenu(new StudyDogMenu());
    }

    public void studyCats() {
        ConsoleUi.setMenu(new StudyCatMenu());
    }

    public void studyHamsters() {
        ConsoleUi.setMenu(new StudyHamsterMenu());
    }

    public void studyHorses() {
        ConsoleUi.setMenu(new StudyHorseMenu());
    }

    public void studyCamels() {
        ConsoleUi.setMenu(new StudyCamelMenu());
    }

    public void studyDonkeys() {
        ConsoleUi.setMenu(new StudyDonkeyMenu());
    }

    public void back() {
        ConsoleUi.setMenu(new MainMenu());
    }
}
