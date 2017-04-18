package com.lmsoft.game.thelost;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

	private final static Logger LOG = LogManager.getLogger(MainApp.class);

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
		// TODO: Main view
		showPlayView();
	}

	private void showPlayView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			LOG.info("Loading fxml");
			loader.setLocation(MainApp.class.getResource("/fxml/gameView.fxml"));

			LOG.info("Loading pane");
			AnchorPane gameLayout = (AnchorPane) loader.load();

			LOG.info("Loading controller");
			GameViewController controller = loader.getController();
			controller.startGame();

			Scene scene = new Scene(gameLayout);
			primaryStage.setScene(scene);
			primaryStage.setMinHeight(gameLayout.getPrefHeight());
			primaryStage.setMinWidth(gameLayout.getPrefWidth());
			primaryStage.setResizable(false);

			LOG.info("Show the window");
			primaryStage.show();
		} catch (IOException e) {
			LOG.error("Load and show fxml error!", e);
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
