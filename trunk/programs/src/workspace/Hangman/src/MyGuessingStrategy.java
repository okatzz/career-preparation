import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

/**
 * A strategy to generate the next guess for Hangman game. It maintains a dictionary for reference, which is, in this implementation, stored in a trie
 * tree data structure for fast lookup and space saving. For each guess, it exploits all available information based on current game state to generate
 * a list of candidate words by examining the dictionary. If the candidate list contains only one word, then that word is the final word guess.
 * Otherwise, it returns the most probable letter, which is the letter that has the maximum occurrence in the list of candidate words, as the next
 * letter guess.
 * 
 * @author Ge Gao
 * 
 * 
 */
public class MyGuessingStrategy implements GuessingStrategy {

	private DictTree dictionary; // Abstraction of the dictionary used by my guessing strategy

	public MyGuessingStrategy() throws IOException {
		this("words.txt");
	}

	public MyGuessingStrategy(String dictFile) throws IOException {

		dictionary = new DictTree();

		// Read in words from dictionary file and populate the dictionary structure
		BufferedReader dictFileReader = null;
		try {
			dictFileReader = new BufferedReader(new FileReader(dictFile));
			String line = null;
			while ((line = dictFileReader.readLine()) != null) {
				dictionary.add(line.trim().toUpperCase());
			}
		} catch (FileNotFoundException e) {
			System.err.println("Unable to find dictionary file!");
			throw e;
		} catch (IOException e) {
			System.err.println("Dictionary file reading failure!");
			throw e;
		} finally {
			if (dictFileReader != null)
				dictFileReader.close();
		}

	}

	/**
	 * Generate the next strategy guess based on current Hangman game state
	 */
	@Override
	public Guess nextGuess(HangmanGame game) {

		// With the current game state, look up dictionary for a list of candidate words
		ArrayList<String> candidateWordList = dictionary.getCandidateWords(game);

		// Not able to find a word in the dictionary matching the known secret word pattern
		if (candidateWordList.isEmpty()) {
			System.err.println("No word in the dictionary matches the given secret word!");
			throw new IllegalArgumentException();
		}

		// If there is only one possible word given current game state, return that word as the next/final guess word
		if (candidateWordList.size() == 1) {
			String candidateWord = candidateWordList.get(0);
			return new GuessWord(candidateWord);
		}
		// Return the letter with the highest probability to be in the secrete word as the next guess letter.
		else {
			Character candidateLetter = getMaxOccurrenceCandidateLetter(candidateWordList, game.getCorrectlyGuessedLetters());
			return new GuessLetter(candidateLetter);
		}
	}

	/**
	 * Return the letter that occurs most frequently in the given word list but not in the given excluded letter set
	 * 
	 * @param wordList
	 * @param excludedLetters
	 * @return The maximum occurrence letter
	 */
	private Character getMaxOccurrenceCandidateLetter(ArrayList<String> wordList, Set<Character> excludedLetters) {

		int[] letterOccurrence = new int[26];
		for (String word : wordList) {
			for (int i = 0; i < word.length(); i++) {
				char C = Character.toUpperCase(word.charAt(i));
				if (!excludedLetters.contains(C))
					letterOccurrence[C - 'A']++;
			}
		}

		int maxCount = 0;
		Character maxLetter = null;
		for (int i = 0; i < letterOccurrence.length; i++) {
			if (letterOccurrence[i] >= maxCount) {
				maxLetter = new Character((char) (i + 'A'));
				maxCount = letterOccurrence[i];
			}
		}
		return maxLetter;
	}

}
