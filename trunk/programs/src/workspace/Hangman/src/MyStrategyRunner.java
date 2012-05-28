import java.io.IOException;


public class MyStrategyRunner {

	public int run(HangmanGame game, GuessingStrategy strategy) {
	
		while (game.gameStatus() == HangmanGame.Status.KEEP_GUESSING) {
			Guess guess = strategy.nextGuess(game);
			guess.makeGuess(game);
		}
		
		return game.currentScore();
	}

public static void main(String[] args) throws IOException{
		
		MyGuessingStrategy strategy = new MyGuessingStrategy();
		String[] words = new String[]{"COMAKER", "CUMULATE", "ERUPTIVE", "FACTUAL", "MONADISM", "MUS", "NAGGING", "OSES", "REMEMBERED", "SPODUMENES", "STEREOISOMERS", "TOXICS", "TRICHROMATS", "TRIOSE", "UNIFORMED"};
		MyStrategyRunner runner = new MyStrategyRunner(); 
		
		for (int i = 0; i < words.length; i++) {
			HangmanGame game = new HangmanGame(words[i], 5);
			int score = runner.run(game, strategy);
			System.out.println(words[i] + " = " + score);
		}
	}
}
