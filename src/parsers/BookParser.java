package parsers;

import analyzers.Analyzer;
import readers.TextReader;
import statistics.Statystics;
import writers.WriterConsole;
import writers.WriterFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookParser {
    private TextReader textReader;
    private Analyzer analyzer;
    private WriterFile writerFile;
    private WriterConsole writerConsole;

    public BookParser() {
        this.textReader = new TextReader();
        this.analyzer = new Analyzer();
        this.writerFile = new WriterFile();
        this.writerConsole = new WriterConsole();
    }

    /**
     * Method for parsing text
     * @param filePath - input file directory
     * @throws IOException when write to file or read from file
     */
    public void parseBook(String filePath) throws IOException {
        String bookText = this.textReader.read(filePath);
        List<String> words = this.analyzer.getWords(bookText);
        words = this.analyzer.filterWords(words);
        Map<String, Long> topTenWords = this.analyzer.getTopWords(words);

        Statystics statystics = new Statystics(filePath, topTenWords, words.size());

        this.writerFile.writeStatistics(statystics);
        this.writerConsole.writeStatistics(statystics);
    }
}
