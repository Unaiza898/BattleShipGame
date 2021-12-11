package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
/**
 * creates the grid for the user
 * 
 *
 */
public class Board extends Parent {


    private String boardfreeze = "enable"; // if this disable the player enemy cannot edit their boards or 
    // add any new ships.
    private ships ships;
    String name; // iniatialize who is playing 
    
   
    

    private char playerturn = 'H' ; // check if it is human or enemy
//    private HBox row = new HBox();
    static box[] boxarray = new box[100];
    
    private GridPane board = new GridPane();

	private char[][] allColors= new char[10][10]; // set char
    private final int GRID_SIZE = 10;
  
    
/**
 * getter of ship
 * @return
 */
   
    public ships getShips() {
		return ships;
	}
    /**
     * getter of board
     * @return
     */


	public GridPane getBoard() {
		return board;
	}


	
	/**
	 * setter of board
	 * @return
	 */

	public void setBoard(GridPane board) {
		this.board = board;
	}


	/**
	 * setter of ship
	 * @return
	 */
	public void setShips(ships ships) {
		this.ships = ships;
	}

	
	/**
	 * getter of grid size
	 * @return
	 */
    public int getGRID_SIZE() {
		return GRID_SIZE;
	}


/**
 * makes the grid with the box class
 * @param box
 */
	public Board(box box) {
    	int i = 0;
    	
    	
        for (int row = 0; row < GRID_SIZE; row++) {
            
            for (int col = 0; col < GRID_SIZE; col++) {
    
            	box = new box(row, col, this);
            	box.setX(row);
            	box.setY(col);
            	boxarray[i] = box  ;
            	
            	i ++;
//                row.getChildren().add(box);
            	setAllColors() ;
   	
           	
          		 box.setOnMouseClicked(new clicked());
         
                
                    
//          box.clickAble();
                board.add(box, row, col);
            }
        }

    
        this.getChildren().add(board);
        
       printColors(GRID_SIZE);	
        

    
    }
	
	
/**
 * get color from grid at x and y	
 * @param x
 * @param y
 * @return
 */
    
	  public char getAllColors(int x, int y) {
	return allColors[x][y];
}

    /**
     * class clicked
     * 
     *
     */
    class clicked implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent arg0) {
			// TODO Auto-generated method stub
			box ct = (box) arg0.getSource();
			ct.clickAble();

			
			
			
			
		}
	}
    
    /**
     * freeze the board , so the human cannot change the ships position
     * @return
     */
 	  public String getBoardfreeze() {
		return boardfreeze;
	}
 	  
 	  /**
 	   * set the board freeze
 	   * @param boardfreeze
 	   */
	public void setBoardfreeze(String boardfreeze) {
		this.boardfreeze = boardfreeze;
	}
	
	/**
	 * set all the color
	 */
    public void setAllColors() {
    for (int row = 0; row < GRID_SIZE; row++) {
            
            for (int col = 0; col < GRID_SIZE; col++) {
          	  allColors[row][col] = 'B';
            }
            }
  }
    
    
    /**
     * set the color coordinate
     * @param x
     * @param y
     * @param letter
     */
    public void setColorscoordinate(int x, int y, char letter) {
            	  allColors[x][y] = letter;

              }
    
    /**
     * print all colors 
     * @param GRID_SIZE
     */
    public void printColors(int GRID_SIZE) {
			for(int row = 0; row < GRID_SIZE; row++) {
				for(int col = 0; col < GRID_SIZE; col++) {
					System.out.print(allColors[row][col] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}




/**
 * get the location of attack ship
 * @param x
 * @param y
 * @return
 */

    // takes the coordinates of the attacck ship
  public int[] attackedships(int x , int y)
  {
	  int num[] = {x,y};
	return num;  
  }


/**
 * get and set player turn 
 * @return
 */
public char getPlayerturn() {
	return playerturn;
}



public void setPlayerturn(char playerturn) {
	this.playerturn = playerturn;
}
    
	    


}

	
	
