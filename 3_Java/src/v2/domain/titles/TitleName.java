package v2.domain.titles;

import v2.domain.base.ValueObject;

import java.util.List;

public class TitleName extends ValueObject {
    private final String value;

    public TitleName(String value) {
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
