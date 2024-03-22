/**
 * New class created to test game logic of the Computer-side of the game
 */
public class ComputerGuessesGame {
    private int numGuesses;
    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    private int lastGuess;

    private void initializeBounds() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
    }

    ComputerGuessesGame(){
        initializeBounds();
        lastGuess = (lowerBound + upperBound + 1) / 2;
    }

    void updateGuessLower() {
        upperBound = Math.min(upperBound, lastGuess);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses++;
    }

    void updateGuessHigher(){
        lowerBound = Math.max(lowerBound, lastGuess + 1);
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses++;
    }

    int getLastGuess(){
        return this.lastGuess;
    }

    int getNumGuesses(){
        return this.numGuesses;
    }
}
