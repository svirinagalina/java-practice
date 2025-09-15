import java.io.*;
import java.nio.charset.Charset;

public class StreamToString {
    public static String readAsString(InputStream inputStream, Charset charset) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        byte[] data = new byte[1024];
        int bytesRead;
        while ((bytesRead = inputStream.read(data)) != -1) {
            buffer.write(data, 0, bytesRead);
        }
        return new String(buffer.toByteArray(), charset);

    }

}
