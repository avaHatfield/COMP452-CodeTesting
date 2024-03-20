import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void constructorCreation(){

        //example member variables
        boolean humanWasPlaying = true;
        int correctValue = 42;
        int numGuesses = 5;

        //create instance
        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        //assert
        assertEquals(humanWasPlaying, gameResult.humanWasPlaying);
        assertEquals(correctValue, gameResult.correctValue);
        assertEquals(numGuesses, gameResult.numGuesses);
    }

    @Test
    void humanPlayingTrue(){
        boolean humanWasPlaying = true;
        int correctValue = 42;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertTrue(gameResult.humanWasPlaying);
    }

    @Test
    void humanPlayingFalse() {
        boolean humanWasPlaying = false;
        int correctValue = 42;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertFalse(gameResult.humanWasPlaying);
    }

    @Test
    void noGuesses() {
        boolean humanWasPlaying = true;
        int correctValue = 42;
        int numGuesses = 0;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);
        
        assertEquals(0, gameResult.numGuesses);
    }


}
