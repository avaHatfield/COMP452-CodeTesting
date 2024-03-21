import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void constructorCreation(){

        //example member variables
        boolean humanWasPlaying = true;
        int correctValue = 50;
        int numGuesses = 10;

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
        int correctValue = 100;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertTrue(gameResult.humanWasPlaying);
    }

    @Test
    void humanPlayingFalse() {
        boolean humanWasPlaying = false;
        int correctValue = 43;
        int numGuesses = 3;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertFalse(gameResult.humanWasPlaying);
    }

    @Test
    void noGuesses() {
        boolean humanWasPlaying = true;
        int correctValue = 500;
        int numGuesses = 0;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);
        
        assertEquals(0, gameResult.numGuesses);
    }

    // will pass if object not equal to null
    @Test
    public void notEqualsNull() {

        GameResult result = new GameResult(true, 42, 5);

        assertNotEquals(result, null);
    }


}
