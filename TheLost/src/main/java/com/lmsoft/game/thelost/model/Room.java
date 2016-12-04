package com.lmsoft.game.thelost.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lmsoft.game.thelost.controller.ItemController;

/**
 * Model class for a room.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class Room {

	private String description;

	private Map<String, Room> exits;

	private String item;

	private String obstacle;

	/**
	 * Default constructor. <br/>
	 * Create a room.<br/>
	 * Initially, it has no exits.
	 * 
	 * @param description
	 *            is a {@link String} and describes the room like "kitchen" or
	 *            "my office"
	 * @param item
	 *            is an {@link ItemController} which is in this room
	 * @param obstacle
	 *            is a {@link String} and describes
	 */
	public Room(String description, String item, String obstacle) {
		super();
		this.description = description;
		this.item = item;
		this.obstacle = obstacle;
		exits = new HashMap<>();
	}

	/**
	 * Adds a new exit.<br/>
	 * If a direction was already set, it'll be overwritten.
	 * 
	 * @param exits
	 */
	public void addExit(DirectionEnum direction, Room exit) {
		exits.put(direction.getDirection(), exit);
	}

	/**
	 * Return the description of the room and the possible exits.
	 * 
	 * @return {@link String}
	 */
	public String getLongDescription() {
		return String.format("%s.\n%s", getDescription(), getExitsAsString());
	}

	private String getExitsAsString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Durchgänge:");

		Set<String> key = exits.keySet();
		for (String exit : key) {
			buffer.append(String.format(" %s,", exit));
		}

		int lastComma = buffer.lastIndexOf(";");
		buffer.delete(lastComma, lastComma);

		return buffer.toString();
	}

	/**
	 * Getter - Method
	 * 
	 * @return exit
	 */
	public Room getExit(DirectionEnum direction) {
		return exits.get(direction);
	}

	/**
	 * Getter - Method
	 * 
	 * @return description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Getter - Method
	 * 
	 * @return item
	 */
	public String getItem() {
		return item;
	}

	/**
	 * Setter - Method
	 * 
	 * @param item
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * Getter - Method
	 * 
	 * @return item
	 */
	public String obstacle() {
		return obstacle;
	}

	/**
	 * Setter - Method
	 * 
	 * @param obstacle
	 */
	public void setobstacle(String obstacle) {
		this.obstacle = obstacle;
	}

}
