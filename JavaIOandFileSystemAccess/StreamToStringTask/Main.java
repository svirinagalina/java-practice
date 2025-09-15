import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class Main {
    public static void main(String[] args)  throws Exception {
    byte[] testData = {48, 49, 50, 51}; // 0 1 2 3
    InputStream input = new ByteArrayInputStream(testData);
    String result = StreamToString.readAsString(input, java.nio.charset.StandardCharsets.US_ASCII);
        System.out.println(result); // выведет "0123"
    }
}
