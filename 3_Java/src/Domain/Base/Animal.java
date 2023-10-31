package Domain.Base;

import java.io.Serializable;
import java.util.*;

public abstract class Animal implements Serializable {
    protected final UUID id;
    protected final String name;
    protected final IAnimalType type;
    protected final Date birthday;

    protected final List<AnimalCommand> commands;

    protected Animal(UUID id, String name, IAnimalType type, Date birthday) {
        commands = new ArrayList<>();
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthday = birthday;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public IAnimalType getType() {
        return type;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getLearnedCommands(){
        return commands.stream().map(AnimalCommand::getTitle).toList().toString();
    }

    protected String learnOrExecute(AnimalCommand command){
        if (isCommandLearned(command.getTitle())) {
            return "The '" + command.getTitle() + "' command was successfully made";
        } else {
            commands.add(command);
            return "The '" + command.getTitle() + "' command was successfully learned";
        }
    }

    private boolean isCommandLearned(String title) {
        return commands.stream().anyMatch(command -> Objects.equals(command.getTitle(), title));
    }
}
