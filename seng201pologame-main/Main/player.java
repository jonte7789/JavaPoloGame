package Main;

import java.util.ArrayList;

public class player {
	
	
	/** THIS IS A TEST COMMENT */
		
	
	/** declare variables used in class player */
	private String name;
	private Integer stamina;
	private Integer defence;
	private Integer offence;
	private Integer value;

	boolean has_ball;
	boolean is_injured;
	ArrayList<consumable> inventory = new ArrayList<consumable>();
	
	/** default constructor */
	player(){
		
	}
	/** detailed constructor */
	player(String name, Integer offence, Integer defence, Integer value) {
		this.name = name;
		this.stamina = 10;
		this.offence = offence;
		this.defence = defence;
		this.value = value;
	}
	
	/** function to return name of the player */
	String get_name() {
		return this.name;
	}
	/** function to set the name of the player */
	void set_name(String new_name) {
		this.name = new_name;
	}
	/** function to return stamina of the player */
	Integer get_stamina() {
		return this.stamina;
	}
	/** function to set the stamina of the player */
	void set_stamina(Integer new_stamina) {
		this.stamina = new_stamina;
	}
	/** function to return the defence of the player */
	Integer get_defence() {
		return this.defence;
	}
	/** function to set the defence of the player */
	void set_defence(Integer new_defence) {
		this.defence = new_defence;
	}
	/** function to return the offence of the player */
	Integer get_offence() {
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
	
	
	
	
}
