package statistics;

import java.util.Map;

public class Statystics {

    private String directory;
    private Map<String, Long> data;
    private long uniqueWords;

    private String fileOutpName;

    public Statystics(String directory, Map<String, Long> data, long uniqueWords) {
        this.directory = directory;
        this.data = data;
        this.uniqueWords = uniqueWords;
        this.fileOutpName = directory + "_statistic.txt";
    }

    public Map<String, Long> getData() {
        return data;
    }

    public long getUniqueWords() {
        return uniqueWords;
    }

    public String getFileOutpName() {
        return fileOutpName;
    }

    public String getDirectory() {
        return directory;
    }
}
