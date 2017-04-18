package com.lmsoft.game.thelost.support.io;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lmsoft.game.thelost.controller.GameViewController;

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

	QUIT("quit"),

	USE("use"),

	SEARCH_ITEM("searchitem"),

	SHOW_ITEMS("showitems");

	private final static Logger LOG = LogManager.getLogger(GameViewController.class);

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

		LOG.error(String.format("The action word \"%s\", does not exist i this game!", value));
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
