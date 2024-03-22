
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {

    @Test
    void maxNumGuesses() {
        StatsFile statsFile = new StatsFile();
        assertEquals(17, statsFile.maxNumGuesses());
    }
    @Test
    void testEmptyFile() throws IOException {
        // Create an empty file
        String emptyFile = "empty-stats.csv";
        FileWriter writer = new FileWriter(emptyFile);
        writer.close();

        StatsFile statsFile = new StatsFile();
        assertEquals(0, statsFile.numGames(5));
        assertEquals(0, statsFile.maxNumGuesses());
    }

}
