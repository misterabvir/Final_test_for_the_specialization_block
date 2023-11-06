package v2.domain.titles;

import v2.domain.base.ValueObject;

import java.util.List;
import java.util.UUID;

public class TitleId extends ValueObject {
    private final UUID value;

    public TitleId(UUID value) {
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
