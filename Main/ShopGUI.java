package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;

/** ShopGUI class, displays the user's team (team and reserve) and allows them to buy consumables for their player's,
 *  buy players, sell player's and switch positions of their players
 * 
 * */
public class ShopGUI {

	private static teammanager manager;
	/** array used to keep track of who is selected */ 
	boolean[] buttonClicked = new boolean[8];
	/** array used to add player to be sold */ 
	private ArrayList<player> players = new ArrayList<player>();
	/** array used to add consumables  to be sold */ 
	private ArrayList<consumable> items = new ArrayList<consumable>();


	
	
	/** main frame for shop window */
	private JFrame shopwindow;
	
	/** player 0 team, including labels for stats, select button, and switch button */ 
	private JPanel panel;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JButton btnNewButton;
	private JButton btnSwitch;
	
	/** player 1 team, including labels for stats, select button, and switch button */ 
	private JPanel panel_1;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1_1;
	private JLabel lblNewLabel_2_1;
	private JLabel lblNewLabel_3_1;
	private JButton btnNewButton_1;
	private JButton btnSwitch_1;
	
	/** player 2 team, including labels for stats, select button, and switch button */ 
	private JPanel panel_1_1;
	private JLabel lblNewLabel_4_1;
	private JLabel lblNewLabel_1_1_1;
	private JLabel lblNewLabel_2_1_1;
	private JLabel lblNewLabel_3_1_1;
	private JButton btnNewButton_1_1;
	private JButton btnSwitch_1_1;
	
	/** player 3 team, including labels for stats, select button, and switch button */ 
	private JPanel panel_1_1_1;
	private JLabel lblNewLabel_4_1_1;
	private JLabel lblNewLabel_1_1_1_1;
	private JLabel lblNewLabel_2_1_1_1;
	private JLabel lblNewLabel_3_1_1_1;
	private JButton btnNewButton_1_1_1;
	private JButton btnSwitch_1_1_1;
	
	/** player 0 reserve, including labels for stats, select button, and switch button */ 
	private JPanel panel_2;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_2_2;
	private JLabel lblNewLabel_3_2;
	private JButton btnNewButton_2;
	private JButton btnSwitch_2;
	
	/** player 1 reserve, including labels for stats, select button, and switch button */ 
	private JPanel panel_2_1;
	private JLabel lblNewLabel_5_1;
	private JLabel lblNewLabel_1_2_1;
	private JLabel lblNewLabel_2_2_1;
	private JLabel lblNewLabel_3_2_1;
	private JButton btnNewButton_2_1;
	private JButton btnSwitch_2_1;
	
	/** player 2 reserve, including labels for stats, select button, and switch button */ 
	private JPanel panel_2_1_1;
	private JLabel lblNewLabel_5_1_1;
	private JLabel lblNewLabel_1_2_1_1;
	private JLabel lblNewLabel_2_2_1_1;
	private JLabel lblNewLabel_3_2_1_1;
	private JButton btnNewButton_2_1_1;
	private JButton btnSwitch_2_1_1;
	
	/** player 3 reserve, including labels for stats, select button, and switch button */ 
	private JPanel panel_2_1_1_1;
	private JLabel lblNewLabel_5_1_1_1;
	private JLabel lblNewLabel_1_2_1_1_1;
	private JLabel lblNewLabel_2_2_1_1_1;
	private JLabel lblNewLabel_3_2_1_1_1;
	private JButton btnNewButton_2_1_1_1;
	private JButton btnSwitch_2_1_1_1;
	private JButton btnNewButton_3;
	private JLabel lblNewLabel_14;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopGUI window = new ShopGUI(manager);

					window.shopwindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/** set the boolean array to false*/
	public void make_false() {
		Arrays.fill(buttonClicked, false);
	}
	
	/** return the position in boolean array */
	public Integer position_in_array() {
		for (int i = 0; i < buttonClicked.length; i++) {
			if (buttonClicked[i] == true) {
				return i;
			}
		}
		return -1;
	}
	
