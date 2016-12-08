package com.lmsoft.game.thelost;

import java.io.IOException;

import com.lmsoft.game.thelost.controller.GameViewController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
		showPlayView();
	}

	private void showPlayView() {
		try {
			// Load person overview.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("/fxml/gameView.fxml"));
			AnchorPane gameLayout = (AnchorPane) loader.load();

			GameViewController controller = loader.getController();
			controller.startGame();

			Scene scene = new Scene(gameLayout);
			primaryStage.setScene(scene);
			primaryStage.setMinHeight(gameLayout.getPrefHeight());
			primaryStage.setMinWidth(gameLayout.getPrefWidth());
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
