package BlackJack.controller;

import BlackJack.view.IView;
import BlackJack.model.Game;

public class PlayGame {
  private 	int input = ' ';
  public void SetupGame(Game a_game, IView a_view) {
	  a_game.AddSubscriber(a_view);
	  a_view.DisplayWelcomeMessage("p","h","s","q");
	  a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
	  a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
  }
	
  public boolean Play(Game a_game, IView a_view) {

    if (a_game.IsGameOver())
    {
        a_view.DisplayGameOver(a_game.IsDealerWinner("playerWinOnEqual")); 
    }

    input = a_view.GetInput();
    
    if (input == 'p')
    {
        a_game.NewGame();
    }
    else if (input == 'h')
    {
        a_game.Hit();
    }
    else if (input == 's')
    {
        a_game.Stand();
    }

	a_view.DisplayWelcomeMessage("p","h","s","q");
    
    a_view.DisplayDealerHand(a_game.GetDealerHand(), a_game.GetDealerScore());
    a_view.DisplayPlayerHand(a_game.GetPlayerHand(), a_game.GetPlayerScore());
    
    return input != 'q';
  }
}