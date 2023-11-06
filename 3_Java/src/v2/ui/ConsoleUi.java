package v2.ui;


import v2.application.FarmService;
import v2.application.utils.DateUtils;
import v2.ui.base.Menu;
import v2.ui.menus.MainMenu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUi {

    private ConsoleUi(){}
    private static final FarmService service = new FarmService();
    private static final Scanner scanner = new Scanner(System.in);
    private static Menu menu = new MainMenu(service);
    private static boolean isWork = true;

    public static void start() {
        while (isWork) {
            print("--------------------------------\n");
            print("✩░▒▓▆▅▃▂▁HUMAN FRIENDS▁▂▃▅▆▓▒░✩\n");
            print("--------------------------------\n");
            print(service.getStatistic());
            print(menu.toString());
            menu.execute(getIntInput(menu.size()) - 1);
        }
    }

    public static void close() {
        scanner.close();
        isWork = false;
    }

    public static void setMenu(Menu newMenu) {
        menu = newMenu;
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void print(String message) {
        System.out.print(message);
    }

    public static int getIntInput(int max) {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= max) {
                    return number;
                }
            }
        } while (true);
    }

    public static String getStringInput(int minLength) {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.length() >= minLength) {
                return input;
            }
        } while (true);
    }

    public static Date getDateInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
                return DateUtils.stringToDate(input);
            }
        } while (true);
    }

    public static String getChoose(List<String> list) {
        int index = 1;
        for (String name : list) {
            ConsoleUi.println(index++ + " " + name);
        }
        index = ConsoleUi.getIntInput(index) - 1;
        return list.get(index);
    }
}