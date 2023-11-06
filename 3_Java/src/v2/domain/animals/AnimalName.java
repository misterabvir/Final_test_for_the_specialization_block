package v2.domain.animals;

import v2.domain.base.ValueObject;

import java.util.List;

public class AnimalName extends ValueObject {
    private final String value;

    public AnimalName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    protected List<Object> getFields() {
        return List.of(value);
    }

    @Override
    public String toString(){
        return value;
    }
}