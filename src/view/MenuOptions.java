package view;

public enum MenuOptions {
	CREATEMEMBER	('1', '1'),
	DELETEMEMBER	('2', '2'),
	CHANGEMEMBER	('3', '3'),
	LOOKATMEMBER	('4', '4'),
	COMPACTLIST		('5', '5'),
	VERBOSELIST		('6', '6'),
	REGISTERBOAT	('7', '7'),
	DELETEBOAT		('8', '8'),
	CHANGEBOAT		('9', '9'),
	SAVEMEMBER		('S', 's'),
	QUIT			('Q', 'q');
	
	private final char option1;
	private final char option2;
	
	MenuOptions(char option1, char option2) {
		this.option1 = option1;
		this.option2 = option2;
	}
	
	public char getOption1() {
		return option1;
	}
	
	public char getOption2() {
		return option2;
	}
}
