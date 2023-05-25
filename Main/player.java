package Main;

import java.util.ArrayList;

/** Class used to create a player, store players in class team */
public class player {
	
	
		
	
	/** name, used to set name of player */
	private String name;
	/** store integer stamina */
	private Integer stamina;
	/** store integer defence */
	private Integer defence;
	/** store integer offence */
	private Integer offence;
	/** store integer value (cost in some cases) */
	private Integer value;
	/** has ball value stored, boolean, true means player has ball, false means player doesn't have ball*/
	boolean has_ball;
	/** stores the player's injured status, false not injured, true means injured*/
	boolean is_injured;
	
	/** default constructor, no parameters */
	player(){
		
	}
	/** detailed constructor
	 * name is used to set name of player,
	 * offence parameter is used to set the offence stat of the player
	 * defence parameter is used to set the defence stat of the player
	 * value parameter is used to set the value of the player
	 *  */
	public player(String name, Integer offence, Integer defence, Integer value) {
		this.name = name;
		this.stamina = 10;
		this.offence = offence;
		this.defence = defence;
		this.value = value;
	}
	
	/** function to return name of the player */
	public String get_name() {
		return this.name;
	}
	/** function to set the name of the player */
	public void set_name(String new_name) {
		this.name = new_name;
	}
	/** function to return stamina of the player */
	public Integer get_stamina() {
		return this.stamina;
	}
	/** function to set the stamina of the player */
	void set_stamina(Integer new_stamina) {
		this.stamina = new_stamina;
	}
	/** function to return the defence of the player */
	public Integer get_defence() {
		return this.defence;
	}
	/** function to set the defence of the player */
	void set_defence(Integer new_defence) {
		this.defence = new_defence;
	}
	/** function to return the offence of the player */
	public Integer get_offence() {
		return this.offence;
	}
	/** function to set the defence of the player */
	void set_offence(Integer new_offence) {
		this.offence = new_offence;
	}
	/** get the value of the player */
	Integer get_value() {
		return this.value;
	}
	/** set value of player*/
	void set_value(Integer new_value) {
		this.value = new_value;
	}
	/** return player's has_ball status */
	public boolean has_ball() {
		return this.has_ball;
	}
	/** set player's has_ball status */
	void set_ball(boolean ball) {
		this.has_ball = ball;
	}

	
	
	
	
}
