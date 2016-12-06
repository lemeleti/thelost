package com.lmsoft.game.thelost.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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

	@FXML
	private Text txtEnterHelper;

	@FXML
	private void handleEnter() {
		taConsole.appendText(String.format("\n%s\n", tfCommand.getText()));
		tfCommand.setText("");
		txtEnterHelper.setText("enter");
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

	public String getTxtEnterHelper() {
		return txtEnterHelper.getText();
	}

	public void setTxtEnterHelperDefault() {
		txtEnterHelper.setText("f");
	}

}
