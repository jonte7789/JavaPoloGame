package Main;

import java.util.ArrayList;

/** team class, used to build a team which contains players, 
 * split into team and reserve within the class team
 * */

public class team {

	
	/** array list of players, access via team.team */
	ArrayList<player> team = new ArrayList<player>();
	/** array list of players, access via team.reserve */
	ArrayList<player> reserve = new ArrayList<player>();
	/** store the team's money */
	Integer money;
	/** store the team's score  */
	Integer score;
	/** store the points */
	Integer points;
	/** store the team name */
	String name;
	/** store the game number */
	Integer game_number;
	
	/** create instance of team, set score, points, game_number to 0
	 * 
	 * 
	 *  */
	public team(){
		this.score = 0;
		this.points = 0;
		this.game_number = 0;
		this.team = new ArrayList<player>();
		this.reserve = new ArrayList<player>();
		
	}
	
	/** create instance of team, set score, points, game_number to 0
	 * Passes in money and name, set team money to money, and name to name
	 * 
	 *  */
	public team(Integer money, String name){
		this.score = 0;
		this.points = 0;
		this.money = money;
		this.name = name;
		this.game_number = 0;
		this.team = new ArrayList<player>();
		this.reserve = new ArrayList<player>();
	}
	
	/** create instance of team, set score, points, game_number to 0
	 * Passes in money and name, set team money to money, and name to name
	 * 
	 * passes in array list of players, add players to the team and reserve via add player function
	 * 
	 *  */
	public team(ArrayList<player> players, Integer money, String name) {
		/** add players to the team and reserve */
		for (int i = 0; i < players.size(); i++) {
			this.add_player(players.get(i));
			this.money = money;
			this.name = name;
			this.score = 0;
			this.points = 0;
			this.game_number = 0;

		}
	}
	
	/** return the game number */
	Integer get_game_number() {
		return this.game_number;
	}
	
	/** set the game number */
	void set_game_number(Integer val) {
		this.game_number = val;
	}
	
	
	/** return true if player is in team */
	boolean is_in_team(player player1) {
		if (team.contains(player1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** return true if player is in reserve */
	boolean is_in_reserve(player player1) {
		if (reserve.contains(player1)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/** switch positions in team or reserve array of players ASSUMES both players
	 * are in team or reserve.
	 * */
	void switch_players(player player1, player player2) {
		/** Check if player1 is in team */
		if (this.is_in_team(player1)) {
			Integer player1index = this.team.indexOf(player1);
			/** swap player 1 and player 2*/
			if (this.is_in_team(player2)) {
				Integer player2index = this.team.indexOf(player2);
				this.team.set(player1index, player2);
				this.team.set(player2index, player1);
			}
			else {
				Integer player2index = this.reserve.indexOf(player2);
				this.team.set(player1index, player2);
				this.reserve.set(player2index, player1);
			}
		}
		else {
			/** Assumes player 1 must be in reserve */
			Integer player1index = this.reserve.indexOf(player1);
			/** swap player 1 and player 2*/
			if (this.is_in_team(player2)) {
				Integer player2index = this.team.indexOf(player2);
				this.reserve.set(player1index, player2);
				this.team.set(player2index, player1);
			}
			else {
				Integer player2index = this.reserve.indexOf(player2);
				this.reserve.set(player1index, player2);
				this.reserve.set(player2index, player1);
			}
			
		}
		
	}
	

	
	/** return value of money team has */
	Integer get_money() {
		return this.money;
	}
	/** set value of money team has */
	void set_money(Integer new_money) {
		this.money = new_money;
	}
	/** add player to team array else add to reserves if team is full (maximum of 4 player in team and maximum of 4 players in reserve */
	void add_player(player player_to_add) {
		/** check if team array length is less than 4, if so add player to the team */
		if (this.team.size() < 4) {
			this.team.add(player_to_add);
		}
		/** check if reserve array length is less than 4, if so add player to the reserve */
		else if (this.reserve.size() < 4) {
			this.reserve.add(player_to_add);
		}
		/** Team are full, cannot add */
		else {
			System.out.println("Teams are full?");
		}
	}
	
	/** remove player from team or reserve */
	void remove_player(player player_to_remove) {
		if (this.is_in_team(player_to_remove)) {
			this.team.remove(player_to_remove);
		}
		else if (this.is_in_reserve(player_to_remove)) {
			this.reserve.remove(player_to_remove);
		}
		else {
			System.out.println("ERROR");
		}
		
	}
	/** sells player and removes them from team / reserve, add money to team from profit made from selling player */
	void selling_player(player player_to_sell) {
		/** add money to club which player is worth */
		this.money = this.money + player_to_sell.get_value();
		/** remove player from the club */
		this.remove_player(player_to_sell);
	}
	/** return the score the team has */
	Integer get_score() {
		return this.score;
	}
	/** set the score the team has */
	void set_score(Integer score_to_set) {
		this.score = score_to_set;
	}
	String get_name() {
		return this.name;
	}
	void set_name(String new_name) {
		this.name = new_name;
	}
	Integer get_points() {
		return this.points;
	}
	void set_points(Integer new_points) {
		this.points = new_points;
	}
	/* prints the team **/
    @Override
    public String toString()
    {
         String res = new String();
         for (int i = 0; i < team.size(); i++) {
        	 res += team.get(i).get_name();
        	 res += " ";
         }
         
         return res;
    }
    

	
	public static void main(String args[]) {

		
		
		
	}

}