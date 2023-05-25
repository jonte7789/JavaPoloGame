package Main;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;

/** GameGUI class.
 * Passes in manager as an argument for the constructor, 
 * Each game lasts for 30 seconds, the goal flashes green upon scoring a goal, and labels in the corner keep track of the score
 * If the user wins the game they receive 250 money, while if they draw they get 100, and nothing if they lose the game
 * Once the 30 second game is over the game screen is closed and the shop screen is opened, here the user can buy new players, consumables and switch around their team layout
 * 
 * 
 * 
 * During the game the play has the options of shooting, passing and switching player positions.
 * 
 * Shooting will call shoot from gamereworked, and if the player scored their team's score will increase and will be shown in the GUI
 * Passing simply passes the ball to the player you want to pass to, changing has_ball status of the two player's (one with ball and one you are passing too)
 * Switch will swap the positions of the player with the ball and the player you wish to switch positions with. 
 * 
 * Shooting will drain 2 stamina each time, and when a player has 0 stamina they are unable to switch, recieve the ball via a pass, or shoot
 * */
public class GameGui3 {

	/** main frame for game GUI */
	private JFrame gameGUIwindow;
	/** manager variable stored in manager */
	private static teammanager manager;
	/** create an instance of gamereworked named game, used to perform game functions */
	private gamereworked game;

	
	/** create panels for players */
	
	/** Player 0 team 1 */
	private JPanel team1_player0;
	private JLabel team1_player0_name;
	private JLabel team1_player0_offence;
	private JLabel team1_player0_defence;
	private JLabel team1_player0_stamina;
	
	/** Player 1 team 1 */
	private JPanel team1_player1;
	private JLabel team1_player1_name;
	private JLabel team1_player1_offence;
	private JLabel team1_player1_defence;
	private JLabel team1_player1_stamina;
	
	/** Player 2 team 1 */
	private JPanel team1_player2;
	private JLabel team1_player2_name;
	private JLabel team1_player2_offence;
	private JLabel team1_player2_defence;
	private JLabel team1_player2_stamina;
	
	/** Player 3 team 1 */
	private JPanel team1_player3;
	private JLabel team1_player3_name;
	private JLabel team1_player3_offence;
	private JLabel team1_player3_defence;
	private JLabel team1_player3_stamina;
	
	/** Player 0 team 2 */
	private JPanel team2_player0;
	private JLabel team2_player0_name;
	private JLabel team2_player0_offence;
	private JLabel team2_player0_defence;
	private JLabel team2_player0_stamina;
	
	/** Player 1 team 2 */
	private JPanel team2_player1;
	private JLabel team2_player1_name;
	private JLabel team2_player1_offence;
	private JLabel team2_player1_defence;
	private JLabel team2_player1_stamina;
	
	/** Player 2 team 2 */
	private JPanel team2_player2;
	private JLabel team2_player2_name;
	private JLabel team2_player2_offence;
	private JLabel team2_player2_defence;
	private JLabel team2_player2_stamina;
	
	/** Player 3 team 2 */
	private JPanel team2_player3;
	private JLabel team2_player3_name;
	private JLabel team2_player3_offence;
	private JLabel team2_player3_defence;
	private JLabel team2_player3_stamina;
	
	/** player 0 team 1 shoot button */
	private JButton team1_player0_shoot_button;
	/** player 1 team 1 shoot button */
	private JButton team1_player1_shoot_button;
	/** player 2 team 1 shoot button */
	private JButton team1_player2_shoot_button;
	/** player 3 team 1 shoot button */
	private JButton team1_player3_shoot_button;
	/** player 0 team 1 pass button */
	private JButton team1_player0_pass_button;
	/** player 1 team 1 pass button */
	private JButton team1_player1_pass_button;
	/** player 2 team 1 pass button */
	private JButton team1_player2_pass_button;
	/** player 3 team 1 pass button */
	private JButton team1_player3_pass_button;
	/** player 0 team 1 switch button */
	private JButton btnNewButton;
	/** player 1 team 1 switch button */
	private JButton btnNewButton_1;
	/** player 2 team 1 switch button */
	private JButton btnNewButton_2;
	/** player 3 team 1 switch button */
	private JButton btnNewButton_3;
	
	
	/** Labels for keeping track of score */ 
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	
	
