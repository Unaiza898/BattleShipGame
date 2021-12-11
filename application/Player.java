package application;

import java.util.ArrayList;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public abstract class Player extends Object{

	
    protected  box box = new box(); // box
    protected boolean enemy; // enemy
    
    
    private char playerturn;// gets the player turn 
	protected Board  board = new Board (box);
	public abstract Board createBoard();
	public abstract boolean initializeShip(ships ship);
    protected ArrayList <ships> shipsList = new ArrayList<ships>();	//array list of ships
    private ships Ship = new ships();
    protected ArrayList<int[]> coords = new ArrayList<int[]>();
//    public abstract void hit(int x,int y, Player other);
    
   // if game is over
    /**
     * tells when game oveer
     * @param board
     * @return
     */
	   public boolean gameover(Board board) {
	    	
	    	boolean isAloser = false;
	    	 for (int row = 0; row < 10; row++) {
		            
		            for (int col = 0; col < 10; col++) {
		            	
		            	if(board.getAllColors(row, col) == 'C')
		            		
		            	{
		            		isAloser = true;
		            	}
		            	else {
		            		
		            		isAloser = false;
		            	}
		            	
		            	
		            }
		            
	    	 }
			return enemy;
	    	
	    	
	    }
    
    
  // changes the grid X and 
    /**
     * change color back when the ships are fully initialize
     * 
     * @param board
     */
    public void changeallcolor(Board board) {
    	
    	 for (int row = 0; row < 10; row++) {
	            
	            for (int col = 0; col < 10; col++) {
	          	  if(board.getAllColors(row, col) == 'X' || board.getAllColors(row, col) == 'B') {
	          		  
	          		board.setColorscoordinate(row, col, 'D');
	          		  
	          		  
	          	  }
	            }
	            }
    	
    	
    	
	}
    

    
    /**
     * getters and setters
     * @return
     */

    
    
    
    public  box getBox() {
		return box;
	}
	public void setBox(box box) {
		this.box = box;
	}
	public boolean isEnemy() {
		return enemy;
	}
	public void setEnemy(boolean enemy) {
		this.enemy = enemy;
	}
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public ArrayList<ships> getShipsList() {
		return shipsList;
	}
	public void setShipsList(ArrayList<ships> shipsList) {
		this.shipsList = shipsList;
	}
	public ArrayList<int[]> getCoords() {
		return coords;
	}
	public void setCoords(ArrayList<int[]> coords) {
		this.coords = coords;
	}
//	public Board createBoard(boolean enemy) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	public char getPlayerturn() {
		return playerturn;
	}
	public void setPlayerturn(char playerturn) {
		this.playerturn = playerturn;
	}
	public ships getShip() {
		return Ship;
	}
	public void setShip(ships ship) {
		Ship = ship;
	}


/**
 * This the planning bellow we did befor ewe started out code
 */
	
	
	/**
	 * initializing shipp 
	 * 
	 * AI will choose whether vertical or horizontal (0 and 1)
	 * 
	 * then it will choose the ship lenght 1 - 5 and 
	 * then goes for loop of horzontal or vertical 
	 * it chooses a random x or y position 
	 */
	
}
