package Main;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

/** GUI class allowing the user to select from 21 random players with different costs for their team
 *  Will only allow the user to continue to the shop screen if they have selected at least 4 players, and a maximum of 8 players can be purchased
 *  
 *  
 * */
public class choosePlayers {
	/** main frame which holds all GUI components for choose players class*/
	private JFrame choosePlayers;
	/** set manager as variable, passed in when chooseplayers instance is created */
	private static teammanager manager;
	/** fill with 21 players to select from, array list which holds the player's that the user can buy */
	ArrayList<player> players_to_select = new ArrayList<player>();
	
	
	/** Jlabels such as "team", and "reserve" */
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_3;
	
	
	/**  player 0 */
	private JPanel team2_player0;
	private JLabel team2_player0_name;
	private JLabel team2_player0_offence;
	private JLabel team2_player0_defence;
	private JLabel team2_player0_stamina;

	/** player 1 */
	private JPanel team2_player0_1;
	private JLabel team2_player0_name_1;
	private JLabel team2_player0_offence_1;
	private JLabel team2_player0_defence_1;
	private JLabel team2_player0_stamina_1;
	/** player 2  */
	private JPanel team2_player0_2;
	private JLabel team2_player0_name_2;
	private JLabel team2_player0_offence_2;
	private JLabel team2_player0_defence_2;
	private JLabel team2_player0_stamina_2;
	/**  player 3 */
	private JPanel team2_player0_3;
	private JLabel team2_player0_name_3;
	private JLabel team2_player0_offence_3;
	private JLabel team2_player0_defence_3;
	private JLabel team2_player0_stamina_3;
	private JLabel lblNewLabel_1;
	/** player 4 */
	private JPanel team2_player0_4;
	private JLabel team2_player0_name_4;
	private JLabel team2_player0_offence_4;
	private JLabel team2_player0_defence_4;
	private JLabel team2_player0_stamina_4;
	/** player 5 */
	private JPanel team2_player0_5;
	private JLabel team2_player0_name_5;
	private JLabel team2_player0_offence_5;
	private JLabel team2_player0_defence_5;
	private JLabel team2_player0_stamina_5;
	/* 	player 6 **/
	private JPanel team2_player0_6;
	private JLabel team2_player0_name_6;
	private JLabel team2_player0_offence_6;
	private JLabel team2_player0_defence_6;
	private JLabel team2_player0_stamina_6;
	/** 	player 7
	 *  */

	private JPanel team2_player0_7;
	private JLabel team2_player0_name_7;
	private JLabel team2_player0_offence_7;
	private JLabel team2_player0_defence_7;
	private JLabel team2_player0_stamina_7;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					choosePlayers window = new choosePlayers(manager);
					window.choosePlayers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/** helper function to use when buying players (check if you can buy the player) 
	 * */
	public void check_if_can_buy(Integer position) {
	if (manager.team1.get_money() >= players_to_select.get(position).get_value()) {
		// error handling, can't add to team if team has 8 already
		if (manager.team1.reserve.size() < 4) {
			// set team 1 money to new value which is current - value of player buying
			manager.team1.set_money(manager.team1.get_money() - players_to_select.get(position).get_value());
			manager.team1.add_player(players_to_select.get(position));	
			updateValues();
		}
		}
	}


	
	/** update the player panels as needed 
	 * If new player is added, then show this player's panel, update team money
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	public void updateValues() {
		Integer position_to_update = manager.team1.team.size() + manager.team1.reserve.size() - 1;
		// update 8 players panel for user, display if it exists? 
		switch(position_to_update) {
		/** case 0, meaning position 0 must be updated, show player 0 in team */
		case 0:
			team2_player0.setVisible(true);
			 team2_player0_name.setText("Player: " + manager.team1.team.get(0).get_name());
			 team2_player0_offence.setText("Offence: " + manager.team1.team.get(0).get_offence());
			 team2_player0_defence.setText("Defence: " + manager.team1.team.get(0).get_defence());	
			 team2_player0_stamina.setText("Value: " + manager.team1.team.get(0).get_value());
			 break;
		/** case 1, meaning position 1 must be updated, show player 1 in team */
		case 1:
			team2_player0_1.setVisible(true);
			team2_player0_name_1.setText("Player: " + manager.team1.team.get(1).get_name());
			team2_player0_offence_1.setText("Offence: " + manager.team1.team.get(1).get_offence());
			team2_player0_defence_1.setText("Defence: " + manager.team1.team.get(1).get_defence());
			team2_player0_stamina_1.setText("Value: " + manager.team1.team.get(1).get_value());
			break;
		/** case 2, meaning position 2 must be updated, show player 2 in team */
		case 2:
			team2_player0_2.setVisible(true);
			team2_player0_name_2.setText("Player: " + manager.team1.team.get(2).get_name());
			team2_player0_offence_2.setText("Offence: " + manager.team1.team.get(2).get_offence());
			team2_player0_defence_2.setText("Defence: " + manager.team1.team.get(2).get_defence());
			team2_player0_stamina_2.setText("Value: " + manager.team1.team.get(2).get_value());
			break;
			/** case 3, meaning position 3 must be updated, show player 3 in team
			 * Here the JButton to go to the Shop GUI is set to setvisible to true so the user can now
			 *  go to the shop
			 *  */
		case 3:
			btnNewButton_3.setVisible(true);
			team2_player0_3.setVisible(true);
			team2_player0_name_3.setText("Player: " + manager.team1.team.get(3).get_name());
			team2_player0_offence_3.setText("Offence: " + manager.team1.team.get(3).get_offence());
			team2_player0_defence_3.setText("Defence: " + manager.team1.team.get(3).get_defence());
			team2_player0_stamina_3.setText("Value: " + manager.team1.team.get(3).get_value());
		  break;
			/** case 4, meaning position 0 must be updated, show player 0 in reserve */
		case 4:
			team2_player0_4.setVisible(true);
			team2_player0_name_4.setText("Player: " + manager.team1.reserve.get(0).get_name());
			team2_player0_offence_4.setText("Offence: " + manager.team1.reserve.get(0).get_offence());
			team2_player0_defence_4.setText("Defence: " + manager.team1.reserve.get(0).get_defence());
			team2_player0_stamina_4.setText("Value: " + manager.team1.reserve.get(0).get_value());
		  break;
			/** case 5, meaning position 1 must be updated, show player 1 in reserve */
		case 5:
			team2_player0_5.setVisible(true);
			team2_player0_name_5.setText("Player: " + manager.team1.reserve.get(1).get_name());
			team2_player0_offence_5.setText("Offence: " + manager.team1.reserve.get(1).get_offence());
			team2_player0_defence_5.setText("Defence: " + manager.team1.reserve.get(1).get_defence());
			team2_player0_stamina_5.setText("Value: " + manager.team1.reserve.get(1).get_value());
		  break;
			/** case 6, meaning position 2 must be updated, show player 2 in reserve */
		case 6:
			team2_player0_6.setVisible(true);
			team2_player0_name_6.setText("Player: " + manager.team1.reserve.get(2).get_name());
			team2_player0_offence_6.setText("Offence: " + manager.team1.reserve.get(2).get_offence());
			team2_player0_defence_6.setText("Defence: " + manager.team1.reserve.get(2).get_defence());
			team2_player0_stamina_6.setText("Value: " + manager.team1.reserve.get(2).get_value());
		  break;
			/** case 7, meaning position 7 must be updated, show player 3 in reserve */
		case 7:
			team2_player0_7.setVisible(true);
			team2_player0_name_7.setText("Player: " + manager.team1.reserve.get(3).get_name());
			team2_player0_offence_7.setText("Offence: " + manager.team1.reserve.get(3).get_offence());
			team2_player0_defence_7.setText("Defence: " + manager.team1.reserve.get(3).get_defence());
			team2_player0_stamina_7.setText("Value: " + manager.team1.reserve.get(3).get_value());
		  break;
		  
