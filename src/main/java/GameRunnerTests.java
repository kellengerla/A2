import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import static org.junit.jupiter.api.Assertions.*;
public class GameRunnerTests {
    @Test
    void test_isGoodInput_Basic()
    {
        // Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "BEGIN";
        // Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        // Assert
        assertTrue(test_result, "Used word <BEGIN>. Result should have been true.");
    }
    // TODO: Rewrite using the Arrange/Act/Assert pattern
    @Test
    void test_isGoodInput_tooLong()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "BEGINS";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <BEGINS>. Result should have been true.");
    }
    // TODO: Create a test for a word that is too short. Use the Arrange, Act, Assert pattern
    @Test
    void test_isGoodInput_tooShort()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "STAR";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <STAR>. Result should have been false");
    }
    // TODO: Fix this.
    @Test
    void test_isGoodInput_notAlpha()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "BEG1N";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <BEG1N>. Result should have been false.");
    }
    @Test
    void test_isGoodInput_NULL()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result,"Used word <>. Result should have been false");
    }
    @Test
    void test_isEnglishAndFiveLettersBasic() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "HELLO";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertTrue(test_result, "Used word <HELLO>. Result should have been true");
    }
    @Test
    void test_isEnglishAndFiveLetters_DifferentCases() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "HELLO";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertTrue(test_result, "Used word <HELLO>. Result should have been true");
    }
    @Test
    void test_isEnglishAndFiveLetters_Invalid() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "GERLA";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertFalse(test_result, "Used word <GERLA>. Result should have been true");
    }
    @Test
    void test_isEnglishAndFiveLetters_NonEnglish() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "JOLIE";//"JOLIE" means happy in French
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertFalse(test_result, "Used word <JOLIE>. Result should have been false");
    }
}

