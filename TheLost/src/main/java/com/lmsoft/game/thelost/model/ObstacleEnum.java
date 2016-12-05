package com.lmsoft.game.thelost.model;

/**
 * Enum of all obstacles
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ObstacleEnum {

	NONE("none", "\nnone"),

	MONSTER("Monster", "\nYou need a sword to defeat it!"),

	WILD_POKEMON("Pokemon", "\nFind Pikachu! He will help you.."),

	CLOSED_DOOR("Closed door", "\nFind the key!"),

	ANGRY_DOG("Angry dog", "\nFind a bone!");

	private final String obstacle;

	private final String solution;

	private ObstacleEnum(String obstacle, String solution) {
		this.obstacle = obstacle;
		this.solution = solution;
	}

	/**
	 * Getter - Method
	 * 
	 * @return obstacle
	 */
	public String getObstacle() {
		return obstacle;
	}

	/**
	 * Getter - Method
	 * 
	 * @return solution
	 */
	public String getSolution() {
		return solution;
	}

}
