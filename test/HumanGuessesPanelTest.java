import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HumanGuessesPanelTest {
    @Test
    void inputWordAsGuess(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("hehehe"); });
    }

    @Test
    void inputNumWithWord(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("123fake"); });
    }

    @Test
    void inputEscCode(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("\n\""); });
    }

    @Test
    void inputNumWithEscCode(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("\"123\""); });
    }

    @Test
    void inputNumWithNewline(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("123\n"); });
    }

    @Test
    void inputGoodNumHigh(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock(); //ans is 500
        assertEquals("too high", mockHG.submitGuess("700"));

    }

    @Test
    void inputGoodNumLow(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();//ans is 500
        assertEquals("too low", mockHG.submitGuess("200"));

    }

    @Test
    void inputGoodNumEqual(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("just right", mockHG.submitGuess("500"));
    }

    @Test
    void inputNumOutsideBound(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("too high", mockHG.submitGuess("10000")); //10000 > 1000 (UPPER_BOUND)
    }

    @Test
    void inputNegativeNum(){
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertEquals("too low", mockHG.submitGuess("-20"));
    }

    /**
     * should it accept this? should it not? who knows...
     */
    @Test
    void inputNumWithComma(){ //weird if you do this but who knows
        //using dependency injection
        HumanGuessesPanelMock mockHG = new HumanGuessesPanelMock();
        assertThrows(NumberFormatException.class, () -> { mockHG.submitGuess("1,235"); });
    }

}
