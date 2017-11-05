public class MemberRegistry {

	/**
	 * Start class for the program. 
	 * 
	 * The parameter in Presenters constructor is the filename for the saved data
	 * that the program uses.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		presenter.Presenter presenter = new presenter.Presenter("memberdata.data");
		presenter.start();
	}
}
