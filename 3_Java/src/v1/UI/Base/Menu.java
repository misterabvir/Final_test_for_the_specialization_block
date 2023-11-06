package v1.ui.base;

import java.util.ArrayList;
import java.util.List;

import v1.presenters.MainPresenter;

public abstract class Menu {

    protected List<MenuItem> menuItems = new ArrayList<>();

    public void execute(int index) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.get(index).execute();
        }
    }

    public String toString() {
        StringBuilder builder = new StringBuilder("\n");
        builder.append(new MainPresenter().getAnimalStatistic()).append("\n");
        int index = 1;
        for (MenuItem command : menuItems) {
            builder.append(index++).append(". ").append(command.toString()).append("\n");
        }
        return builder.toString();
    }

    public int size() {
        return menuItems.size();
    }
}
