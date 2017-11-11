package presenter;

import model.Coordinator;
import view.MenuOptions;

/**
 * This is the presenter. This class communicates with the different views directly
 * and with the model through the model class. It also contains the logic necessary  
 * for the presenters functionality. 
 * 
 * To start this application the start program creates an instance of this class and
 * calls the method start. 
 * 
 * @author secret
 *
 */
public class Presenter {
	private Coordinator coordinator;
	
	public Presenter (String savedRegistryFileName) {
		this.coordinator = new Coordinator(savedRegistryFileName);
	}
	
	/**
	 * Method called from public static void main method in class MemberRegistry.
	 */
	public void start() {
		view.StartEndView startEndView = new view.StartEndView();
		startEndView.displayStartMenu();
		if (coordinator.existsFile()) {
			startEndView.savedDataExistsMessage();
			coordinator.load();
		} else {
			startEndView.savedDataMissingMessage();
		}
		options();
	}
	
	/**
	 * Method that loops during the program run waiting to inputs.
	 */
	private void options() {
		view.OptionsView optionsView = new view.OptionsView();
		char answer;
		while (true) {
			optionsView.displayMenu();
			answer = optionsView.readChar();
			if (answer == MenuOptions.CREATEMEMBER.getOption1() || answer == MenuOptions.CREATEMEMBER.getOption2()) {
				memberCreate();
			} else if (answer == MenuOptions.DELETEMEMBER.getOption1() || answer == MenuOptions.DELETEMEMBER.getOption2()) {
				memberDelete();
			} else if (answer == MenuOptions.CHANGEMEMBER.getOption1() || answer == MenuOptions.CHANGEMEMBER.getOption2()) {
				memberChange();
			} else if (answer == MenuOptions.LOOKATMEMBER.getOption1() || answer == MenuOptions.LOOKATMEMBER.getOption2()) {
				memberLookAt();
			} else if (answer == MenuOptions.COMPACTLIST.getOption1() || answer == MenuOptions.COMPACTLIST.getOption2()) {
				listCompact();
			} else if (answer == MenuOptions.VERBOSELIST.getOption1() || answer == MenuOptions.VERBOSELIST.getOption2()) {
				listVerbose();
			} else if (answer == MenuOptions.REGISTERBOAT.getOption1() || answer == MenuOptions.REGISTERBOAT.getOption2()) {
				boatRegister();
			} else if (answer == MenuOptions.DELETEBOAT.getOption1() || answer == MenuOptions.DELETEBOAT.getOption2()) {
				boatDelete();
			} else if (answer == MenuOptions.CHANGEBOAT.getOption1() || answer == MenuOptions.CHANGEBOAT.getOption2()) {
				boatChange();
			} else if (answer == MenuOptions.SAVEMEMBER.getOption1() || answer == MenuOptions.SAVEMEMBER.getOption2()) {
				memberDataSave();
			} else if (answer == MenuOptions.QUIT.getOption1() || answer == MenuOptions.QUIT.getOption2()) {
				programEnd();
			} else {
				answerOutOfRange();
			}
		}
	}

	/**
	 * Method display information, collect input and create a new Member object.
	 */
	private void memberCreate() {
		String name = "";
		String personalNumber = "";
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		name = memberHandlerView.inputMemberName();
		personalNumber = memberHandlerView.inputMemberPersonalNumber();
		coordinator.addMember(name, personalNumber);
	}
	
	/**
	 * Method display information, collect input and delete a Member object.
	 */
	private void memberDelete() {
		int idNumber;
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		idNumber = memberHandlerView.inputIdNumber();
		if (coordinator.deleteMember(idNumber)) {
		} else {
			memberHandlerView.noSuchMemberMessage(idNumber);		
		}		
	}
	
