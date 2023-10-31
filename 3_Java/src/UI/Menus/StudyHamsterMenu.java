package UI.Menus;

import Presenters.StudyHamsterPresenter;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyHamsterMenu extends Menu {
    private final StudyHamsterPresenter presenter = new StudyHamsterPresenter();

    public StudyHamsterMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyRoll, "Study Roll"));
        menuItems.add(new MenuItem(this::studyHide, "Study Hide"));
        menuItems.add(new MenuItem(this::studySpin, "Study Spin"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHamsterNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any hamster for study");
        }
        ConsoleUi.println("Available hamsters: " + names);
        ConsoleUi.println("Input Name: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyHide() {
        educate(presenter::learnCommandHide);
    }

    public void studySpin() {
        educate(presenter::learnCommandSpin);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
