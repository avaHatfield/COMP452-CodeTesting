import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {


    //pass if constructor works
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


    //pass is humanWasPlaying is true
    @Test
    void humanPlayingTrue(){
        boolean humanWasPlaying = true;
        int correctValue = 100;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertTrue(gameResult.humanWasPlaying);
    }

    //pass is humanWasPlaying is false
    @Test
    void humanPlayingFalse() {
        boolean humanWasPlaying = false;
        int correctValue = 43;
        int numGuesses = 3;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertFalse(gameResult.humanWasPlaying);
    }


    //pass if there are 0 guesses
    @Test
    void noGuesses() {
        boolean humanWasPlaying = true;
        int correctValue = 500;
        int numGuesses = 0;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);
        
        assertEquals(0, gameResult.numGuesses);
    }


    //test upper bound limits
    @Test
    void largeCorrectValue() {
        boolean humanWasPlaying = true;
        int correctValue = 999;
        int numGuesses = 15;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertEquals(999, gameResult.correctValue);
    }

    //test lower bound limits
    @Test
    void smallCorrectValue() {
        boolean humanWasPlaying = true;
        int correctValue = 1;
        int numGuesses = 1;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertEquals(1, gameResult.correctValue);
    }

    // will pass if object not equal to null
    @Test
    public void notEqualsNull() {

        GameResult result = new GameResult(true, 42, 5);

        assertNotEquals(result, null);
    }



}
