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

	private ItemEnum itemObject;

	private ObstacleEnum obstacleObject;

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
	public Room(String description, ItemEnum item, ObstacleEnum obstacle) {
		super();
		this.description = description;
		this.itemObject = item;
		this.obstacleObject = obstacle;
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
	 * @return exit
	 */
	public Room getExit(String directionString) {
		try {
			DirectionEnum direction = DirectionEnum.valueOf(directionString);
			return exits.get(direction);
		} catch (IllegalArgumentException e) {
			return null;
		}
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
	public ItemEnum getItemObject() {
		return itemObject;
	}

	/**
	 * Setter - Method
	 * 
	 * @param item
	 */
	public void setItemObject(ItemEnum item) {
		this.itemObject = item;
	}

	/**
	 * Getter - Method
	 * 
	 * @return item
	 */
	public ObstacleEnum getObstacleObject() {
		return obstacleObject;
	}

	/**
	 * Setter - Method
	 * 
	 * @param obstacle
	 */
	public void setObstacleObject(ObstacleEnum obstacle) {
		this.obstacleObject = obstacle;
	}

}
