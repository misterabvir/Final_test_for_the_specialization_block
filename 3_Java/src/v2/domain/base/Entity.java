package v2.domain.base;

public abstract class Entity<T extends ValueObject>{
    protected final T id;
    protected Entity(T id){
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Entity<?> entity &&  entity.id.equals(id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
