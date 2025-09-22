package SerializationDeserialization;
import java.io.*;
import java.util.*;

public class Animal implements Serializable {
    private final String name;
    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
    @Override
    public String toString() {
        return "Animal name= " + name;
    }
}
