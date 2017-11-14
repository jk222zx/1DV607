package BlackJack.model;

import java.util.List;

import BlackJack.model.rules.INewCardObserver;

import java.util.ArrayList;
import java.util.LinkedList;

public class Player {
  private List<Card> m_hand;
  protected String identity;
  protected int g_maxScore;

  protected ArrayList<INewCardObserver> m_subscribers;
  
  public Player(String identity, int maxScore)
  {
    m_hand = new LinkedList<Card>();
    this.identity = identity;
    g_maxScore = maxScore;
    m_subscribers = new ArrayList<INewCardObserver>();
    System.out.println("Hello List World");
  }
  
  public void AddSubscriber(INewCardObserver iNCO) {
	  m_subscribers.add(iNCO);
  }
  
  public void DealCard(Card a_addToHand)
  {
    m_hand.add(a_addToHand);
    for (INewCardObserver iNCO : m_subscribers) {
    	iNCO.NewCard(identity, a_addToHand, CalcScore());
    }
  }
  
  public Iterable<Card> GetHand()
  {
    return m_hand;
  }
  
  public void ClearHand()
  {
    m_hand.clear();
  }
  
  public void ShowHand()
  {
    for(Card c : m_hand)
    {
      c.Show(true);
    }
  }
  
  public int CalcScore()
  {
    // the number of scores is dependant on the number of scorable values
    // as it seems there is no way to do this check at compile time in java ?!
    // cardScores[13] = {...};
    int cardScores[] = {
        2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 11
    };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }

    if (score > g_maxScore)
    {
        for(Card c : GetHand())
        {
            if (c.GetValue() == Card.Value.Ace && score > g_maxScore)
            {
                score -= 10;
            }
        }
    }

    return score;
  }
  
  public int CalcScoreLowAces() {
    int cardScores[] = {
            2, 3, 4, 5, 6, 7, 8, 9, 10, 10 ,10 ,10, 1
        };
    assert (cardScores.length == Card.Value.Count.ordinal()) : "Card Scores array size does not match number of card values";
  
    int score = 0;

    for(Card c : GetHand()) {
        if (c.GetValue() != Card.Value.Hidden)
        {
            score += cardScores[c.GetValue().ordinal()];
        }
    }
    return score;
  }
}