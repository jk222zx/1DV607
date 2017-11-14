package BlackJack.model.rules;

import BlackJack.model.Player;

class Soft17 implements IHitStrategy {
    private final int g_hitLimit = 17;

    public boolean DoHit(Player a_dealer) {
    	int score = a_dealer.CalcScore();
    	if (score < g_hitLimit) {
    		return true;
    	} else if (score == g_hitLimit) {
    		return a_dealer.CalcScoreLowAces() < g_hitLimit;
    	} else {
    		return false;
    	}
    }
}