	private Integer team1scorerelative = 0;
	private Integer team2scorerelative = 0;
	
	/** Goal 1 */
	private JPanel panel_1;
	private JLabel lblNewLabel_5;
	/** Goal 2 */
	private JPanel panel_2;
	private JLabel lblNewLabel_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameGui3 window = new GameGui3(manager);
					window.gameGUIwindow.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	


	/** Create instance of gamegui3, passing in manager which is stored as a variable called manager
	 * Create an instance of game passing in manager. Increase games played by 1. 
	 * Start a 30 second timer via function startTimer(); and start game through game class.
	 * 
	 * THroughout the 30 second duration update values is called periodically as well as called every time the user clicks shoot, pass or switch
	 * 
	 * 
	 * Update Values goes through all players in team 1 and team 2 and updates their values accordingly, 
	 * All buttons are hide when team 2 (computer) is playing
	 * Only the player with the ball (which is highlighted blue) can shoot
	 * Players with 0 stamina cannot receive the ball via a pass, and they cannot shoot or switch. 
	 * 
	 * After the game is over (30 seconds have finished, timer has stopped) gameGUI is closed via closeWindow() and shopGUI is launched.
	 * If the user wins they receive 250 money for their team, if they draw they receive 100 and nothing for a lose.
	 * 
	 * */
	public GameGui3(teammanager manager) {
		this.manager = manager;
		this.game = new gamereworked(manager);
		this.team1scorerelative = 0;
		this.team2scorerelative = 0;
		this.manager.setGamesplayed(1 + manager.getGamesplayed());
		
		/** reset stamina */
		reset_stamina();
		
		initialize();
		/** will start the worker, last for 30 seconds */
		startTimer();
		/** start game round */ 
		this.game.start_round();
		updateValues();
		/** show window */
		gameGUIwindow.setVisible(true);
		updateValues();
	}
	
	/** reset the stamina of every player in team 1 and team 2 before the game starts */
	public void reset_stamina() {
		 for (int i = 0; i < manager.team1.team.size(); i++) {
			 manager.team1.team.get(i).set_stamina(10);
		 }
		 for (int j = 0; j < manager.team1.reserve.size(); j++) {
			 manager.team1.reserve.get(j).set_stamina(10);
		 }
		 for (int k = 0; k < manager.team2.team.size(); k++) {
			 manager.team2.team.get(k).set_stamina(10);
		 }
	}
	
	
	/** close window */
	public void closeWindow() {
		gameGUIwindow.dispose();
	}
	
