package com.lmsoft.game.thelost.controller;

import java.util.Optional;

import com.lmsoft.game.thelost.Game;
import com.lmsoft.game.thelost.support.io.CommandParser;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputDialog;

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

	/**
	 * Do some inits and start the game
	 */
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
	}

	/**
	 * End the game
	 */
	public void gameEnd() {
		btnEnter.setVisible(false);
		tfCommand.setVisible(false);
	}

	/**
	 * Append - Method
	 * 
	 * @param text
	 *            {@link String}
	 */
	public void appendConsoleText(String text) {
		taConsole.appendText(String.format("%s", text));
	}

	/**
	 * Getter - Method
	 * 
	 * @return commad {@link String}
	 */
	public String getCommandText() {
		return tfCommand.getText();
	}

	/**
	 * Getter - Method
	 * 
	 * @return pin {@link String}
	 */
	public String getPin() {
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Secret Elevator Pin");
		dialog.setHeaderText("On which floor did you start?");
		dialog.setContentText("Pin:");
		dialog.setResizable(false);

		Optional<String> result = dialog.showAndWait();
		return (result.isPresent()) ? result.get() : "";
	}

}
