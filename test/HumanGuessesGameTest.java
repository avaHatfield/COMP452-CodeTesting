import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HumanGuessesGameTest {

    // pass when guess is too low
    @Test
    void lowGuessTest() {
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("LOW");
        assertEquals(GuessResult.LOW, testHumanGame.makeGuess(10));
    }

    // pass when guess is too high
    @Test
    void highGuessTest() {
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("HIGH");
        assertEquals(GuessResult.HIGH, testHumanGame.makeGuess(850));
    }

    // pass when guess is correct
    @Test
    void correctGuessTest() {
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("");
        assertEquals(GuessResult.CORRECT, testHumanGame.makeGuess(500));
    }

    // should pass even if player guess is outside the Random's UPPER_BOUND
    @Test
    void guessOutOfBounds(){
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("");
        assertEquals(GuessResult.HIGH, testHumanGame.makeGuess(5000)); // upper bound is 1000 and 5000>1000
    }

    // should pass even if player guess is negative
    @Test
    void negativeGuess(){
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("");
        assertEquals(GuessResult.LOW, testHumanGame.makeGuess(-500));
    }

    // checking is numGuesses is tracking properly
    @Test
    void numGuessTracking(){
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("");
        testHumanGame.makeGuess(200);
        testHumanGame.makeGuess(200);
        testHumanGame.makeGuess(200);
        testHumanGame.makeGuess(200);
        assertEquals(4, testHumanGame.getNumGuesses());
    }

    @Test
    void gameDoneTest(){
        //using dependency injection
        HumanGuessesGameStub testHumanGame = new HumanGuessesGameStub("");
        testHumanGame.makeGuess(500); //make guess is called with target value: CORRECT
        assertTrue(testHumanGame.isDone());
    }
}
