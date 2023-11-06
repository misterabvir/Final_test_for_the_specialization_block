package v2.domain.animals;

import v2.domain.base.ValueObject;

import java.util.List;
import java.util.UUID;

public class AnimalId extends ValueObject {

    private final UUID value;

    public AnimalId(UUID value) {
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