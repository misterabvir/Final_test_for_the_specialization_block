package v2.application.factories;

import v2.domain.commands.Command;
import v2.domain.titles.Title;

import java.util.HashSet;
import java.util.Set;

public class CommandFactory {
    public static HashSet<Command> getCommands(Set<Title> titles) {
        HashSet<Command> commands = new HashSet<>();
        fillCommand(new String[]{"Sit", "Stay", "Fetch", "Paw", "Bark", "Roll"},
                commands,
                SearchService.getTitleByName("Dog", titles));
        fillCommand(new String[]{"Sit", "Pounce", "Scratch", "Meow", "Jump"},
                commands,
                SearchService.getTitleByName("Cat", titles));
        fillCommand(new String[]{"Roll", "Hide", "Spin"},
                commands,
                SearchService.getTitleByName("Hamster", titles));
        fillCommand(new String[]{"Trot", "Canter", "Gallop", "Jump"},
                commands,
                SearchService.getTitleByName("Horse", titles));
        fillCommand(new String[]{"Walk", "Carry Load", "Sit", "Run"},
                commands,
                SearchService.getTitleByName("Camel", titles));
        fillCommand(new String[]{"Walk", "Carry Load", "Bray", "Kick"},
                commands,
                SearchService.getTitleByName("Donkey", titles));
        return commands;
    }

    private static void fillCommand(String[] strCommands, HashSet<Command> commands, Title title) {
        for (String strCommand : strCommands) {
            commands.add(Command.create(strCommand, title));
        }
    }

    private CommandFactory() {
    }
}
