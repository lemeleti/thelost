package com.lmsoft.game.thelost;

import static com.lmsoft.game.thelost.model.DirectionEnum.DOWN;
import static com.lmsoft.game.thelost.model.DirectionEnum.EAST;
import static com.lmsoft.game.thelost.model.DirectionEnum.NORTH;
import static com.lmsoft.game.thelost.model.DirectionEnum.SOUTH;
import static com.lmsoft.game.thelost.model.DirectionEnum.UP;
import static com.lmsoft.game.thelost.model.DirectionEnum.WEST;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lmsoft.game.thelost.controller.GameViewController;
import com.lmsoft.game.thelost.controller.ItemController;
import com.lmsoft.game.thelost.model.ItemEnum;
import com.lmsoft.game.thelost.model.ObstacleEnum;
import com.lmsoft.game.thelost.model.Room;
import com.lmsoft.game.thelost.support.io.ActionWordEnum;
import com.lmsoft.game.thelost.support.io.ActionWordHelper;
import com.lmsoft.game.thelost.support.io.Command;

/**
 * This class manages the game.<br/>
 * All the rooms are here defined and connected.<br/>
 * Also are the items and obstacles set in some rooms.
 * 
 * @author Leandro Meleti
 * @date created on 05.12.2016
 */
public class Game {

	private final static Logger LOG = LogManager.getLogger(Game.class);

	private GameViewController guiController;

	private ItemController itemController;

	private Room currentRoom;

	private Room nextRoom;

	private Room finalRoom;

	private Room secretFinalRoom;

	private Room secretElevator;

	/**
	 * Default constructor
	 */
	public Game(GameViewController guiController) {
		this.guiController = guiController;

		itemController = new ItemController();

		createRooms();
	}

	public void play() {
		printWelcome();
	}

	private void printWelcome() {
		LOG.log(Level.INFO, "Print welcome text");
		guiController.appendConsoleText("Welcome to The Lost!");
		guiController.appendConsoleText("\nYou're in a high-rise building. Recently, a terrorist group");
		guiController.appendConsoleText("\nbombed the building. Try to find the exit. You will encounter challenges ");
		guiController.appendConsoleText("\n'cause the great magician Piranavan has enchanted the whole building.");
		guiController.appendConsoleText("\nTry to escape! Good Luck :D");
		guiController.appendConsoleText("\n\nType help for information\n");
		look();
	}

	private void look() {
		guiController.appendConsoleText(String.format("\n%s", currentRoom.getLongDescription()));
	}

	/*
	 * Lists all items the player found
	 */
	private void listItem() {
		guiController
				.appendConsoleText(String.format("\nYou've got these items: %s", itemController.getItemsAsString()));
	}

	/*
	 * Lists all valid action words
	 */
	private void printHelp() {
		guiController.appendConsoleText(
				String.format("\nYou got these commands:\n%s", ActionWordHelper.getAllValidActionWords()));
	}

