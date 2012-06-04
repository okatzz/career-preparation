import java.util.ArrayList;

/**
 * Implementation of a trie tree to hold the dictionary words. Each node and its position in the tree represents a letter in a word. Next letter is
 * used to index the node branch array. Each word in the tree ends with the symbol "#", in order to differentiate between a complete word a prefix of
 * a word. Nodes get created only when necessary to make the tree compact.
 * 
 * @author Ge Gao
 */
class DictTree {

	/**
	 * Represents each node in the trie tree.
	 * 
	 */
	private static class TrieNode {

		public static final char END_CHAR = '#'; // The ending word character
		private TrieNode[] children = new TrieNode[27]; // The branch array of the node. English alphabet plus the ending character "#" is the index
														// into the array.

		public TrieNode() {
		}

		/**
		 * Add the given suffix to the right subtree of this node (create if necessary)
		 */
		public boolean add(String suffix) {
			boolean result = false;
			char c = suffix.charAt(0);

			int index = char2Idx(c);
			// create a child node when necessary to represent the starting letter
			if (children[index] == null)
				children[index] = new TrieNode();

			// If not end of the word, add recursively the rest of the suffix to the corresponding subtree of the child node
			if (c != END_CHAR)
				result = children[index].add(suffix.substring(1)) || result;

			return result;
		}

		/**
		 * Convert character to branch array index
		 */
		public static int char2Idx(char c) {
			if (Character.isLetter(c))
				return c - 'A';
			else if (c == '#')
				return 26;
			else {
				System.err.println("Illegal format!");
				throw new IllegalArgumentException();
			}
		}

		/**
		 * Convert branch array idex to character
		 */
		public static char idx2Char(int idx) {
			if (idx == 26)
				return TrieNode.END_CHAR;
			if (idx >= 0 && idx < 26)
				return (char) ('A' + idx);
			System.err.println("Illegal argument!");
			throw new IllegalArgumentException();
		}
	}

	private TrieNode root; // The trie tree root

	DictTree() {
		root = new TrieNode();
	}

	/**
	 * Add the given word, to which the end character "#" is attached, into the tree
	 */
	boolean add(String word) {
		return root.add(word + TrieNode.END_CHAR);
	}

	/**
	 * Implement candidate word generation. Search the dictionary tree recursively to get a list of candidate words based on available information
	 * from the current game state. The available information includes: (1) the secrete word length; (2) the correctly guessed letters and their
	 * positions in the secrete word; (3) the incorrectly guessed letters; (4) the incorrectly guessed words
	 * 
	 * @param game
	 *            The Hangman game
	 * @return The list of candidate words that match the current guessed secrete word pattern of the given game
	 */
	ArrayList<String> getCandidateWords(HangmanGame game) {

		int level = 0; // The current tree visiting level
		char[] candidateWord = new char[game.getSecretWordLength()]; // Caching words during tree visiting
		ArrayList<String> candidateWordList = new ArrayList<String>(); // The list of candidate words to be returned

		computeCandiateWords(level, root, candidateWord, candidateWordList, game);

		return candidateWordList;
	}

	private void computeCandiateWords(int level, TrieNode node, char[] candidateWord, ArrayList<String> candidateWordList, HangmanGame game) {

		// If having visited the tree deep enough for the secrete word search
		if (level == game.getSecretWordLength()) {
			// If no word ends at this node, go back to its parent
			if (node.children[TrieNode.char2Idx('#')] == null)
				return;
			// Else if having found a word but is known to be incorrect guess, go back to its parent
			if (game.getIncorrectlyGuessedWords().contains(String.valueOf(candidateWord)))
				return;
			// Else if having found a possibly correctly guessed word, add it to the candidate word list
			candidateWordList.add(String.valueOf(candidateWord));
			// Else if in the middle of candidate word search
		} else {
			char c = game.getGuessedSoFar().charAt(level);
			// If the letter at current corresponding position of the secrete word has been correctly guessed, follow the branch to the child node
			// that represents the letter and recurse to the next level
			if (c != game.MYSTERY_LETTER) {
				TrieNode child = node.children[TrieNode.char2Idx(c)];
				if (child != null) {
					candidateWord[level] = c;
					computeCandiateWords(level + 1, child, candidateWord, candidateWordList, game);
					candidateWord[level] = '\0';
				}
				// Else branch out to each of its children nodes that has neither incorrectly guessed letter or correctly guessed letter
			} else {
				for (int i = 0; i < node.children.length; i++) {
					c = TrieNode.idx2Char(i);
					TrieNode child = node.children[i];
					if (child != null && !game.getAllGuessedLetters().contains(c)) {
						candidateWord[level] = c;
						computeCandiateWords(level + 1, child, candidateWord, candidateWordList, game);
						candidateWord[level] = '\0';
					}
				}
			}

		}
	}

}