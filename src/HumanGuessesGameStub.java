import java.util.Random;

/**
 * STUB CLASS FOR TESTING
 * DO NOT USE IN PROD
 *
 *
 *
 * A game where a human guesses a number between 1 and UPPER_BOUND
 * Tracks the target, the number of guesses made, and if the number has been guessed
 *
 * NOTE: You can refactor and edit this file if needed
 */
public class HumanGuessesGameStub {
    //public final static int UPPER_BOUND = 1000; // will be upper bound in prod code

    private final int target;
    private int numGuesses;
    private boolean gameIsDone; // true iff makeGuess has been called with the target value

    HumanGuessesGameStub(String testCase){
        //Random randGen = new Random();
        if(testCase.equals("LOW")) { //testing for LOW so set high target value
            this.target = 900;
        }
        else if(testCase.equals("HIGH")){ //testing for HIGH so set low target value
            this.target = 25;
        }
        else{
            this.target = 500;
        }

        numGuesses = 0;
        gameIsDone = false;
    }

    GuessResult makeGuess(int value){
        numGuesses += 1;

        if(value < target){
            return GuessResult.LOW;
        }
        if(value > target){
            return GuessResult.HIGH;
        }

        return GuessResult.CORRECT;
    }

    int getNumGuesses(){
        return numGuesses;
    }

    boolean isDone(){
        return gameIsDone;
    }
}
