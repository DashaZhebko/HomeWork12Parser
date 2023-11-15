package readers;

import java.io.IOException;

public interface Reader {
    String read(String path) throws IOException;
}
