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

	private Map<ObstacleEnum, Boolean> obstacles;

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
		obstacles.put(obstacle, false);
	}

	/**
	 * Sets the found obstacle to status found
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void setObstacleFound(ObstacleEnum obstacle) {
		obstacles.put(obstacle, true);
	}

	/**
	 * Returns all found obstacles
	 * 
	 * @return {@link String}
	 */
	public String getObstaclesAsString() {
		String result = "";

		for (Map.Entry<ObstacleEnum, Boolean> entry : obstacles.entrySet()) {
			if (entry.getValue()) {
				result = String.format("%s, %s", entry.getKey().getObstacle(), result);
			}
		}

		return result;
	}
}
