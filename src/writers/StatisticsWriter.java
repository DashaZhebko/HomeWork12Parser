package writers;

import statistics.Statystics;

import java.io.IOException;

public interface StatisticsWriter{
    void writeStatistics(Statystics statystics) throws IOException;
}
