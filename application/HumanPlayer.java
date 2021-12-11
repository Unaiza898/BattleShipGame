package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import application.Board.clicked;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class HumanPlayer extends Player{

	 public String errormessage;
    

  
	
	 int noofShip = 1;

	

	public Board createBoard() {
		// TODO Auto-generated method stub
		
//	board.setAllColors();
		return board ;
	}
	

/**
 * initailize ship for the human ship
 */
	
	public boolean initializeShip(ships ship) {
		
		
		
		
		// initialize
		
		boolean shipinitialized = false;
		// check for vertical ships and horizontal
		//lets check for vertical
		int noofShip = 1;
		String name;
		int counter; // which would count the ships
		System.out.println(board.getGRID_SIZE());
		System.out.println(board.getAllColors(0, 9));
		
		System.out.println(board.getAllColors(2, 4));
		
		
	
		//lets check for vertical
		int[] num = {};
		for(int i = 0 ; i < 8; i++)
		{
			
			for(int j = 0 ; j < 8; j++)
		{
				
				if(board.getAllColors(i, j) == 'A') {
					
				    int [] point = {i,j};
				    
				    
				    
				    
//				    num = point;
					coords.add(num);
					
					System.out.println("i" + i + "j  " + j);
					
//					System.out.println(Arrays.toString(coords.get(0)));
//					pointValidVertical(noofShip, coords);
//					
					
				}
				
				
				
		}
			
			/**
			 * if coords size is 5 it goes to ship size 5 ,if coords size is 4 it goes to ship size 4
			 */
			if(coords.size() == 5) {
			
				
				shipsList.add(new ships("Carrier",5));
			    ship.coordinates.put("Carrier",coords);
			    coords.clear();
					
				}
				else if (coords.size() == 4 && noofShip == 1) {
					
					shipsList.add(new ships("Battleship",4));
				    ship.coordinates.put("Battleship",coords);
				    coords.clear();
						
					}
				else if (coords.size() == 3&& noofShip == 3) {
					
					shipsList.add(new ships("Cruiser",3));
				    ship.coordinates.put("Cruiser",coords);
				    coords.clear();
				  
					} 
				else if (coords.size() == 2&& noofShip == 2) {
					
					shipsList.add(new ships("Submarine",2));
				    ship.coordinates.put("Submarine",coords);
				    coords.clear();
						
					}
                 else if (coords.size() == 1 && noofShip == 1) {
					
					shipsList.add(new ships("Destroyer",1));
				    ship.coordinates.put("Destroyer",coords);
				System.out.println("ShipList.contain : Destroyer" + shipsList.contains("Destroyer"));
				noofShip ++;
				coords.clear();
						
					}
                 else if (shipsList.size() == 0) {
 					
                	 errormessage = "no ships were initialized";
                	 shipinitialized = false;
 						
 					}
				
                 else if (shipsList.size() > 5) {
  					
                	 errormessage = "Add more ships: Total ";
                	 shipinitialized = false;
 						
 					}
			
                 else if (shipsList.size() == 5) {
   					
                	 errormessage = " ships were initialized";
                	 shipinitialized = true;
 						
 					}
			
		}
		
		return shipinitialized;
	}

	   
}
	
