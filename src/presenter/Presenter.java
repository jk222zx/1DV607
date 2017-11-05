package presenter;

import model.Coordinator;

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
		char answer = 0;
		while (true) {
			optionsView.displayMenu("1","2","3","4","5","6","7","8","9","S","Q");
			answer = optionsView.readChar();
			switch (answer) {
				case '1':
					memberCreate();
					break;
				case '2':
					memberDelete();
					break;
				case '3':
					memberChange();
					break;
				case '4':
					memberLookAt();
					break;
				case '5':
					listCompact();
					break;
				case '6':
					listVerbose();
					break;
				case '7':
					boatRegister();
					break;
				case '8':
					boatDelete();
					break;
				case '9':
					boatChange();
					break;
				case 'S':
					memberDataSave();
					break;
				case 's':
					memberDataSave();
					break;
				case 'Q':
					programEnd();
					break;
				case 'q':
					programEnd();
					break;
				default :
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

