import javax.swing.*;
import java.awt.*;
import java.util.function.Consumer;

// mock for testing exception throwing
/**
 * UI for when the human is guessing a number
 *
 */
public class HumanGuessesPanelMock extends JPanel {
    private HumanGuessesGameStub game;

    /**
     * takes no args bcs this is a Mock
     */
    public HumanGuessesPanelMock(){
        game = new HumanGuessesGameStub(""); //ans is 500

//        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
//
//        JPanel promptPanel = new JPanel(new FlowLayout());
//
//        JLabel prompt = new JLabel("Enter your guess:");
//        promptPanel.add(prompt);
//
//        JTextField guessTxt = new JTextField("");
//        promptPanel.add(guessTxt);
//
//        promptPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, guessTxt.getHeight() + 8));
//        this.add(promptPanel);
//
//        this.add(Box.createRigidArea(new Dimension(0,20)));
//
//        JLabel reply = new JLabel("");
//        reply.setMinimumSize(prompt.getSize());
//        this.add(reply);
//        reply.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//        this.add(Box.createRigidArea(new Dimension(0,40)));
//
//        JPanel buttonPanel = new JPanel();
//
//        JButton quit = new JButton("Back to Home");
//        quit.addActionListener(e -> {
            // See itemStateChanged in https://docs.oracle.com/javase/tutorial/uiswing/examples/layout/CardLayoutDemoProject/src/layout/CardLayoutDemo.java
//            CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
//            cardLayout.show(cardsPanel, ScreenID.HOME.name());
//        });
//        buttonPanel.add(quit);
//
//        JButton submit = new JButton("Submit");
//        submit.addActionListener(e -> {
//
//        });
//        buttonPanel.add(submit);
//
//        this.add(Box.createVerticalGlue());
//
//        this.add(buttonPanel);
//        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
//        this.add(Box.createRigidArea(new Dimension(0, 20)));

        //this.addComponentListener(new java.awt.event.ComponentAdapter() {
            //public void componentShown(java.awt.event.ComponentEvent e) {
//                reply.setText("");
//                guessTxt.setText("");
//                guessTxt.requestFocusInWindow();
//                SwingUtilities.getRootPane(submit).setDefaultButton(submit);

//                game = new HumanGuessesGameStub("");
//            }
//        });
    }

    /**
     * takes a string (actual input in the real HumanGuessPanel)
     * and returns whether it is too low, too high, or just right.
     *
     * if input (as a String arg) is bad (not a number that can be parsed), throw a NumberFormatException.
     *
     * @param guessVal
     * @return
     */
    String submitGuess(String guessVal){
        try {
            int GV = Integer.parseInt(guessVal);
            GuessResult res = game.makeGuess(GV);

            if (res == GuessResult.LOW) {
                //.setText(guessVal + " is too low.");
                return "too low";
            } else if (res == GuessResult.HIGH) {
                //reply.setText(guessVal + " is too high.");
                return "too high";
            } else {
                //reply.setText("");

                // Send the result from the game to the callback function
                //GameResult result = new GameResult(true, guessVal, game.getNumGuesses());
                //gameFinishedCallback.accept(result);

                //CardLayout cardLayout = (CardLayout) cardsPanel.getLayout();
                //cardLayout.show(cardsPanel, ScreenID.GAME_OVER.name());
                return "just right";
            }

            //guessTxt.setText("");
            //guessTxt.requestFocusInWindow();
        } catch (NumberFormatException nfe) {
            //reply.setText("Please enter a valid number.");
            throw nfe;
        }
    }

}

