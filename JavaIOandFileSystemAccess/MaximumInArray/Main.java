package MaximumInArray;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        String path = "list.ser";
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            @SuppressWarnings("unchecked")
            ArrayList<Integer> list = (ArrayList<Integer>) ois.readObject();

            int max = Collections.max(list);


            System.out.println(max);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }
  }
