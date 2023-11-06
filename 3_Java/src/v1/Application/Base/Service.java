package v1.application.base;

import v1.infrastructure.AnimalFabric;
import v1.infrastructure.Farm;
import v1.infrastructure.db.AnimalDb;
import v1.infrastructure.db.Db;


public abstract class Service {
    protected final Farm farm;
    protected final Db<Farm> db = new AnimalDb();

    protected Service() {
        farm = db.load();
        if (farm.getAllAnimals().isEmpty()) {
            AnimalFabric.fillAnimals(farm.getAllAnimals());
            db.save(farm);
        }
    }
}
