import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {


    //pass if constructor works
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


    //pass is humanWasPlaying is true
    @Test
    void humanPlayingTrue(){
        boolean humanWasPlaying = true;
        int correctValue = 42;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertTrue(gameResult.humanWasPlaying);
    }

    //pass is humanWasPlaying is false
    @Test
    void humanPlayingFalse() {
        boolean humanWasPlaying = false;
        int correctValue = 42;
        int numGuesses = 5;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);

        assertFalse(gameResult.humanWasPlaying);
    }


    //pass if there are 0 guesses
    @Test
    void noGuesses() {
        boolean humanWasPlaying = true;
        int correctValue = 42;
        int numGuesses = 0;

        GameResult gameResult = new GameResult(humanWasPlaying, correctValue, numGuesses);
        
        assertEquals(0, gameResult.numGuesses);
    }


}
