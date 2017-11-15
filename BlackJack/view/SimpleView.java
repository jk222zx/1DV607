package BlackJack.view;

public class SimpleView implements IView, BlackJack.model.rules.INewCardObserver
{
	@Override
	public void NewCard(String identity, BlackJack.model.Card a_card, int a_score) {
		System.out.print(identity + " draw a card!");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println(" It is a " + a_card.GetValue() + " of " + a_card.GetColor() + " for a total score of: " + a_score);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
	
	public void DisplayWelcomeMessage()
    {
      for(int i = 0; i < 50; i++) {System.out.print("\n");}; 
      System.out.println("Hello Black Jack World");
      System.out.println("Type '" 
    		  			+ Options.PLAY.getOption() + "' to Play, '" 
    		  			+ Options.HIT.getOption() + "' to Hit, '"
						+ Options.STAND.getOption() + "' to Stand or '" 
    		  			+ Options.QUIT.getOption() + "' to Quit\n");
    }

    public int GetInput()
    {
      try {
        int c = System.in.read();
        while (c == '\r' || c =='\n') {
          c = System.in.read();
        }
        return c;
      } catch (java.io.IOException e) {
        System.out.println("" + e);
        return 0;
      }
    }

    public void DisplayCard(BlackJack.model.Card a_card)
    {
        System.out.println("" + a_card.GetValue() + " of " + a_card.GetColor());
    }

    public void DisplayPlayerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        DisplayHand("Player", a_hand, a_score);
    }

    public void DisplayDealerHand(Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        DisplayHand("Dealer", a_hand, a_score);
    }

    private void DisplayHand(String a_name, Iterable<BlackJack.model.Card> a_hand, int a_score)
    {
        System.out.println(a_name + " Has: ");
        for(BlackJack.model.Card c : a_hand)
        {
            DisplayCard(c);
        }
        System.out.println("Score: " + a_score);
        System.out.println("");
    }

    public void DisplayGameOver(boolean a_dealerIsWinner)
    {
        System.out.println("GameOver: ");
        if (a_dealerIsWinner)
        {
            System.out.println("Dealer Won!");
        }
        else
        {
            System.out.println("You Won!");
        }
        
    }
}
