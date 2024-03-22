import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.function.Consumer;

//no need to test if refactored well

/**
 * UI screen for when the computer is guessing a number
 *
 * Displays the computer's guesses and processes human's answers
 * Tracks the computer's guesses
 *
 * TODO: refactor this class
 */
public class ComputerGuessesPanel extends JPanel {
    ComputerGuessesGame game = new ComputerGuessesGame();

    public ComputerGuessesPanel(JPanel cardsPanel, Consumer<GameResult> gameFinishedCallback){

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
            game.updateGuessLower();
            guessMessage.setText("I guess " + game.getLastGuess() + ".");
        });
        add(lowerBtn);

        JButton correctBtn = createButton("Equal", e -> {
            GameResult result = new GameResult(false, game.getLastGuess(), game.getNumGuesses());
            gameFinishedCallback.accept(result);
            showGameOverScreen(cardsPanel);
        });
        add(correctBtn);

        JButton higherBtn = createButton("Higher", e -> {
            game.updateGuessHigher();
            guessMessage.setText("I guess " + game.getLastGuess() + ".");
        });
        add(higherBtn);

        this.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent e) {
//                numGuesses = 0;
//                upperBound = 1000;
//                lowerBound = 1;
//                lastGuess = (lowerBound + upperBound + 1) / 2;
                ComputerGuessesGame newGame = new ComputerGuessesGame();
                guessMessage.setText("I guess " + newGame.getLastGuess() + ".");
            }
        });
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
