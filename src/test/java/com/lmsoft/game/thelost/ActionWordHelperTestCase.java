package com.lmsoft.game.thelost;

import com.lmsoft.game.thelost.support.io.ActionWordEnum;
import com.lmsoft.game.thelost.support.io.ActionWordHelper;

import junit.framework.TestCase;

/**
 * Test class for {@link ActionWordHelper}
 * 
 * @author C110426
 * @date created on 10.12.2016
 */
public class ActionWordHelperTestCase extends TestCase {

	private ActionWordEnum[] values = ActionWordEnum.values();

	@Override
	protected void setUp() throws Exception {
	}

	@Override
	protected void tearDown() throws Exception {
	}

	public void testGetAllValidActionWords() {
		String allWords = ActionWordHelper.getAllValidActionWords();
		String[] wordArray = allWords.split(",");

		for (int i = 0; i < values.length; i++) {
			assertEquals(values[i].getActionWord(), wordArray[i].trim());
		}
	}

	public void testIsActionCommand() {
		for (ActionWordEnum actionWordEnum : values) {
			assertTrue(ActionWordHelper.isActionCommand(actionWordEnum.getActionWord()));
		}
	}

	public void testIsNotActionCommand() {
		assertFalse(ActionWordHelper.isActionCommand("Test"));
		assertFalse(ActionWordHelper.isActionCommand("xy"));
		assertFalse(ActionWordHelper.isActionCommand("215"));
		assertFalse(ActionWordHelper.isActionCommand("xy77"));
	}

}
