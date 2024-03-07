import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)

public class StateTests {
    // TODO:
    // Build test cases which test each constructor and each class method

    // Test default constructor here
    @Test
    void test_State_defaultWordIntialization()
    {
        //Arrange
        State state = new State();
        //Act --> No action needed
        //Assert
        assertEquals("START", state.getSecretWord());
    }
    @Test
    void test_State_letterMatchStatus()
    {
        //Arrange
        State state = new State();
        //Act --> No action needed
        //Assert
        int [] expectedLetterStatus = {0,0,0,0,0}; //All elements should be equal to 0, i.e. NO_MATCH
        assertArrayEquals(expectedLetterStatus, state.getLetterStatus());
    }
    @Test
    void test_State_secretWordLength() {
        //Arrange
        State state = new State();
        //Act --> No action needed
        //Assert
        assertEquals(5, state.getSecretWord().length());
    }
    // Test State(String) here
    @Test
    void test_StateString_inputSecretWord()
    {
        //Arrange
        String inputWord = "SHARK";
        //Act
        State state = new State(inputWord);
        //Assert
        assertEquals(inputWord, state.getSecretWord());
    }
    @Test
    void test_StateString_inputWordLetterStatus()
    {
        //Arrange
        String inputWord = "SHARK";
        //Act
        State state = new State(inputWord);
        //Assert
        int [] expectedInputWordStatus = {0,0,0,0,0}; //All elements should be equal to 0, i.e. NO_MATCH
        assertArrayEquals(expectedInputWordStatus, state.getLetterStatus());
    }
    @Test
    void test_StateString_inputWordLength()
    {
        //Arrange
        String inputWord = "SHARK";
        //Act
        State state = new State(inputWord);
        //Assert
        assertEquals(5, state.getLetterStatus().length);
    }
    // Test updateState() here

    // Test hasWin() here

    // Test toString here
}
