package Main;

/** class used to store majority of the game's information
 *  holds two teams in variables team1 and team2
 *  Holds difficulty variable used in lobby when building the stats of the opponents
 *  Holds variables, tournament_length, goals_scored, goals_conceded, games_won, games_lost and games_drawn
 *  
 *  
 *  Passed in every GUI as a parameter
 *  */
public class teammanager {
	/** used to store team 1, type team  */
	public team team1;
	/**  used to store team 2, type team */
	public team team2;
	/** used to store difficulty, integer */
	public Integer difficulty;
	/** used to store games played as integer, used to check if games played >= tournament_length then tournament is over */
	public Integer gamesplayed;
	/** Integer: stores the length the user decided the tournament should be */
	public Integer tournament_length;
	/** INteger: keeps track of goals scored from team 1 */
	public Integer goals_scored;
	/**  Integer: keeps track of goals team 1 has conceded */
	public Integer goals_conceded;
	/**  Integer: keeps track of games that team 1 has won */
	public Integer games_won;
	/** Integer: keeps track of games lost for team 1 */
	public Integer games_lost;
	/** Integer: keeps track of games drawn for team 1 */
	public Integer games_drawn;
	
	/** Default constructor, set all variables to 0, and set tournament length to 5 (as default) 
	 * Team 1 and team 2 are set via set_team_1 and set_team_2 helper functions
	 * 
	 * */ 
	teammanager(){
		this.difficulty = 0;
		this.gamesplayed = 0;
		// set to 5 by default
		this.tournament_length = 5;
		this.goals_scored = 0;
		this.goals_conceded = 0;
		this.games_won = 0;
		this.games_lost = 0;
		this.games_drawn = 0;
		
	}
	/** alternative constructor to build teammanager */
	teammanager(team team1, team team2){
		this.team1 = team1;
		this.team2 = team2;
	}
	
	
	/** helper function, takes team as a parameter, sets value passed in as team1 */
	void set_team_1(team team1){
		this.team1 = team1;
	}
	/** helper function, takes team as a parameter, sets value passed in as team2 */
	void set_team_2(team team2) {
		this.team2 = team2;
	}
	
	/** launch gameGUI screen */
	public void launchGameScreen() {
		GameGui3 gameWindow = new GameGui3(this);
	}
	
	/** close gameGUI window */
	public void closeGameGUI(GameGui3 gameWindow) {
		// TODO Auto-generated method stub
		gameWindow.closeWindow();
		
	}

	/** launch setup screen window */
	public void launchsetupscreen() {
		setupscreen setupscreenwindow = new setupscreen(this);
	}
	
	/** close setupscreen window */
	public void closesetupscreen(setupscreen setupscreenwindow) {
		// TODO Auto-generated method stub
		setupscreenwindow.closewindow();
	}
	
	/** launch shop screen * /
	 * 
	 */
	public void launchshopscreen() {
		ShopGUI shopscreen = new ShopGUI(this);

	}
	
	/** close shop screen * /
	 * 
	 */
	public void closeshopscreen(ShopGUI shopGUIframe) {
		shopGUIframe.closeWindow();
	}
    
		
		
    
    /** launches the chooseplayers screen */
    public void launchchoosePlayers() {
    	choosePlayers ChoosePlayerScreen = new choosePlayers(this);
    	
    } 
    /**Closes the chooseplayers screen */
    public void closechooseplayers(choosePlayers frame) {
    		frame.closewindow();
    }
    /** launches the lobby screen */
    public void launchLobby() {
    	Lobby lobbywindow = new Lobby(this);
    }
    
    /** closes the lobby screen */
    public void closeLobby(Lobby window) {
    	window.closewindow();
    }
    /** set the difficulty, takes Integer as parameter */
    public void set_difficulty(Integer difficulty) {
    	this.difficulty = difficulty;
    }
    /** return integer difficulty */
    public Integer get_difficulty() {
    	return this.difficulty;
    }
    
    /** return integer games played */
    public int getGamesplayed() {
        return this.gamesplayed;
    }
    
    /** set the games played, takes integer as paramter */
    public void setGamesplayed(int newGamesplayed) {
        this.gamesplayed = newGamesplayed;
    }
    
    /** return integer tournament length */
    public int getTournament_length() {
        return this.tournament_length;
    }
    
    /** set the tournament length: takes integer as parameter */
    public void setTournament_length(int newTournament_length) {
        this.tournament_length = newTournament_length;
    }
    
    /** launches the end screen */
    public void launchendscreen() {
    	endScreen endscreen = new endScreen(this);
    }
    /** return goals scored: integer */
    public Integer getGoalsScored() {
        return this.goals_scored;
    }
    /** set the goals scored, takes integer as parameter */
    public void setGoalsScored(Integer newGoalsScored) {
        this.goals_scored = newGoalsScored;
    }
    /** gets the goals conceded and return integer  */
    public Integer getGoalsConceded() {
        return this.goals_conceded;
    }

    /** set the goals conceded: takes integer as parameter  */
    public void setGoalsConceded(Integer newGoalsConceded) {
        this.goals_conceded = newGoalsConceded;
    }

    /** gets the games won and return integer  */
    public Integer getGamesWon() {
        return this.games_won;
    }
    /** set games won: takes integer as parameter  */
    public void setGamesWon(Integer newGamesWon) {
        this.games_won = newGamesWon;
    }
    /** gets the games lost: returns integer */
    public Integer getGamesLost() {
        return this.games_lost;
    }
    /** sets the games lost: takes integer as parameter  */
    public void setGamesLost(Integer newGamesLost) {
        this.games_lost = newGamesLost;
    }
    /** gets the games drawn: return integer   */
    public Integer getGamesDrawn() {
        return this.games_drawn;
    }
    /** sets the games drawn: takes integer as parameter  */
    public void setGamesDrawn(Integer newGamesDrawn) {
        this.games_drawn = newGamesDrawn;
    }

    
    
    
    
    
    
    
    /** launches the setupscreen */
	public static void main(String args[]) {
		teammanager manager = new teammanager();
		manager.launchsetupscreen();
	}

	
	
	


    


}
