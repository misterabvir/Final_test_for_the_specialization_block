package v2.domain.commands;

import v2.domain.base.ValueObject;

import java.util.List;
import java.util.UUID;

public class CommandId  extends ValueObject {
    private final UUID value;

    public CommandId(UUID value) {
        this.value = value;
    }

    public UUID getValue() {
        return value;
    }

    @Override
    protected List<Object> getFields() {
        return List.of(value);
    }
}
