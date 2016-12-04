package com.lmsoft.game.thelost.support.io;

import org.apache.commons.lang3.StringUtils;

/**
 * Model class for a command.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class Command {

	private final String actionWord;

	private final String secondWord;

	/**
	 * Default constructor.<br/>
	 * 
	 * @param actionWord
	 *            {@link String}
	 * @param secondWord
	 *            {@link String}
	 */
	public Command(String actionWord, String secondWord) {
		super();
		this.actionWord = actionWord;
		this.secondWord = secondWord;
	}

	/**
	 * Returns true if there's an action word
	 * 
	 * @return {@link Boolean}
	 */
	public boolean hasActionWord() {
		return !StringUtils.isEmpty(actionWord);
	}

	/**
	 * Returns true if there's a second word
	 * 
	 * @return {@link Boolean}
	 */
	public boolean hasSecondWord() {
		return !StringUtils.isEmpty(secondWord);
	}

	/**
	 * Getter - Method
	 * 
	 * @return actionWord
	 */
	public String getActionWord() {
		return actionWord;
	}

	/**
	 * Getter - Method
	 * 
	 * @return secondWord
	 */
	public String getSecondWord() {
		return secondWord;
	}
}
