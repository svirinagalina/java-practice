package SerializationDeserialization;

import java.io.*;
import java.util.*;

public class Main {

    public static Animal[] deserializeAnimals(byte[] data) {
        try (ObjectInputStream in = new ObjectInputStream(new ByteArrayInputStream(data))) {
            int size = in.readInt();
            Animal[] animals = new Animal[size];

            for (int i = 0; i < size; i++) {
                Object obj = in.readObject();
                if (!(obj instanceof Animal)) {
                    throw new IllegalArgumentException("Not an Animal at index " + i);
                }
                animals[i] = (Animal) obj;
            }
            return animals;

        } catch (ClassNotFoundException | ClassCastException | IOException e) {
            throw new IllegalArgumentException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        try (ObjectOutputStream out = new ObjectOutputStream(bout)) {
            out.writeInt(2);
            out.writeObject(new Animal("Dog"));
            out.writeObject(new Animal("Cat"));
        }
        byte[] bytes = bout.toByteArray();

        Animal[] animals = Main.deserializeAnimals(bytes);
        System.out.println(Arrays.toString(animals));
    }
}
