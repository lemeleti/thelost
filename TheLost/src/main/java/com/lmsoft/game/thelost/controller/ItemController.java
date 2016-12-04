package com.lmsoft.game.thelost.controller;

import java.util.HashMap;
import java.util.Map;

import com.lmsoft.game.thelost.model.ItemEnum;

/**
 * Controller class of the items.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class ItemController {

	private Map<String, Boolean> items;

	/**
	 * Default constructor.<br/>
	 */
	public ItemController() {
		super();
		items = new HashMap<>();
	}

	/**
	 * Adds an item with default status not found.
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void addItem(ItemEnum item) {
		items.put(item.getItem(), false);
	}

	/**
	 * Sets the found item to status found
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void setItemFound(ItemEnum item) {
		items.put(item.getItem(), true);
	}

	/**
	 * Returns all found items
	 * 
	 * @return {@link String}
	 */
	public String getItemsAsString() {
		String result = "";

		for (Object o : items.keySet().toArray()) {
			if (items.get(o)) {
				result = String.format("%s, %s", o, result);
			}
		}

		return result;
	}

}
