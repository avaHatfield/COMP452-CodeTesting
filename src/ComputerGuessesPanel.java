import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class
 */
public class ComputerGuessesPanel extends JPanel {

    private int numGuesses;
    private int lastGuess;

    // upperBound and lowerBound track the computer's knowledge about the correct number
    // They are updated after each guess is made
    private int upperBound; // correct number is <= upperBound
    private int lowerBound; // correct number is >= lowerBound

    private void initializeBounds() {
        numGuesses = 0;
        upperBound = 1000;
        lowerBound = 1;
    }

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){

        initializeBounds();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        JLabel guessMessage = new JLabel("I guess ___.");
        guessMessage.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(guessMessage);
        guessMessage.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.add(Box.createRigidArea(new Dimension(0, 40)));

        JLabel prompt = new JLabel("Your number is...");
        this.add(prompt);
        prompt.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(Box.createRigidArea(new Dimension(0,10)));

        JButton lowerBtn = createButton("Lower", e -> {
            upperBound = Math.min(upperBound, lastGuess);
            updateGuess(guessMessage);
        });
        add(lowerBtn);

        JButton correctBtn = createButton("Equal", e -> {
            GameResult result = new GameResult(false, lastGuess, numGuesses);
            gameFinishedCallback.accept(result);
            showGameOverScreen(cardsPanel);
        });
        add(correctBtn);

        JButton higherBtn = createButton("Higher", e -> {
            lowerBound = Math.max(lowerBound, lastGuess + 1);
            updateGuess(guessMessage);
        });
        add(higherBtn);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
                numGuesses = 0;
                upperBound = 1000;
                lowerBound = 1;
                lastGuess = (lowerBound + upperBound + 1) / 2;
                guessMessage.setText("I guess " + lastGuess + ".");
            }
        });
    }

    //message needs to be updated frequently
    private void updateGuess(JLabel guessMessage) {
        lastGuess = (lowerBound + upperBound + 1) / 2;
        numGuesses++;
        guessMessage.setText("I guess " + lastGuess + ".");
    }

    //creating button was repetive code
    //method that takes in String and ActionEvent
    private JButton createButton(String text, Consumer<ActionEvent> action) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(e -> action.accept(e));
        return button;
    }

    //new screen so this its own method
    private void showGameOverScreen(JPanel cardsPanel) {
        CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
        cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
    }
}
