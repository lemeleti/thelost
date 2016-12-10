package com.lmsoft.game.thelost.support.io;

/**
 * Helper class for the action words.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class ActionWordHelper {

	// This class doesn't need an instance, because all methods are static.
	private ActionWordHelper() {
	}

	/**
	 * Returns a {@link String} of all valid action words.
	 * 
	 * @return {@link String}
	 */
	public static String getAllValidActionWords() {

		ActionWordEnum[] actionWords = ActionWordEnum.values();
		String result = actionWords[0].getActionWord();
		for (int i = 1; i < actionWords.length; i++) {
			result = String.format("%s, %s", result, actionWords[i].getActionWord());
		}

		return result;
	}

	/**
	 * Returns true if the given action word is a valid one.<br/>
	 * Returns false if the given action word is invalid.
	 * 
	 * @param actionWord
	 *            {@link String}
	 * @return {@link Boolean}
	 */
	public static boolean isActionCommand(String actionWord) {
		boolean result = false;

		if (actionWord != null) {
			for (ActionWordEnum aw : ActionWordEnum.values()) {
				if (actionWord.equalsIgnoreCase(aw.getActionWord())) {
					result = true;
					break;
				}
			}
		}

		return result;
	}
}
