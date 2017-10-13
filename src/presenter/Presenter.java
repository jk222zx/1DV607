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
	
	private void options() {
		view.OptionsView optionsView = new view.OptionsView();
		char answer = 0;
		while (true) {
			optionsView.displayMenu();
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

	private void memberCreate() {
		String name = "";
		String personalNumber = "";
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		name = memberHandlerView.inputMemberName();
		personalNumber = memberHandlerView.inputMemberPersonalNumber();
		coordinator.addMember(name, personalNumber);
	}
	
	private void memberDelete() {
		int idNumber;
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		idNumber = memberHandlerView.inputMemberNumber();
		if (coordinator.existsMember(idNumber)) {
			coordinator.deleteMember(idNumber);
		} else {
			memberHandlerView.noSuchMemberMessage(idNumber);		
		}		
	}
	
	private void memberChange() {
		int idNumber;
		String name = "";
		String personalNumber = "";
		view.MemberHandlerView memberHandlerView = new view.MemberHandlerView();
		memberHandlerView.displayMenu();
		idNumber = memberHandlerView.inputMemberNumber();
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
	
	private void memberLookAt() {
		int idNumber;
		view.MemberLookAtView memberLookAtView = new view.MemberLookAtView();
		memberLookAtView.displayMenu();	
		idNumber = memberLookAtView.inputMemberNumber();
		if (coordinator.existsMember(idNumber)) {
			memberLookAtView.setIdNumber(idNumber);
			memberLookAtView.setMemberName(coordinator.getMemberName(idNumber));
			memberLookAtView.setMemberPersonalNumber(coordinator.getMemberPersonalNumber(idNumber));
			memberLookAtView.setMemberAllBoatsData(coordinator.getMemberAllBoatsData(idNumber));
			memberLookAtView.displayMemberInfo();
		} else {
			memberLookAtView.noSuchMemberMessage(idNumber);
		}
	}
	
	private void listCompact() {
		ListHelper helper = new ListHelper(coordinator);
		view.ListHandlerView listCompactView = new view.ListHandlerView();			
		listCompactView.displayCompactListMenu();		
		listCompactView.displayCompactList(helper.listCompact());
	}
	
	private void listVerbose() {
		ListHelper helper = new ListHelper(coordinator);
		view.ListHandlerView listVerboseView = new view.ListHandlerView();
		listVerboseView.displayVerboseListMenu();		
		listVerboseView.displayVerboseList(helper.listVerbose());
	}	

	private void boatRegister() {
		int idNumber;
		String boatType;
		double boatLength;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatRegisterMenu();
		idNumber = boatHandlerView.inputMemberNumber();
		if (coordinator.existsMember(idNumber)) {
			boatType = boatHandlerView.inputBoatType();
			boatLength = boatHandlerView.inputBoatLength();
			coordinator.addBoat(idNumber, boatType, boatLength);
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	private void boatDelete() {
		int idNumber;
		int boatListNumber;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatDeleteMenu();
		idNumber = boatHandlerView.inputMemberNumber();
		if (coordinator.existsMember(idNumber)) {
			boatListNumber = boatHandlerView.inputBoatNumber();
			if (coordinator.existsBoat(idNumber, boatListNumber)) {
				coordinator.deleteBoat(idNumber, boatListNumber);
			} else {
				boatHandlerView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	private void boatChange() {
		int idNumber;
		int boatListNumber;
		String boatType;
		double boatLength;
		view.BoatHandlerView boatHandlerView = new view.BoatHandlerView();
		boatHandlerView.displayBoatChangeMenu();
		idNumber = boatHandlerView.inputMemberNumber();
		if (coordinator.existsMember(idNumber)) {
			boatListNumber = boatHandlerView.inputBoatNumber();
			if (coordinator.existsBoat(idNumber, boatListNumber)) {
				boatType = boatHandlerView.inputBoatType();
				boatLength = boatHandlerView.inputBoatLength();
				if (boatType.length() > 0) {
					coordinator.changeBoatType(idNumber, boatListNumber, boatType);
				}
				if (boatLength > 0) {
					coordinator.changeBoatLength(idNumber, boatListNumber, boatLength);
				}
			} else {
				boatHandlerView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatHandlerView.noSuchMemberMessage(idNumber);
		}
	}
	
	private void memberDataSave() {
		view.VariousView variousView = new view.VariousView();
			variousView.memberDataSaveMessage(coordinator.save());
	}	
	
	private void programEnd() {
		coordinator.save();
		view.StartEndView startEndView = new view.StartEndView();
		startEndView.displayEndMenu();
		System.exit(0);
	}
	
	private void answerOutOfRange() {
		view.VariousView variousView = new view.VariousView();
		variousView.answerOutOfRangeMessage();	
	}
}

