package Main;

import java.util.Random;

/**
 * Handler class, useful for handling functions such as shoot and pass, create instance of this class within game to compare 
 * stats and then set score accordingly
 * 
 * */
public class handler {
	
	/** passes in two players.
	 * Compares player 1 stats (player shooting), with player 2 stats (player defending) 
	 * returns true if a goal is scored, else returns false
	 * 
	 * 3 scenarios:
	 *  player 1 has greater chance of scoring if their offence is greater than the defending player's defence
	 *  player 1 has less chance of scoring if their offence stat is lower than the defending player's defence stat
	 *  player 1 has a 50% chance of scoring if their offence stat is equal to the defender's defence stat
	 * 
	 * */
	public boolean shoot(player player1, player player2) {
		
		if (player1.get_stamina() == 0) {
			
			return false;
		}
		
		int stat_dif = 0;
		
		player1.set_stamina(player1.get_stamina() - 2);

		if (player1.get_offence() < player2.get_defence()) {
			stat_dif = player2.get_defence() - player1.get_offence();
			
			Random random = new Random();
			if (random.nextInt(2+stat_dif) == 0) {
				return true;
			}
			
			else if(random.nextInt(2+ stat_dif) >= 1) {
				return false;
			}
			return false;

		}
		else if (player1.get_offence() == player2.get_defence()){
			Random random = new Random();
		
			if (random.nextInt(2) == 0) {
				return false;
			}
			
			else if(random.nextInt(2) == 1) {
				return true;
			}
			return false;
		}
		else {
			stat_dif = player1.get_offence() - player2.get_defence();
			Random random = new Random();
			if (random.nextInt(2+stat_dif) == 0) {
				return false;
			}
			
			else if(random.nextInt(2+ stat_dif) >= 1) {
				return true;
			}
			return false;
		}
		

				
	}

	/** pass the ball from player 1 to player 2
	 * uses set_ball function to change ball status of the player
	 * */
	public void pass(player player1, player player2) {
				
		player1.set_ball(false);
		player2.set_ball(true);
	}

	
	public static void main(String args[]) {
	}

}
