package com.lmsoft.game.thelost.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	private final static Logger LOG = LogManager.getLogger(GameViewController.class);

	@FXML
	private TextArea taConsole;

	@FXML
	private TextField tfCommand;

	@FXML
	private Button btnEnter;

	private Game game;

	private CommandParser parser;

	/**
	 * Start the game
	 */
	public void startGame() {
		LOG.info("Game started");
		parser = new CommandParser(this);

		game = new Game(this);
		game.play();
	}

	@FXML
	private void handleEnter() {
		appendConsoleText(String.format("\n> %s\n", tfCommand.getText()));

		boolean finished = game.processCommand(parser.getCommand());
		if (finished) {
			appendConsoleText("\n---------------------------------------------------");
			appendConsoleText("\n---\t\tThanks for playing.\t\t---");
			appendConsoleText("\n---------------------------------------------------");
			gameEnd();
		} else {
			tfCommand.setText("");
		}
	}

	/**
	 * End the game
	 */
	public void gameEnd() {
		LOG.info("Game over");
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
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format("text[\"%s\"]", text.replace("\n", "")));
		}
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
		String title = "Secret Elevator Pin";

		LOG.info(String.format("Start dialog (%s)", title));

		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle(title);
		dialog.setHeaderText("On which floor did you start?");
		dialog.setContentText("Pin:");
		dialog.setResizable(false);

		Optional<String> result = dialog.showAndWait();
		return (result.isPresent()) ? result.get() : "";
	}

}
