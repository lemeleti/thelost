package com.lmsoft.game.thelost.support.io;

/**
 * Enum of all possible action words.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ActionWordEnum {

	/* !!!! ONLY LOWERCASE TEXT !!!! */
	HELP("help"),

	LOOK("look"),

	GO("go"),

	QUIT("quit"),

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

	public static ActionWordEnum getEnumByString(String value) {

		if (value != null) {
			for (ActionWordEnum actionWord : ActionWordEnum.values()) {
				if (value.equalsIgnoreCase(actionWord.getActionWord())) {
					return actionWord;
				}
			}
		}

		return null;
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
