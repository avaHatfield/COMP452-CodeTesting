import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ComputerGuessesGameTest {
    @Test
    void initialGuessTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        assertEquals(501, game.getLastGuess());
    }

    @Test
    void guess1HigherTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessHigher();
        assertEquals(751, game.getLastGuess());
    }

    @Test
    void guess1LowerTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessLower();
        //integer division makes 251.5 => 251
        assertEquals(251, game.getLastGuess());
    }

    @Test
    void guessSomeLowerTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessLower(); //251
        game.updateGuessLower(); //126
        game.updateGuessLower(); //64
        assertEquals(64, game.getLastGuess());
    }

    @Test
    void guessSomeHigherTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessHigher(); //751
        game.updateGuessHigher(); //876
        game.updateGuessHigher(); //938
        assertEquals(938, game.getLastGuess());
    }

    @Test
    void guessSomeTimesTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessHigher(); //751
        game.updateGuessLower(); //626
        game.updateGuessLower(); //564
        game.updateGuessLower(); //533
        game.updateGuessHigher(); //549
        assertEquals(549, game.getLastGuess());
    }

    /**
     * THIS TEST FAILS BECAUSE
     * THE ORIGINAL CODE DOES NOT COUNT THE FIRST GUESS THE COMPUTER MAKES
     */
    @Test
    void numGuessesTrackTest(){
        ComputerGuessesGame game = new ComputerGuessesGame();
        game.updateGuessHigher(); //751
        game.updateGuessLower(); //626
        game.updateGuessLower(); //564
        game.updateGuessLower(); //533
        game.updateGuessHigher(); //549
        assertEquals(6, game.getNumGuesses());
    }
}