	/** return true if user is able to buy player 
	 * checks if reserve is not full and if player has enough money to buy the player, if so 
	 * decrease team1 money status by the cost of the player they are buying and adds them to the team and updates 
	 * values to show their panel
	 * */
	boolean buy_player(player player_to_buy) {
		Integer cost = player_to_buy.get_value();
		if (cost <= manager.team1.get_money() && manager.team1.reserve.size() < 4) {
			manager.team1.add_player(player_to_buy);
			manager.team1.set_money(manager.team1.get_money() - cost);
			updateValues();
			return true;
		}
		return false;
	}
	
	
	/** consume item on selected player and increase said stat,
	 * decrease team's money by the cost if they are able to purchase the item,
	 * uses math.min to set a ceiling of 10 for stats
	 * 
	 *  */
	void consume(consumable item, Integer cost) {
		Integer pos = position_in_array();
		
		
		
		if (pos != -1 && manager.team1.get_money() >= cost) {
			// check for reserve
			manager.team1.set_money(manager.team1.get_money() - cost);
			
			if (pos > 3) {
				pos = pos - 4;
				// check if offence
				if (item.get_stat() == "offence") {
					manager.team1.reserve.get(pos).set_offence(Math.min(10, manager.team1.reserve.get(pos).get_offence() + item.get_increase()));
				}
				// must be defence 
				else {
					manager.team1.reserve.get(pos).set_defence(Math.min(10, manager.team1.reserve.get(pos).get_defence() + item.get_increase()));
				}
				
				
							}
			else {
				// this section is for team
				if (item.get_stat() == "offence") {
					manager.team1.team.get(pos).set_offence(Math.min(10, manager.team1.team.get(pos).get_offence() + item.get_increase()));
				}
				// must be defence 
				else {
					manager.team1.team.get(pos).set_defence(Math.min(10, manager.team1.team.get(pos).get_defence() + item.get_increase()));
				}
				
				
			}
		}
	}
	
	
	/**
	 * Create the application.
	 */
	public ShopGUI(teammanager manager) {
		this.manager = manager;
		Random random = new Random();
		
		/** list of 100 names */
		String[] names = {
			    "Ash", "Ethan", "James", "Caleb", "Logan", "Mason", "Lucas", "Henry", "Isaac", "Owen",
			    "Levi", "Aaron", "Evan", "Liam", "Wyatt", "Isaac", "Noah", "Luke", "Jack", "Adam",
			    "Jude", "Alex", "Max", "Leo", "Eli", "Eric", "Ryan", "Noah", "Paul", "Mark",
			    "Sean", "Jake", "Kyle", "Carl", "Sean", "Seth", "Dean", "Luke", "John", "Joel",
			    "Drew", "Cole", "Clark", "Todd", "Neil", "Dane", "Troy", "Evan", "Finn", "Lane",
			    "Hugh", "Omar", "Kane", "Kent", "Reed", "Dale", "Dirk", "Dean", "Hank", "Seth",
			    "Kurt", "Mike", "Pete", "Ray", "Paul", "Tony", "Troy", "Walt", "Will", "Clay",
			    "Dale", "Dave", "Eric", "Greg", "Hank", "Iain", "Jack", "Jake", "Kent", "Kurt",
			    "Liam", "Matt", "Neal", "Nick", "Omar", "Paul", "Pete", "Quinn", "Reed", "Sean",
			    "Seth", "Todd", "Troy", "Vince", "Walt", "Will", "Xavi", "Zack", "Zane", "Zed"
			};


		/** choose 4 random index's to populate player names with */ 
		int index1 = random.nextInt(names.length);
		int index2 = random.nextInt(names.length);
		int index3 = random.nextInt(names.length);
		int index4 = random.nextInt(names.length);
		
		/** adds 4 random players to the players array which is the array displayed for buying players */
		this.players.add(new player(names[index1], random.nextInt(2) + 9, random.nextInt(2) + 9, random.nextInt(201) + 750));
		this.players.add(new player(names[index2], random.nextInt(2) + 9, random.nextInt(2) + 9, random.nextInt(201) + 750));
		this.players.add(new player(names[index3], random.nextInt(5) + 6, random.nextInt(5) + 6, random.nextInt(201) + 500));
		this.players.add(new player(names[index4], random.nextInt(5) + 6, random.nextInt(5) + 6, random.nextInt(201) + 500));
	
		/** creates and adds 4 consumables to items array */
		this.items.add(new consumable("Egg", "offence", 1));
		this.items.add(new consumable("Beef", "defence", 1));
		this.items.add(new consumable("Pork", "offence", 2));
		this.items.add(new consumable("Fish", "defence", 2));


		
		
		
		
		// make all buttons clicked set to false in array 
		make_false();
		initialize();
		updateValues();
		shopwindow.setVisible(true);
    	if (manager.getGamesplayed() >= manager.getTournament_length()) {
    		closeWindow();
    		manager.launchendscreen();
    	}
	}
	
	/** closes the shopGUI window */
	public void closeWindow() {
		shopwindow.dispose();
	}
	
	/** closes the shopGUI window via manager */
	public void finishedWindow() {
		manager.closeshopscreen(this);
	}
	
