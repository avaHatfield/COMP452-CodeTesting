import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HumanGuessesPanelTest {
    @Test
    void inputWordAsGuess(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("hehehe"); });
    }

    @Test
    void inputNumWithWord(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("123fake"); });
    }

    @Test
    void inputEscCode(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("\n\""); });
    }

    @Test
    void inputNumWithEscCode(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("\"123\""); });
    }

    @Test
    void inputNumWithNewline(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("123\n"); });
    }

    @Test
    void inputGoodNumHigh(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock(); //ans is 500
        assertEquals("too high", mockHG.submitGuess("700"));

    }

    @Test
    void inputGoodNumLow(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();//ans is 500
        assertEquals("too low", mockHG.submitGuess("200"));

    }

    @Test
    void inputGoodNumEqual(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("just right", mockHG.submitGuess("500"));
    }

    @Test
    void inputNumOutsideBound(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("too high", mockHG.submitGuess("10000")); //10000 > 1000 (UPPER_BOUND)
    }

    @Test
    void inputNegativeNum(){
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("too low", mockHG.submitGuess("-20"));
    }

    /**
     * should it accept this? should it not? who knows...
     */
    @Test
    void inputNumWithComma(){ //weird if you do this but who knows
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("1,235"); });
    }

}
