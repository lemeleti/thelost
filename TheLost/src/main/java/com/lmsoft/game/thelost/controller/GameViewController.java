package com.lmsoft.game.thelost.controller;

import com.lmsoft.game.thelost.Game;
import com.lmsoft.game.thelost.support.io.CommandParser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * View controller
 * 
 * @author Leandro Meleti
 * @date created on 06.12.2016
 */
public class GameViewController {

	@FXML
	private TextArea taConsole;

	@FXML
	private TextField tfCommand;

	@FXML
	private Button btnEnter;

	private Game game;

	private CommandParser parser;

	public void startGame() {
		parser = new CommandParser(this);

		game = new Game(this);
		game.play();
	}

	@FXML
	private void handleEnter() {
		taConsole.appendText(String.format("\n%s", tfCommand.getText()));

		boolean finished = game.processCommand(parser.getCommand());
		if (finished) {
			appendConsoleText("\nThanks for playing.");
			gameEnd();
		} else {
			tfCommand.setText("");
		}

		// this will scroll to the bottom
		taConsole.setScrollTop(Double.MAX_VALUE);
	}

	public void gameEnd() {
		btnEnter.setVisible(false);
		tfCommand.setVisible(false);
	}

	public void appendConsoleText(String text) {
		taConsole.appendText(String.format("%s", text));
	}

	public String getCommandText() {
		return tfCommand.getText();
	}

}
