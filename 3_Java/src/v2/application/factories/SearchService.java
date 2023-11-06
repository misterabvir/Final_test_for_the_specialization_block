package v2.application.factories;

import v2.domain.animals.Animal;
import v2.domain.commands.Command;
import v2.domain.kinds.Kind;
import v2.domain.titles.Title;

import java.util.Set;

public class SearchService {
    public static Title getTitleByName(String name, Set<Title> titles) {
        var result = titles.stream().filter(title -> title.getName().equals(name)).findFirst();
        if (result.isEmpty()) throw new IllegalArgumentException();
        return result.get();
    }

    public static Kind getKindByName(String name, Set<Kind> kinds) {
        var result = kinds.stream().filter(kind -> kind.getName().equals(name)).findFirst();
        if (result.isEmpty()) throw new IllegalArgumentException();
        return result.get();
    }

    public static Animal getAnimalByName(String name, Set<Animal> animals) {
        var result = animals.stream().filter(title -> title.getName().equals(name)).findFirst();
        if (result.isEmpty()) throw new IllegalArgumentException();
        return result.get();
    }

    public static boolean isExistKindByName(String name, Set<Kind> kinds) {
        var result = kinds.stream().filter(kind -> kind.getName().equals(name)).findFirst();
        return result.isPresent();
    }

    public static boolean isExistTitleByName(String name, Set<Title> titles) {
        var result = titles.stream().filter(title -> title.getName().equals(name)).findFirst();
        return result.isPresent();
    }
    public static boolean isExistAnimalByName(String name, Set<Animal> animals) {
        var result = animals.stream().filter(title -> title.getName().equals(name)).findFirst();
        return result.isPresent();
    }


    private SearchService() {
    }

    public static boolean isExistCommandByName(String commandName, Set<Command> commands) {
        var result = commands.stream().filter(title -> title.getName().equals(commandName)).findFirst();
        return result.isPresent();
    }
}
