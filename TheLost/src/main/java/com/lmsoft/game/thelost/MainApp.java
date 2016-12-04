package com.lmsoft.game.thelost;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Main class
 * 
 * @author Leandro Meleti
 * @date created on 02.12.2016
 */
public class MainApp extends Application {

	private Stage primaryStage;

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		showMainView();
	}

	private void showMainView() {

	}

	private void showPlayView() {

	}

	/**
	 * launch method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}

}