	/** timer for 30 second, then the game closes 
	 * will start the game in this section
	 * Creates  a timer which lasts for 30 seconds
	 *  */
	private void startTimer() {
	    int delay = 30000; //  timer set for 30 seconds

	    Timer mainTimer = new Timer(delay, new ActionListener() {
	        public void actionPerformed(ActionEvent evt) {
	        	/** after 30 seconds are over close main window and launch shop 
	        	 * call the winner function to adjust wins and loses
	        	 * */
	        	
	        	game.winner();
	        	gameGUIwindow.setVisible(false);
	        	closeWindow();
	            manager.launchshopscreen();
	        }
	    });
	    /** currently only using once per game*/
	    mainTimer.setRepeats(false);
	    mainTimer.start();

	    /** Swing worker allows for updates of panels and labels, constantly update values every 2750 milliseconds via updateValues()
	     * 
	     *  
	     *  */
	    SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
	        @Override
	        protected Void doInBackground() throws Exception {
	            while (true) {
	                updateValues(); // Update the labels and stats 
	                Thread.sleep(2750); 
	            }
	        }
	    };
	    /** execute the worker which will be checking for updates of values (SwingWorker is called via worker.execute())
	     * 
	     *  */
	    worker.execute();
	}
	
	
	/** make the computer play after 2.75 seconds roughly
	 * The computer will use the function in class gamereworked called computer_shoot, if the computer scores team 2 score increases and 
	 * is displayed in the gameGUI in a label in the right corner. After the computer shoots the ball is passed to a random player in team 1
	 * 
	 *  */
	private void delayAndExecuteComputerShoot() {
		game.computer_shoot();	
		
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gameGUIwindow = new JFrame();
		gameGUIwindow.setTitle("Polo Game");
		gameGUIwindow.setBounds(100, 100, 1405, 693);
		gameGUIwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameGUIwindow.getContentPane().setLayout(null);
		
		
		/** player 0 team 1 */
		 team1_player0 = new JPanel();
		team1_player0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team1_player0.setBounds(26, 234, 193, 162);
		gameGUIwindow.getContentPane().add(team1_player0);
		team1_player0.setLayout(null);
		
		 team1_player0_name = new JLabel("Player: ");
		team1_player0_name.setBounds(6, 6, 181, 16);
		team1_player0.add(team1_player0_name);
		
		 team1_player0_offence = new JLabel("Offence: ");
		team1_player0_offence.setBounds(6, 30, 150, 16);
		team1_player0.add(team1_player0_offence);
		
		 team1_player0_defence = new JLabel("Defence");
		team1_player0_defence.setBounds(6, 59, 181, 16);
		team1_player0.add(team1_player0_defence);
		
		 team1_player0_stamina = new JLabel("Stamina: ");
		team1_player0_stamina.setBounds(6, 91, 170, 16);
		team1_player0.add(team1_player0_stamina);
		
		/** player 0 team 1 shoot button */
		team1_player0_shoot_button = new JButton("Shoot");
		team1_player0_shoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.shoot(0);
				updateValues();
				delayAndExecuteComputerShoot();
				
			}
		});
		team1_player0_shoot_button.setBounds(52, 398, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player0_shoot_button);
		
		/** player 0 team 1 pass button */
		team1_player0_pass_button = new JButton("Pass");
		team1_player0_pass_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.pass(manager.team1.team.get(game.player_with_ball(manager.team1)), manager.team1.team.get(0));
				updateValues();
			}
		});
		team1_player0_pass_button.setBounds(52, 438, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player0_pass_button);
		
		/** player 1 team 1 */
		team1_player1 = new JPanel();
		team1_player1.setLayout(null);
		team1_player1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team1_player1.setBounds(231, 234, 193, 162);
		gameGUIwindow.getContentPane().add(team1_player1);
		
		team1_player1_name = new JLabel("Player: ");
		team1_player1_name.setBounds(6, 6, 181, 16);
		team1_player1.add(team1_player1_name);
		
		team1_player1_offence = new JLabel("Offence: ");
		team1_player1_offence.setBounds(6, 30, 150, 16);
		team1_player1.add(team1_player1_offence);
		
		team1_player1_defence = new JLabel("Defence");
		team1_player1_defence.setBounds(6, 59, 181, 16);
		team1_player1.add(team1_player1_defence);
		
		team1_player1_stamina = new JLabel("Stamina: ");
		team1_player1_stamina.setBounds(6, 91, 170, 16);
		team1_player1.add(team1_player1_stamina);
		
		/** player 1 team 1 shoot button */
		team1_player1_shoot_button = new JButton("Shoot");
		team1_player1_shoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.shoot(1);
				updateValues();
				delayAndExecuteComputerShoot();
			}
		});
		team1_player1_shoot_button.setBounds(243, 398, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player1_shoot_button);
		
		/** player 1 team 1 pass button */
		team1_player1_pass_button = new JButton("Pass");
		team1_player1_pass_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.pass(manager.team1.team.get(game.player_with_ball(manager.team1)), manager.team1.team.get(1));
				updateValues();
			}
		});
		team1_player1_pass_button.setBounds(243, 438, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player1_pass_button);
		
		
		
		/** player 2 team 1 */
		team1_player2 = new JPanel();
		team1_player2.setLayout(null);
		team1_player2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team1_player2.setBounds(458, 234, 193, 162);
		gameGUIwindow.getContentPane().add(team1_player2);
		
		team1_player2_name = new JLabel("Player: ");
		team1_player2_name.setBounds(6, 6, 181, 16);
		team1_player2.add(team1_player2_name);
		
		team1_player2_offence = new JLabel("Offence: ");
		team1_player2_offence.setBounds(6, 30, 150, 16);
		team1_player2.add(team1_player2_offence);
		
		team1_player2_defence = new JLabel("Defence");
		team1_player2_defence.setBounds(6, 59, 181, 16);
		team1_player2.add(team1_player2_defence);
		
		team1_player2_stamina = new JLabel("Stamina: ");
		team1_player2_stamina.setBounds(6, 91, 170, 16);
		team1_player2.add(team1_player2_stamina);
		
		/** player 2 team 1 shoot button */
		team1_player2_shoot_button = new JButton("Shoot");
		team1_player2_shoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.shoot(2);
				updateValues();
				delayAndExecuteComputerShoot();
			}
		});
		team1_player2_shoot_button.setBounds(522, 398, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player2_shoot_button);
		
		/** player 2 team 1 pass button */
		team1_player2_pass_button = new JButton("Pass");
		team1_player2_pass_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.pass(manager.team1.team.get(game.player_with_ball(manager.team1)), manager.team1.team.get(2));
				updateValues();
			}
		});
		team1_player2_pass_button.setBounds(522, 438, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player2_pass_button);
		
		
		
		/** player 3 team 1 */
		team1_player3 = new JPanel();
		team1_player3.setLayout(null);
		team1_player3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team1_player3.setBounds(676, 234, 193, 162);
		gameGUIwindow.getContentPane().add(team1_player3);
		
		team1_player3_name = new JLabel("Player: ");
		team1_player3_name.setBounds(6, 6, 181, 16);
		team1_player3.add(team1_player3_name);
		
		team1_player3_offence = new JLabel("Offence: ");
		team1_player3_offence.setBounds(6, 30, 150, 16);
		team1_player3.add(team1_player3_offence);
		
		team1_player3_defence = new JLabel("Defence");
		team1_player3_defence.setBounds(6, 59, 181, 16);
		team1_player3.add(team1_player3_defence);
		
		team1_player3_stamina = new JLabel("Stamina: ");
		team1_player3_stamina.setBounds(6, 91, 170, 16);
		team1_player3.add(team1_player3_stamina);
		
		/** player 3 team 1 shoot button */
		team1_player3_shoot_button = new JButton("Shoot");
		team1_player3_shoot_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.shoot(3);
				updateValues();
				delayAndExecuteComputerShoot();
			}
		});
		team1_player3_shoot_button.setBounds(686, 398, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player3_shoot_button);
		
		/** player 3 team 1 pass button */
		team1_player3_pass_button = new JButton("Pass");
		team1_player3_pass_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				game.pass(manager.team1.team.get(game.player_with_ball(manager.team1)), manager.team1.team.get(3));
				updateValues();
			}
		});
		team1_player3_pass_button.setBounds(686, 438, 129, 39);
		gameGUIwindow.getContentPane().add(team1_player3_pass_button);
		
		
		
		/** player 0 team 2 */
		team2_player0 = new JPanel();
		team2_player0.setLayout(null);
		team2_player0.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player0.setBounds(26, 67, 193, 162);
		gameGUIwindow.getContentPane().add(team2_player0);
		
		team2_player0_name = new JLabel("Player: ");
		team2_player0_name.setBounds(6, 6, 181, 16);
		team2_player0.add(team2_player0_name);
		
		team2_player0_offence = new JLabel("Offence: ");
		team2_player0_offence.setBounds(6, 30, 150, 16);
		team2_player0.add(team2_player0_offence);
		
		team2_player0_defence = new JLabel("Defence");
		team2_player0_defence.setBounds(6, 59, 181, 16);
		team2_player0.add(team2_player0_defence);
		
		team2_player0_stamina = new JLabel("Stamina: ");
		team2_player0_stamina.setBounds(6, 91, 170, 16);
		team2_player0.add(team2_player0_stamina);
		
		
		/** player 1 team 2 */
		team2_player1 = new JPanel();
		team2_player1.setLayout(null);
		team2_player1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player1.setBounds(231, 67, 193, 162);
		gameGUIwindow.getContentPane().add(team2_player1);
		
		team2_player1_name = new JLabel("Player: ");
		team2_player1_name.setBounds(6, 6, 181, 16);
		team2_player1.add(team2_player1_name);
		
		team2_player1_offence = new JLabel("Offence: ");
		team2_player1_offence.setBounds(6, 30, 150, 16);
		team2_player1.add(team2_player1_offence);
		
		team2_player1_defence = new JLabel("Defence");
		team2_player1_defence.setBounds(6, 59, 181, 16);
		team2_player1.add(team2_player1_defence);
		
		team2_player1_stamina = new JLabel("Stamina: ");
		team2_player1_stamina.setBounds(6, 91, 170, 16);
		team2_player1.add(team2_player1_stamina);
		
		
		
		/** player 2 team 2 */
		team2_player2 = new JPanel();
		team2_player2.setLayout(null);
		team2_player2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player2.setBounds(458, 67, 193, 162);
		gameGUIwindow.getContentPane().add(team2_player2);
		
		team2_player2_name = new JLabel("Player: ");
		team2_player2_name.setBounds(6, 6, 181, 16);
		team2_player2.add(team2_player2_name);
		
		team2_player2_offence = new JLabel("Offence: ");
		team2_player2_offence.setBounds(6, 30, 150, 16);
		team2_player2.add(team2_player2_offence);
		
		team2_player2_defence = new JLabel("Defence");
		team2_player2_defence.setBounds(6, 59, 181, 16);
		team2_player2.add(team2_player2_defence);
		
		team2_player2_stamina = new JLabel("Stamina: ");
		team2_player2_stamina.setBounds(6, 91, 170, 16);
		team2_player2.add(team2_player2_stamina);
		
		
		
		
		/** player 3 team 2 */
		team2_player3 = new JPanel();
		team2_player3.setLayout(null);
		team2_player3.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		team2_player3.setBounds(676, 67, 193, 162);
		gameGUIwindow.getContentPane().add(team2_player3);
		
		team2_player3_name = new JLabel("Player: ");
		team2_player3_name.setBounds(6, 6, 181, 16);
		team2_player3.add(team2_player3_name);
		
		team2_player3_offence = new JLabel("Offence: ");
		team2_player3_offence.setBounds(6, 30, 150, 16);
		team2_player3.add(team2_player3_offence);
		
		team2_player3_defence = new JLabel("Defence");
		team2_player3_defence.setBounds(6, 59, 181, 16);
		team2_player3.add(team2_player3_defence);
		
		team2_player3_stamina = new JLabel("Stamina: ");
		team2_player3_stamina.setBounds(6, 91, 170, 16);
		team2_player3.add(team2_player3_stamina);
		
		lblNewLabel = new JLabel("Team 1");
		lblNewLabel.setBounds(39, 24, 88, 16);
		gameGUIwindow.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Team 2");
		lblNewLabel_1.setBounds(589, 24, 61, 16);
		gameGUIwindow.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("team1score");
		lblNewLabel_2.setBounds(139, 24, 88, 16);
		gameGUIwindow.getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("team2score");
		lblNewLabel_3.setBounds(714, 24, 88, 16);
		gameGUIwindow.getContentPane().add(lblNewLabel_3);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(406, 0, 69, 65);
		gameGUIwindow.getContentPane().add(panel_1);
		
		lblNewLabel_5 = new JLabel("GOAL");
		lblNewLabel_5.setBounds(6, 6, 61, 16);
		panel_1.add(lblNewLabel_5);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_2.setBounds(406, 408, 69, 65);
		gameGUIwindow.getContentPane().add(panel_2);
		
		lblNewLabel_6 = new JLabel("GOAL");
		lblNewLabel_6.setBounds(6, 6, 61, 16);
		panel_2.add(lblNewLabel_6);
		
		/** switch position 0 team 1 */
		btnNewButton = new JButton("Switch");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer currentposition = game.player_with_ball(manager.team1);
				player player1 = manager.team1.team.get(currentposition);
				player player2 = manager.team1.team.get(0);
				manager.team1.switch_players(player1, player2);
				updateValues();
			}
		});
		btnNewButton.setBounds(52, 483, 129, 39);
		gameGUIwindow.getContentPane().add(btnNewButton);
		
		/** switch position 1 team 1 */
		btnNewButton_1 = new JButton("Switch");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer currentposition = game.player_with_ball(manager.team1);
				player player1 = manager.team1.team.get(currentposition);
				player player2 = manager.team1.team.get(1);
				manager.team1.switch_players(player1, player2);
				updateValues();
			}
		});
		btnNewButton_1.setBounds(243, 489, 129, 39);
		gameGUIwindow.getContentPane().add(btnNewButton_1);
		
		
		/** switch position 2 team 1 */
		btnNewButton_2 = new JButton("Switch");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer currentposition = game.player_with_ball(manager.team1);
				player player1 = manager.team1.team.get(currentposition);
				player player2 = manager.team1.team.get(2);
				manager.team1.switch_players(player1, player2);
				updateValues();
			}
		});
		btnNewButton_2.setBounds(522, 488, 129, 39);
		gameGUIwindow.getContentPane().add(btnNewButton_2);
		
		
		/** switch position 3 team 1 */
		btnNewButton_3 = new JButton("Switch");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer currentposition = game.player_with_ball(manager.team1);
				player player1 = manager.team1.team.get(currentposition);
				player player2 = manager.team1.team.get(3);
				manager.team1.switch_players(player1, player2);
				updateValues();
			}
		});
		btnNewButton_3.setBounds(676, 489, 129, 39);
		gameGUIwindow.getContentPane().add(btnNewButton_3);
		

		

		

		

		

		

		

		

	}
	
	
	/** Function which updates all player panels, labels, goals, and score 
	 * 
	 * Hides team 1 buttons if team 2 has the ball
	 * Hides shoot button for all players except player with ball (if team 1 has the ball)
	 * Hides pass and switch button for the player with the ball
	 * Players with 0 stamina cannot receive the ball via a pass or be switched with, and they cannot shoot these buttons will be hidden
	 * 
	 * If team 1 or team 2 scores a goal the goal will turn green for a brief moment 
	 * 
	 * */
	public void updateValues() {
		
		/** hide buttons if computer playing */
		if (game.team_with_ball() == manager.team2) {
			team1_player0_pass_button.setVisible(false);
			
			team1_player1_pass_button.setVisible(false);

			team1_player2_pass_button.setVisible(false);
			
			team1_player3_pass_button.setVisible(false);
		}
		/** computer is not playing so show the pass buttons */
		else {
			team1_player0_pass_button.setVisible(true);

			team1_player1_pass_button.setVisible(true);

			team1_player2_pass_button.setVisible(true);

			team1_player3_pass_button.setVisible(true);
		}
		
		/**  always hide shoot button , show if the player has the ball*/
		team1_player0_shoot_button.setVisible(false);
		
		team1_player1_shoot_button.setVisible(false);

		team1_player2_shoot_button.setVisible(false);

		team1_player3_shoot_button.setVisible(false);
		
		/** show switch buttons */
		btnNewButton.setVisible(true);
		btnNewButton_1.setVisible(true);
		btnNewButton_2.setVisible(true);
		btnNewButton_3.setVisible(true);
		
		
		
		
		
		/** update team 1 player 0 */
		team1_player0.setBackground(Color.WHITE);
		team1_player0_name.setText("Player: " + manager.team1.team.get(0).get_name());
		team1_player0_offence.setText("Offence: " + manager.team1.team.get(0).get_offence());
		team1_player0_defence.setText("Defence: " + manager.team1.team.get(0).get_defence());
		team1_player0_stamina.setText("Stamina: " + manager.team1.team.get(0).get_stamina());
		if (manager.team1.team.get(0).has_ball() == true) {
			btnNewButton.setVisible(false);
			team1_player0.setBackground(new Color(173, 216, 230));
			team1_player0_shoot_button.setVisible(true);
			team1_player0_pass_button.setVisible(false);

		}
		/** update team 1 player 1 */
		team1_player1.setBackground(Color.WHITE);
		team1_player1_name.setText("Player: " + manager.team1.team.get(1).get_name());
		team1_player1_offence.setText("Offence: " + manager.team1.team.get(1).get_offence());
		team1_player1_defence.setText("Defence: " + manager.team1.team.get(1).get_defence());
		team1_player1_stamina.setText("Stamina: " + manager.team1.team.get(1).get_stamina());
		if (manager.team1.team.get(1).has_ball()) {
			btnNewButton_1.setVisible(false);
		    team1_player1.setBackground(new Color(173, 216, 230));
			team1_player1_shoot_button.setVisible(true);

		    team1_player1_pass_button.setVisible(false);
		}

		/** update team 1 player 2 */
		team1_player2.setBackground(Color.WHITE);
		team1_player2_name.setText("Player: " + manager.team1.team.get(2).get_name());
		team1_player2_offence.setText("Offence: " + manager.team1.team.get(2).get_offence());
		team1_player2_defence.setText("Defence: " + manager.team1.team.get(2).get_defence());
		team1_player2_stamina.setText("Stamina: " + manager.team1.team.get(2).get_stamina());
		if (manager.team1.team.get(2).has_ball()) {
			btnNewButton_2.setVisible(false);
		    team1_player2.setBackground(new Color(173, 216, 230));
			team1_player2_shoot_button.setVisible(true);

		    team1_player2_pass_button.setVisible(false);
		}

		/** update team 1 player 3 */
		team1_player3.setBackground(Color.WHITE);
		team1_player3_name.setText("Player: " + manager.team1.team.get(3).get_name());
		team1_player3_offence.setText("Offence: " + manager.team1.team.get(3).get_offence());
		team1_player3_defence.setText("Defence: " + manager.team1.team.get(3).get_defence());
		team1_player3_stamina.setText("Stamina: " + manager.team1.team.get(3).get_stamina());
		if (manager.team1.team.get(3).has_ball()) {
			btnNewButton_3.setVisible(false);
		    team1_player3.setBackground(new Color(173, 216, 230));
			team1_player3_shoot_button.setVisible(true);
		    team1_player3_pass_button.setVisible(false);
		}
		
		/** update team 2 player 0 */
		team2_player0.setBackground(Color.WHITE);
		team2_player0_name.setText("Player: " + manager.team2.team.get(0).get_name());
		team2_player0_offence.setText("Offence: " + manager.team2.team.get(0).get_offence());
		team2_player0_defence.setText("Defence: " + manager.team2.team.get(0).get_defence());
		team2_player0_stamina.setText("Stamina: " + manager.team2.team.get(0).get_stamina());
		if (manager.team2.team.get(0).has_ball()) {
		    team2_player0.setBackground(new Color(173, 216, 230));
		}

		/** update team 2 player 1 */
		team2_player1.setBackground(Color.WHITE);
		team2_player1_name.setText("Player: " + manager.team2.team.get(1).get_name());
		team2_player1_offence.setText("Offence: " + manager.team2.team.get(1).get_offence());
		team2_player1_defence.setText("Defence: " + manager.team2.team.get(1).get_defence());
		team2_player1_stamina.setText("Stamina: " + manager.team2.team.get(1).get_stamina());
		if (manager.team2.team.get(1).has_ball()) {
		    team2_player1.setBackground(new Color(173, 216, 230));
		}

		/** update team 2 player 2 */
		team2_player2.setBackground(Color.WHITE);
		team2_player2_name.setText("Player: " + manager.team2.team.get(2).get_name());
		team2_player2_offence.setText("Offence: " + manager.team2.team.get(2).get_offence());
		team2_player2_defence.setText("Defence: " + manager.team2.team.get(2).get_defence());
		team2_player2_stamina.setText("Stamina: " + manager.team2.team.get(2).get_stamina());
		if (manager.team2.team.get(2).has_ball()) {
		    team2_player2.setBackground(new Color(173, 216, 230));
		}

		/** update team 2 player 3 */
		team2_player3.setBackground(Color.WHITE);
		team2_player3_name.setText("Player: " + manager.team2.team.get(3).get_name());
		team2_player3_offence.setText("Offence: " + manager.team2.team.get(3).get_offence());
		team2_player3_defence.setText("Defence: " + manager.team2.team.get(3).get_defence());
		team2_player3_stamina.setText("Stamina: " + manager.team2.team.get(3).get_stamina());
		if (manager.team2.team.get(3).has_ball()) {
		    team2_player3.setBackground(new Color(173, 216, 230));
		}
		
		/** update team 1 score label */
		lblNewLabel_2.setText("" + manager.team1.get_score());
		/** update team 2 score label */
		lblNewLabel_3.setText("" + manager.team2.get_score());
		
		/** If goal has been scored for team 1 then make the goal go green for a brief moment */
		panel_1.setBackground(Color.WHITE);
		/** Creates a timer which changes the panel to green for 1 second then white*/
		if (team1scorerelative != manager.team1.get_score()) {
			team1scorerelative = manager.team1.get_score();
		panel_1.setBackground(Color.GREEN);
        Timer timer1 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_1.setBackground(Color.WHITE);
                ((Timer) e.getSource()).stop(); 
            }
        });
        timer1.setRepeats(false);
        timer1.start();
		}
		
		
		/** If goal has been scored for team 2 then make the goal go green for a brief moment */
		panel_2.setBackground(Color.WHITE); 
		/** Creates a timer which changes the panel to green for 1 second then white*/
		if (team2scorerelative != manager.team2.get_score()) {
			team2scorerelative = manager.team2.get_score();
        panel_2.setBackground(Color.GREEN);
        Timer timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel_2.setBackground(Color.WHITE); 
                ((Timer) e.getSource()).stop(); 
            }
        });
        timer2.setRepeats(false); 
        timer2.start(); 
		}
        

      
        
        
        


		
		/** hide pass / switch buttons if stamina is 0 */
		if (manager.team1.team.get(0).get_stamina() <= 0) {
			btnNewButton.setVisible(false);
			team1_player0_pass_button.setVisible(false);
			team1_player0_shoot_button.setVisible(false);
		}
		/** hide pass / switch buttons if stamina is 0 */
		if (manager.team1.team.get(1).get_stamina() <= 0) {
			btnNewButton_1.setVisible(false);
			team1_player1_pass_button.setVisible(false);
			team1_player1_shoot_button.setVisible(false);
		}
		/** hide pass / switch buttons if stamina is 0 */
		if (manager.team1.team.get(2).get_stamina() <= 0) {
			btnNewButton_2.setVisible(false);
			team1_player2_pass_button.setVisible(false);
			team1_player2_shoot_button.setVisible(false);
		}
		/** hide pass / switch buttons if stamina is 0 */
		if (manager.team1.team.get(3).get_stamina() <= 0) {
			btnNewButton_3.setVisible(false);
			team1_player3_pass_button.setVisible(false);
			team1_player3_shoot_button.setVisible(false);
		}
		
		


		
		
		

		

		
	}

}
