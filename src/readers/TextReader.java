package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextReader implements Reader {

    /**
     * Method for reading text from text file
     * @param filePath - input file directory
     * @return String text from file
     * @throws IOException
     */
    @Override
    public String read(String filePath) throws IOException {
        StringBuilder text = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                text.append(line).append("\n");
            }
            return text.toString();
        }
    }
}
