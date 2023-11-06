package v1.infrastructure.db;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import v1.infrastructure.Farm;

public class AnimalDb implements Db<Farm> {

    private static final String PATH = "animals.bin";

    @Override
    public void save(Farm entity) {
        try (FileOutputStream fos = new FileOutputStream(PATH);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(entity);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Farm load() {
        try (FileInputStream fis = new FileInputStream(PATH);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            return (Farm) ois.readObject();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new Farm();
        }
    }
}
