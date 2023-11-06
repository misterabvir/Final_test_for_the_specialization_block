package v1.infrastructure.db;

public interface Db<T> {
    void save(T entity);
    T load();
}
