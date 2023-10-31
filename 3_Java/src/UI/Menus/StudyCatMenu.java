package UI.Menus;

import Presenters.StudyCatPresenter;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyCatMenu extends Menu {
    private final StudyCatPresenter presenter = new StudyCatPresenter();

    public StudyCatMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studySit, "Study Sit"));
        menuItems.add(new MenuItem(this::studyPounce, "Study Pounce"));
        menuItems.add(new MenuItem(this::studyScratch, "Study Scratch"));
        menuItems.add(new MenuItem(this::studyMeow, "Study Meow"));
        menuItems.add(new MenuItem(this::studyJump, "Study Jump"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableCatNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any cats for study");
        }
        ConsoleUi.println("Available cats: " + names);
        ConsoleUi.println("Input Name: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyPounce() {
        educate(presenter::learnCommandPounce);
    }

    public void studyScratch() {
        educate(presenter::learnCommandScratch);
    }

    public void studyMeow() {
        educate(presenter::learnCommandMeow);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
