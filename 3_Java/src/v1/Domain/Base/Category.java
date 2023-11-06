package v1.domain.base;


public enum Category{
    PETS(1, "Pets"),
    PACK_ANIMALS(2, "Pack Animals");

    private final int id;
    private final String name;
    Category(int id, String name){
        this.id = id;
        this.name = name;
    }

    public static Category getById(int id){
        return switch (id) {
            case 1 -> PETS;
            case 2 -> PACK_ANIMALS;
            default -> throw new IllegalArgumentException("not found");
        };
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }



    @Override
    public String toString() {
        return name;
    }
}
