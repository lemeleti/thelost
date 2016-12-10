package com.lmsoft.game.thelost.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lmsoft.game.thelost.model.ItemEnum;

/**
 * Controller class of the items.
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public class ItemController {

	private final static Logger LOG = LogManager.getLogger(ItemController.class);

	private Map<ItemEnum, Boolean> inventar;

	/**
	 * Default constructor.<br/>
	 */
	public ItemController() {
		super();
		inventar = new HashMap<>();
	}

	/**
	 * Sets the found item to status found
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void putToInventar(ItemEnum item) {
		LOG.log(Level.DEBUG, "Found the item [\"%s\"]", item.getItem());
		inventar.put(item, true);
	}

	/**
	 * Returns all found items
	 * 
	 * @return {@link String}
	 */
	public String getItemsAsString() {
		String result = "";

		for (Map.Entry<ItemEnum, Boolean> entry : inventar.entrySet()) {
			if (entry.getValue()) {
				result = String.format("%s, %s", entry.getKey().getItem(), result);
			}
		}

		return result;
	}

}