	/**
	 * Method display information, collect input and change some of the attributes
	 * in a Member object.
	 */
	private void memberChange() {
		int idNumber;
		String name = "";
		String personalNumber = "";
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		idNumber = memberHandlerView.inputIdNumber();
		if (coordinator.existsMember(idNumber)) {
			name = memberHandlerView.inputMemberChangeName();
			personalNumber = memberHandlerView.inputMemberChangePersonalNumber();
			if (name.length() > 0) {
				coordinator.changeMemberName(idNumber, name);			
			}
			if (personalNumber.length() > 0) {
				coordinator.changeMemberPersonalNumber(idNumber, personalNumber);
			}
		} else {
			memberHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	/**
	 * Method display information, collect input, get data and display data about a 
	 * Member object.
	 */
	private void memberLookAt() {
		DataGatherer helper = new DataGatherer(coordinator);
		view.MemberLookAtView memberLookAtView = new view.MemberLookAtView();
		int idNumber;
		memberLookAtView.displayMenu();	
		idNumber = memberLookAtView.inputIdNumber();
		if (coordinator.existsMember(idNumber)) {
			memberLookAtView.displayMemberInfo(	idNumber,
												helper.getName(idNumber),
												helper.getPersonalNumber(idNumber),
												helper.getBoatData(idNumber));
		} else {
			memberLookAtView.noSuchMemberMessage(idNumber);
		}
	}
	
	/**
	 * Method display information, collect input, get data and display a compact list with
	 * data about all Member objects.
	 */
	private void listCompact() {
		DataGatherer helper = new DataGatherer(coordinator);
		view.ListHandlerView listCompactView = new view.ListHandlerView();			
		listCompactView.displayCompactListMenu();		
		listCompactView.displayCompactList(helper.listCompact());
	}
	
	/**
	 * Method display information, collect input, get data and display a more detailed list with
	 * data about all Member objects.
	 */
	private void listVerbose() {
		DataGatherer helper = new DataGatherer(coordinator);
		view.ListHandlerView listVerboseView = new view.ListHandlerView();
		listVerboseView.displayVerboseListMenu();		
		listVerboseView.displayVerboseList(helper.listVerbose());
	}	

	/**
	 * Method display information, collect input and create a new Boat object.
	 */
	private void boatRegister() {
		int idNumber;
		String boatType;
		double boatLength;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatRegisterMenu();
		idNumber = boatHandlerView.inputIdNumber();
		if (coordinator.existsMember(idNumber)) {
			boatType = boatHandlerView.inputBoatType();
			boatLength = boatHandlerView.inputBoatLength();
			coordinator.addBoat(idNumber, boatType, boatLength);
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	/**
	 * Method display information, collect input and delete a Boat object.
	 */
	private void boatDelete() {
		int idNumber;
		int boatListNumber;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatDeleteMenu();
		idNumber = boatHandlerView.inputIdNumber();
		if (coordinator.existsMember(idNumber)) {
			boatListNumber = boatHandlerView.inputBoatNumber();
			if (coordinator.existsBoat(idNumber, boatListNumber - 1)) {
				coordinator.deleteBoat(idNumber, boatListNumber - 1);
			} else {
				boatHandlerView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	/**
	 * Method display information, collect input and change some of the attributes
	 * in a Boat object.
	 */
	private void boatChange() {
		int idNumber;
		int boatListNumber;
		String boatType;
		double boatLength;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatChangeMenu();
		idNumber = boatHandlerView.inputIdNumber();
		if (coordinator.existsMember(idNumber)) {
			boatListNumber = boatHandlerView.inputBoatNumber();
			if (coordinator.existsBoat(idNumber, boatListNumber - 1)) {
				boatType = boatHandlerView.inputBoatType();
				boatLength = boatHandlerView.inputBoatLength();
				if (boatType.length() > 0) {
					coordinator.changeBoatType(idNumber, boatListNumber - 1, boatType);
				}
				if (boatLength > 0) {
					coordinator.changeBoatLength(idNumber, boatListNumber - 1, boatLength);
				}
			} else {
				boatHandlerView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	/**
	 * Method to initialize the saving of an object containing all Member- and Boat objects
	 * in a file in the file system.
	 */
	private void memberDataSave() {
		view.VariousView variousView = new view.VariousView();
			variousView.memberDataSaveMessage(coordinator.save());
	}	
	 /**
	  * Method to stop the program.
	  */
	private void programEnd() {
		coordinator.save();
		view.StartEndView startEndView = new view.StartEndView();
		startEndView.displayEndMenu();
		System.exit(0);
	}
	/**
	 * Method to display an message when an option that does not exist has been chosen.
	 */
	private void answerOutOfRange() {
		view.VariousView variousView = new view.VariousView();
		variousView.answerOutOfRangeMessage();	
	}
}

