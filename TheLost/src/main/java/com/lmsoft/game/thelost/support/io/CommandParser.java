package com.lmsoft.game.thelost.support.io;

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
		String[] words = inputLine.split(" ");

		if (ActionWordHelper.isActionCommand(words[0])) {
			return new Command(words[0], words[1]);
		} else {
			return new Command(null, words[1]);
		}
	}

}
