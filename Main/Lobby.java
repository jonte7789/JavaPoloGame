package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;

/** creates lobby gui, 
 * class allows user to select from 8 opponenets to face off against, one an opponent has been selected the user can go to game which closes lobbyGUI and launches the gameGUI
 * 
 * */
public class Lobby {
	/** main frame for lobby */
	private JFrame lobbyframe;
	/** stores manager as variable */
	private static teammanager manager;
	/** array list of teams, used to display the opponents and pass them into manager as needed */
	ArrayList<team> teams_to_face = new ArrayList<team>();
	/** dropdown list containing the teams the user can select and play against*/
	private JComboBox dropdown_list_opponents;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Lobby window = new Lobby(manager);
					window.lobbyframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * creates 8 teams which are added to the array teams_to_face,
	 * the stats of the players depend on the difficulty the user selected at the start of the game in setupscreen
	 * 
	 */
	public Lobby(teammanager manager) {
		this.manager = manager;
		Random random = new Random();
		Integer range_for_difficulty = manager.get_difficulty();
		
		/** create the teams array */
		
		// opponent 1 
		team opponent1 = new team();
		opponent1.set_name("Orange Apes");
		opponent1.add_player(new player("Owen", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent1.add_player(new player("Sam", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent1.add_player(new player("Jacob", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent1.add_player(new player("Asher", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent1);
		
		// opponent 2
		team opponent2 = new team();
		opponent2.set_name("Red Dragons");
		opponent2.add_player(new player("Aiden", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent2.add_player(new player("John", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent2.add_player(new player("Joseph", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent2.add_player(new player("Wyatt", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent2);
		
		// opponent 3
		team opponent3 = new team();
		opponent3.set_name("White Flash");
		opponent3.add_player(new player("David", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent3.add_player(new player("Leo", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent3.add_player(new player("Luke", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent3.add_player(new player("Julian", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent3);
		
		// opponent 4
		team opponent4 = new team();
		opponent4.set_name("Purple Stars");
		opponent4.add_player(new player("Hudson", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent4.add_player(new player("Gray", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent4.add_player(new player("Matt", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent4.add_player(new player("Erza", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent4);
		
		// opponent 5
		team opponent5 = new team();
		opponent5.set_name("Black Bull");
		opponent5.add_player(new player("Yami", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent5.add_player(new player("Asta", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent5.add_player(new player("Zora", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent5.add_player(new player("Luck", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent5);
		
		// opponent 6
		team opponent6 = new team();
		opponent6.set_name("Green Apple");
		opponent6.add_player(new player("Luca", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent6.add_player(new player("Ant", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent6.add_player(new player("Dylan", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent6.add_player(new player("Linc", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent6);
		
		// opponent 7
		team opponent7 = new team();
		opponent7.set_name("Red Demons");
		opponent7.add_player(new player("Thomas", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent7.add_player(new player("Mav", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent7.add_player(new player("Elias", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent7.add_player(new player("Josiah", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent7);
		
		// opponent 8
		team opponent8 = new team();
		opponent8.set_name("Grey Sulkers");
		opponent8.add_player(new player("Charles", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent8.add_player(new player("Caleb", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent8.add_player(new player("Chris", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		opponent8.add_player(new player("Miles", random.nextInt(range_for_difficulty) + 2, random.nextInt(range_for_difficulty) + 2, random.nextInt(201) + 500));
		teams_to_face.add(opponent8);
		
		
		
		
		
		
		
		

		
		
		
		
		initialize();
		lobbyframe.setVisible(true);
		
	}
	
	/** closes the window */
	public void closewindow() {
		lobbyframe.dispose();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 */
	private void initialize() {
		lobbyframe = new JFrame();
		lobbyframe.setBounds(100, 100, 831, 553);
		lobbyframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lobbyframe.getContentPane().setLayout(null);
		/** launches the game GUI and closes lobby screen */
		JButton btnNewButton = new JButton("Go to game");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/** cast the dropdownlist selected item as string then go through array of teams, if name equals team name then add to manager.team2 */
		        String selectedOpponent = (String) dropdown_list_opponents.getSelectedItem();
		        
		        /** Find the team with the selected opponent's name */
		        team selectedTeam = null;
		        for (team t : teams_to_face) {
		            if (t.get_name().equals(selectedOpponent)) {
		                selectedTeam = t;
		                break;
		            }
		        }
		        
		        if (selectedTeam != null) {
		            manager.team2 = selectedTeam;
		            closewindow();
		            manager.launchGameScreen();
		        }
				

			}
		});
		btnNewButton.setBounds(626, 402, 174, 91);
		lobbyframe.getContentPane().add(btnNewButton);
		
		/** create drop down list for storing the opponents, */
		 dropdown_list_opponents = new JComboBox();
		dropdown_list_opponents.setBounds(284, 34, 427, 63);
		lobbyframe.getContentPane().add(dropdown_list_opponents);
		
        /** Add opponents to the dropdown list, using comboboxmodel 
		* JComboBox is  populated with data using a data model */
        DefaultComboBoxModel<String> opponentsModel = new DefaultComboBoxModel<>();
        for (team t : teams_to_face) {
            opponentsModel.addElement(t.get_name());
        }
        dropdown_list_opponents.setModel(opponentsModel);
    
		
		/** label for choose opponent */
		JLabel lblNewLabel = new JLabel("Choose Opponent:");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblNewLabel.setBounds(6, 39, 266, 48);
		lobbyframe.getContentPane().add(lblNewLabel);
	}
}
