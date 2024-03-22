import java.util.SortedMap;
import java.util.TreeMap;

public class StatsFileStub extends GameStats {
    private SortedMap<Integer, Integer> statsMap;

    // Constructor
    public StatsFileStub() {
        statsMap = new TreeMap<>();
    }

    // Override methods
    @Override
    public int numGames(int numGuesses) {

        return 0;
    }

    @Override
    public int maxNumGuesses() {

        return 0;
    }
}
