package com.lmsoft.game.thelost.model;

/**
 * Enum of all obstacles
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ObstacleEnum {

	NONE("none", "\nnone"),

	MONSTER("monster", "\nYou need a sword to defeat it!"),

	WILD_POKEMON("pokemon", "\nFind pikachu! He will help you.."),

	CLOSED_DOOR("closed door", "\nFind the key!"),

	ANGRY_DOG("angry dog", "\nFind a bone!");

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
