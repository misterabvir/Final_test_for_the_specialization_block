package Domain.Base;


public enum PetsType implements IAnimalType {
    DOG(1, "Dog"),
    CAT(2, "Cat"),
    HAMSTER(3, "Hamster");

    private final int id;
    private final String name;
    private final Category category;

    PetsType(int id, String name) {
        this.id = id;
        this.name = name;
        this.category = Category.PETS;
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
