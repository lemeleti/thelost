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

	private Map<ItemEnum, Boolean> items;

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
		items.put(item, false);
	}

	/**
	 * Sets the found item to status found
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void setItemFound(ItemEnum item) {
		items.put(item, true);
	}

	/**
	 * Returns all found items
	 * 
	 * @return {@link String}
	 */
	public String getItemsAsString() {
		String result = "";

		for (Map.Entry<ItemEnum, Boolean> entry : items.entrySet()) {
			if (entry.getValue()) {
				result = String.format("%s, %s", entry.getKey().getItem(), result);
			}
		}

		return result;
	}

}
