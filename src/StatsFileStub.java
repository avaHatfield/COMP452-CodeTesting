import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.SortedMap;
import java.util.TreeMap;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;


public class StatsFileStub extends StatsFile {
    private static SortedMap<Integer, Integer> statsMap;
    LocalDateTime limit;

    // Constructor
    public StatsFileStub() {
        statsMap = new TreeMap<>();

    }

    public static void input(LocalDateTime timestamp) {
        LocalDateTime limit  = LocalDateTime.now().minusDays(30);
        try (CSVReader csvReader = new CSVReader(new FileReader(FILENAME))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {

                try {
                    timestamp = LocalDateTime.parse(values[0]);
                    int numGuesses = Integer.parseInt(values[1]);

                    if (timestamp.isAfter(limit)) {
                        statsMap.put(numGuesses, 1 + statsMap.getOrDefault(numGuesses, 0));
                    }
                } catch (NumberFormatException nfe) {

                    throw nfe;
                } catch (DateTimeParseException dtpe) {

                    throw dtpe;
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
