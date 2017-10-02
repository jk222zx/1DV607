package presenter;

import model.Model;

/**
 * This is the presenter. This class communicates with the different views directly
 * and with the model through the model class. It also contains the logic necessary  
 * for the presenters functionality. 
 * 
 * To start this application the start program creates an instance of this class and
 * calls the method start. 
 * 
 * @author 
 *
 */
public class Presenter {
	private Model model;
	
	public Presenter (String savedRegistryFileName) {
		this.model = new Model(savedRegistryFileName);
	}
	
	public void start() {
		view.StartView startView = new view.StartView();
		startView.displayMenu();
		if (model.existsFile()) {
			startView.savedDataExistsMessage();
			model.load();
		} else {
			startView.savedDataMissingMessage();
		}
		options();
	}
	
	private void options() {
		view.OptionsView optionsView = new view.OptionsView();
		char answer = 0;
		while (answer != '0') {
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
		view.MemberCreateView memberCreateView = new view.MemberCreateView();
		memberCreateView.displayMenu();
		name = memberCreateView.inputMemberName();
		personalNumber = memberCreateView.inputMemberPersonalNumber();
		model.addMember(name, personalNumber);
	}
	
	private void memberDelete() {
		int memberNumber;
		view.MemberDeleteView memberDeleteView = new view.MemberDeleteView();
		memberDeleteView.displayMenu();
		memberNumber = memberDeleteView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			model.deleteMember(memberNumber);
		} else {
			memberDeleteView.noSuchMemberMessage(memberNumber);		
		}		
	}
	
	private void memberChange() {
		int memberNumber;
		String name = "";
		String personalNumber = "";
		view.MemberChangeView memberChangeView = new view.MemberChangeView();
		memberChangeView.displayMenu();
		memberNumber = memberChangeView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			name = memberChangeView.inputMemberName();
			personalNumber = memberChangeView.inputMemberPersonalNumber();
			if (name.length() > 0) {
				model.changeMemberName(memberNumber, name);
			}
			if (personalNumber.length() > 0) {
				model.changeMemberPersonalNumber(memberNumber, personalNumber);
			}
		} else {
			memberChangeView.noSuchMemberMessage(memberNumber);
		}
	}
	
	private void memberLookAt() {
		int memberNumber;
		view.MemberLookAtView memberLookAtView = new view.MemberLookAtView();
		memberLookAtView.displayMenu();	
		memberNumber = memberLookAtView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			memberLookAtView.displayMemberInfo(model.getMemberData(memberNumber));
		} else {
			memberLookAtView.noSuchMemberMessage(memberNumber);
		}
	}
	
	private void listCompact() {
		view.ListCompactView listCompactView = new view.ListCompactView();
		listCompactView.displayMenu();
		listCompactView.displayCompactList(model.getCompactList());
	}
	
	private void listVerbose() {
		view.ListVerboseView listVerboseView = new view.ListVerboseView();
		listVerboseView.displayMenu();		
		listVerboseView.displayVerboseList(model.getVerboseList());
	}	

	private void boatRegister() {
		int memberNumber;
		String boatType;
		double boatLength;
		view.BoatRegisterView boatRegisterView = new view.BoatRegisterView();
		boatRegisterView.displayMenu();
		memberNumber = boatRegisterView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			boatType = boatRegisterView.inputBoatType();
			boatLength = boatRegisterView.inputBoatLength();
			model.addBoat(memberNumber, boatType, boatLength);
		} else {
			boatRegisterView.noSuchMemberMessage(memberNumber);
		}
	}
	
	private void boatDelete() {
		int memberNumber;
		int boatListNumber;
		view.BoatDeleteView boatDeleteView = new view.BoatDeleteView();
		boatDeleteView.displayMenu();
		memberNumber = boatDeleteView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			boatListNumber = boatDeleteView.inputBoatNumber();
			if (model.existsBoat(memberNumber, boatListNumber)) {
				model.deleteBoat(memberNumber, boatListNumber);
			} else {
				boatDeleteView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatDeleteView.noSuchMemberMessage(memberNumber);
		}
	}
	
	private void boatChange() {
		int memberNumber;
		int boatListNumber;
		String boatType;
		double boatLength;
		view.BoatChangeView boatChangeView = new view.BoatChangeView();
		boatChangeView.displayMenu();
		memberNumber = boatChangeView.inputMemberNumber();
		if (model.existsMember(memberNumber)) {
			boatListNumber = boatChangeView.inputBoatNumber();
			if (model.existsBoat(memberNumber, boatListNumber)) {
				boatType = boatChangeView.inputBoatType();
				boatLength = boatChangeView.inputBoatLength();
				if (boatType.length() > 0) {
					model.changeBoatType(memberNumber, boatListNumber, boatType);
				}
				if (boatLength > 0) {
					model.changeBoatLength(memberNumber, boatListNumber, boatLength);
				}
			} else {
				boatChangeView.noSuchBoatMessage(boatListNumber);
			}
		} else {
			boatChangeView.noSuchMemberMessage(memberNumber);
		}
	}
	
	private void memberDataSave() {
		view.VariousView variousView = new view.VariousView();
			variousView.memberDataSaveMessage(model.save());
	}	
	
	private void programEnd() {
		model.save();
		view.EndView endView = new view.EndView();
		endView.displayMenu();
		System.exit(0);
	}
	
	private void answerOutOfRange() {
		view.VariousView variousView = new view.VariousView();
		variousView.answerOutOfRangeMessage();	
	}
}

