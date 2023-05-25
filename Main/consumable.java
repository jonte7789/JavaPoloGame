package Main;
/** Used to create an object consumable, which is consumed by players to increase their stats  */
public class consumable {

	String name;
	String stat;
	Integer increase;
	
	/** default constructor */
	consumable(){
		
	}
	/** Constructor with variables */
	consumable(String name, String stat, Integer increase){
		this.name = name;
		this.stat = stat;
		this.increase = increase;
	}
	/** get the name of the consumable */
	String get_name() {
		return this.name;
	}
	/** set name of the consumable */
	void set_name(String new_name) {
		this.name = new_name;
	}
	/** get the stat of the consumable */
	String get_stat() {
		return this.stat;
	}
	/** set stat of the consumable */
	void set_stat(String new_stat) {
		this.stat = new_stat;
	}
	/** get the increase value of the consumable */
	Integer get_increase() {
		return this.increase;
	}
	/** set increase value of the consumable */
	void set_increase(Integer new_increase) {
		this.increase = new_increase;
	}
	
	public static void main(String args[]) {
		System.out.println("Consumable call!");

	}
	
	
}
