package com.lmsoft.game.thelost;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lmsoft.game.thelost.controller.GameViewController;
import com.lmsoft.game.thelost.controller.StartViewController;

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

	private static final Logger LOG = LogManager.getLogger(MainApp.class);

	private Stage primaryStage;

	/*
	 * (non-Javadoc)
	 * @see javafx.application.Application#start(javafx.stage.Stage)
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;

		showStartView();
	}

	private void showStartView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading fxml (start view)");
			}
			loader.setLocation(MainApp.class.getResource("/fxml/startView.fxml"));

			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading pane");
			}
			AnchorPane startLayout = (AnchorPane) loader.load();

			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading controller");
			}
			StartViewController controller = loader.getController();
			controller.setMain(this);

			Scene scene = new Scene(startLayout);
			primaryStage.setScene(scene);
			primaryStage.setMinHeight(startLayout.getPrefHeight());
			primaryStage.setMinWidth(startLayout.getPrefWidth());
			primaryStage.setResizable(false);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Show the window");
			}
			primaryStage.show();
		} catch (IOException e) {
			LOG.error("Load and show fxml error!", e);
		}
	}

	public void showGameView() {
		try {
			FXMLLoader loader = new FXMLLoader();
			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading fxml (game view)");
			}
			loader.setLocation(MainApp.class.getResource("/fxml/gameView.fxml"));

			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading pane");
			}
			AnchorPane gameLayout = (AnchorPane) loader.load();

			if (LOG.isDebugEnabled()) {
				LOG.debug("Loading controller");
			}
			GameViewController controller = loader.getController();
			controller.startGame();

			Scene scene = new Scene(gameLayout);
			primaryStage.setScene(scene);
			primaryStage.setMinHeight(gameLayout.getPrefHeight());
			primaryStage.setMinWidth(gameLayout.getPrefWidth());
			primaryStage.setResizable(false);

			if (LOG.isDebugEnabled()) {
				LOG.debug("Show the window");
			}
			primaryStage.show();
		} catch (IOException e) {
			LOG.error("Load and show fxml error!", e);
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
