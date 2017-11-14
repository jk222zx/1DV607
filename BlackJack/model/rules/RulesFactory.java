package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new Soft17();
    //return new BasicHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
  
  public IWinnerStrategy GetWinnerRule() {
	  //return new DealerWinOnEqualStrategy();
	  return new PlayerWinOnEqualStrategy();
  }
}