package com.lmsoft.game.thelost.controller;

import java.util.ArrayList;
import java.util.List;

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

	private List<ItemEnum> inventory;

	/**
	 * Default constructor.<br/>
	 */
	public ItemController() {
		super();
		inventory = new ArrayList<>();
	}

	/**
	 * Adds an item to the inventory
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void putToInventory(ItemEnum item) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format("Found the item [\"%s\"]", item.getItem()));
		}
		inventory.add(item);
	}

	/**
	 * Removes an item from inventory
	 * 
	 * @param name
	 *            {@link String}
	 */
	public void removeFromInventory(ItemEnum item) {
		if (LOG.isDebugEnabled()) {
			LOG.debug(String.format("Remove item [\"%s\"]", item.getItem()));
		}
		inventory.remove(item);
	}

	/**
	 * Returns all found items
	 * 
	 * @return {@link String}
	 */
	public String getItemsAsString() {
		String result = "";

		for (ItemEnum itemEnum : inventory) {
			if (inventory.size() > 1) {
				result = String.format("%s, %s", itemEnum.getItem(), result);
			} else {
				result = itemEnum.getItem();
			}
		}

		return result;
	}

}
