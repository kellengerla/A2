import java.util.*;

public class State {

    private final String secretWord;
    private final int[] letterStatus;
    private final int WORD_LENGTH = 5;
    private final String DEFAULT_WORD = "START";
    private final int NO_MATCH = 0;
    private final int IN_WORD = 1;
    private final int EXACT_MATCH = 2;
    public State()
    {
         secretWord = DEFAULT_WORD;
         letterStatus = new int[WORD_LENGTH];
         for (int i = 0; i < WORD_LENGTH;i++)
         {
             letterStatus[i] = NO_MATCH;
         }
    }

    /**
     * Allows the secretWord variable to be accessed in the StateTests() class
     * @return secretWord
     */
    public String getSecretWord(){
        return secretWord;
    }
    /**
     * Allows the letterStatus variable to be accessed in the StateTests() class
     * @return letterStatus
     */
    public int [] getLetterStatus(){
        return letterStatus;
    }
    public State(String inputWord)
    {
        secretWord = inputWord;
        letterStatus = new int[WORD_LENGTH];
        for (int i = 0; i < WORD_LENGTH;i++)
        {
            letterStatus[i] = NO_MATCH;
        }
    }
    public void updateState(String newGuess)
    {
        for (int i = 0; i < WORD_LENGTH; i++) {
            if (secretWord.contains(String.valueOf(newGuess.charAt(i)))) {
                letterStatus[i] = IN_WORD;
                if (secretWord.charAt(i) == newGuess.charAt(i))
                    letterStatus[i] = EXACT_MATCH;
            }

        }
    }
    public boolean hasWin()
    {
        boolean winState = true;
        for (int i = 0; i < WORD_LENGTH; i++)
        {
            if (letterStatus[i] < EXACT_MATCH)
                winState = false;
        }
        return winState;
    }

    @Override
    public String toString() {
        return "State{" +
                "secretWord='" + secretWord + '\'' +
                ", letterStatus=" + Arrays.toString(letterStatus) +
                '}';
    }
}
