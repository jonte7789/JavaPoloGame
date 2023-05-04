package Main;

import java.util.ArrayList;

public class team {

	
	
	ArrayList<player> team = new ArrayList<player>();
	ArrayList<player> reserve = new ArrayList<player>();
	Integer money;
	Integer score;
	Integer points;
	String name;
	
	team(){
		this.score = 0;
		this.points = 0;
	}
	
	team(Integer money, String name){
		this.score = 0;
		this.points = 0;
		this.money = money;
		this.name = name;
	}
	
	team(ArrayList<player> players, Integer money, String name) {
		/** add players to the team and reserve */
		for (int i = 0; i < players.size(); i++) {
			this.add_player(players.get(i));
			this.money = money;
			this.name = name;
			this.score = 0;
			this.points = 0;
		}
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
	 * are in team or reserve
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
		
//		team team1 = new team();
//		player player1 = new player();
//		player1.set_name("jason");
//		player player2 = new player();
//		player2.set_name("mike");
//		player player3 = new player();
//		player3.set_name("barry");
//		player player4 = new player();
//		player4.set_name("toby");
//		player player5 = new player();
//		player5.set_name("james");
//		team1.add_player(player1);
//		team1.add_player(player2);
//		team1.add_player(player3);
//		team1.add_player(player4);
//		team1.add_player(player5);
//		
//		System.out.println(team1.team.get(3).get_name());
//		System.out.println(team1.reserve.get(0).get_name());
//		
//		team1.remove_player(player3);
//		System.out.println(team1.team.size());
//		
//		team1.switch_players(player1, player2);
//		System.out.println(team1.team.get(0).get_name());
//		System.out.println(team1.team.get(1).get_name());
//		
//		team1.switch_players(player1, player5);
//		System.out.println(team1.reserve.get(0).get_name());
//		System.out.println(team1.team.get(1).get_name());
		
		
		
	}

}