package com.lmsoft.game.thelost.support.io;

import java.util.StringTokenizer;

import com.lmsoft.game.thelost.controller.GameViewController;

/**
 * Parse the input command to a java object {@link Command}
 * 
 * @author Leandro Meleti
 * @date created on 06.12.2016
 */
public class CommandParser {

	private GameViewController gameController;

	/**
	 * Default constructor
	 * 
	 * @param gameController
	 *            {@link GameViewController}
	 */
	public CommandParser(GameViewController gameController) {
		super();
		this.gameController = gameController;
	}

	/**
	 * Get the command as java object
	 * 
	 * @return {@link Command}
	 */
	public Command getCommand() {
		String inputLine = gameController.getCommandText();
		String actionWord = null;
		String secondWord = null;

		StringTokenizer tokenizer = new StringTokenizer(inputLine);

		if (tokenizer.hasMoreTokens()) {
			actionWord = tokenizer.nextToken(); // get first word
		}

		if (tokenizer.hasMoreTokens()) {
			secondWord = tokenizer.nextToken(); // get second word
		}

		/*
		 * Check if the first word is a valid action command. If it's valid
		 * create a command object with the first and second word. If it's
		 * invalid create a command object with the second word. For the first
		 * word we take null for unknown command.
		 */
		if (ActionWordHelper.isActionCommand(actionWord)) {
			return new Command(actionWord, secondWord);
		} else {
			return new Command(null, secondWord);
		}
	}

}