	/*
	 * Quit the game
	 */
	private boolean quit(Command command) {
		if (command.hasSecondWord()) {
			guiController.appendConsoleText("\nQuit what?");
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Prints ASCII drawing of the item or the text that there's nothing
	 */
	private void showItem() {

		ItemEnum item = currentRoom.getItemObject();
		if (item != ItemEnum.NONE) {
			LOG.log(Level.INFO, "Show ASCII drawing of the item.");
			switch (item) {
				case PIKACHU:
					guiController.appendConsoleText("\n           ,     ,_");
					guiController.appendConsoleText("\n           |`\\    `;;,            ,;;'");
					guiController.appendConsoleText("\n           |  `\\    \\ '.        .'.'");
					guiController.appendConsoleText("\n           |    `\\   \\  '-\"\"\"\"-' /");
					guiController.appendConsoleText("\n           `.     `\\ /          |`");
					guiController.appendConsoleText("\n             `>    /;   _     _ \\ ");
					guiController.appendConsoleText("\n              /   / |       .    ;");
					guiController.appendConsoleText("\n             <  (`\";\\ ()   ~~~  (/_");
					guiController.appendConsoleText("\n              ';;\\  `,     __ _.-'` )");
					guiController.appendConsoleText("\n                >;\\          `   _.'");
					guiController.appendConsoleText("\n                `;;\\          \\-'");
					guiController.appendConsoleText("\n                  ;/           \\ _");
					guiController.appendConsoleText("\n                  |   ,\"\".     .` \\");
					guiController.appendConsoleText("\n                  |      _|   '   /");
					guiController.appendConsoleText("\n                   ;    /\")     .;-,");
					guiController.appendConsoleText("\n                    \\    /  __   .-'");
					guiController.appendConsoleText("\n                     \\,_/-\"`  `-'\n");
					break;

				case SWORD:
					guiController.appendConsoleText("\n                           ___");
					guiController.appendConsoleText("\n                          ( ((");
					guiController.appendConsoleText("\n                           ) ))");
					guiController.appendConsoleText("\n  .::.                    / /(");
					guiController.appendConsoleText(
							"\n '  .-;-.-.-.-.-.-.-.-/| ((::::::::::::::::::::::::::::::::::::::::::.._");
					guiController.appendConsoleText(
							"\n(  ( ( ( ( ( ( ( ( ( ( |  ))   -================================-      _.>");
					guiController.appendConsoleText(
							"\n `  `-;-`-`-`-`-`-`-`-\\| ((::::::::::::::::::::::::::::::::::::::::::''");
					guiController.appendConsoleText("\n  `::'                    \\ \\(");
					guiController.appendConsoleText("\n                           ) ))");
					guiController.appendConsoleText("\n                          (_((\n");
					break;

				case KEY:
					guiController.appendConsoleText("\n         .--.");
					guiController.appendConsoleText("\n        /.-. '----------.");
					guiController.appendConsoleText("\n        \\'-' .--\"--\"\"-\"-'");
					guiController.appendConsoleText("\n         '--'\n");
					break;

				case BONE:
					guiController.appendConsoleText("\n      .-.               .-.");
					guiController.appendConsoleText("\n     (   `-._________.-'   )");
					guiController.appendConsoleText("\n      >=     _______     =<");
					guiController.appendConsoleText("\n     (   ,-'`       `'-,   )");
					guiController.appendConsoleText("\n      `-'               `-'\n");
					break;

				default:
					LOG.log(Level.DEBUG, "The ASCII drawing of the item is not implemented yet!");
					break;
			}
			guiController.appendConsoleText(String.format("\nYou found: %s", item.getItem()));
			itemController.putToInventory(item);
			currentRoom.removeItem();
		} else {
			guiController.appendConsoleText("\nThere's nothing!");
		}
	}

	/*
	 * Use an item for a obstacle
	 */
	private void use(Command command) {
		if (!command.hasSecondWord()) {
			guiController.appendConsoleText("\nUse what?");
			return;
		}

		String itemString = command.getSecondWord();
		ObstacleEnum obstacle = nextRoom.getObstacleObject();

		LOG.log(Level.DEBUG, String.format("Use the item [\"%s\"]", itemString));
		switch (obstacle) {
			case MONSTER:
				if (itemString.equalsIgnoreCase(ItemEnum.SWORD.getItem())) {
					itemController.removeFromInventory(ItemEnum.SWORD);
					guiController.appendConsoleText("\nYou've defeat the monster!");
					overcomeObstacle(obstacle);
				} else {
					guiController.appendConsoleText("\nYou need a sword to defeat the monster!");
				}
				break;

			case WILD_POKEMON:
				if (itemString.equalsIgnoreCase(ItemEnum.PIKACHU.getItem())) {
					itemController.removeFromInventory(ItemEnum.PIKACHU);
					guiController.appendConsoleText("\nYou've defeat the wild pokemon!");
					overcomeObstacle(obstacle);
				} else {
					guiController.appendConsoleText("\nYou need Pikachu to defeat this Pokemon!");
				}
				break;

			case ANGRY_DOG:
				if (itemString.equalsIgnoreCase(ItemEnum.BONE.getItem())) {
					itemController.removeFromInventory(ItemEnum.BONE);
					guiController.appendConsoleText("\nYou've calmed the angry dog!");
					overcomeObstacle(obstacle);
				} else {
					guiController.appendConsoleText("\nYou need a bone to calm the dog!");
				}
				break;

			case CLOSED_DOOR:
				if (itemString.equalsIgnoreCase(ItemEnum.KEY.getItem())) {
					itemController.removeFromInventory(ItemEnum.KEY);
					guiController.appendConsoleText("\nYou opened the door!");
					overcomeObstacle(obstacle);
				} else {
					guiController.appendConsoleText("\nYou need a key to open this door!");
				}
				break;

			default:
				guiController.appendConsoleText("\nThe way is free!");
				break;
		}

	}

	/*
	 * Logic to run when an obstacle has overcome
	 */
	private void overcomeObstacle(ObstacleEnum obstacle) {
		nextRoom.setObstacleObject(ObstacleEnum.NONE);
		nextRoom();
	}

	private void nextRoom() {
		currentRoom = nextRoom;
		look();
	}

	/*
	 * Go to another room or face another obstacle
	 */
	private void goRoom(Command command) {
		if (!command.hasSecondWord()) {
			guiController.appendConsoleText("\nGo where?");
			return;
		}

		String direction = command.getSecondWord();

		nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null) { // wrong direction or spelling error
			guiController.appendConsoleText("\nThere's no way!");
		} else if (nextRoom == finalRoom) {
			LOG.log(Level.DEBUG, "Print found exit");
			printEnteredFinalRoom(false);
		} else if (nextRoom == secretElevator) {
			guiController.appendConsoleText("\nOn which floor the game has started? ");
			guiController.appendConsoleText("\nYou only have one chance! Otherwise, the building explodes");
			guiController.appendConsoleText("\nand you lose the game! Good luck :)");

			boolean result = checkPin();
			if (result) {
				guiController.appendConsoleText("\nThe elevator works!");
				if (nextRoom == null) {
					guiController.appendConsoleText("\nThere's no way!");
				} else {
					currentRoom = nextRoom;
					look();
				}
			} else {
				loseGame();
			}
		} else if (nextRoom == secretFinalRoom) {
			LOG.log(Level.DEBUG, "Print found secret exit");
			printEnteredFinalRoom(true);
		} else if (nextRoom.getObstacleObject() != ObstacleEnum.NONE) {

			ObstacleEnum obstacle = nextRoom.getObstacleObject();
			guiController.appendConsoleText(
					String.format("\nPassage impossible. Something is in the way: %s", obstacle.getObstacle()));

			switch (obstacle) {
				case MONSTER:
				case WILD_POKEMON:
				case CLOSED_DOOR:
				case ANGRY_DOG:
					guiController.appendConsoleText(String.format("\n%s", obstacle.getSolution()));
					break;

				default:
					loseGame();
					break;
			}
		} else {
			nextRoom();
		}

	}

	private boolean checkPin() {
		return "9".equals(guiController.getPin().trim());
	}

	private void loseGame() {
		guiController.appendConsoleText("\n\n************************************************************\n");
		guiController.appendConsoleText("************************************************************\n");
		guiController.appendConsoleText("***              Y O U ' V E      L O S T !              ***\n");
		guiController.appendConsoleText("************************************************************\n");
		guiController.appendConsoleText("************************************************************\n");
		guiController.gameEnd();
	}

	private void printEnteredFinalRoom(boolean wasSecretFinal) {
		guiController.appendConsoleText("\n\n************************************************************\n");
		guiController.appendConsoleText("************************************************************\n");
		guiController.appendConsoleText("***       You've really made it! CONGRATULATE !!         ***\n");
		guiController.appendConsoleText("***       Unfortunately the game is over...              ***\n");
		if (wasSecretFinal) {
			guiController.appendConsoleText("***       P.S. Nice that you have found the secret exit! ***\n");
		}
		guiController.appendConsoleText("************************************************************\n");
		guiController.appendConsoleText("************************************************************\n");
		guiController.gameEnd();
	}

	/**
	 * Process the command
	 */
	public boolean processCommand(Command command) {
		boolean wantToQuit = false;

		if (!command.hasActionWord()) {
			guiController.appendConsoleText("\nI don't understand you...");
			return false;
		}

		// null or valid action word
		String actionWordString = command.getActionWord();

		if (actionWordString == null) {
			return false;
		} else {

			ActionWordEnum actionWord = ActionWordEnum.getEnumByString(actionWordString);
			if (actionWord == null) {
				guiController.appendConsoleText("\nI don't understand you...");
				return false;
			}

			switch (actionWord) {
				case HELP:
					printHelp();
					break;
				case GO:
					goRoom(command);
					break;
				case SEARCH_ITEM:
					showItem();
					break;
				case SHOW_ITEMS:
					listItem();
					break;
				case USE:
					use(command);
					break;
				case QUIT:
					wantToQuit = quit(command);
					break;
				case LOOK:
					look();
					break;
			}
		}

		return wantToQuit;
	}

	/*
	 * Create all rooms and build them together. Set all special rooms and the
	 * start room.
	 */
	private void createRooms() {

		LOG.log(Level.DEBUG, "Prepare rooms");

		/*
		 * Declare all rooms.
		 */

		// EG
		Room exit = new Room("YOU DID IT! You survived.", ItemEnum.NONE, ObstacleEnum.NONE);
		Room reception = new Room("It is becoming brighter. You've reached the reception.", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room toilet = new Room("You are at the haunted toilet", ItemEnum.NONE, ObstacleEnum.NONE);
		Room kiosk = new Room("You are at the kiosk!", ItemEnum.NONE, ObstacleEnum.NONE);
		Room storageRoom = new Room("You are in the storage room", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		toilet.addExit(WEST, storageRoom);

		storageRoom.addExit(EAST, toilet);
		storageRoom.addExit(NORTH, reception);

		reception.addExit(SOUTH, storageRoom);
		reception.addExit(EAST, toilet);
		reception.addExit(NORTH, kiosk);

		kiosk.addExit(EAST, exit);
		kiosk.addExit(SOUTH, reception);
		kiosk.addExit(WEST, toilet);

		// first floor
		Room corridor1 = new Room("You are in the corridor of the first floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office11 = new Room("You are in the office 1.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office12 = new Room("You are in the office 1.2", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office17 = new Room("You are in the office 1.7. Where are the rest of the office?", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room printerRoom11 = new Room("You found the printer room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room elevator = new Room("The elevator starts.", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		corridor1.addExit(SOUTH, office12);
		corridor1.addExit(NORTH, office11);
		corridor1.addExit(EAST, office17);

		office11.addExit(SOUTH, corridor1);
		office12.addExit(NORTH, corridor1);
		office17.addExit(WEST, corridor1);
		office17.addExit(NORTH, printerRoom11);

		printerRoom11.addExit(SOUTH, office17);
		printerRoom11.addExit(EAST, elevator);

		elevator.addExit(DOWN, storageRoom);

		// second floor
		Room corridor2 = new Room("You are in the corridor of the second floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room meetingRoom21 = new Room("You are in a meeting room 2.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room lounge = new Room("You are in the lounge. Why do not a short break?!", ItemEnum.NONE, ObstacleEnum.NONE);
		Room securityRoom = new Room("You made it in the security room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room nataschasOffice = new Room("You are in Nataschas office", ItemEnum.NONE, ObstacleEnum.NONE);
		Room rolfsOffice = new Room("You are in Rolfs office", ItemEnum.NONE, ObstacleEnum.NONE);
		Room toilet22 = new Room("You've landed in a smelly toilet 2.2", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		office12.addExit(UP, meetingRoom21); // first floor

		toilet22.addExit(NORTH, lounge);

		meetingRoom21.addExit(DOWN, office12);
		meetingRoom21.addExit(WEST, securityRoom);

		securityRoom.addExit(EAST, meetingRoom21);
		securityRoom.addExit(NORTH, corridor2);

		lounge.addExit(SOUTH, toilet22);
		lounge.addExit(EAST, corridor2);

		rolfsOffice.addExit(WEST, corridor2);
		nataschasOffice.addExit(SOUTH, corridor2);

		corridor2.addExit(SOUTH, securityRoom);
		corridor2.addExit(WEST, lounge);
		corridor2.addExit(EAST, rolfsOffice);
		corridor2.addExit(NORTH, nataschasOffice);

		// third floor
		Room corridor3 = new Room("You are in the corridor of the third floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room meetingRoom31 = new Room("You are in the meeting room 3.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room nextRoom = new Room("You are in the next room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room breakRoom32 = new Room("You are in the break room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room emergencyStairwell = new Room("You have reached the emergency stairwell", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room serverRoom = new Room("You are in the server room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room computerRoom = new Room("You are in the computer room", ItemEnum.NONE, ObstacleEnum.CLOSED_DOOR);
		Room secetariat = new Room("You're at the Secretariat", ItemEnum.NONE, ObstacleEnum.NONE);
		Room toilet33 = new Room("You are at the toilet 3.3", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		toilet22.addExit(UP, emergencyStairwell); // second floor

		emergencyStairwell.addExit(DOWN, toilet22);
		emergencyStairwell.addExit(SOUTH, serverRoom);

		serverRoom.addExit(NORTH, emergencyStairwell);
		serverRoom.addExit(WEST, computerRoom);

		computerRoom.addExit(EAST, serverRoom);
		computerRoom.addExit(WEST, corridor3);

		corridor3.addExit(EAST, computerRoom);
		corridor3.addExit(WEST, meetingRoom31);
		corridor3.addExit(SOUTH, secetariat);
		corridor3.addExit(NORTH, breakRoom32);

		meetingRoom31.addExit(EAST, corridor3);
		meetingRoom31.addExit(NORTH, nextRoom);

		secetariat.addExit(NORTH, corridor3);
		secetariat.addExit(EAST, toilet33);

		breakRoom32.addExit(SOUTH, corridor3);

		nextRoom.addExit(SOUTH, meetingRoom31);

		// fourth floor
		Room corridor4 = new Room("You are in the corridor of the fourth floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office41 = new Room("You are in the office 4.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room emptyRoom = new Room("You are in the empty room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room materialRoom = new Room("You are in the material room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room chillRoom42 = new Room("You are in the chill room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room fitnessRoom = new Room("You are in the fitness room", ItemEnum.NONE, ObstacleEnum.MONSTER);
		Room janitorsRoom = new Room("You are in the janitor's room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room engineRoom43 = new Room("You are in the engine room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room toilet44 = new Room("You are at the toilet 4.4", ItemEnum.SWORD, ObstacleEnum.NONE);

		// exits
		nextRoom.addExit(UP, office41); // third floor

		office41.addExit(DOWN, nextRoom);
		office41.addExit(SOUTH, fitnessRoom);

		fitnessRoom.addExit(NORTH, office41);
		fitnessRoom.addExit(WEST, chillRoom42);

		chillRoom42.addExit(EAST, fitnessRoom);
		chillRoom42.addExit(WEST, materialRoom);
		chillRoom42.addExit(NORTH, corridor4);
		chillRoom42.addExit(SOUTH, janitorsRoom);

		materialRoom.addExit(EAST, chillRoom42);
		materialRoom.addExit(NORTH, emptyRoom);
		materialRoom.addExit(SOUTH, engineRoom43);

		corridor4.addExit(SOUTH, chillRoom42);
		corridor4.addExit(WEST, emptyRoom);

		emptyRoom.addExit(EAST, corridor4);
		emptyRoom.addExit(SOUTH, materialRoom);

		toilet44.addExit(WEST, janitorsRoom);

		janitorsRoom.addExit(EAST, toilet44);
		janitorsRoom.addExit(NORTH, chillRoom42);
		janitorsRoom.addExit(WEST, engineRoom43);

		engineRoom43.addExit(EAST, janitorsRoom);
		engineRoom43.addExit(NORTH, materialRoom);

		// fifth floor
		Room corridor5 = new Room("You are in the corridor of the fifth floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office51 = new Room("You are in the office 5.1 ", ItemEnum.NONE, ObstacleEnum.NONE);
		Room kitchen = new Room("You are in the kitchen. Sorry, NONE to eat", ItemEnum.NONE, ObstacleEnum.NONE);
		Room foodStorageRoom = new Room("You are in the food storage. It has only rotten meat", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room diningRoom = new Room("You are in the dining room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room managerRoom = new Room("You are in the manager room", ItemEnum.NONE, ObstacleEnum.WILD_POKEMON);
		Room classRoom52 = new Room("You are in the classroom of apprentices", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		engineRoom43.addExit(UP, kitchen); // fourth floor

		kitchen.addExit(DOWN, engineRoom43);
		kitchen.addExit(SOUTH, managerRoom);

		managerRoom.addExit(NORTH, kitchen);
		managerRoom.addExit(EAST, corridor5);

		corridor5.addExit(WEST, managerRoom);
		corridor5.addExit(NORTH, office51);
		corridor5.addExit(SOUTH, classRoom52);
		corridor5.addExit(EAST, diningRoom);

		office51.addExit(SOUTH, corridor5);

		classRoom52.addExit(NORTH, corridor5);

		diningRoom.addExit(WEST, corridor5);
		diningRoom.addExit(NORTH, foodStorageRoom);

		foodStorageRoom.addExit(SOUTH, diningRoom);

		// sixth floor
		Room corridor6 = new Room("You are in the corridor of the sixth floor", ItemEnum.NONE, ObstacleEnum.ANGRY_DOG);
		Room printerRoom61 = new Room("You found the printer room 6.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office62 = new Room("You are in the office 6.2", ItemEnum.NONE, ObstacleEnum.NONE);
		Room nextOffice = new Room("You are in the next office", ItemEnum.NONE, ObstacleEnum.NONE);
		Room learnlounge = new Room("You are in the learning lounge", ItemEnum.NONE, ObstacleEnum.NONE);
		Room library = new Room("You are in a boring Library", ItemEnum.NONE, ObstacleEnum.NONE);
		Room classRoom63 = new Room("You are in the classroom interns", ItemEnum.KEY, ObstacleEnum.NONE);

		// exits
		foodStorageRoom.addExit(UP, printerRoom61); // fifth floor

		printerRoom61.addExit(DOWN, foodStorageRoom);
		printerRoom61.addExit(SOUTH, office62);

		office62.addExit(NORTH, printerRoom61);
		office62.addExit(EAST, nextOffice);
		office62.addExit(SOUTH, corridor6);

		nextOffice.addExit(WEST, office62);
		nextOffice.addExit(EAST, classRoom63);

		corridor6.addExit(NORTH, office62);
		corridor6.addExit(EAST, learnlounge);

		classRoom63.addExit(WEST, nextOffice);

		learnlounge.addExit(WEST, corridor6);
		learnlounge.addExit(SOUTH, library);

		library.addExit(NORTH, learnlounge);

		// seventh floor
		Room corridor7 = new Room("You are in the corridor of the seventh floor", ItemEnum.BONE, ObstacleEnum.NONE);
		Room logisticRoom = new Room("You are in the logistic room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office71 = new Room("You are in the office 7.1", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		library.addExit(UP, logisticRoom); // sixth floor

		logisticRoom.addExit(DOWN, library);
		logisticRoom.addExit(SOUTH, corridor7);

		corridor7.addExit(NORTH, logisticRoom);
		corridor7.addExit(EAST, office71);

		office71.addExit(WEST, corridor7);

		// eighth floor
		Room corridor8 = new Room("You are in the corridor of the eighth floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office81 = new Room("You are in the office 8.1", ItemEnum.NONE, ObstacleEnum.NONE);
		Room office82 = new Room("You are in the office 8.2", ItemEnum.NONE, ObstacleEnum.NONE);
		Room breakRoom83 = new Room("You are in the break room", ItemEnum.PIKACHU, ObstacleEnum.NONE);
		Room adminRoom = new Room("You are in the administrator room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room floormanagerOffice = new Room("You are in the floor manager office", ItemEnum.NONE, ObstacleEnum.NONE);
		Room itRoom = new Room("You are in the IT room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room engineRoom84 = new Room("You are in the engine room", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		office71.addExit(UP, engineRoom84); // seventh floor

		engineRoom84.addExit(DOWN, office71);
		engineRoom84.addExit(NORTH, itRoom);

		itRoom.addExit(SOUTH, engineRoom84);
		itRoom.addExit(WEST, corridor8);

		corridor8.addExit(EAST, itRoom);
		corridor8.addExit(NORTH, office81);
		corridor8.addExit(WEST, floormanagerOffice);

		office81.addExit(SOUTH, corridor8);
		office81.addExit(NORTH, adminRoom);
		office81.addExit(WEST, breakRoom83);

		floormanagerOffice.addExit(EAST, corridor8);
		floormanagerOffice.addExit(NORTH, breakRoom83);

		adminRoom.addExit(SOUTH, office81);
		adminRoom.addExit(WEST, office82);

		breakRoom83.addExit(EAST, office81);
		breakRoom83.addExit(SOUTH, floormanagerOffice);

		office82.addExit(EAST, adminRoom);

		// ninth floor
		Room corridor9 = new Room("You are in the corridor of the ninth floor", ItemEnum.NONE, ObstacleEnum.NONE);
		Room gameRoom = new Room("You are in a giant game room", ItemEnum.NONE, ObstacleEnum.NONE);
		Room bigbossOffice = new Room("You are in the magnificent office from the Boss Piri", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room bigbossOffice2 = new Room("You are in the magnificent office from the Big Boss Leo", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room kebabShop = new Room("You are in the kebab shop.\n Unfortunately, it has only Falaffel", ItemEnum.NONE,
				ObstacleEnum.NONE);
		Room homeTheater = new Room("You are in a huge home theater", ItemEnum.NONE, ObstacleEnum.NONE);
		Room chilllounge = new Room("You are in the Chill Lounge", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		office82.addExit(UP, chilllounge); // eighth floor

		chilllounge.addExit(DOWN, office82);
		chilllounge.addExit(WEST, homeTheater);

		homeTheater.addExit(EAST, chilllounge);
		homeTheater.addExit(NORTH, corridor9);

		corridor9.addExit(SOUTH, homeTheater);
		corridor9.addExit(NORTH, bigbossOffice);
		corridor9.addExit(EAST, bigbossOffice2);
		corridor9.addExit(WEST, gameRoom);

		bigbossOffice.addExit(SOUTH, corridor9);

		bigbossOffice2.addExit(WEST, corridor9);

		gameRoom.addExit(EAST, corridor9);
		gameRoom.addExit(SOUTH, kebabShop);

		kebabShop.addExit(NORTH, gameRoom);

		// roof
		Room landingPad = new Room("You are on a helicopter landing pad", ItemEnum.NONE, ObstacleEnum.NONE);

		// exits
		kebabShop.addExit(UP, landingPad); // ninth floor

		// Declare start room and special rooms
		currentRoom = bigbossOffice2;
		secretElevator = elevator;
		secretFinalRoom = landingPad;
		finalRoom = exit;
	}

}
