package Main;

import java.util.Random;

/** rework of original game class so it is more suited for the GUI interactions 
 * functions include shoot, switch_player, pass, reset_ball, team_with_ball
 * set_player_with_ball, set_round_number, get_round_number, start_round, winner, computer_shoot
 * 
 * */
public class gamereworked {
	/** store round number: Integer*/
	Integer round_number;
    /**store manager as variable */
	teammanager manager;

    /** create gamereworked class, pass in manager as parameter*/
	gamereworked(teammanager manager){
		this.round_number = 1;
		this.manager = manager;
	}
	
	/** Shoot function, makes instance of handler and passes in player with the ball and the player in the opposition team who is in same position in array
	 * Then handler function compared their stats and returns a boolean, if it is true the player has scored and the team's scores are adjusted
	 * After the player has shot, the ball is given to a random player in the other team
	 * 
	 * 
	 * */
	void shoot(Integer player_with_ball) {
		handler shootObj = new handler();
		if (this.team_with_ball() == this.manager.team1) {
			boolean x = shootObj.shoot(this.manager.team1.team.get(player_with_ball), this.manager.team2.team.get(player_with_ball));
			/**increment score if team 1 has scored*/
			if (x == true) {
				this.manager.team1.set_score(this.manager.team1.get_score() + 1);
				this.manager.setGoalsScored(this.manager.getGoalsScored() + 1);
			}
			/** change ball to be in team2*/
			set_player_with_ball(this.manager.team2);
		}
		else {
			boolean x = shootObj.shoot(this.manager.team2.team.get(player_with_ball), this.manager.team1.team.get(player_with_ball));
			/**increment score if team 1 has scored*/
			if (x == true) {
				this.manager.team2.set_score(this.manager.team2.get_score() + 1);
			}
			/** change ball to be in team2*/
			set_player_with_ball(this.manager.team1);
		}



	}


	/** passes the ball from player_with_ball to player_to_pass_to */
	void pass (player player_with_ball, player player_to_pass_to) {
		handler passObj = new handler();
		passObj.pass(player_with_ball, player_to_pass_to);
	}
	
	

	/** will set all players has ball status to false */
	void reset_ball(){
		for (int i = 0; i < this.manager.team1.team.size(); i++) {
			player player_to_check = this.manager.team1.team.get(i);
			player_to_check.set_ball(false);
		}
		for (int i = 0; i < this.manager.team2.team.size(); i++) {
			player player_to_check = this.manager.team2.team.get(i);
			player_to_check.set_ball(false);
		}
	}
	
	/** returns which team has the ball, assumes that one team has the ball */
	team team_with_ball() {
		for (int i = 0; i < this.manager.team1.team.size(); i++) {
			if (this.manager.team1.team.get(i).has_ball == true) {
				return this.manager.team1;
				}
			}
		return this.manager.team2;
}
	/** returns which position on the team which has the ball, assumes that one team has the ball */
	Integer player_with_ball(team teamwithball) {
		for (int i = 0; i < teamwithball.team.size(); i++) {
			if (teamwithball.team.get(i).has_ball() == true) {
				return i;
			}
		
		}
		return -1;
		}
	
	/** takes team as parameter: sets random player in this team to have the ball*/
	void set_player_with_ball(team team_to_gain_ball) {
		reset_ball();
		if (team_to_gain_ball == this.manager.team2) {
			/** giving the ball to a random player in team 2 */
			Random random = new Random();
			int position_with_ball = random.nextInt(4);
			player player_to_start_with_ball = this.manager.team2.team.get(position_with_ball);
			player_to_start_with_ball.set_ball(true);
		}
		else {
		/** giving the ball to a random player in team 1 */
			Random random = new Random();
			int position_with_ball = random.nextInt(4);
			this.manager.team1.team.get(position_with_ball).set_ball(true);
		}
	}
	
	/** Takes integer as parameter: set round number to this integer*/
	void set_round_number(Integer round_number) {
		this.round_number = round_number;
		
	}
	/** return round number: integer: */
	Integer get_round_number() {
		return this.round_number;
	}
	
	/** start the game, reset the relative score of the teams and reset the ball and pass it to someone in team 1*/
	void start_round() {
		manager.team1.set_score(0);
		manager.team2.set_score(0);
		
		reset_ball();
		Random random = new Random();
		int position_with_ball = random.nextInt(4);
		this.manager.team1.team.get(position_with_ball).set_ball(true);
	}
	
	/** check who won, change stats accordingly, give player 250 if they win, and 100 for draw*/
	void winner(){
		if (manager.team1.get_score() >= manager.team2.get_score()) {
			manager.setGamesWon(manager.getGamesWon() + 1);
			manager.team1.set_money(manager.team1.get_money() + 250);
		}
		else if (manager.team1.get_score() < manager.team2.get_score()) {
			manager.setGamesLost(manager.getGamesLost() + 1);
		}
		else {
			manager.setGamesDrawn(manager.getGamesDrawn() + 1);
			manager.team1.set_money(manager.team1.get_money() + 100);
		}
	}
	
	/** function used by the computer, allows the computer to shoot and adjusts the computer's team's score if the computer scores.
	 * then passes the ball to team 1
	 * 
	 * */
	void computer_shoot() {

		Integer player_with_ball = player_with_ball(this.manager.team2);
		handler shootObj = new handler();
		boolean x = shootObj.shoot(this.manager.team2.team.get(player_with_ball), this.manager.team1.team.get(player_with_ball));
		if (x == true) {
			manager.team2.set_score(manager.team2.get_score() + 1);
			manager.setGoalsConceded(manager.getGoalsConceded() + 1);
		}
		set_player_with_ball(this.manager.team1);
	}
	
	
	
	
}
