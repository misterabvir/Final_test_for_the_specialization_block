package v1.ui.menus;

import v1.infrastructure.shared.ICreatable;
import v1.presenters.AddAnimalPresenter;
import v1.ui.ConsoleUi;
import v1.ui.base.Menu;
import v1.ui.base.MenuItem;

import java.util.ArrayList;
import java.util.Date;

public class AddAnimalMenu extends Menu {
    private final AddAnimalPresenter presenter = new AddAnimalPresenter();

    public AddAnimalMenu() {

        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::addDog, "Add new Dog"));
        menuItems.add(new MenuItem(this::addCat, "Add new Cat"));
        menuItems.add(new MenuItem(this::addHamster, "Add new Hamster"));
        menuItems.add(new MenuItem(this::addHorse, "Add new Horse"));
        menuItems.add(new MenuItem(this::addCamel, "Add new Camel"));
        menuItems.add(new MenuItem(this::addDonkey, "Add new Donkey"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    public void back() {
        ConsoleUi.setMenu(new MainMenu());
    }

    private void addAnimal(ICreatable creator) {
        ConsoleUi.println("Input Name: (min length 3 symbols)");
        String name = ConsoleUi.getStringInput(3);
        ConsoleUi.println("Input Birthday: (format: 'YYYY-MM-dd')");
        Date birthday = ConsoleUi.getDateInput();
        creator.invoke(name, birthday);
    }

    public void addCat() {
        addAnimal(presenter::addCat);
    }

    public void addDog() {
        addAnimal(presenter::addDog);
    }

    public void addHamster() {
        addAnimal(presenter::addHamster);
    }

    public void addHorse() {
        addAnimal(presenter::addHorse);
    }

    public void addCamel() {
        addAnimal(presenter::addCamel);
    }

    public void addDonkey() {
        addAnimal(presenter::addDonkey);
    }
}
