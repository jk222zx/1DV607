package BlackJack.model;

import BlackJack.model.rules.*;

public class Dealer extends Player {

  private Deck m_deck;
  private INewGameStrategy m_newGameRule;
  private IHitStrategy m_hitRule;

  public Dealer(String identity, int maxScore, RulesFactory a_rulesFactory) {
	super(identity, maxScore);
    m_newGameRule = a_rulesFactory.GetNewGameRule();
    m_hitRule = a_rulesFactory.GetHitRule();
    
    /*for(Card c : m_deck.GetCards()) {
      c.Show(true);
      System.out.println("" + c.GetValue() + " of " + c.GetColor());
    }    */
  }
  
  public boolean NewGame(Player a_player) {
    if (m_deck == null || IsGameOver()) {
      m_deck = new Deck();
      ClearHand();
      a_player.ClearHand();
      return m_newGameRule.NewGame(this, a_player);  
    }
    return false;
  }

  public boolean Hit(Player a_player) {
    if (m_deck != null && a_player.CalcScore() < g_maxScore && !IsGameOver()) {
    	DrawAndDeal(a_player, true);
      return true;
    }
    return false;
  } 
  
  public boolean Stand() {
	  if (m_deck != null) {
		  ShowHand();
		  while (m_hitRule.DoHit(this)) {
			  DrawAndDeal(this, true);
		  };
		  return true;
	  }
	  return false;
  }

  public boolean IsGameOver() {
    if (m_deck != null && m_hitRule.DoHit(this) != true) {
        return true;
    }
    return false;
  }
  
  public void DrawAndDeal(Player player, boolean show) {
	Card c;  
	c = m_deck.GetCard();
	c.Show(show);
	player.DealCard(c);	  
  }
}