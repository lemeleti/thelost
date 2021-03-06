package com.lmsoft.game.thelost.model;

/**
 * Enum of all items
 * 
 * @author Leandro Meleti
 * @date created on 04.12.2016
 */
public enum ItemEnum {

	NONE("none"),

	SWORD("sword"),

	PIKACHU("pikachu"),

	KEY("key"),

	BONE("bone");

	private final String item;

	private ItemEnum(String item) {
		this.item = item;
	}

	/**
	 * Getter - Method
	 * 
	 * @return item
	 */
	public String getItem() {
		return item;
	}

}
