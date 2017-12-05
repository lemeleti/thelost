package com.lmsoft.game.thelost.model;

import java.util.EnumMap;
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

	private Map<DirectionEnum, Room> exits;

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
		exits = new EnumMap<>(DirectionEnum.class);
	}

	/**
	 * Adds a new exit.<br/>
	 * If a direction was already set, it'll be overwritten.
	 * 
	 * @param exits
	 */
	public void addExit(DirectionEnum direction, Room exit) {
		exits.put(direction, exit);
	}

	/**
	 * Return the description of the room and the possible exits.
	 * 
	 * @return {@link String}
	 */
	public String getLongDescription() {
		return String.format("%s.%n%s", getDescription(), getExitsAsString());
	}

	private String getExitsAsString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Exits:");

		Set<DirectionEnum> key = exits.keySet();
		for (DirectionEnum exit : key) {
			sb.append(String.format(" %s,", exit.getDirection()));
		}

		int lastComma = sb.lastIndexOf(",");
		sb.delete(lastComma, lastComma + 1);

		return sb.toString();
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

		if (directionString != null) {
			for (DirectionEnum direction : DirectionEnum.values()) {
				if (directionString.equalsIgnoreCase(direction.getDirection())) {
					return exits.get(direction);
				}
			}
		}

		return null;
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
	public void removeItem() {
		this.itemObject = ItemEnum.NONE;
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