		  default:
			  break;
			  
		}
		/** update the money label, uses team1 get money function to get the current ammount */
		lblNewLabel_4.setText("Money: $" + manager.team1.get_money());
		  

		
	}
	

	/** choose player constructor, 
	 * 
	 * passes in manager as a parameter and sets this to manager variable
	 * Creates 21 players which are added to player_to_select array
	 * 
	 * 
	 * 
	 * */
	public choosePlayers(teammanager manager) {
		this.manager = manager;
		/** initialize the 21 players to select
		(String name, Integer offence, Integer defence, Integer value)

		*/
		

		Random random = new Random();
		// high class players, high stats on average, expensive
		players_to_select.add(new player("Liam", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("Noah", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("Oliver", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("Elijah", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("James", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("Will", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		players_to_select.add(new player("Ben", random.nextInt(4) + 7, random.nextInt(4) + 7, random.nextInt(201) + 500));
		// average class players, average stats on average, average price
		players_to_select.add(new player("Lucas", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Henry", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Theo", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Jack", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Levi", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Alex", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		players_to_select.add(new player("Jackson", random.nextInt(3) + 5, random.nextInt(3) + 5, random.nextInt(201) + 300));
		// lower class players, lower stats on average, cheaper
		players_to_select.add(new player("Mateo", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Daniel", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Mike", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Mason", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Seb", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Ethan", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));
		players_to_select.add(new player("Logan", random.nextInt(4) + 1, random.nextInt(4) + 1, random.nextInt(201) + 50));

				
		
		// initialize the players from playertoselect
		initialize();
		choosePlayers.setVisible(true);
	}
	

	/** function used to close the window */
	public void closewindow() {
		choosePlayers.dispose();
	}
	/** function used to close the window via manager */
	public void finishedWindow() {
		manager.closechooseplayers(this);
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		choosePlayers = new JFrame();
		choosePlayers.setBounds(100, 100, 1424, 817);
		choosePlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		choosePlayers.getContentPane().setLayout(null);
		
		/** player 0 in team */ 
		 team2_player0 = new JPanel();
		team2_player0.setLayout(null);
		team2_player0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0.setBackground(Color.WHITE);
		team2_player0.setBounds(69, 6, 119, 107);
		choosePlayers.getContentPane().add(team2_player0);
		
		 team2_player0_name = new JLabel("Player: <dynamic>");
		team2_player0_name.setBounds(6, 6, 181, 16);
		team2_player0.add(team2_player0_name);
		
		 team2_player0_offence = new JLabel("Offence: null");
		team2_player0_offence.setBounds(6, 30, 150, 16);
		team2_player0.add(team2_player0_offence);
		
		 team2_player0_defence = new JLabel("Defence: null");
		team2_player0_defence.setBounds(6, 59, 181, 16);
		team2_player0.add(team2_player0_defence);
		
		 team2_player0_stamina = new JLabel("Stamina: null");
		team2_player0_stamina.setBounds(6, 91, 170, 16);
		team2_player0.add(team2_player0_stamina);
		team2_player0.setVisible(false);
		
		
		 lblNewLabel = new JLabel("Team: ");
		lblNewLabel.setBounds(6, 6, 61, 16);
		choosePlayers.getContentPane().add(lblNewLabel);
		
		
		/** player 1 in team */
		 team2_player0_1 = new JPanel();
		team2_player0_1.setLayout(null);
		team2_player0_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_1.setBackground(Color.WHITE);
		team2_player0_1.setBounds(200, 6, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_1);
		
		 team2_player0_name_1 = new JLabel("Player: <dynamic>");
		team2_player0_name_1.setBounds(6, 6, 181, 16);
		team2_player0_1.add(team2_player0_name_1);
		
		 team2_player0_offence_1 = new JLabel("Offence: null");
		team2_player0_offence_1.setBounds(6, 30, 150, 16);
		team2_player0_1.add(team2_player0_offence_1);
		
		 team2_player0_defence_1 = new JLabel("Defence: null");
		team2_player0_defence_1.setBounds(6, 59, 181, 16);
		team2_player0_1.add(team2_player0_defence_1);
		
		 team2_player0_stamina_1 = new JLabel("Stamina: null");
		team2_player0_stamina_1.setBounds(6, 91, 170, 16);
		team2_player0_1.add(team2_player0_stamina_1);
		team2_player0_1.setVisible(false);
		
		
		/** player 2 in team */
		 team2_player0_2 = new JPanel();
		team2_player0_2.setLayout(null);
		team2_player0_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_2.setBackground(Color.WHITE);
		team2_player0_2.setBounds(331, 6, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_2);
		
		 team2_player0_name_2 = new JLabel("Player: <dynamic>");
		team2_player0_name_2.setBounds(6, 6, 181, 16);
		team2_player0_2.add(team2_player0_name_2);
		
		 team2_player0_offence_2 = new JLabel("Offence: null");
		team2_player0_offence_2.setBounds(6, 30, 150, 16);
		team2_player0_2.add(team2_player0_offence_2);
		
		 team2_player0_defence_2 = new JLabel("Defence: null");
		team2_player0_defence_2.setBounds(6, 59, 181, 16);
		team2_player0_2.add(team2_player0_defence_2);
		
		 team2_player0_stamina_2 = new JLabel("Stamina: null");
		team2_player0_stamina_2.setBounds(6, 91, 170, 16);
		team2_player0_2.add(team2_player0_stamina_2);
		team2_player0_2.setVisible(false);
		
		
		/** player 3 in team */
		 team2_player0_3 = new JPanel();
		team2_player0_3.setLayout(null);
		team2_player0_3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_3.setBackground(Color.WHITE);
		team2_player0_3.setBounds(462, 6, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_3);
		
		 team2_player0_name_3 = new JLabel("Player: <dynamic>");
		team2_player0_name_3.setBounds(6, 6, 181, 16);
		team2_player0_3.add(team2_player0_name_3);
		
		 team2_player0_offence_3 = new JLabel("Offence: null");
		team2_player0_offence_3.setBounds(6, 30, 150, 16);
		team2_player0_3.add(team2_player0_offence_3);
		
		 team2_player0_defence_3 = new JLabel("Defence: null");
		team2_player0_defence_3.setBounds(6, 59, 181, 16);
		team2_player0_3.add(team2_player0_defence_3);
		
		 team2_player0_stamina_3 = new JLabel("Stamina: null");
		team2_player0_stamina_3.setBounds(6, 91, 170, 16);
		team2_player0_3.add(team2_player0_stamina_3);
		team2_player0_3.setVisible(false);
		
		
		/** player 0 in reserve */
		 lblNewLabel_1 = new JLabel("Reserves:");
		lblNewLabel_1.setBounds(6, 133, 77, 16);
		choosePlayers.getContentPane().add(lblNewLabel_1);
		
		 team2_player0_4 = new JPanel();
		team2_player0_4.setLayout(null);
		team2_player0_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_4.setBackground(Color.WHITE);
		team2_player0_4.setBounds(69, 117, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_4);
		
		 team2_player0_name_4 = new JLabel("Player: <dynamic>");
		team2_player0_name_4.setBounds(6, 6, 181, 16);
		team2_player0_4.add(team2_player0_name_4);
		
		 team2_player0_offence_4 = new JLabel("Offence: null");
		team2_player0_offence_4.setBounds(6, 30, 150, 16);
		team2_player0_4.add(team2_player0_offence_4);
		
		 team2_player0_defence_4 = new JLabel("Defence: null");
		team2_player0_defence_4.setBounds(6, 59, 181, 16);
		team2_player0_4.add(team2_player0_defence_4);
		
		 team2_player0_stamina_4 = new JLabel("Stamina: null");
		team2_player0_stamina_4.setBounds(6, 91, 170, 16);
		team2_player0_4.add(team2_player0_stamina_4);
		team2_player0_4.setVisible(false);
		
		
		/** player 1 in reserve */
		 team2_player0_5 = new JPanel();
		team2_player0_5.setLayout(null);
		team2_player0_5.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_5.setBackground(Color.WHITE);
		team2_player0_5.setBounds(200, 117, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_5);
		
		 team2_player0_name_5 = new JLabel("Player: <dynamic>");
		team2_player0_name_5.setBounds(6, 6, 181, 16);
		team2_player0_5.add(team2_player0_name_5);
		
		 team2_player0_offence_5 = new JLabel("Offence: null");
		team2_player0_offence_5.setBounds(6, 30, 150, 16);
		team2_player0_5.add(team2_player0_offence_5);
		
		 team2_player0_defence_5 = new JLabel("Defence: null");
		team2_player0_defence_5.setBounds(6, 59, 181, 16);
		team2_player0_5.add(team2_player0_defence_5);
		
		 team2_player0_stamina_5 = new JLabel("Stamina: null");
		team2_player0_stamina_5.setBounds(6, 91, 170, 16);
		team2_player0_5.add(team2_player0_stamina_5);
		team2_player0_5.setVisible(false);
		
		
		
		/** player 2 in reserve */
		 team2_player0_6 = new JPanel();
		team2_player0_6.setLayout(null);
		team2_player0_6.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_6.setBackground(Color.WHITE);
		team2_player0_6.setBounds(331, 117, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_6);
		
		 team2_player0_name_6 = new JLabel("Player: <dynamic>");
		team2_player0_name_6.setBounds(6, 6, 181, 16);
		team2_player0_6.add(team2_player0_name_6);
		
		 team2_player0_offence_6 = new JLabel("Offence: null");
		team2_player0_offence_6.setBounds(6, 30, 150, 16);
		team2_player0_6.add(team2_player0_offence_6);
		
		 team2_player0_defence_6 = new JLabel("Defence: null");
		team2_player0_defence_6.setBounds(6, 59, 181, 16);
		team2_player0_6.add(team2_player0_defence_6);
		
		 team2_player0_stamina_6 = new JLabel("Stamina: null");
		team2_player0_stamina_6.setBounds(6, 91, 170, 16);
		team2_player0_6.add(team2_player0_stamina_6);
		team2_player0_6.setVisible(false);
		
		
		/** player 3 in reserve */
		 team2_player0_7 = new JPanel();
		team2_player0_7.setLayout(null);
		team2_player0_7.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_7.setBackground(Color.WHITE);
		team2_player0_7.setBounds(462, 117, 119, 107);
		choosePlayers.getContentPane().add(team2_player0_7);
		
		 team2_player0_name_7 = new JLabel("Player: <dynamic>");
		team2_player0_name_7.setBounds(6, 6, 181, 16);
		team2_player0_7.add(team2_player0_name_7);
		
		 team2_player0_offence_7 = new JLabel("Offence: null");
		team2_player0_offence_7.setBounds(6, 30, 150, 16);
		team2_player0_7.add(team2_player0_offence_7);
		
		 team2_player0_defence_7 = new JLabel("Defence: null");
		team2_player0_defence_7.setBounds(6, 59, 181, 16);
		team2_player0_7.add(team2_player0_defence_7);
		
		 team2_player0_stamina_7 = new JLabel("Stamina: null");
		team2_player0_stamina_7.setBounds(6, 91, 170, 16);
		team2_player0_7.add(team2_player0_stamina_7);
		team2_player0_7.setVisible(false);
		
		
		
		/** player 0 for sale */
		JPanel team2_player0_8 = new JPanel();
		team2_player0_8.setLayout(null);
		team2_player0_8.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8.setBackground(Color.WHITE);
		team2_player0_8.setBounds(4, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8);
		
		JLabel team2_player0_name_8 = new JLabel("Player: " + this.players_to_select.get(0).get_name());
		team2_player0_name_8.setBounds(6, 6, 181, 16);
		team2_player0_8.add(team2_player0_name_8);
		
		JLabel team2_player0_offence_8 = new JLabel("Offence: " + this.players_to_select.get(0).get_offence());
		team2_player0_offence_8.setBounds(6, 30, 150, 16);
		team2_player0_8.add(team2_player0_offence_8);
		
		JLabel team2_player0_defence_8 = new JLabel("Defence: " + this.players_to_select.get(0).get_defence());
		team2_player0_defence_8.setBounds(6, 59, 181, 16);
		team2_player0_8.add(team2_player0_defence_8);
		
		JLabel team2_player0_stamina_8 = new JLabel("Stamina: " + this.players_to_select.get(0).get_stamina());
		team2_player0_stamina_8.setBounds(6, 91, 170, 16);
		team2_player0_8.add(team2_player0_stamina_8);
		
		JLabel lblNewLabel_2 = new JLabel("Cost: " + this.players_to_select.get(0).get_value());
		lblNewLabel_2.setBounds(6, 119, 107, 16);
		team2_player0_8.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Buy");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(0);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton.setVisible(false);	
			}
		});
		btnNewButton.setBounds(6, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Choose Athletes: ");
		lblNewLabel_3.setBounds(6, 236, 326, 16);
		choosePlayers.getContentPane().add(lblNewLabel_3);
		
		
		/** player 1 for sale */
		JPanel team2_player0_8_1 = new JPanel();
		team2_player0_8_1.setLayout(null);
		team2_player0_8_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1.setBackground(Color.WHITE);
		team2_player0_8_1.setBounds(134, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1);
		
		JLabel team2_player0_name_8_1 = new JLabel("Player: " + this.players_to_select.get(1).get_name());
		team2_player0_name_8_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1.add(team2_player0_name_8_1);
		
		JLabel team2_player0_offence_8_1 = new JLabel("Offence: " + this.players_to_select.get(1).get_offence());
		team2_player0_offence_8_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1.add(team2_player0_offence_8_1);
		
		JLabel team2_player0_defence_8_1 = new JLabel("Defence: " + this.players_to_select.get(1).get_defence());
		team2_player0_defence_8_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1.add(team2_player0_defence_8_1);
		
		JLabel team2_player0_stamina_8_1 = new JLabel("Stamina: " + this.players_to_select.get(1).get_stamina());
		team2_player0_stamina_8_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1.add(team2_player0_stamina_8_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Cost: " + this.players_to_select.get(1).get_value());
		lblNewLabel_2_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1.add(lblNewLabel_2_1);
		
		JButton btnNewButton_1 = new JButton("Buy");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(1);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1.setVisible(false);	
			}
		});
		btnNewButton_1.setBounds(134, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1);
		
		
		
		//** player 2 for sale */
		JPanel team2_player0_8_1_1 = new JPanel();
		team2_player0_8_1_1.setLayout(null);
		team2_player0_8_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1_1.setBackground(Color.WHITE);
		team2_player0_8_1_1.setBounds(265, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1_1);
		
		JLabel team2_player0_name_8_1_1 = new JLabel("Player: " + this.players_to_select.get(2).get_name());
		team2_player0_name_8_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1_1.add(team2_player0_name_8_1_1);
		
		JLabel team2_player0_offence_8_1_1 = new JLabel("Offence: " + this.players_to_select.get(2).get_offence());
		team2_player0_offence_8_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1_1.add(team2_player0_offence_8_1_1);
		
		JLabel team2_player0_defence_8_1_1 = new JLabel("Defence: " + this.players_to_select.get(2).get_defence());
		team2_player0_defence_8_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1_1.add(team2_player0_defence_8_1_1);
		
		JLabel team2_player0_stamina_8_1_1 = new JLabel("Stamina: " + + this.players_to_select.get(2).get_stamina());
		team2_player0_stamina_8_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1_1.add(team2_player0_stamina_8_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Cost: " + + this.players_to_select.get(2).get_value());
		lblNewLabel_2_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1_1.add(lblNewLabel_2_1_1);
		
		JButton btnNewButton_1_1 = new JButton("Buy");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(2);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1_1.setVisible(false);
			}
		});
		btnNewButton_1_1.setBounds(263, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1_1);
		
		
		
		//** player 3 for sale */
		JPanel team2_player0_8_1_1_1 = new JPanel();
		team2_player0_8_1_1_1.setLayout(null);
		team2_player0_8_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_1_1_1.setBounds(396, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1_1_1);
		
		JLabel team2_player0_name_8_1_1_1 = new JLabel("Player: " + this.players_to_select.get(3).get_name());
		team2_player0_name_8_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1_1_1.add(team2_player0_name_8_1_1_1);
		
		JLabel team2_player0_offence_8_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(3).get_offence());
		team2_player0_offence_8_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1_1_1.add(team2_player0_offence_8_1_1_1);
		
		JLabel team2_player0_defence_8_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(3).get_defence());
		team2_player0_defence_8_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1_1_1.add(team2_player0_defence_8_1_1_1);
		
		JLabel team2_player0_stamina_8_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(3).get_stamina());
		team2_player0_stamina_8_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1_1_1.add(team2_player0_stamina_8_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(3).get_value());
		lblNewLabel_2_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Buy");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(3);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1_1_1.setVisible(false);
			}
		});
		btnNewButton_1_1_1.setBounds(398, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1_1_1);
		
		
		
		/** player 4 for sale */
		JPanel team2_player0_8_1_1_1_1 = new JPanel();
		team2_player0_8_1_1_1_1.setLayout(null);
		team2_player0_8_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_1_1_1_1.setBounds(525, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1_1_1_1);
		
		JLabel team2_player0_name_8_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(4).get_name());
		team2_player0_name_8_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1_1_1_1.add(team2_player0_name_8_1_1_1_1);
		
		JLabel team2_player0_offence_8_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(4).get_offence());
		team2_player0_offence_8_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1_1_1_1.add(team2_player0_offence_8_1_1_1_1);
		
		JLabel team2_player0_defence_8_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(4).get_defence());
		team2_player0_defence_8_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1_1_1_1.add(team2_player0_defence_8_1_1_1_1);
		
		JLabel team2_player0_stamina_8_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(4).get_stamina());
		team2_player0_stamina_8_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1_1_1_1.add(team2_player0_stamina_8_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(4).get_value());
		lblNewLabel_2_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1_1_1_1.add(lblNewLabel_2_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("Buy");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(4);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1_1_1_1.setVisible(false);
				
			}
		});
		btnNewButton_1_1_1_1.setBounds(527, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1_1_1_1);
		
		
		
		/** player 5 for sale */
		JPanel team2_player0_8_1_1_1_1_1 = new JPanel();
		team2_player0_8_1_1_1_1_1.setLayout(null);
		team2_player0_8_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_1_1_1_1_1.setBounds(656, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1_1_1_1_1);
		
		JLabel team2_player0_name_8_1_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(5).get_name());
		team2_player0_name_8_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1_1_1_1_1.add(team2_player0_name_8_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_1_1_1_1_1 = new JLabel("Offence: " +  this.players_to_select.get(5).get_offence());
		team2_player0_offence_8_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1_1_1_1_1.add(team2_player0_offence_8_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_1_1_1_1_1 = new JLabel("Defence: " +  this.players_to_select.get(5).get_defence());
		team2_player0_defence_8_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1_1_1_1_1.add(team2_player0_defence_8_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_1_1_1_1_1 = new JLabel("Stamina: " +  this.players_to_select.get(5).get_stamina());
		team2_player0_stamina_8_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1_1_1_1_1.add(team2_player0_stamina_8_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Cost: " +  this.players_to_select.get(5).get_value());
		lblNewLabel_2_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(5);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1_1.setBounds(656, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1_1_1_1_1);
		
		
		/** player 6 for sale */
		
		JPanel team2_player0_8_1_1_1_1_1_1 = new JPanel();
		team2_player0_8_1_1_1_1_1_1.setLayout(null);
		team2_player0_8_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_1_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_1_1_1_1_1_1.setBounds(786, 265, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_1_1_1_1_1_1);
		
		JLabel team2_player0_name_8_1_1_1_1_1_1 = new JLabel("Player: " +  this.players_to_select.get(6).get_name());
		team2_player0_name_8_1_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_1_1_1_1_1_1.add(team2_player0_name_8_1_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_1_1_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(6).get_offence());
		team2_player0_offence_8_1_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_1_1_1_1_1_1.add(team2_player0_offence_8_1_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_1_1_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(6).get_defence());
		team2_player0_defence_8_1_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_1_1_1_1_1_1.add(team2_player0_defence_8_1_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_1_1_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(6).get_stamina());
		team2_player0_stamina_8_1_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_1_1_1_1_1_1.add(team2_player0_stamina_8_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(6).get_value());
		lblNewLabel_2_1_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_1_1_1_1_1_1.add(lblNewLabel_2_1_1_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(6);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_1_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_1_1_1_1_1_1.setBounds(785, 402, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_1_1_1_1_1_1);
		
		
		
		/** player 7 for sale */
		JPanel team2_player0_8_2 = new JPanel();
		team2_player0_8_2.setLayout(null);
		team2_player0_8_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2.setBackground(Color.WHITE);
		team2_player0_8_2.setBounds(6, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2);
		
		JLabel team2_player0_name_8_2 = new JLabel("Player: " + this.players_to_select.get(7).get_name());
		team2_player0_name_8_2.setBounds(6, 6, 181, 16);
		team2_player0_8_2.add(team2_player0_name_8_2);
		
		JLabel team2_player0_offence_8_2 = new JLabel("Offence: " + this.players_to_select.get(7).get_offence());
		team2_player0_offence_8_2.setBounds(6, 30, 150, 16);
		team2_player0_8_2.add(team2_player0_offence_8_2);
		
		JLabel team2_player0_defence_8_2 = new JLabel("Defence: " + this.players_to_select.get(7).get_defence());
		team2_player0_defence_8_2.setBounds(6, 59, 181, 16);
		team2_player0_8_2.add(team2_player0_defence_8_2);
		
		JLabel team2_player0_stamina_8_2 = new JLabel("Stamina: " + this.players_to_select.get(7).get_stamina());
		team2_player0_stamina_8_2.setBounds(6, 91, 170, 16);
		team2_player0_8_2.add(team2_player0_stamina_8_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("Cost: " + this.players_to_select.get(7).get_value());
		lblNewLabel_2_2.setBounds(6, 119, 107, 16);
		team2_player0_8_2.add(lblNewLabel_2_2);
		
		JButton btnNewButton_2 = new JButton("Buy");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(7);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2.setVisible(false);
			}
		});
		btnNewButton_2.setBounds(6, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2);
		
		
		
		/** player 8 for sale */
		JPanel team2_player0_8_2_1 = new JPanel();
		team2_player0_8_2_1.setLayout(null);
		team2_player0_8_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1.setBackground(Color.WHITE);
		team2_player0_8_2_1.setBounds(135, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1);
		
		JLabel team2_player0_name_8_2_1 = new JLabel("Player: " + this.players_to_select.get(8).get_name());
		team2_player0_name_8_2_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1.add(team2_player0_name_8_2_1);
		
		JLabel team2_player0_offence_8_2_1 = new JLabel("Offence: " + this.players_to_select.get(8).get_offence());
		team2_player0_offence_8_2_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1.add(team2_player0_offence_8_2_1);
		
		JLabel team2_player0_defence_8_2_1 = new JLabel("Defence: " + this.players_to_select.get(8).get_defence());
		team2_player0_defence_8_2_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1.add(team2_player0_defence_8_2_1);
		
		JLabel team2_player0_stamina_8_2_1 = new JLabel("Stamina: " + this.players_to_select.get(8).get_stamina());
		team2_player0_stamina_8_2_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1.add(team2_player0_stamina_8_2_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Cost: " + this.players_to_select.get(8).get_value());
		lblNewLabel_2_2_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1.add(lblNewLabel_2_2_1);
		
		JButton btnNewButton_2_1 = new JButton("Buy");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(8);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1.setVisible(false);
			}
		});
		btnNewButton_2_1.setBounds(134, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1);
		
		
		
		/** player 9 for sale */
		JPanel team2_player0_8_2_1_1 = new JPanel();
		team2_player0_8_2_1_1.setLayout(null);
		team2_player0_8_2_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_1_1.setBounds(265, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1_1);
		
		JLabel team2_player0_name_8_2_1_1 = new JLabel("Player: " + this.players_to_select.get(9).get_name());
		team2_player0_name_8_2_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1_1.add(team2_player0_name_8_2_1_1);
		
		JLabel team2_player0_offence_8_2_1_1 = new JLabel("Offence: " + this.players_to_select.get(9).get_offence());
		team2_player0_offence_8_2_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1_1.add(team2_player0_offence_8_2_1_1);
		
		JLabel team2_player0_defence_8_2_1_1 = new JLabel("Defence: " + this.players_to_select.get(9).get_defence());
		team2_player0_defence_8_2_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1_1.add(team2_player0_defence_8_2_1_1);
		
		JLabel team2_player0_stamina_8_2_1_1 = new JLabel("Stamina: " + this.players_to_select.get(9).get_stamina());
		team2_player0_stamina_8_2_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1_1.add(team2_player0_stamina_8_2_1_1);
		
		JLabel lblNewLabel_2_2_1_1 = new JLabel("Cost: " + this.players_to_select.get(9).get_value());
		lblNewLabel_2_2_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1_1.add(lblNewLabel_2_2_1_1);
		
		JButton btnNewButton_2_1_1 = new JButton("Buy");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(9);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1_1.setVisible(false);
			}
		});
		btnNewButton_2_1_1.setBounds(265, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1_1);
		
		
		/** player 10 for sale */
		JPanel team2_player0_8_2_1_1_1 = new JPanel();
		team2_player0_8_2_1_1_1.setLayout(null);
		team2_player0_8_2_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_1_1_1.setBounds(396, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1_1_1);
		
		JLabel team2_player0_name_8_2_1_1_1 = new JLabel("Player: " + this.players_to_select.get(10).get_name());
		team2_player0_name_8_2_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1_1_1.add(team2_player0_name_8_2_1_1_1);
		
		JLabel team2_player0_offence_8_2_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(10).get_offence());
		team2_player0_offence_8_2_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1_1_1.add(team2_player0_offence_8_2_1_1_1);
		
		JLabel team2_player0_defence_8_2_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(10).get_defence());
		team2_player0_defence_8_2_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1_1_1.add(team2_player0_defence_8_2_1_1_1);
		
		JLabel team2_player0_stamina_8_2_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(10).get_stamina());
		team2_player0_stamina_8_2_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1_1_1.add(team2_player0_stamina_8_2_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(10).get_value());
		lblNewLabel_2_2_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1_1_1.add(lblNewLabel_2_2_1_1_1);
		
		JButton btnNewButton_2_1_1_1 = new JButton("Buy");
		btnNewButton_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(10);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_1_1_1.setBounds(398, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1_1_1);
		
		
		/** player 11 for sale */
		JPanel team2_player0_8_2_1_1_1_1 = new JPanel();
		team2_player0_8_2_1_1_1_1.setLayout(null);
		team2_player0_8_2_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_1_1_1_1.setBounds(527, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1_1_1_1);
		
		JLabel team2_player0_name_8_2_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(11).get_name());
		team2_player0_name_8_2_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1_1_1_1.add(team2_player0_name_8_2_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(11).get_offence());
		team2_player0_offence_8_2_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1_1_1_1.add(team2_player0_offence_8_2_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(11).get_defence());
		team2_player0_defence_8_2_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1_1_1_1.add(team2_player0_defence_8_2_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(11).get_stamina());
		team2_player0_stamina_8_2_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1_1_1_1.add(team2_player0_stamina_8_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(11).get_value());
		lblNewLabel_2_2_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1_1_1_1.add(lblNewLabel_2_2_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(11);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_1_1_1_1.setBounds(525, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1_1_1_1);
		
		
		
		/** player 12 for sale */
		JPanel team2_player0_8_2_1_1_1_1_1 = new JPanel();
		team2_player0_8_2_1_1_1_1_1.setLayout(null);
		team2_player0_8_2_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_1_1_1_1_1.setBounds(656, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1_1_1_1_1);
		
		JLabel team2_player0_name_8_2_1_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(12).get_name());
		team2_player0_name_8_2_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1_1_1_1_1.add(team2_player0_name_8_2_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_1_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(12).get_offence());
		team2_player0_offence_8_2_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1_1_1_1_1.add(team2_player0_offence_8_2_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_1_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(12).get_defence());
		team2_player0_defence_8_2_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1_1_1_1_1.add(team2_player0_defence_8_2_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_1_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(12).get_stamina());
		team2_player0_stamina_8_2_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1_1_1_1_1.add(team2_player0_stamina_8_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(12).get_value());
		lblNewLabel_2_2_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1_1_1_1_1.add(lblNewLabel_2_2_1_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(12);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_1_1_1_1_1.setBounds(656, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1_1_1_1_1);
		
		
		/** player 13 for sale */
		JPanel team2_player0_8_2_1_1_1_1_1_1 = new JPanel();
		team2_player0_8_2_1_1_1_1_1_1.setLayout(null);
		team2_player0_8_2_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_1_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_1_1_1_1_1_1.setBounds(786, 430, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_1_1_1_1_1_1);
		
		JLabel team2_player0_name_8_2_1_1_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(13).get_name());
		team2_player0_name_8_2_1_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_1_1_1_1_1_1.add(team2_player0_name_8_2_1_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_1_1_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(13).get_offence());
		team2_player0_offence_8_2_1_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_1_1_1_1_1_1.add(team2_player0_offence_8_2_1_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_1_1_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(13).get_defence());
		team2_player0_defence_8_2_1_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_1_1_1_1_1_1.add(team2_player0_defence_8_2_1_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_1_1_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(13).get_stamina());
		team2_player0_stamina_8_2_1_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_1_1_1_1_1_1.add(team2_player0_stamina_8_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_1_1_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(13).get_value());
		lblNewLabel_2_2_1_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_1_1_1_1_1_1.add(lblNewLabel_2_2_1_1_1_1_1_1);
		
		JButton btnNewButton_2_1_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(13);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_1_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_1_1_1_1_1_1.setBounds(786, 569, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_1_1_1_1_1_1);
		
		
		
		/** player 14 for sale */
		JPanel team2_player0_8_2_2 = new JPanel();
		team2_player0_8_2_2.setLayout(null);
		team2_player0_8_2_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2.setBackground(Color.WHITE);
		team2_player0_8_2_2.setBounds(4, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2);
		
		JLabel team2_player0_name_8_2_2 = new JLabel("Player: " + this.players_to_select.get(14).get_name());
		team2_player0_name_8_2_2.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2.add(team2_player0_name_8_2_2);
		
		JLabel team2_player0_offence_8_2_2 = new JLabel("Offence: " + this.players_to_select.get(14).get_offence());
		team2_player0_offence_8_2_2.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2.add(team2_player0_offence_8_2_2);
		
		JLabel team2_player0_defence_8_2_2 = new JLabel("Defence: " + this.players_to_select.get(14).get_defence());
		team2_player0_defence_8_2_2.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2.add(team2_player0_defence_8_2_2);
		
		JLabel team2_player0_stamina_8_2_2 = new JLabel("Stamina: " + this.players_to_select.get(14).get_stamina());
		team2_player0_stamina_8_2_2.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2.add(team2_player0_stamina_8_2_2);
		
		JLabel lblNewLabel_2_2_2 = new JLabel("Cost: " + this.players_to_select.get(14).get_value());
		lblNewLabel_2_2_2.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2.add(lblNewLabel_2_2_2);
		
		JButton btnNewButton_2_2 = new JButton("Buy");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(14);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2.setVisible(false);
			}
		});
		btnNewButton_2_2.setBounds(0, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2);
		
		
		/** player 15 for sale */
		JPanel team2_player0_8_2_2_1 = new JPanel();
		team2_player0_8_2_2_1.setLayout(null);
		team2_player0_8_2_2_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1.setBounds(134, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1);
		
		JLabel team2_player0_name_8_2_2_1 = new JLabel("Player: " + this.players_to_select.get(15).get_name());
		team2_player0_name_8_2_2_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1.add(team2_player0_name_8_2_2_1);
		
		JLabel team2_player0_offence_8_2_2_1 = new JLabel("Offence: " + this.players_to_select.get(15).get_offence());
		team2_player0_offence_8_2_2_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1.add(team2_player0_offence_8_2_2_1);
		
		JLabel team2_player0_defence_8_2_2_1 = new JLabel("Defence: " + this.players_to_select.get(15).get_defence());
		team2_player0_defence_8_2_2_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1.add(team2_player0_defence_8_2_2_1);
		
		JLabel team2_player0_stamina_8_2_2_1 = new JLabel("Stamina: " + this.players_to_select.get(15).get_stamina());
		team2_player0_stamina_8_2_2_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1.add(team2_player0_stamina_8_2_2_1);
		
		JLabel lblNewLabel_2_2_2_1 = new JLabel("Cost: " + this.players_to_select.get(15).get_value());
		lblNewLabel_2_2_2_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1.add(lblNewLabel_2_2_2_1);
		
		JButton btnNewButton_2_2_1 = new JButton("Buy");
		btnNewButton_2_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(15);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1.setBounds(134, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1);
		
		
		
		/** player 16 for sale */
		JPanel team2_player0_8_2_2_1_1 = new JPanel();
		team2_player0_8_2_2_1_1.setLayout(null);
		team2_player0_8_2_2_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1_1.setBounds(265, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1_1);
		
		JLabel team2_player0_name_8_2_2_1_1 = new JLabel("Player: " + this.players_to_select.get(16).get_name());
		team2_player0_name_8_2_2_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1_1.add(team2_player0_name_8_2_2_1_1);
		
		JLabel team2_player0_offence_8_2_2_1_1 = new JLabel("Offence: " + this.players_to_select.get(16).get_offence());
		team2_player0_offence_8_2_2_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1_1.add(team2_player0_offence_8_2_2_1_1);
		
		JLabel team2_player0_defence_8_2_2_1_1 = new JLabel("Defence: " + this.players_to_select.get(16).get_defence());
		team2_player0_defence_8_2_2_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1_1.add(team2_player0_defence_8_2_2_1_1);
		
		JLabel team2_player0_stamina_8_2_2_1_1 = new JLabel("Stamina: " + this.players_to_select.get(16).get_stamina());
		team2_player0_stamina_8_2_2_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1_1.add(team2_player0_stamina_8_2_2_1_1);
		
		JLabel lblNewLabel_2_2_2_1_1 = new JLabel("Cost: " + this.players_to_select.get(16).get_value());
		lblNewLabel_2_2_2_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1_1.add(lblNewLabel_2_2_2_1_1);
		
		JButton btnNewButton_2_2_1_1 = new JButton("Buy");
		btnNewButton_2_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(16);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1_1.setBounds(265, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1_1);
		
		
		/** player 17 for sale */
		JPanel team2_player0_8_2_2_1_1_1 = new JPanel();
		team2_player0_8_2_2_1_1_1.setLayout(null);
		team2_player0_8_2_2_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1_1_1.setBounds(396, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1_1_1);
		
		JLabel team2_player0_name_8_2_2_1_1_1 = new JLabel("Player: " + this.players_to_select.get(17).get_name());
		team2_player0_name_8_2_2_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1_1_1.add(team2_player0_name_8_2_2_1_1_1);
		
		JLabel team2_player0_offence_8_2_2_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(17).get_offence());
		team2_player0_offence_8_2_2_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1_1_1.add(team2_player0_offence_8_2_2_1_1_1);
		
		JLabel team2_player0_defence_8_2_2_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(17).get_defence());
		team2_player0_defence_8_2_2_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1_1_1.add(team2_player0_defence_8_2_2_1_1_1);
		
		JLabel team2_player0_stamina_8_2_2_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(17).get_stamina());
		team2_player0_stamina_8_2_2_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1_1_1.add(team2_player0_stamina_8_2_2_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(17).get_value());
		lblNewLabel_2_2_2_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1_1_1.add(lblNewLabel_2_2_2_1_1_1);
		
		JButton btnNewButton_2_2_1_1_1 = new JButton("Buy");
		btnNewButton_2_2_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(17);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1_1_1.setBounds(394, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1_1_1);
		
		
		/** player 18 for sale */
		JPanel team2_player0_8_2_2_1_1_1_1 = new JPanel();
		team2_player0_8_2_2_1_1_1_1.setLayout(null);
		team2_player0_8_2_2_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1_1_1_1.setBounds(525, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1_1_1_1);
		
		JLabel team2_player0_name_8_2_2_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(18).get_name());
		team2_player0_name_8_2_2_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1_1_1_1.add(team2_player0_name_8_2_2_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_2_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(18).get_offence());
		team2_player0_offence_8_2_2_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1_1_1_1.add(team2_player0_offence_8_2_2_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_2_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(18).get_defence());
		team2_player0_defence_8_2_2_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1_1_1_1.add(team2_player0_defence_8_2_2_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_2_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(18).get_stamina());
		team2_player0_stamina_8_2_2_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1_1_1_1.add(team2_player0_stamina_8_2_2_1_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(18).get_value());
		lblNewLabel_2_2_2_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1_1_1_1.add(lblNewLabel_2_2_2_1_1_1_1);
		
		JButton btnNewButton_2_2_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_2_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(18);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1_1_1_1.setBounds(523, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1_1_1_1);
		
		
		
		/** player 19 for sale */
		JPanel team2_player0_8_2_2_1_1_1_1_1 = new JPanel();
		team2_player0_8_2_2_1_1_1_1_1.setLayout(null);
		team2_player0_8_2_2_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1_1_1_1_1.setBounds(656, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1_1_1_1_1);
		
		JLabel team2_player0_name_8_2_2_1_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(19).get_name());
		team2_player0_name_8_2_2_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1_1_1_1_1.add(team2_player0_name_8_2_2_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_2_1_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(19).get_offence());
		team2_player0_offence_8_2_2_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1_1_1_1_1.add(team2_player0_offence_8_2_2_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_2_1_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(19).get_defence());
		team2_player0_defence_8_2_2_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1_1_1_1_1.add(team2_player0_defence_8_2_2_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_2_1_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(19).get_stamina());
		team2_player0_stamina_8_2_2_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1_1_1_1_1.add(team2_player0_stamina_8_2_2_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(19).get_value());
		lblNewLabel_2_2_2_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1_1_1_1_1.add(lblNewLabel_2_2_2_1_1_1_1_1);
		
		JButton btnNewButton_2_2_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_2_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(19);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1_1_1_1_1.setBounds(658, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1_1_1_1_1);
		
		
		
		/** player 20 for sale */
		JPanel team2_player0_8_2_2_1_1_1_1_1_1 = new JPanel();
		team2_player0_8_2_2_1_1_1_1_1_1.setLayout(null);
		team2_player0_8_2_2_1_1_1_1_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0_8_2_2_1_1_1_1_1_1.setBackground(Color.WHITE);
		team2_player0_8_2_2_1_1_1_1_1_1.setBounds(786, 600, 119, 136);
		choosePlayers.getContentPane().add(team2_player0_8_2_2_1_1_1_1_1_1);
		
		JLabel team2_player0_name_8_2_2_1_1_1_1_1_1 = new JLabel("Player: " + this.players_to_select.get(20).get_name());
		team2_player0_name_8_2_2_1_1_1_1_1_1.setBounds(6, 6, 181, 16);
		team2_player0_8_2_2_1_1_1_1_1_1.add(team2_player0_name_8_2_2_1_1_1_1_1_1);
		
		JLabel team2_player0_offence_8_2_2_1_1_1_1_1_1 = new JLabel("Offence: " + this.players_to_select.get(20).get_offence());
		team2_player0_offence_8_2_2_1_1_1_1_1_1.setBounds(6, 30, 150, 16);
		team2_player0_8_2_2_1_1_1_1_1_1.add(team2_player0_offence_8_2_2_1_1_1_1_1_1);
		
		JLabel team2_player0_defence_8_2_2_1_1_1_1_1_1 = new JLabel("Defence: " + this.players_to_select.get(20).get_defence());
		team2_player0_defence_8_2_2_1_1_1_1_1_1.setBounds(6, 59, 181, 16);
		team2_player0_8_2_2_1_1_1_1_1_1.add(team2_player0_defence_8_2_2_1_1_1_1_1_1);
		
		JLabel team2_player0_stamina_8_2_2_1_1_1_1_1_1 = new JLabel("Stamina: " + this.players_to_select.get(20).get_stamina());
		team2_player0_stamina_8_2_2_1_1_1_1_1_1.setBounds(6, 91, 170, 16);
		team2_player0_8_2_2_1_1_1_1_1_1.add(team2_player0_stamina_8_2_2_1_1_1_1_1_1);
		
		JLabel lblNewLabel_2_2_2_1_1_1_1_1_1 = new JLabel("Cost: " + this.players_to_select.get(20).get_value());
		lblNewLabel_2_2_2_1_1_1_1_1_1.setBounds(6, 119, 107, 16);
		team2_player0_8_2_2_1_1_1_1_1_1.add(lblNewLabel_2_2_2_1_1_1_1_1_1);
		
		JButton btnNewButton_2_2_1_1_1_1_1_1 = new JButton("Buy");
		btnNewButton_2_2_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				check_if_can_buy(20);
				// always hide button anyway as they cannot buy the player again or cannot afford
				btnNewButton_2_2_1_1_1_1_1_1.setVisible(false);
			}
		});
		btnNewButton_2_2_1_1_1_1_1_1.setBounds(786, 740, 117, 29);
		choosePlayers.getContentPane().add(btnNewButton_2_2_1_1_1_1_1_1);
		
		/** display the money that team 1 has */
		 lblNewLabel_4 = new JLabel("Money: $" + manager.team1.get_money());
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(703, 6, 216, 77);
		choosePlayers.getContentPane().add(lblNewLabel_4);
		
		/** button which closes the chooseplayer window and opens the shopGUI
		 * will only be displayed when at least 4 people are in team
		 * 
		 * */
		 btnNewButton_3 = new JButton("Go to Shop!");
		 btnNewButton_3.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		closewindow();
		 		manager.launchshopscreen();
		 	}
		 });
		btnNewButton_3.setBounds(672, 128, 216, 107);
		choosePlayers.getContentPane().add(btnNewButton_3);
		btnNewButton_3.setVisible(false);
	}
}
