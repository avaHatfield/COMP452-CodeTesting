
import org.junit.jupiter.api.Test;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class StatsFileTest {

    @Test
    void maxNumGuesses() {
        StatsFile statsFile = new StatsFile();
        assertEquals(17, statsFile.maxNumGuesses());
    }

    @Test
    public void numberFormatExceptionTest() {

        String invalidCsvLine = "2024-03-20T12:00:00,invalid";

        assertThrows(NumberFormatException.class, () -> {

            new StatsFileStub();
            StatsFileStub.input(LocalDateTime.parse(invalidCsvLine));
        });
    }

    @Test
    public void dateTimeExceptionTest() {

        String invalidCsvLine = "2024-03-00:00,invalid";

        assertThrows(DateTimeParseException.class, () -> {

            new StatsFileStub();
            StatsFileStub.input(LocalDateTime.parse(invalidCsvLine));
        });
    }

}
