package v1.ui.menus;

import v1.infrastructure.shared.IEducable;
import v1.presenters.StudyDonkeyPresenter;
import v1.ui.ConsoleUi;
import v1.ui.base.Menu;
import v1.ui.base.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class StudyDonkeyMenu extends Menu {

    private final StudyDonkeyPresenter presenter = new StudyDonkeyPresenter();

    public StudyDonkeyMenu() {
        menuItems = new ArrayList<>();
        menuItems.add(new MenuItem(this::studyWalk, "Study Walk"));
        menuItems.add(new MenuItem(this::studyCarryLoad, "Study CarryLoad"));
        menuItems.add(new MenuItem(this::studyBray, "Study Bray"));
        menuItems.add(new MenuItem(this::studyKick, "Study Kick"));
        menuItems.add(new MenuItem(this::back, "back"));
    }

    private void educate(IEducable educable) {
        List<String> names = presenter.getAvailableDonkeyNames();
        if (names.isEmpty()) {
            ConsoleUi.println("not found any donkey for educate");
        }
        ConsoleUi.println("Available donkey: " + names);
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

    public void studyBray() {
        educate(presenter::learnCommandBray);
    }

    public void studyKick() {
        educate(presenter::learnCommandKick);
    }

    public void back() {
        ConsoleUi.setMenu(new StudyMenu());
    }
}