package BlackJack.model;

public interface INewCardObserver {
	void NewCard(String player, Card a_card, int a_score);
}
