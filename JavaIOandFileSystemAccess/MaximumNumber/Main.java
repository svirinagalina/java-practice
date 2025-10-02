package MaximumNumber;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Main {
    public static void main(String[] args) {
        String path = "list.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            Object object = ois.readObject();
            if (object instanceof int[] x) {}
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
