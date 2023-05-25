package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import java.awt.Font;

/** setupscreen is the first screen when launching the game
 * Choose difficulty, team name, and tournament length before being allowed to move to choose players screen
 * 
 * */
public class setupscreen extends teammanager {
	/** main frame for setupscreen  */
	private JFrame setupscreenframe;
	/** store manager as a variable  */
	private static teammanager manager;
	private JTextField txtTeamName;
	/** array of boolean, used to see which difficulty has been picked */
	boolean[] buttonClicked = new boolean[2];
	private JLabel lblNewLabel_2;
	private JButton btnNewButton_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	/** used to set difficulty for team1 and set team1's money status, and name status */
	private team team1;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					setupscreen window = new setupscreen(manager);
					window.setupscreenframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public setupscreen(teammanager manager) {
		this.manager = manager;
		initialize();
		setupscreenframe.setVisible(true);
	}
	
	/** closes the window */
	public void closewindow() {
		setupscreenframe.dispose();
	}
	/** closes window via manager */
	public void finishedWindow() {
		manager.closesetupscreen(this);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setupscreenframe = new JFrame();
		setupscreenframe.setBounds(100, 100, 860, 614);
		setupscreenframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupscreenframe.getContentPane().setLayout(null);
		

		
		txtTeamName = new JTextField();
		txtTeamName.setBounds(132, 6, 130, 26);
		setupscreenframe.getContentPane().add(txtTeamName);
		txtTeamName.setColumns(10);
		/**  label for team name */
		JLabel lblNewLabel = new JLabel("Enter Team Name:");
		lblNewLabel.setBounds(6, 11, 114, 16);
		setupscreenframe.getContentPane().add(lblNewLabel);
		/** label for difficulty */
		JLabel lblNewLabel_1 = new JLabel("Choose difficulty: ");
		lblNewLabel_1.setBounds(6, 50, 136, 16);
		setupscreenframe.getContentPane().add(lblNewLabel_1);
		
		/** button for difficulty easy, set button clicked status 0 to true and 1 to false, used to set difficulty of team */
		 btnNewButton_1 = new JButton("Easy");
		 btnNewButton_1.setBackground(new Color(238, 238, 238));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setForeground(Color.GREEN);
				btnNewButton_2.setForeground(Color.BLACK);
				buttonClicked[0] = true;
				buttonClicked[1] = false;
			}
		});
		btnNewButton_1.setBounds(132, 45, 117, 29);
		setupscreenframe.getContentPane().add(btnNewButton_1);
		
		/** button for difficulty easy, set button clicked status 1 to true and 0 to false, used to set difficulty of team */
		 btnNewButton_2 = new JButton("Hard");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// turn button green
				Color green = new Color(144, 240, 140);
				btnNewButton_1.setForeground(Color.BLACK);
				btnNewButton_2.setForeground(Color.GREEN);
				buttonClicked[1] = true;
				buttonClicked[0] = false;
			}
		});
		btnNewButton_2.setBounds(261, 45, 117, 29);
		setupscreenframe.getContentPane().add(btnNewButton_2);
		
		/** once this button is clicked, choose players screen will open and setupscreen will close
		 * only opens choose player screen if a team name is entered, a difficulty is selected.
		 * Tournament length is set to 5 by default so no need to test if this has been set
		 *  
		 *  */
		JButton btnNewButton = new JButton("Choose Players");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtTeamName.getText().length() > 0) {
					if (buttonClicked[0] == true || buttonClicked[1] == true) {
						/** easy difficulty has been chosen, set team with 3000 as money value */
						if (buttonClicked[0] == true) {
							team team1 = new team(3000, txtTeamName.getText());
							manager.team1 = team1;
							manager.set_difficulty(7);
							closewindow();
							manager.launchchoosePlayers();
						}
						else {
							/** hard difficulty has been chosen, set team with 1500 as money value */
							team team1 = new team(1500, txtTeamName.getText());
							manager.team1 = team1;
							manager.set_difficulty(9);
							closewindow();
							manager.launchchoosePlayers();

						}
						

						
						
						
						
						
					}
						
					/** user has not entered difficulty */
					else {
						lblNewLabel_2.setText("Please enter difficulty");
					}
				
				}
				/** user has not entered a name */
				else {
					lblNewLabel_2.setText("Please enter name");
				}
			}
		});
		btnNewButton.setBounds(145, 129, 186, 29);
		setupscreenframe.getContentPane().add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(132, 88, 200, 16);
		setupscreenframe.getContentPane().add(lblNewLabel_2);
		
		/** create slider and listen for changes in it */
		JSlider slider = new JSlider();
		slider.setBackground(new Color(202, 205, 254));
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(1);
		slider.setMaximum(15);
		slider.setMinimum(5);
		/** set default to 5 */
		slider.setValue(5); 
		slider.setBounds(44, 231, 754, 66);
		slider.setPaintTicks(true); 
		slider.setPaintLabels(true); 
		setupscreenframe.getContentPane().add(slider);
		/** if it is moved change tournament length for manager */
		slider.addChangeListener(new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        JSlider source = (JSlider) e.getSource();
		        int value = source.getValue();
		        manager.setTournament_length(value);
		    }
		});
		
		JLabel lblNewLabel_3 = new JLabel("Tournament Length:");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(39, 185, 200, 34);
		setupscreenframe.getContentPane().add(lblNewLabel_3);
		
		
	}
}
