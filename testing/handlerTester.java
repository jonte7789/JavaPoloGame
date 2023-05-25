package testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Main.handler;
import Main.player;

class handlerTester {
	
	/**Test Stamina Function: Testing reading correct stamina and stamina drain*/
	
	@Test
	public void getStaminaTest() {
		player testPlayer = new player("bob", 3, 5, 100);
		assertEquals(10,testPlayer.get_stamina());
		
	}
	
	@Test
	public void staminaDrainTest() {
		player testPlayer1 = new player("jerry", 1, 2, 100);
		player testPlayer2 = new player("fred", 3, 4, 100);
		handler shootObj = new handler();
		
		shootObj.shoot(testPlayer1, testPlayer2);
		assertEquals(8,testPlayer1.get_stamina());

	}
	
	/**Test Defense/Offense Function: Testing reading correct offense and defense*/

	@Test
	public void getOffenceTest() {
		player testPlayer = new player("jeff", 4, 5, 100);
		assertEquals(4,testPlayer.get_offence());
	}
	
	@Test
	public void getDefenceTest() {
		player testPlayer = new player("tom", 4, 6, 100);
		assertEquals(6,testPlayer.get_defence());
	}
	
/**Testing passing the ball too see if new player gets ball and old player doesn't*/
	
	
	@Test
	public void passBallTest() {
		player testPlayer1 = new player("joe", 1, 2, 100);
		player testPlayer2 = new player("mark", 3, 4, 100);
		
		handler passObj = new handler();
		passObj.pass(testPlayer1, testPlayer2);

		assertEquals(true, testPlayer2.has_ball());
		assertEquals(false, testPlayer1.has_ball());

	}
	
	

}
