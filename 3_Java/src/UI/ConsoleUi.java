package UI;

import Infrastructure.Shared.DateService;
import UI.Base.Menu;
import UI.Menus.MainMenu;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleUi {

    private static final Scanner scanner = new Scanner(System.in);
    private static Menu menu = new MainMenu();
    private static boolean isWork = true;

    public void start() {
        String title = """             
                            ,--,
                     _ ___/ / \\|
                 ,;'( )__, )  ~
                //  //   '--; 
                '   \\     | ^
                     ^    ^
                ✩░▒▓▆▅▃▂▁\uD835\uDC07\uD835\uDC2E\uD835\uDC26\uD835\uDC1A\uD835\uDC27 \uD835\uDC05\uD835\uDC2B\uD835\uDC22\uD835\uDC1E\uD835\uDC27\uD835\uDC1D\uD835\uDC2C▁▂▃▅▆▓▒░✩
                """;
        while (isWork) {
            print(title);
            print(menu.toString());
            menu.execute(getIntInput() - 1);
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

    public static int getIntInput() {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (input.matches("\\d+")) {
                int number = Integer.parseInt(input);
                if (number >= 1 && number <= menu.size()) {
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
                return DateService.stringToDate(input);
            }
        } while (true);
    }

    public static String chooseName(List<String> names) {
        String input;
        do {
            print("> ");
            input = scanner.nextLine();
            if (names.contains(input)) {
                return input;
            }
        } while (true);
    }
}
