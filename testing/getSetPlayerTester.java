package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.player;

class getSetPlayerTester {
		
	/**Test Group 1: Getting Names by testing get functions*/
	
	@Test
	public void getNameTest1() {
		player testPlayer = new player("tyrone", 2, 5, 100);
		assertEquals("tyrone",testPlayer.get_name());

	}
	
	@Test
	public void getNameTest2() {
		player testPlayer = new player("J-t", 8, 7, 87);
		assertEquals("J-t",testPlayer.get_name());

	}
	
	@Test
	public void getNameTest3() {
		player testPlayer = new player("BOB", 3, 2, 50);
		assertEquals("BOB",testPlayer.get_name());

	}
	
	/**Test Group 2: Set name function and checking with get */
	
	@Test
	public void setNameTest1() {
		player testPlayer = new player("tyrone", 2, 5, 100);
		assertEquals("tyrone",testPlayer.get_name());
		testPlayer.set_name("bob");
		assertEquals("bob",testPlayer.get_name());
		
	}
	
	@Test
	public void setNameTest2() {
		player testPlayer = new player("J-t", 8, 7, 87);
		assertEquals("J-t",testPlayer.get_name());
		testPlayer.set_name("James");
		assertEquals("James",testPlayer.get_name());
		
	}
	
	@Test
	public void setNameTest3() {
		player testPlayer = new player("BOB", 3, 2, 50);
		assertEquals("BOB",testPlayer.get_name());
		testPlayer.set_name("a-n-d-y");
		assertEquals("a-n-d-y",testPlayer.get_name());
	}
}
