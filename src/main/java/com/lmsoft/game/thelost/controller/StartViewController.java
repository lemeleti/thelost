package com.lmsoft.game.thelost.controller;

import com.lmsoft.game.thelost.MainApp;

import javafx.fxml.FXML;

public class StartViewController {

	private MainApp main;

	@FXML
	private void handleStart() {
		main.showGameView();
	}

	/**
	 * Setter - Method
	 * 
	 * @param main
	 */
	public void setMain(MainApp main) {
		this.main = main;
	}

}
