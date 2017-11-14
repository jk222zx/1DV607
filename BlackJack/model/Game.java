package BlackJack.model;

import BlackJack.model.rules.INewCardObserver;
import BlackJack.view.IView;

public class Game {

  private Dealer m_dealer;
  private Player m_player;
  protected final int g_maxScore = 21;

  public Game()
  {
    m_dealer = new Dealer("Dealer", g_maxScore, new BlackJack.model.rules.RulesFactory());
    m_player = new Player("Player", g_maxScore);
  }
  
  public void AddSubscriber(IView a_view) {
	  m_dealer.AddSubscriber((INewCardObserver) a_view);
	  m_player.AddSubscriber((INewCardObserver) a_view);
  }
    
  public boolean IsGameOver()
  {
    return m_dealer.IsGameOver();
  }
  
  public boolean IsDealerWinner(String winnerRule)
  {
	return m_dealer.isDealerWinner(m_player);
  }
  
  public boolean NewGame()
  {
    return m_dealer.NewGame(m_player);
  }
  
  public boolean Hit()
  {
    return m_dealer.Hit(m_player);
  }
  
  public boolean Stand()
  {
	return m_dealer.Stand();
  }
  
  public Iterable<Card> GetDealerHand()
  {
    return m_dealer.GetHand();
  }
  
  public Iterable<Card> GetPlayerHand()
  {
    return m_player.GetHand();
  }
  
  public int GetDealerScore()
  {
    return m_dealer.CalcScore();
  }
  
  public int GetPlayerScore()
  {
    return m_player.CalcScore();
  }
    
  public int GetMaxScore() {
	  return g_maxScore;
  }
}