	/** switch positions of players */
	void switch_positions(Integer pos, Integer pos1) {
 		/** someone is selected, switch the positions
 		 * pos return -1 if no one selected, 0 - 7 inclusive
 		 * 4 + is in reserve
		 * pos is the value from position_in_array, 
		 * pos1 is the value of position of player which switch button has been clicked */
 		if (pos != -1) {
 			if (pos > 3) {
 				
 				if (pos1 > 3) {
 	 				pos = pos - 4;
 	 				pos1 = pos1 - 4;
 	 				manager.team1.switch_players(manager.team1.reserve.get(pos1), manager.team1.reserve.get(pos));
 				}
 				else {
 	 				pos = pos - 4;
 	 				manager.team1.switch_players(manager.team1.team.get(pos1), manager.team1.reserve.get(pos));
 				}
 				

 			}
 			else {
 				if (pos1 > 3) {
 	 				pos1 = pos1 - 4;
 	 				manager.team1.switch_players(manager.team1.reserve.get(pos1), manager.team1.team.get(pos));
 				}
 				else {
 	 				manager.team1.switch_players(manager.team1.team.get(pos1), manager.team1.team.get(pos));
 				}
 				
 			}
 		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		shopwindow = new JFrame();
		shopwindow.setBounds(100, 100, 833, 536);
		shopwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		shopwindow.getContentPane().setLayout(null);
		
		
		/** player 0 team show player's stats, offence, defence, value, and display button select, switch */ 
		 panel = new JPanel();
		panel.setBackground(new Color(247, 255, 247));
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(75, 6, 96, 90);
		shopwindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		 lblNewLabel = new JLabel("Player: ");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel.setBounds(6, 16, 84, 16);
		panel.add(lblNewLabel);
		
		 lblNewLabel_1 = new JLabel("Offence: ");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1.setBounds(6, 34, 84, 16);
		panel.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("Defence: ");
		lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2.setBounds(6, 51, 84, 16);
		panel.add(lblNewLabel_2);
		
		 lblNewLabel_3 = new JLabel("Value: ");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3.setBounds(6, 69, 84, 16);
		panel.add(lblNewLabel_3);
		
		 lblNewLabel_11 = new JLabel("Team: ");
		lblNewLabel_11.setBounds(6, 17, 61, 16);
		shopwindow.getContentPane().add(lblNewLabel_11);
		
		 lblNewLabel_12 = new JLabel("Reserves:");
		lblNewLabel_12.setBounds(6, 119, 61, 16);
		shopwindow.getContentPane().add(lblNewLabel_12);
		
		 btnNewButton = new JButton("Select");
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[0] = true;
		 		updateValues();
		 	}
		 });
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton.setBounds(75, 96, 53, 29);
		shopwindow.getContentPane().add(btnNewButton);
		
		 btnSwitch = new JButton("Switch");
		 btnSwitch.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 0);
		 		make_false();
		 		updateValues();
		 		
		 		
		 	}
		 });
		btnSwitch.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch.setBounds(118, 95, 61, 29);
		shopwindow.getContentPane().add(btnSwitch);
		
		
		/** player 1 team show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBackground(new Color(247, 255, 247));
		panel_1.setBounds(183, 6, 96, 90);
		shopwindow.getContentPane().add(panel_1);
		
		 lblNewLabel_4 = new JLabel("Player: ");
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_4.setBounds(6, 16, 84, 16);
		panel_1.add(lblNewLabel_4);
		
		 lblNewLabel_1_1 = new JLabel("Offence: ");
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_1.setBounds(6, 34, 84, 16);
		panel_1.add(lblNewLabel_1_1);
		
		 lblNewLabel_2_1 = new JLabel("Defence: ");
		lblNewLabel_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_1.setBounds(6, 51, 84, 16);
		panel_1.add(lblNewLabel_2_1);
		
		 lblNewLabel_3_1 = new JLabel("Value: ");
		lblNewLabel_3_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_1.setBounds(6, 69, 84, 16);
		panel_1.add(lblNewLabel_3_1);
		
		 btnNewButton_1 = new JButton("Select");
		 btnNewButton_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[1] = true;
		 		updateValues();
		 	}
		 });
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1.setBounds(181, 95, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_1);
		
		 btnSwitch_1 = new JButton("Switch");
		 btnSwitch_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 1);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_1.setBounds(228, 95, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_1);
		
		 panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBackground(new Color(247, 255, 247));
		panel_1_1.setBounds(288, 6, 96, 90);
		shopwindow.getContentPane().add(panel_1_1);
		
		
		/** player 2 team show player's stats, offence, defence, value, and display button select, switch */ 
		 lblNewLabel_4_1 = new JLabel("Player: ");
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_4_1.setBounds(6, 16, 84, 16);
		panel_1_1.add(lblNewLabel_4_1);
		
		 lblNewLabel_1_1_1 = new JLabel("Offence: ");
		lblNewLabel_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_1_1.setBounds(6, 34, 84, 16);
		panel_1_1.add(lblNewLabel_1_1_1);
		
		 lblNewLabel_2_1_1 = new JLabel("Defence: ");
		lblNewLabel_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_1_1.setBounds(6, 51, 84, 16);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		 lblNewLabel_3_1_1 = new JLabel("Value: ");
		lblNewLabel_3_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_1_1.setBounds(6, 69, 84, 16);
		panel_1_1.add(lblNewLabel_3_1_1);
		
		 btnNewButton_1_1 = new JButton("Select");
		 btnNewButton_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[2] = true;
		 		updateValues();

		 	}
		 });
		btnNewButton_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1_1.setBounds(287, 95, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_1_1);
		
		 btnSwitch_1_1 = new JButton("Switch");
		 btnSwitch_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 2);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_1_1.setBounds(330, 95, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_1_1);
		
		
		
		/** player 3 team show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1_1.setBackground(new Color(247, 255, 247));
		panel_1_1_1.setBounds(389, 6, 96, 90);
		shopwindow.getContentPane().add(panel_1_1_1);
		
		 lblNewLabel_4_1_1 = new JLabel("Player: ");
		lblNewLabel_4_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_4_1_1.setBounds(6, 16, 84, 16);
		panel_1_1_1.add(lblNewLabel_4_1_1);
		
		 lblNewLabel_1_1_1_1 = new JLabel("Offence: ");
		lblNewLabel_1_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_1_1_1.setBounds(6, 34, 84, 16);
		panel_1_1_1.add(lblNewLabel_1_1_1_1);
		
		 lblNewLabel_2_1_1_1 = new JLabel("Defence: ");
		lblNewLabel_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_1_1_1.setBounds(6, 51, 84, 16);
		panel_1_1_1.add(lblNewLabel_2_1_1_1);
		
		 lblNewLabel_3_1_1_1 = new JLabel("Value: ");
		lblNewLabel_3_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_1_1_1.setBounds(6, 69, 84, 16);
		panel_1_1_1.add(lblNewLabel_3_1_1_1);
		
		 btnNewButton_1_1_1 = new JButton("Select");
		 btnNewButton_1_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[3] = true;
		 		updateValues();

		 	}
		 });
		btnNewButton_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_1_1_1.setBounds(385, 95, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_1_1_1);
		
		 btnSwitch_1_1_1 = new JButton("Switch");
		 btnSwitch_1_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 3);
		 		make_false();
		 		updateValues();
		 	}
		 	
		 });
		btnSwitch_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_1_1_1.setBounds(434, 95, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_1_1_1);
		
		
		/** player 0 reserve show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBackground(new Color(247, 255, 247));
		panel_2.setBounds(75, 121, 96, 90);
		shopwindow.getContentPane().add(panel_2);
		
		 lblNewLabel_5 = new JLabel("Player: ");
		lblNewLabel_5.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_5.setBounds(6, 16, 84, 16);
		panel_2.add(lblNewLabel_5);
		
		 lblNewLabel_1_2 = new JLabel("Offence: ");
		lblNewLabel_1_2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_2.setBounds(6, 34, 84, 16);
		panel_2.add(lblNewLabel_1_2);
		
		 lblNewLabel_2_2 = new JLabel("Defence: ");
		lblNewLabel_2_2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_2.setBounds(6, 51, 84, 16);
		panel_2.add(lblNewLabel_2_2);
		
		 lblNewLabel_3_2 = new JLabel("Value: ");
		lblNewLabel_3_2.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_2.setBounds(6, 69, 84, 16);
		panel_2.add(lblNewLabel_3_2);
		
		 btnNewButton_2 = new JButton("Select");
		 btnNewButton_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[4] = true;
		 		updateValues();

		 	}
		 });
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_2.setBounds(75, 209, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_2);
		
		 btnSwitch_2 = new JButton("Switch");
		 btnSwitch_2.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 4);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_2.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_2.setBounds(118, 208, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_2);
		
		
		/** player 1 reserve show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1.setBackground(new Color(247, 255, 247));
		panel_2_1.setBounds(183, 121, 96, 90);
		shopwindow.getContentPane().add(panel_2_1);
		
		 lblNewLabel_5_1 = new JLabel("Player: ");
		lblNewLabel_5_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_5_1.setBounds(6, 16, 84, 16);
		panel_2_1.add(lblNewLabel_5_1);
		
		 lblNewLabel_1_2_1 = new JLabel("Offence: ");
		lblNewLabel_1_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_2_1.setBounds(6, 34, 84, 16);
		panel_2_1.add(lblNewLabel_1_2_1);
		
		 lblNewLabel_2_2_1 = new JLabel("Defence: ");
		lblNewLabel_2_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_2_1.setBounds(6, 51, 84, 16);
		panel_2_1.add(lblNewLabel_2_2_1);
		
		 lblNewLabel_3_2_1 = new JLabel("Value: ");
		lblNewLabel_3_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_2_1.setBounds(6, 69, 84, 16);
		panel_2_1.add(lblNewLabel_3_2_1);
		
		 btnNewButton_2_1 = new JButton("Select");
		 btnNewButton_2_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[5] = true;
		 		updateValues();

		 	}
		 });
		btnNewButton_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_2_1.setBounds(181, 208, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_2_1);
		
		 btnSwitch_2_1 = new JButton("Switch");
		 btnSwitch_2_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 5);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_2_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_2_1.setBounds(228, 208, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_2_1);
		
		
		/** player 2 reserve show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_2_1_1 = new JPanel();
		panel_2_1_1.setLayout(null);
		panel_2_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1.setBackground(new Color(247, 255, 247));
		panel_2_1_1.setBounds(288, 121, 96, 90);
		shopwindow.getContentPane().add(panel_2_1_1);
		
		 lblNewLabel_5_1_1 = new JLabel("Player: ");
		lblNewLabel_5_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_5_1_1.setBounds(6, 16, 84, 16);
		panel_2_1_1.add(lblNewLabel_5_1_1);
		
		 lblNewLabel_1_2_1_1 = new JLabel("Offence: ");
		lblNewLabel_1_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_2_1_1.setBounds(6, 34, 84, 16);
		panel_2_1_1.add(lblNewLabel_1_2_1_1);
		
		 lblNewLabel_2_2_1_1 = new JLabel("Defence: ");
		lblNewLabel_2_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_2_1_1.setBounds(6, 51, 84, 16);
		panel_2_1_1.add(lblNewLabel_2_2_1_1);
		
		 lblNewLabel_3_2_1_1 = new JLabel("Value: ");
		lblNewLabel_3_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1.setBounds(6, 69, 70, 16);
		panel_2_1_1.add(lblNewLabel_3_2_1_1);
		
		 btnNewButton_2_1_1 = new JButton("Select");
		 btnNewButton_2_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[6] = true;
		 		updateValues();

		 	}
		 });
		btnNewButton_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_2_1_1.setBounds(287, 208, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_2_1_1);
		
		 btnSwitch_2_1_1 = new JButton("Switch");
		 btnSwitch_2_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 6);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_2_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_2_1_1.setBounds(330, 208, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_2_1_1);
		
		
		/** player 3 reserve show player's stats, offence, defence, value, and display button select, switch */ 
		 panel_2_1_1_1 = new JPanel();
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2_1_1_1.setBackground(new Color(247, 255, 247));
		panel_2_1_1_1.setBounds(389, 121, 96, 90);
		shopwindow.getContentPane().add(panel_2_1_1_1);
		
		 lblNewLabel_5_1_1_1 = new JLabel("Player: ");
		lblNewLabel_5_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_5_1_1_1.setBounds(6, 16, 84, 16);
		panel_2_1_1_1.add(lblNewLabel_5_1_1_1);
		
		 lblNewLabel_1_2_1_1_1 = new JLabel("Offence: ");
		lblNewLabel_1_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_1_2_1_1_1.setBounds(6, 34, 84, 16);
		panel_2_1_1_1.add(lblNewLabel_1_2_1_1_1);
		
		 lblNewLabel_2_2_1_1_1 = new JLabel("Defence: ");
		lblNewLabel_2_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_2_2_1_1_1.setBounds(6, 51, 84, 16);
		panel_2_1_1_1.add(lblNewLabel_2_2_1_1_1);
		
		 lblNewLabel_3_2_1_1_1 = new JLabel("Value: ");
		lblNewLabel_3_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblNewLabel_3_2_1_1_1.setBounds(6, 69, 84, 16);
		panel_2_1_1_1.add(lblNewLabel_3_2_1_1_1);
		
		 btnNewButton_2_1_1_1 = new JButton("Select");
		 btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		make_false();
		 		buttonClicked[7] = true;
		 		updateValues();
		 	}
		 });
		btnNewButton_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnNewButton_2_1_1_1.setBounds(389, 208, 53, 29);
		shopwindow.getContentPane().add(btnNewButton_2_1_1_1);
		
		 btnSwitch_2_1_1_1 = new JButton("Switch");
		 btnSwitch_2_1_1_1.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		Integer pos = position_in_array();
		 		switch_positions(pos, 7);
		 		make_false();
		 		updateValues();
		 	}
		 });
		btnSwitch_2_1_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		btnSwitch_2_1_1_1.setBounds(434, 208, 61, 29);
		shopwindow.getContentPane().add(btnSwitch_2_1_1_1);
		
		/** once this button is clicked the shopgui screen is closed and the lobby gui screen is opened */
		 btnNewButton_3 = new JButton("Go to lobby!");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
				manager.launchLobby();
				
			}
		});
		btnNewButton_3.setBounds(500, 17, 142, 79);
		shopwindow.getContentPane().add(btnNewButton_3);
		
		/** label for consumables */
		JLabel lblNewLabel_6 = new JLabel("Consumables:");
		lblNewLabel_6.setBounds(6, 242, 103, 16);
		shopwindow.getContentPane().add(lblNewLabel_6);
		
		/** consumable  1 */
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3.setBounds(6, 259, 103, 90);
		shopwindow.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Name: " + items.get(0).get_name());
		lblNewLabel_7.setBounds(6, 6, 91, 16);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Stat: " + items.get(0).get_stat());
		lblNewLabel_8.setBounds(6, 27, 91, 16);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Increase: " + items.get(0).get_increase());
		lblNewLabel_9.setBounds(6, 46, 91, 16);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Cost: 300");
		lblNewLabel_10.setBounds(6, 68, 91, 16);
		panel_3.add(lblNewLabel_10);
		
		JButton btnNewButton_4 = new JButton("Buy");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consume(items.get(0), 300);
				updateValues();
			}
		});
		btnNewButton_4.setBounds(6, 351, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4);
		
		
		
		
		/** consumable  2 */
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setLayout(null);
		panel_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_1.setBounds(118, 259, 103, 90);
		shopwindow.getContentPane().add(panel_3_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Name: " + items.get(1).get_name());
		lblNewLabel_7_1.setBounds(6, 6, 91, 16);
		panel_3_1.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("Stat: " + items.get(1).get_stat());
		lblNewLabel_8_1.setBounds(6, 27, 91, 16);
		panel_3_1.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_9_1 = new JLabel("Increase: " + items.get(1).get_increase());
		lblNewLabel_9_1.setBounds(6, 46, 91, 16);
		panel_3_1.add(lblNewLabel_9_1);
		
		JLabel lblNewLabel_10_1 = new JLabel("Cost: 300");
		lblNewLabel_10_1.setBounds(6, 68, 91, 16);
		panel_3_1.add(lblNewLabel_10_1);
		
		JButton btnNewButton_4_1 = new JButton("Buy");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consume(items.get(1), 300);
				updateValues();
			}
		});
		btnNewButton_4_1.setBounds(118, 351, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_1);
		
		
		
		/** consumable  3 */
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setLayout(null);
		panel_3_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_2.setBounds(6, 381, 103, 90);
		shopwindow.getContentPane().add(panel_3_2);
		
		JLabel lblNewLabel_7_2 = new JLabel("Name: " + items.get(2).get_name());
		lblNewLabel_7_2.setBounds(6, 6, 91, 16);
		panel_3_2.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_8_2 = new JLabel("Stat: " + items.get(2).get_stat());
		lblNewLabel_8_2.setBounds(6, 27, 91, 16);
		panel_3_2.add(lblNewLabel_8_2);
		
		JLabel lblNewLabel_9_2 = new JLabel("Increase: " + items.get(2).get_increase());
		lblNewLabel_9_2.setBounds(6, 46, 91, 16);
		panel_3_2.add(lblNewLabel_9_2);
		
		JLabel lblNewLabel_10_2 = new JLabel("Cost: 500");
		lblNewLabel_10_2.setBounds(6, 68, 91, 16);
		panel_3_2.add(lblNewLabel_10_2);
		
		JButton btnNewButton_4_2 = new JButton("Buy");
		btnNewButton_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consume(items.get(2), 500);
				updateValues();
			}
		});
		btnNewButton_4_2.setBounds(6, 473, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_2);
		
		
		/** consumable  4 */
		JPanel panel_3_2_1 = new JPanel();
		panel_3_2_1.setLayout(null);
		panel_3_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_2_1.setBounds(118, 381, 103, 90);
		shopwindow.getContentPane().add(panel_3_2_1);
		
		JLabel lblNewLabel_7_2_1 = new JLabel("Name: " + items.get(3).get_name());
		lblNewLabel_7_2_1.setBounds(6, 6, 91, 16);
		panel_3_2_1.add(lblNewLabel_7_2_1);
		
		JLabel lblNewLabel_8_2_1 = new JLabel("Stat: " + items.get(3).get_stat());
		lblNewLabel_8_2_1.setBounds(6, 27, 91, 16);
		panel_3_2_1.add(lblNewLabel_8_2_1);
		
		JLabel lblNewLabel_9_2_1 = new JLabel("Increase: " + items.get(3).get_increase());
		lblNewLabel_9_2_1.setBounds(6, 46, 91, 16);
		panel_3_2_1.add(lblNewLabel_9_2_1);
		
		JLabel lblNewLabel_10_2_1 = new JLabel("Cost: 500");
		lblNewLabel_10_2_1.setBounds(6, 68, 91, 16);
		panel_3_2_1.add(lblNewLabel_10_2_1);
		
		JButton btnNewButton_4_2_1 = new JButton("Buy");
		btnNewButton_4_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consume(items.get(3), 500);
				updateValues();
			}
		});
		btnNewButton_4_2_1.setBounds(118, 473, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_2_1);
		
		
		/** label for players for sale */
		JLabel lblNewLabel_13 = new JLabel("Players: ");
		lblNewLabel_13.setBounds(228, 242, 61, 16);
		shopwindow.getContentPane().add(lblNewLabel_13);
		
		
		/** player 1 for sale  */
		JPanel panel_3_3 = new JPanel();
		panel_3_3.setLayout(null);
		panel_3_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_3.setBounds(237, 259, 103, 90);
		shopwindow.getContentPane().add(panel_3_3);
		
		JLabel lblNewLabel_7_3 = new JLabel("Name: " + players.get(0).get_name());
		lblNewLabel_7_3.setBounds(6, 6, 91, 16);
		panel_3_3.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_8_3 = new JLabel("Offence: " + players.get(0).get_offence());
		lblNewLabel_8_3.setBounds(6, 27, 91, 16);
		panel_3_3.add(lblNewLabel_8_3);
		
		JLabel lblNewLabel_9_3 = new JLabel("Defence" + players.get(0).get_defence());
		lblNewLabel_9_3.setBounds(6, 46, 91, 16);
		panel_3_3.add(lblNewLabel_9_3);
		
		JLabel lblNewLabel_10_3 = new JLabel("Cost: " + players.get(0).get_value());
		lblNewLabel_10_3.setBounds(6, 68, 91, 16);
		panel_3_3.add(lblNewLabel_10_3);
		
		JButton btnNewButton_4_3 = new JButton("Buy");
		btnNewButton_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buy_player(players.get(0)) == true) {
					btnNewButton_4_3.setVisible(false);
				}
			}
		});
		btnNewButton_4_3.setBounds(232, 351, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_3);
		
		/** player 2 for sale  */
		JPanel panel_3_3_1 = new JPanel();
		panel_3_3_1.setLayout(null);
		panel_3_3_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_3_1.setBounds(352, 259, 103, 90);
		shopwindow.getContentPane().add(panel_3_3_1);
		
		JLabel lblNewLabel_7_3_1 = new JLabel("Name: " + players.get(1).get_name());
		lblNewLabel_7_3_1.setBounds(6, 6, 91, 16);
		panel_3_3_1.add(lblNewLabel_7_3_1);
		
		JLabel lblNewLabel_8_3_1 = new JLabel("Offence: " + players.get(1).get_offence());
		lblNewLabel_8_3_1.setBounds(6, 27, 91, 16);
		panel_3_3_1.add(lblNewLabel_8_3_1);
		
		JLabel lblNewLabel_9_3_1 = new JLabel("Defence: " + players.get(1).get_defence());
		lblNewLabel_9_3_1.setBounds(6, 46, 91, 16);
		panel_3_3_1.add(lblNewLabel_9_3_1);
		
		JLabel lblNewLabel_10_3_1 = new JLabel("Cost: " + players.get(1).get_value());
		lblNewLabel_10_3_1.setBounds(6, 68, 91, 16);
		panel_3_3_1.add(lblNewLabel_10_3_1);
		
		JButton btnNewButton_4_3_1 = new JButton("Buy");
		btnNewButton_4_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buy_player(players.get(1)) == true) {
					btnNewButton_4_3_1.setVisible(false);
				}
			}
		});
		btnNewButton_4_3_1.setBounds(346, 351, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_3_1);
		
		
		/** player 3 for sale  */
		JPanel panel_3_3_2 = new JPanel();
		panel_3_3_2.setLayout(null);
		panel_3_3_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_3_2.setBounds(237, 381, 103, 90);
		shopwindow.getContentPane().add(panel_3_3_2);
		
		JLabel lblNewLabel_7_3_2 = new JLabel("Name: " + players.get(2).get_name());
		lblNewLabel_7_3_2.setBounds(6, 6, 91, 16);
		panel_3_3_2.add(lblNewLabel_7_3_2);
		
		JLabel lblNewLabel_8_3_2 = new JLabel("Offence: " + players.get(2).get_offence());
		lblNewLabel_8_3_2.setBounds(6, 27, 91, 16);
		panel_3_3_2.add(lblNewLabel_8_3_2);
		
		JLabel lblNewLabel_9_3_2 = new JLabel("Name: " + players.get(2).get_defence());
		lblNewLabel_9_3_2.setBounds(6, 46, 91, 16);
		panel_3_3_2.add(lblNewLabel_9_3_2);
		
		JLabel lblNewLabel_10_3_2 = new JLabel("Cost: " + players.get(2).get_value());
		lblNewLabel_10_3_2.setBounds(6, 68, 91, 16);
		panel_3_3_2.add(lblNewLabel_10_3_2);
		
		JButton btnNewButton_4_3_2 = new JButton("Buy");
		btnNewButton_4_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buy_player(players.get(2)) == true) {
					btnNewButton_4_3_2.setVisible(false);
				}
			}
		});
		btnNewButton_4_3_2.setBounds(237, 473, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_3_2);
		
		
		
		/** player 4 for sale  */
		JPanel panel_3_3_2_1 = new JPanel();
		panel_3_3_2_1.setLayout(null);
		panel_3_3_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_3_3_2_1.setBounds(352, 381, 103, 90);
		shopwindow.getContentPane().add(panel_3_3_2_1);
		
		JLabel lblNewLabel_7_3_2_1 = new JLabel("Name: " + players.get(3).get_name());
		lblNewLabel_7_3_2_1.setBounds(6, 6, 91, 16);
		panel_3_3_2_1.add(lblNewLabel_7_3_2_1);
		
		JLabel lblNewLabel_8_3_2_1 = new JLabel("Offence: " + players.get(3).get_offence());
		lblNewLabel_8_3_2_1.setBounds(6, 27, 91, 16);
		panel_3_3_2_1.add(lblNewLabel_8_3_2_1);
		
		JLabel lblNewLabel_9_3_2_1 = new JLabel("Defence: " + players.get(3).get_defence());
		lblNewLabel_9_3_2_1.setBounds(6, 46, 91, 16);
		panel_3_3_2_1.add(lblNewLabel_9_3_2_1);
		
		JLabel lblNewLabel_10_3_2_1 = new JLabel("Cost: " + players.get(3).get_value());
		lblNewLabel_10_3_2_1.setBounds(6, 68, 91, 16);
		panel_3_3_2_1.add(lblNewLabel_10_3_2_1);
		
		JButton btnNewButton_4_3_2_1 = new JButton("Buy");
		btnNewButton_4_3_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (buy_player(players.get(3)) == true) {
					btnNewButton_4_3_2_1.setVisible(false);
				}

			}
		});
		btnNewButton_4_3_2_1.setBounds(359, 473, 96, 29);
		shopwindow.getContentPane().add(btnNewButton_4_3_2_1);
		
		
		/** sell the player currently selected, push other players -1 down the array
		 * must have at least 1 reserve to be able to sell a player
		 * */
		JButton btnNewButton_5 = new JButton("Sell Player");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer pos = position_in_array();
				
				
				if ((pos != -1) && (manager.team1.reserve.size() >= 1)) {
					// player is in reserve, simply remove them from reserve
					if (pos > 3) {
						pos = pos - 4;
						manager.team1.set_money(manager.team1.get_money() + manager.team1.reserve.get(pos).get_value());
						manager.team1.remove_player(manager.team1.reserve.get(pos));
					}
					else {

						// set money to current + value of player selling in team
						manager.team1.set_money(manager.team1.get_money() + manager.team1.team.get(pos).get_value());
						manager.team1.remove_player(manager.team1.team.get(pos));
						player temp = manager.team1.reserve.get(0);
						manager.team1.remove_player(manager.team1.reserve.get(0));
						manager.team1.add_player(temp);
						
					}
					
				}
				
				make_false();
				updateValues();
				
			}
		});
		btnNewButton_5.setBounds(525, 159, 83, 52);
		shopwindow.getContentPane().add(btnNewButton_5);
		
		lblNewLabel_14 = new JLabel("Money: ");
		lblNewLabel_14.setBounds(667, 17, 128, 52);
		shopwindow.getContentPane().add(lblNewLabel_14);
	}
	/** updates the values of the panels and labels,
	 * if a player if bought then adds to the team and updates value,
	 * if a consumable is bought update values and can see the increase in stats
	 *  if a player is sold can see them removed from team and one less panel is shown
	 *  shows the team's money in corner
	 * */
	void updateValues() {
		
		// player 0 team 1
		panel.setBackground(Color.WHITE);
		lblNewLabel.setText("Player: " + manager.team1.team.get(0).get_name());
		lblNewLabel_1.setText("Offence: " + manager.team1.team.get(0).get_offence());
		lblNewLabel_2.setText("Defence: " + manager.team1.team.get(0).get_defence());
		lblNewLabel_3.setText("Value: " + manager.team1.team.get(0).get_value());
		btnNewButton.setVisible(true);
		btnSwitch.setVisible(true);
		
		// player 1 team 1
		panel_1.setBackground(Color.WHITE);
		lblNewLabel_4.setText("Player: " + manager.team1.team.get(1).get_name());
		lblNewLabel_1_1.setText("Offence: " + manager.team1.team.get(1).get_offence());
		lblNewLabel_2_1.setText("Defence: " + manager.team1.team.get(1).get_defence());
		lblNewLabel_3_1.setText("Value: " + manager.team1.team.get(1).get_value());
		btnNewButton_1.setVisible(true);
		btnSwitch_1.setVisible(true);

		// player 2 team 1
		panel_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_1.setText("Player: " + manager.team1.team.get(2).get_name());
		lblNewLabel_1_1_1.setText("Offence: " + manager.team1.team.get(2).get_offence());
		lblNewLabel_2_1_1.setText("Defence: " + manager.team1.team.get(2).get_defence());
		lblNewLabel_3_1_1.setText("Value: " + manager.team1.team.get(2).get_value());
		btnNewButton_1_1.setVisible(true);
		btnSwitch_1_1.setVisible(true);

		// player 3 team 1
		panel_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_4_1_1.setText("Player: " + manager.team1.team.get(3).get_name());
		lblNewLabel_1_1_1_1.setText("Offence: " + manager.team1.team.get(3).get_offence());
		lblNewLabel_2_1_1_1.setText("Defence: " + manager.team1.team.get(3).get_defence());
		lblNewLabel_3_1_1_1.setText("Value: " + manager.team1.team.get(3).get_value());
		btnNewButton_1_1_1.setVisible(true);
		btnSwitch_1_1_1.setVisible(true);

		
		Integer length_of_reserve = manager.team1.reserve.size();
		
		// player 0 reserve
		if (length_of_reserve >= 1) {
		panel_2.setBackground(Color.WHITE);
		panel_2.setVisible(true);
		lblNewLabel_5.setText("Player: " + manager.team1.reserve.get(0).get_name());
		lblNewLabel_1_2.setText("Offence: " + manager.team1.reserve.get(0).get_offence());
		lblNewLabel_2_2.setText("Defence: " + manager.team1.reserve.get(0).get_defence());
		lblNewLabel_3_2.setText("Value: " + manager.team1.reserve.get(0).get_value());
		btnNewButton_2.setVisible(true);
		btnSwitch_2.setVisible(true);
		}
		else {
			panel_2.setVisible(false); 
			btnNewButton_2.setVisible(false);
			btnSwitch_2.setVisible(false);
		}

		// player 1 reserve
		if (length_of_reserve >= 2) {
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setVisible(true);
		lblNewLabel_5_1.setText("Player: " + manager.team1.reserve.get(1).get_name());
		lblNewLabel_1_2_1.setText("Offence: " + manager.team1.reserve.get(1).get_offence());
		lblNewLabel_2_2_1.setText("Defence: " + manager.team1.reserve.get(1).get_defence());
		lblNewLabel_3_2_1.setText("Value: " + manager.team1.reserve.get(1).get_value());
		btnNewButton_2_1.setVisible(true);
		btnSwitch_2_1.setVisible(true);
		}
		else {
			panel_2_1.setVisible(false);
			btnNewButton_2_1.setVisible(false);
			btnSwitch_2_1.setVisible(false);
		}

		// player 2 reserve
		if (length_of_reserve >= 3) {
		panel_2_1_1.setBackground(Color.WHITE);
		panel_2_1_1.setVisible(true);
		lblNewLabel_5_1_1.setText("Player: " + manager.team1.reserve.get(2).get_name());
		lblNewLabel_1_2_1_1.setText("Offence: " + manager.team1.reserve.get(2).get_offence());
		lblNewLabel_2_2_1_1.setText("Defence: " + manager.team1.reserve.get(2).get_defence());
		lblNewLabel_3_2_1_1.setText("Value: " + manager.team1.reserve.get(2).get_value());
		btnNewButton_2_1_1.setVisible(true);
		btnSwitch_2_1_1.setVisible(true);
		}
		else {
			btnNewButton_2_1_1.setVisible(false);
			btnSwitch_2_1_1.setVisible(false);
			panel_2_1_1.setVisible(false);
		}

		// player 3 reserve
		if (length_of_reserve >= 4) {
		panel_2_1_1_1.setBackground(Color.WHITE);
		panel_2_1_1_1.setVisible(true);
		lblNewLabel_5_1_1_1.setText("Player: " + manager.team1.reserve.get(3).get_name());
		lblNewLabel_1_2_1_1_1.setText("Offence: " + manager.team1.reserve.get(3).get_offence());
		lblNewLabel_2_2_1_1_1.setText("Defence: " + manager.team1.reserve.get(3).get_defence());
		lblNewLabel_3_2_1_1_1.setText("Value: " + manager.team1.reserve.get(3).get_value());
		btnNewButton_2_1_1_1.setVisible(true);
		btnSwitch_2_1_1_1.setVisible(true);
		}
		else {
			btnNewButton_2_1_1_1.setVisible(false);
			btnSwitch_2_1_1_1.setVisible(false);
			panel_2_1_1_1.setVisible(false);
		}
		
		// update money label
		lblNewLabel_14.setText("Money: " + manager.team1.get_money());
		
		Integer position_in_array_selected = position_in_array();

		switch (position_in_array_selected) {
		    case 0:
		        // Player 0 team 1
		        panel.setBackground(Color.CYAN);
		        break;

		    case 1:
		        // Player 1 team 1
		        panel_1.setBackground(Color.CYAN);
		        break;

		    case 2:
		        // Player 2 team 1
		        panel_1_1.setBackground(Color.CYAN);
		        break;

		    case 3:
		        // Player 3 team 1
		        panel_1_1_1.setBackground(Color.CYAN);
		        break;

		    case 4:
		        // Player 0 reserve
		        panel_2.setBackground(Color.CYAN);
		        break;

		    case 5:
		        // Player 1 reserve
		        panel_2_1.setBackground(Color.CYAN);
		        break;

		    case 6:
		        // Player 2 reserve
		        panel_2_1_1.setBackground(Color.CYAN);
		        break;

		    case 7:
		        // Player 3 reserve
		        panel_2_1_1_1.setBackground(Color.CYAN);
		        break;

		    default:
		        // Default case - do nothing
		        break;
		}

		
		
		}

		
		
		
		
	}
	
	

