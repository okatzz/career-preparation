import java.io.IOException;
import java.util.HashMap;

public class MyGuessingStrategy implements GuessingStrategy {

	private DictTree dictionary;

	public MyGuessingStrategy() throws IOException {
		dictionary = new DictTree("words.txt");
	}

	public MyGuessingStrategy(String dictFile) throws IOException {
		dictionary = new DictTree(dictFile);
	}

	@Override
	public Guess nextGuess(HangmanGame game) {

		HashMap<Character, Integer> letterFrequency = dictionary
				.calculateCandidateLetterFrequency(game);

		if (dictionary.getCandidateWordNumber() == 1)
			return new GuessWord(dictionary.getCandidateWord());

		Character candidateLetter = null;
		Integer maxFreq = 0;
		for (Character c : letterFrequency.keySet()) {
			Integer freq = letterFrequency.get(c);
			if (freq > maxFreq) {
				maxFreq = freq;
				candidateLetter = c;
			}
		}

		return new GuessLetter(candidateLetter);
	}
	

}
