import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

class DictTree {

	private static class TrieNode {

		public static final char END_CHAR = '#';
		//private char value;
		private TrieNode[] children = new TrieNode[27];

		public TrieNode() {
		}

//		public TrieNode(char c) {
//			value = c;
//		}

		public boolean add(String suffix) {
			boolean result = false;
			char c = suffix.charAt(0);

			int index = char2Idx(c);
			if (children[index] == null)
				children[index] = new TrieNode();

			if (c != END_CHAR)
				result = children[index].add(suffix.substring(1)) || result;

			return result;
		}

		public static int char2Idx(char c) {
			if (Character.isLetter(c))
				return c - 'A';
			return 26;
		}

		public static char idx2Char(int idx) {
			if (idx == 26)
				return TrieNode.END_CHAR;
			return (char) ('A' + idx);
		}
	}

	private TrieNode root = new TrieNode();

	DictTree(String fileName) throws IOException {
		BufferedReader dictFileReader = new BufferedReader(new FileReader(
				fileName));
		String line = null;
		while ((line = dictFileReader.readLine()) != null) {
			add(line.trim().toUpperCase());
		}
		dictFileReader.close();
	}

	boolean add(String word) {
		return root.add(word + TrieNode.END_CHAR);
	}

	HashMap<Character, Integer> calculateCandidateLetterFrequency(
			HangmanGame game) {

		int level = 0;
		int[] letterFrequency = new int[26];
		char[] candidateWord = new char[game.getSecretWordLength()];

		numCandidateWords = 0;
		lastCandidateWord = null;
		calculateCandidateLetterFrequency(level, root, candidateWord,
				letterFrequency, game);

		HashMap<Character, Integer> letterFrequenceyMap = new HashMap<Character, Integer>();
		for (int i = 0; i < letterFrequency.length; i++) {
			if (letterFrequency[i] != 0)
				letterFrequenceyMap.put(TrieNode.idx2Char(i),
						letterFrequency[i]);
		}

		return letterFrequenceyMap;
	}

	private int numCandidateWords = 0;
	private String lastCandidateWord = null;

	private void calculateCandidateLetterFrequency(int level, TrieNode node,
			char[] candidateWord, int[] letterFrequency, HangmanGame game) {

		if (level == game.getSecretWordLength()) {
			if (node.children[TrieNode.char2Idx('#')] == null)
				return;
			if (game.getIncorrectlyGuessedWords().contains(
					String.valueOf(candidateWord)))
				return;

			numCandidateWords++;
			lastCandidateWord = String.valueOf(candidateWord);
			// HashSet<Character> letterSet = new HashSet<Character>();
			// for(char c: candidateWord){
			// if(!game.getCorrectlyGuessedLetters().contains(c))
			// letterSet.add(c);
			// }
			// for (Character c : letterSet)
			// letterFrequency[TrieNode.char2Idx(c)]++;
			for (char c : candidateWord) {
				if (!game.getCorrectlyGuessedLetters().contains(c))
					letterFrequency[TrieNode.char2Idx(c)]++;
			}
		} else {
			char c = game.getGuessedSoFar().charAt(level);
			if (c != game.MYSTERY_LETTER) {
				TrieNode child = node.children[TrieNode.char2Idx(c)];
				if (child != null) {
					candidateWord[level] = c;
					calculateCandidateLetterFrequency(level + 1, child,
							candidateWord, letterFrequency, game);
					candidateWord[level] = '\0';
				}
			} else {
				for (int i = 0; i < node.children.length; i++) {
					c = TrieNode.idx2Char(i);
					TrieNode child = node.children[i];
					if (child != null
							&& !game.getAllGuessedLetters().contains(c)) {
						candidateWord[level] = c;
						calculateCandidateLetterFrequency(level + 1, child,
								candidateWord, letterFrequency, game);
						candidateWord[level] = '\0';
					}
				}
			}

		}
	}

	int getCandidateWordNumber() {
		return numCandidateWords;
	}

	String getCandidateWord() {
		return lastCandidateWord;
	}

}