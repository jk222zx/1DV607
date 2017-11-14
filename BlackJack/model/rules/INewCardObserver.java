package BlackJack.model.rules;

import BlackJack.model.Card;

public interface INewCardObserver {
	void NewCard(String player, Card a_card, int a_score);
}
