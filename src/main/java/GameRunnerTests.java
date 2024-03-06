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
        String toCheck = "begin";
        // Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        // Assert
        assertTrue(test_result, "Used word <begin>. Result should have been true.");
    }
    // TODO: Rewrite using the Arrange/Act/Assert pattern
    @Test
    void test_isGoodInput_tooLong()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "begins";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <begins>. Result should have been true.");
    }
    // TODO: Create a test for a word that is too short. Use the Arrange, Act, Assert pattern
    @Test
    void test_isGoodInput_tooShort()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "star";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <star>. Result should have been false");
    }
    // TODO: Fix this.
    @Test
    void test_isGoodInput_notAlpha()
    {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "beg1n";
        //Act
        boolean test_result = testGameRunner.isGoodInput(toCheck);
        //Assert
        assertFalse(test_result, "Used word <beg1n>. Result should have been false.");
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
        String toCheck = "hello";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertTrue(test_result, "Used word <hello>. Result should have been true");
    }
    @Test
    void test_isEnglishAndFiveLetters_DifferentCases() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "Hello";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertTrue(test_result, "Used word <Hello>. Result should have been true");
    }
    @Test
    void test_isEnglishAndFiveLetters_Invalid() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "gerla";
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertFalse(test_result, "Used word <gerla>. Result should have been false");
    }
    @Test
    void test_isEnglishAndFiveLetters_NonEnglish() {
        //Arrange
        GameRunner testGameRunner = new GameRunner();
        String toCheck = "jolie";//"jolie" means happy in French
        //Act
        boolean test_result = testGameRunner.isEnglishAndFiveLetters(toCheck);
        //Assert
        assertFalse(test_result, "Used word <jolie>. Result should have been false");
    }
}

