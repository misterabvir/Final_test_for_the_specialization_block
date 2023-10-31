package UI.Menus;

import Presenters.StudyCamelPresenter;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCamelMenu extends Menu {
   private final StudyCamelPresenter presenter = new StudyCamelPresenter();

    public StudyCamelMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Study Walk"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Study CarryLoad"));
        menuItems.add(new MenuItem(this::studySit, "Study Sit"));
        menuItems.add(new MenuItem(this::studyRun, "Study Run"));
        menuItems.add(new MenuItem(this::back, "back"));
    }
    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCamelNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any camel for educate");
        }
        ConsoleUi.println("Available camels: " + names);
        ConsoleUi.println("Input Name: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyWalk() {
        educate(presenter::learnCommandWalk);
    }

    public void studyCarryLoad() {
        educate(presenter::learnCommandCarryLoad);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyRun() {
        educate(presenter::learnCommandRun);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}