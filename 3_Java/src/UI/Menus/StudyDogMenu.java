package UI.Menus;

import Presenters.StudyDogPresenter;
import UI.ConsoleUi;
import Infrastructure.Shared.IEducable;
import UI.Base.MenuItem;
import UI.Base.Menu;

import java.util.ArrayList;
import java.util.List;

public class StudyDogMenu extends Menu {
    private final StudyDogPresenter presenter = new StudyDogPresenter();

    public StudyDogMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyBark, "Study Bark"));
        menuItems.add(new MenuItem(this::studyFetch, "Study Fetch"));
        menuItems.add(new MenuItem(this::studyRoll, "Study Roll"));
        menuItems.add(new MenuItem(this::studyPaw, "Study Paw"));
        menuItems.add(new MenuItem(this::studySit, "Study Sit"));
        menuItems.add(new MenuItem(this::studyStay, "Study Stay"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableDogNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any dogs for study");
        }
        ConsoleUi.println("Available dogs: " + names);
        ConsoleUi.println("Input Name: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }


    public void studyBark() {
        educate(presenter::learnCommandBark);
    }

    public void studyPaw() {
        educate(presenter::learnCommandPaw);
    }

    public void studyRoll() {
        educate(presenter::learnCommandRoll);
    }

    public void studyFetch() {
        educate(presenter::learnCommandFetch);
    }

    public void studySit() {
        educate(presenter::learnCommandSit);
    }

    public void studyStay() {
        educate(presenter::learnCommandStay);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}
