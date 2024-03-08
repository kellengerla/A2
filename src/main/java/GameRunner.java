import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.HashSet;
import java.util.Scanner;

public class GameRunner {
    private final int MAX_TURNS = 6;
    private final int WORD_LENGTH = 5;
    State gameState;
    HashSet<String> validWords;

    public GameRunner()
    {
        // A note: pre-setting the initial capacity of the HashSet to approximately the right size
        // should make populating the HashSet a bit faster.
        validWords = new HashSet<>(5800);
        try
        {
            FileReader fReader = new FileReader("sgb-words.txt");
            BufferedReader bReader = new BufferedReader(fReader);

            String currentLine = null;
            while((currentLine = bReader.readLine()) != null)
            {
                validWords.add(currentLine.strip());
            }
        }
        catch(IOException ioE)
        {
            System.err.println("There seems to be an issue with sgb-words");
        }

    }

    public void playGame()
    {
        int numTurns = 0;
        String guess = "";
        gameState= new State();
        Scanner input = new Scanner(System.in);

        while ((numTurns < MAX_TURNS) && (!gameState.hasWin()))
        {
            System.out.println("Type a six-letter word");
            guess = input.nextLine();
            System.out.println(guess);

            if (!isGoodInput(guess))
            {
                System.out.println("Your input was invalid in some way. " +
                        "Make sure you have a six letter word with only characters from A-Z");
               continue;
            }

            gameState.updateState(guess);
            numTurns++;
        }
        if(gameState.hasWin())
        {
            System.out.println("Wow! You won in " + numTurns  + "guesses. Good work!");
        }

    }

    public boolean isGoodInput(String toCheck)
    {
        boolean isValid = false;

        // a note on logic. If we don't have the right word length,
        // our flag will be false. If we do, it passes.
        // Then we need to check that each letter in the word is actually a legitimate
        // letter.
        // It's easier to do this by setting the flag to false as soon as we find a character
        // which is not a letter. Once we find something, we don't have to check the rest of the word
        // so we'll stop to be more efficient.
        if (toCheck.length() == WORD_LENGTH)
        {
            isValid = true;
            for (Character letter:toCheck.toCharArray())
            {
                if (!Character.isLetter(letter)) {
                    isValid = false;
                    break;
                }
            }
        }
        return isValid;
    }

    /**
     * Checks if a user-inputted word, whether that be the secret word or a guessed word, is an English word and is five letters long
     * @param toCheck The string that is checked to see if it is an English word and is five letters long
     * @return inputWord if the user-inputted word is in fact an English word and five letters long
     */
    public boolean isEnglishAndFiveLetters(String toCheck) {
        if (toCheck == null || toCheck.length() != 5) {
            return false;
        }
        String inputWord = toCheck.toLowerCase();
        return validWords.contains(inputWord);
    }
}
