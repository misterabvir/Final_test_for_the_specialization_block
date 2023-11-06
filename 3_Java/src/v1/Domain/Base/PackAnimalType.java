package v1.domain.base;

public enum PackAnimalType implements IAnimalType {
    HORSE(4, "Horse"),
    CAMEL(5, "Camel"),
    DONKEY(6, "Donkey");

    private final int id;
    private final String name;
    private final Category category;

    PackAnimalType(int id, String name) {
        this.id = id;
        this.name = name;
        this.category = Category.PACK_ANIMALS;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return name;
    }
}
