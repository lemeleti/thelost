package com.lmsoft.game.thelost.model;

/**
 * Enum of possible directions
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum DirectionEnum {
	NORTH("North"),

	SOUTH("South"),

	EAST("East"),

	WEST("West"),

	UP("Up"),

	DOWN("Down");

	private final String direction;

	private DirectionEnum(String direction) {
		this.direction = direction;
	}

	/**
	 * Getter - Method
	 * 
	 * @return direction
	 */
	public String getDirection() {
		return direction;
	}

}
