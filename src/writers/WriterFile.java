package writers;

import statistics.Statystics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriterFile implements StatisticsWriter {
    /**
     * Method for write statistics in a file
     *
     * @param statystics - an object of the class Statistics that contains data to be written to the statistics file
     * @throws IOException when write to file
     */
    @Override
    public void writeStatistics(Statystics statystics) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(statystics.getFileOutpName()))) {
            for (Map.Entry<String, Long> entry : statystics.getData().entrySet()) {
                writer.write(entry.getKey() + " -> " + entry.getValue() + "\n");
            }
            writer.newLine();
            writer.write("Total number of unique words: " + statystics.getUniqueWords());
        }
    }
}
