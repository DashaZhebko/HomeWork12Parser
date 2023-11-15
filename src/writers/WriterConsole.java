package writers;

import statistics.Statystics;

public class WriterConsole implements StatisticsWriter {
    /**
     * @param statystics an object of the class Statistics that contains data to output to the console for user
     */
    @Override
    public void writeStatistics(Statystics statystics) {
        System.out.println("Statistics are saved in the file: " + statystics.getFileOutpName());
        System.out.println("Top 10 words: " + statystics.getData());
        System.out.println("Total number of unique words: " + statystics.getUniqueWords());
    }
}
