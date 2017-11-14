package BlackJack.view;

public interface IView
{
	public enum Options {
		PLAY	('p'),
		HIT		('h'),
		STAND	('s'),
		QUIT	('q');
		
		private final char option;
		
		private Options(char option) {
			this.option = option;
		}
		
		public char getOption() {
			return option;
		}
	}
	void DisplayWelcomeMessage();
	int GetInput();
	void DisplayCard(BlackJack.model.Card a_card);
	void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
	void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score);
	void DisplayGameOver(boolean a_dealerIsWinner);
}