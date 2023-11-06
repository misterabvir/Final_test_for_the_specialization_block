package v2.application;

import v2.application.factories.*;
import v2.application.utils.DateUtils;
import v2.application.utils.StringUtils;
import v2.domain.animals.Animal;
import v2.domain.commands.Command;
import v2.domain.kinds.Kind;
import v2.domain.titles.Title;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

public class FarmService {
    private final HashSet<Kind> kinds;
    private final HashSet<Title> titles;
    private final HashSet<Animal> animals;
    private final HashSet<Command> commands;

    public FarmService() {
        kinds = KindFactory.getKinds();
        titles = TitleFactory.getTitles(kinds);
        animals = AnimalFactory.getAnimals(titles);
        commands = CommandFactory.getCommands(titles);
        educateAnimals();
    }

    private void educateAnimals() {
        educate("Fido", new String[] { "Sit", "Stay", "Fetch" });
        educate("Whiskers", new String[] { "Sit", "Pounce" });
        educate("Hammy", new String[] { "Roll", "Hide" });
        educate("Buddy", new String[] { "Sit", "Paw", "Bark" });
        educate("Smudge", new String[] { "Sit", "Pounce", "Scratch" });
        educate("Peanut", new String[] { "Roll", "Spin" });
        educate("Bella", new String[] { "Sit", "Stay", "Roll" });
        educate("Oliver", new String[] { "Meow", "Scratch", "Jump" });
        educate("Thunder", new String[] { "Trot", "Canter", "Gallop" });
        educate("Sandy", new String[] { "Walk", "Carry Load" });
        educate("Eeyore", new String[] { "Walk", "Carry Load", "Bray" });
        educate("Storm", new String[] { "Trot", "Canter" });
        educate("Dune", new String[] { "Walk", "Sit" });
        educate("Burro", new String[] { "Walk", "Bray", "Kick" });
        educate("Blaze", new String[] { "Trot", "Jump", "Gallop" });
        educate("Sahara", new String[] { "Walk", "Run" });
    }

    public void educate(String animalName, String[] commandNames) {
        for (String commandName : commandNames) {
            educate(animalName, commandName);
        }
    }

    public boolean educate(String animalName, String commandName) {
        Animal animal = SearchService.getAnimalByName(animalName, animals);
        Command command = getAvailableCommandByName(commandName,
                SearchService.getTitleByName(animal.getAnimalTitle(), titles));
        if (animal.addNewCommand(command)) {
            command.addNewAnimal(animal);
            commands.add(command);
            return true;
        }
        return false;
    }

    private Command getAvailableCommandByName(String commandName, Title title) {
        var result = title
                .getAvailableCommands()
                .stream()
                .filter(command -> command.getName().equals(commandName))
                .findFirst();
        if (result.isEmpty())
            throw new IllegalArgumentException();
        return result.get();
    }




    public List<String> getKindList() {
        return kinds.stream().map(Kind::getName).toList();
    }

    public List<String> getTitleList(String kindName) {
        Kind kind = SearchService.getKindByName(kindName, kinds);
        return kind.getExistsTitles().stream().map(Title::getName).toList();
    }

    public List<String> getAnimalList(String titleName) {
        Title title = SearchService.getTitleByName(titleName, titles);
        return title.getExistsAnimals().stream().map(Animal::getName).toList();
    }

    public List<String> getAvailableCommandList(String titleName) {
        Title title = SearchService.getTitleByName(titleName, titles);
        return title.getAvailableCommands().stream().map(Command::getName).toList();
    }

    public List<String> getLearnedCommandList(String animalName) {
        Animal animal = SearchService.getAnimalByName(animalName, animals);
        return animal.getLearnedCommands().stream().map(Command::getName).toList();
    }

    public boolean createNewKind(String kindName) {
        if (SearchService.isExistKindByName(kindName, kinds)) {
            return false;
        }
        kinds.add(Kind.create(kindName));
        return true;
    }

    public boolean createNewTitle(String titleName, String kindName) {
        if (SearchService.isExistTitleByName(titleName, titles) ||
                !SearchService.isExistKindByName(kindName, kinds)) {
            return false;
        }
        titles.add(Title.create(titleName, SearchService.getKindByName(kindName, kinds)));
        return true;
    }

    public boolean createNewAnimal(String animalName, Date birthday, String titleName) {
        if (SearchService.isExistAnimalByName(animalName, animals) ||
                !SearchService.isExistTitleByName(titleName, titles)) {
            return false;
        }
        animals.add(Animal.create(animalName, birthday, SearchService.getTitleByName(titleName, titles)));
        return true;
    }

    public boolean createNewCommand(String commandName, String titleName) {
        if (SearchService.isExistCommandByName(commandName, commands) ||
                !SearchService.isExistTitleByName(titleName, titles)) {
            return false;
        }
        commands.add(Command.create(commandName, SearchService.getTitleByName(titleName, titles)));
        return true;
    }

    public String getStatistic() {
        StringBuilder builder = new StringBuilder();
        for (Title title : titles) {
            builder.append(title.getName()).append("s: ").append(title.getExistsAnimals().size()).append("\n");
        }
        builder.append("Total: ").append(animals.size()).append(" \r\n");
        return builder.toString();
    }

    public String getDetails() {
        StringBuilder builder = new StringBuilder();
        builder.append("   name    |  birthday  |     title     |      kind     | learned commands\r\n");
        builder.append("----------------------------------------------------------------------------\r\n");
        for (Animal animal : animals) {
            builder
                    .append(" ").append(StringUtils.rightPad(animal.getName(), 8)).append(" | ")
                    .append(StringUtils.rightPad(DateUtils.dateToString(animal.getBirthday()), 8)).append(" | ")
                    .append(StringUtils.rightPad(animal.getAnimalTitle(), 8)).append(" | ")
                    .append(StringUtils
                            .rightPad(SearchService.getTitleByName(animal.getAnimalTitle(), titles).getKindName(), 12))
                    .append(" | ")
                    .append(animal.getLearnedCommands().toString()).append("\r\n");
        }
        return builder.toString();
    }
}
