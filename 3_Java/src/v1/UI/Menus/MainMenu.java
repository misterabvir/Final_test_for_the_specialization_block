package v1.ui.menus;

import v1.presenters.MainPresenter;
import v1.ui.ConsoleUi;
import v1.ui.base.Menu;
import v1.ui.base.MenuItem;

import java.util.ArrayList;

public class MainMenu extends Menu {

    private final MainPresenter presenter;
    public MainMenu() {
        presenter = new MainPresenter();
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::showAnimals, "Show animals"));
        menuItems.add(new MenuItem(this::addAnimal, "Add new animal"));
        menuItems.add(new MenuItem(this::studyAnimals, "Study animal"));
        menuItems.add(new MenuItem(this::quit, "Quit"));
    }

    public void quit() {
        ConsoleUi.close();
    }

    public void showAnimals() {
        ConsoleUi.println(presenter.getAnimalDetails());
    }

    public void addAnimal() {
        ConsoleUi.setMenu(new AddAnimalMenu());
    }

    public void studyAnimals() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
