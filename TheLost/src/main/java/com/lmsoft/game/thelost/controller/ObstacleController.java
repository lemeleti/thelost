package com.lmsoft.game.thelost.controller;

import java.util.HashMap;
import java.util.Map;

import com.lmsoft.game.thelost.model.ObstacleEnum;

/**
 * Controller class of the obstacles.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class ObstacleController {

	private Map<String, Boolean> obstacles;

	/**
	 * Default constructor.<br/>
	 */
	public ObstacleController() {
		super();
		this.obstacles = new HashMap<>();
	}

	/**
	 * Adds an obstacle with default status not found.
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void addObstacle(ObstacleEnum obstacle) {
		obstacles.put(obstacle.getObstacle(), false);
	}

	/**
	 * Sets the found obstacle to status found
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void setObstacleFound(ObstacleEnum obstacle) {
		obstacles.put(obstacle.getObstacle(), true);
	}

	/**
	 * Returns all found obstacles
	 * 
	 * @return {@link String}
	 */
	public String getObstaclesAsString() {
		String result = "";

		for (Object o : obstacles.keySet().toArray()) {
			if (obstacles.get(o)) {
				result = String.format("%s, %s", o, result);
			}
		}

		return result;
	}
}
