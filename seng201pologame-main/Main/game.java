package Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;  // Import the Scanner class


//TEST

public class game {
	team team1;
	team team2;
	
	
	/** need 2 teams to start a game */
	game(team team1, team team2){
		this.team1 = team1;
		this.team2 = team2;
	}
	
 	
	/** this is one round, goes for 30 seconds */
	void round(){
		/** reset ball, no one will have has_ball = true status*/
		reset_ball();
		/** giving the ball to a random player in team 1 */
		Random random = new Random();
		int position_with_ball = random.nextInt(4);
		player player_to_start_with_ball = team1.team.get(position_with_ball);
		player_to_start_with_ball.has_ball = true;
		
		

			
			/** Creates and runs this while loop for 30 seconds, each round will last 30 seconds */
			long endTime = System.currentTimeMillis() + 30000;
				while (System.currentTimeMillis() < endTime) {
					
					/** team 1 is the team the user is playing as, so they can perform the game actions in handler*/
				    if (team_with_ball() == team1) {
				    	Scanner scanner = new Scanner(System.in);

				        System.out.print("which action to perform?");
				        String input = scanner.nextLine();
				        if (System.currentTimeMillis() > endTime) {
				        	break;
				        }
				        switch(input) {
			        		/** perform pass action, to be implemented */
				        	case "pass":
				        	break;
				        	
			        		/** perform shoot action, to be implemented*/
				        	case "shoot":
				        		/** pass in the player with ball and opposition*/
				        		Integer player_with_ball = player_with_ball(team1);
				        		handler shootObj = new handler();
				        		boolean x = shootObj.shoot(team1.team.get(position_with_ball), team2.team.get(position_with_ball));
				        		/**increment score if team 1 has scored*/
				        		if (x == true) {
				        			team1.set_score(team1.get_score() + 1);
				        		}
				        		/** change ball to be in team2*/
				        		System.out.println("Team1 Score: " + team1.get_score() + "\nTeam2 Score: " + team2.get_score());
				        		set_player_with_ball(team2);
				        	break;
				 
				        	/** perform shoot action, to be implemented*/
				        	case "switch":
				        		handler switchObj = new handler();
				        		switchObj.switch_players(player_to_start_with_ball, player_to_start_with_ball);
				        	break;
				        	
				        	default:
				        	System.out.println("please enter: shoot, pass or switch: ");
				        }
				    }
				    /** team 2 must have the ball, so the computer will play a move*/
				    else {
				    	
						System.out.println("Computer's Turn!");
				    	long time_to_sleep = System.currentTimeMillis() + 2000;
						while (System.currentTimeMillis() < time_to_sleep) {
						}
						if (System.currentTimeMillis() > endTime) {
				        	break;
				        }
				    	
		        		Integer player_with_ball = player_with_ball(team2);
		        		handler shootObj = new handler();
		        		boolean x = shootObj.shoot(team2.team.get(position_with_ball), team1.team.get(position_with_ball));
		        		/**increment score if team 1 has scored*/
		        		
		        		if (x == true) {
		        			team2.set_score(team2.get_score() + 1);
		        		}
		        		System.out.println("Team1 Score: " + team1.get_score() + "\nTeam2 Score: " + team2.get_score());
		        		/** change ball to be in team2*/
		        		set_player_with_ball(team1);
				    	
				    }
	
				} 
	}
	
	/** will set all players has ball status to false */
	void reset_ball(){
		for (int i = 0; i < team1.team.size(); i++) {
			player player_to_check = team1.team.get(i);
			player_to_check.has_ball = false;
		}
		for (int i = 0; i < team2.team.size(); i++) {
			player player_to_check = team2.team.get(i);
			player_to_check.has_ball = false;
		}
	}
	
	/** returns which team has the ball, assumes that one team has the ball */
	team team_with_ball() {
		for (int i = 0; i < team1.team.size(); i++) {
			if (team1.team.get(i).has_ball == true) {
				return team1;
				}
			}
		return team2;
}
	/** returns which team has the ball, assumes that one team has the ball */
	Integer player_with_ball(team teamwithball) {
		for (int i = 0; i < teamwithball.team.size(); i++) {
			if (teamwithball.team.get(i).has_ball == true) {
				return i;
			}
		
		}
		return -1;
		}
	
	void set_player_with_ball(team team_to_gain_ball) {
		reset_ball();
		/** giving the ball to a random player in team 1 */
		Random random = new Random();
		int position_with_ball = random.nextInt(4);
		player player_to_start_with_ball = team_to_gain_ball.team.get(position_with_ball);
		player_to_start_with_ball.has_ball = true;
	}
	
	
	
	/** run 4 rounds*/
	public static void main(String args[]) {
		team team1 = new team();
		player player1 = new player("jason", 7, 3, 100);
		player player2 = new player("mike", 3, 5, 100);
		player player3 = new player("barry", 6, 1, 100);
		player player4 = new player("toby", 5, 5, 100);
		player player5 = new player("james", 9, 1, 100);
		team1.add_player(player1);
		team1.add_player(player2);
		team1.add_player(player3);
		team1.add_player(player4);
		team1.add_player(player5);
		
		team team2 = new team();
		player player11 = new player("tyrone", 2, 5, 100);
		player player22 = new player("sam", 10, 5, 100);
		player player33 = new player("dan", 7, 10, 100);
		player player44 = new player("aaa", 6, 3, 100);
		player player55 = new player("abab", 1, 4, 100);
		team2.add_player(player11);
		team2.add_player(player22);
		team2.add_player(player33);
		team2.add_player(player44);
		team2.add_player(player55);
		
		
		
		
		
		
		game test_game = new game(team1, team2);
		for (int i = 0; i < 1; i++) {
			test_game.round();
			System.out.println("ROUND OVER");
			
		}
		if (team1.get_score() > team2.get_score()) {
			System.out.println("Team1 wins");
			team1.set_points(team1.get_points() + 3);
		}
		else if (team2.get_score() > team1.get_score()) {
			System.out.println("Team2 wins");
			team2.set_points(team2.get_points() + 3);
		}
		else {
			System.out.println("Draw!");
			team1.set_points(team1.get_points() + 1);
			team2.set_points(team2.get_points() + 1);
		}
	}

}
