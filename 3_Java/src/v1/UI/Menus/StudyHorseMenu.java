package v1.ui.menus;

import v1.infrastructure.shared.IEducable;
import v1.presenters.StudyHorsePresenter;
import v1.ui.ConsoleUi;
import v1.ui.base.Menu;
import v1.ui.base.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StudyHorseMenu extends Menu {

    private final StudyHorsePresenter presenter = new StudyHorsePresenter();

    public StudyHorseMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyTrot, "Study Trot"));
        menuItems.add(new MenuItem(this::studyCanter, "Study Canter"));
        menuItems.add(new MenuItem(this::studyGallop, "Study Gallop"));
        menuItems.add(new MenuItem(this::studyJump, "Study Jump"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableHorseNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any horse for educate");
        }
        ConsoleUi.println("Available horses: " + names);
        ConsoleUi.println("Input Name: ");
        String name = ConsoleUi.chooseName(names);
        ConsoleUi.println(educable.invoke(name));
    }

    public void studyTrot() {
        educate(presenter::learnCommandTrot);
    }

    public void studyCanter() {
        educate(presenter::learnCommandCanter);
    }

    public void studyJump() {
        educate(presenter::learnCommandJump);
    }

    public void studyGallop() {
        educate(presenter::learnCommandGallop);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}