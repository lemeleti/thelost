package com.lmsoft.game.thelost.support.io;

/**
 * Enum of all possible action words.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ActionWordEnum {

	HELP("help"),

	LOOK("look"),

	GO("go"),

	USE("use"),

	SEARCH_ITEM("searchitem"),

	SHOW_ITEMS("showitems");

	private final String actionCommand;

	/**
	 * @param actionCommand
	 */
	private ActionWordEnum(String actionCommand) {
		this.actionCommand = actionCommand;
	}

	/**
	 * Getter - Method
	 * 
	 * @return actionCommand
	 */
	public String getActionWord() {
		return actionCommand;
	}

}
