package com.lmsoft.game.thelost.model;

/**
 * Enum of all obstacles
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ObstacleEnum {

	NOTHING("nothing", "nothing"),

	MONSTER("Monster", "You need a sword to defeat it!"),

	POKEMON("Pokemon", "Find Pikachu! He will help you.."),

	DOOR("Closed door", "Find the key!"),

	ANGRY_DOG("Angry dog", "Find a bone!");

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
