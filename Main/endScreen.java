package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;

/** End game screen
 * Display user's stats at the end of the tournament 
 * Dispaly, wins, loses, draws, goals, goals conceded, and money
 * */
public class endScreen {
	
	/** main frame for end screen */
	private JFrame endScreenFrame;
	/** manager variable stored as manager */
	private static teammanager manager;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					endScreen window = new endScreen(manager);
					window.endScreenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public endScreen(teammanager manager) {
		this.manager = manager;
		initialize();
		endScreenFrame.setSize(800, 600);
        endScreenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		endScreenFrame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 * Create several labels which will display the final stats of the user using manager.get functions
	 */
	private void initialize() {
		endScreenFrame = new JFrame();
		endScreenFrame.getContentPane().setLayout(null);
		
		/** label for tournament over stats */
		JLabel lblNewLabel = new JLabel("Tournament Over!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setBounds(302, 6, 580, 43);
		endScreenFrame.getContentPane().add(lblNewLabel);
		
		/** label for final stats */
		JLabel lblNewLabel_1 = new JLabel("Final Stats!");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(22, 83, 290, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_1);
		
		/** label for displaying the total wins that the user has  */
		JLabel lblNewLabel_2 = new JLabel("Wins: " + manager.getGamesWon());
		lblNewLabel_2.setBounds(23, 133, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2);
		
		/** label for displaying the total loses that the user has  */
		JLabel lblNewLabel_2_1 = new JLabel("Loses: " + manager.getGamesLost());
		lblNewLabel_2_1.setBounds(22, 160, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2_1);
		
		/** label for displaying the total draws that the user has  */
		JLabel lblNewLabel_2_2 = new JLabel("Draws: " + manager.getGamesDrawn());
		lblNewLabel_2_2.setBounds(23, 188, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2_2);
		
		/** label for displaying the total goals that the user has  */
		JLabel lblNewLabel_2_3 = new JLabel("Goals scored: " + manager.getGoalsScored());
		lblNewLabel_2_3.setBounds(22, 223, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2_3);
		
		/** label for displaying the total goals conceded that the user has  */
		JLabel lblNewLabel_2_4 = new JLabel("Goals conceded: " + manager.getGoalsConceded());
		lblNewLabel_2_4.setBounds(22, 262, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2_4);
		
		/** label for displaying the money left that the user has  */
		JLabel lblNewLabel_2_5 = new JLabel("Money: " + manager.team1.get_money());
		lblNewLabel_2_5.setBounds(22, 302, 278, 16);
		endScreenFrame.getContentPane().add(lblNewLabel_2_5);
	}

}
