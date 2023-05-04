package Main;

import java.util.Random;

public class handler {
	
	/** to be implemented */
	boolean shoot(player player1, player player2) {
		System.out.println("Player 1 Stats: \n"+"Stamina: " +player1.get_stamina()+"\n"
		+"Offence: " +player1.get_offence()+"\n"+"Defence: " +player1.get_defence()+"\n");
		
		System.out.println("Player 2 Stats: \n"+"Stamina: " +player2.get_stamina()+"\n"
				+"Offence: " +player2.get_offence()+"\n"+"Defence: " +player2.get_defence()+"\n");
		
		int stat_dif = 0;
		if (player1.get_offence() <= player2.get_defence()) {
			stat_dif = player2.get_defence() - player1.get_offence();
			System.out.println("You are at an disadvantage by "+stat_dif+" points!");	
			Random random = new Random();
			if (random.nextInt(2+stat_dif) == 0) {
				return true;
			}
			
			else if(random.nextInt(2+ stat_dif) >= 1) {
				return false;
			}
		}
		else if (player1.get_offence() == player2.get_defence()){
			System.out.println("Stats are equal!");
			Random random = new Random();
		
			if (random.nextInt(2) == 0) {
				return false;
			}
			
			else if(random.nextInt(2) == 1) {
				return true;
			}
		}
		else {
			stat_dif = player1.get_offence() - player2.get_defence();
			System.out.println("You are at an advantage by "+stat_dif+" points!");
			Random random = new Random();
			if (random.nextInt(2+stat_dif) == 0) {
				return true;
			}
			
			else if(random.nextInt(2+ stat_dif) >= 1) {
				return false;
			}
		}
		
		return false;
		
	}
	/** drain stamina of players and switch their position on field 
	 * @return 
	 * @return */

	void switch_players(player player1, player player2) {
	
		
	}
	/** pass the ball from player 1 to player 2, simply change has ball status */
	void pass(player player1, player player2) {
		player1.has_ball = false;
		player2.has_ball = true;
	}
	/** Add consumable item to player's inventory */
	void consume(player player1, consumable item) {
		player1.inventory.add(item);
	}
	/** improve stat and remove consumable from 
	 * the players inventory
	 * */
	void improve_stat(player player1, consumable stat) {
		if (stat.stat == "stamina") {
			Integer cur = player1.get_stamina();
			cur = Math.min(10, cur + stat.increase);
			player1.set_stamina(cur);
			player1.inventory.remove(stat);
		}
		else if (stat.stat == "offence") {
			Integer cur = player1.get_offence();
			cur = Math.min(10, cur + stat.increase);
			player1.set_offence(cur);
			player1.inventory.remove(stat);
		}
		else if (stat.stat == "defence") {
			Integer cur = player1.get_defence();
			cur = Math.min(10, cur + stat.increase);
			player1.set_defence(cur);
			player1.inventory.remove(stat);
		}
		else {
			System.out.println("ERROR");
		}
	}
	
	public static void main(String args[]) {
	}

}
