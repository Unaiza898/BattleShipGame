package application;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Computer extends Player{

	
// private Board  board = new Board (box,true);
    public String errormessage; // send an error message for the user
    // store the ships name and health in an array
    // stor the coordinates of the ships
// contains random input
    private ArrayList<Integer> randomnum = new ArrayList<Integer>();
   // stores in the boxes number in the grid and make sure it doesnt repeat it.    
////    
//
   int noofShip = 1; // counts the ship
    
    
   /**
    * This contructor initializes the board for the computer player
    */
	@Override
	public Board createBoard() {
		// TODO Auto-generated method stub
		
	
//	board.setAllColors();
		return board ;
	}
	
	
	
	
	/**
	 *  Intializes the ships into random positions (vertical only)
	 *  check if the bounds of the shop coordinates doesnt go out
	 *  of bounds
	 *  
	 *  returns a bool.
	 *  if true all ships are initialize 
	 *  else false;
	 *  it marks the box before the ship and after the ship by X so that it saves the locatio
	 *  it will no pick that spot for the next ship
	 */
 
	public boolean initializeShip(ships ship) {
		

		 // increment the no of ship as it initiallize it		
		
		if(noofShip == 1) {
			int num = (int) (Math.random()*100); // pick random numbers
			
			randomnum.add(num);
			randomnum.add(num +10);
			randomnum.add(num -10);
			int x = (int) board.boxarray[num].getX();
			int y = (int) board.boxarray[num].getY();
		  board.setColorscoordinate(x, y, 'C');
		  if(x != 0)
		  {
			  board.setColorscoordinate(x-1, y, 'X');
		  }
		  if(x != 9)
		  {
			  board.setColorscoordinate(x+1, y, 'X');
		  }
		
			
			int [] point = {x,y};
		    coords.add(point);
			shipsList.add(new ships("Destroyer",1));
		    ship.coordinates.put("Destroyer",coords);
		    randomnum.add(y);
			
		}
		
		coords.clear();
		noofShip++;

        board.printColors(10);
		
        if(noofShip == 2) {
        
        	boolean initialship = false;
//			 int  num = (int) (Math.random()*100);
		      int  x = (int) (Math.random()*8);
	           	int y =  (int) (Math.random()*10);
	           	
	           	
	           
	      
			while (initialship == false  ){
		if((board.getAllColors(x , y) == 'C' ) ||(board.getAllColors(x , y) == 'X' ) ){
			
			
			    x = (int) (Math.random()*8);
	            y =  (int) (Math.random()*10);
			
			
		}
		
		if((board.getAllColors(x +1 , y) != 'B' ))
		{
			board.setColorscoordinate(x+1, y, 'X');
		    x = (int) (Math.random()*8);
            y =  (int) (Math.random()*10);
          
		}
		
		
		else {
			initialship = true;
		}
		
			
			}
			
			
			
			
			
			
			  if(x != 0)
			  {
				  board.setColorscoordinate(x-1, y, 'X');
			  }
	
//			randomnum.add(num);
	    int []  point = {x,y};
			 coords.add(point);

			 board.setColorscoordinate(x, y, 'C');
			 x += 1;
			 board.setColorscoordinate(x, y, 'C');
//			 randomnum.add(num);
		       point[0] = x;
		      coords.add(point);
		     if(x != 9)
			  {
				  board.setColorscoordinate(x+1, y, 'X');
			  }
			shipsList.add(new ships("Submarine",2));
		    ship.coordinates.put("Submarine",coords);
			noofShip++;
			randomnum.add(y);
		}
		
        
        System.out.println();
        coords.clear();
		

        board.printColors(10);
		
		
        
        
        if(noofShip == 3) {
        	
        	
        	boolean shipdone =  false;
            
		     int  x = (int) (Math.random()*7);
	           	int y =  (int) (Math.random()*10);

			while (shipdone ==  false){
		if((board.getAllColors(x , y) == 'C' ) ||(board.getAllColors(x , y) == 'X' ) ){
					
					
				    x = (int) (Math.random()*7);
		            y =  (int) (Math.random()*10);
				
				
			}
			
			if((board.getAllColors(x +1 , y) != 'B' ))
			{
                  board.setColorscoordinate(x+1, y, 'X');
			    x = (int) (Math.random()*7);
	            y =  (int) (Math.random()*10);
	            
			}
			
			if((board.getAllColors(x +2 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+2, y, 'X');
			    x = (int) (Math.random()* 7);
	            y =  (int) (Math.random()*10);
	     
			}
			
			if((board.getAllColors(x +2 , y) == 'B' ) && (board.getAllColors(x +1 , y) == 'B' ))
			{
		
				shipdone =  true;
			}
				}
			
			
			  if(x != 0)
			  {
				  board.setColorscoordinate(x-1, y, 'X');
			  }
//			randomnum.add(num);
	    int []  point = {x,y};
			 coords.add(point);
			 board.setColorscoordinate(x, y, 'C');
			 x += 1;
			 board.setColorscoordinate(x, y, 'C');
//			 randomnum.add(num);
		       point[0] = x;
		      coords.add(point);
		 	 x += 1;
			 board.setColorscoordinate(x, y, 'C');
//			 randomnum.add(num);
		       point[0] = x;
		      coords.add(point);
		      if(x != 9)
			  {
				  board.setColorscoordinate(x+1, y, 'X');
			  }
		      
			shipsList.add(new ships("Cruiser",3));
		    ship.coordinates.put("Cruiser",coords);
			noofShip++;
			randomnum.add(y);
		}
		
        
        System.out.println();
        coords.clear();
		

        board.printColors(10);
        if(noofShip == 4) {
            
        	boolean shipdone =  false;
            
		     int  x = (int) (Math.random()*6);
	           	int y =  (int) (Math.random()*10);

			while (shipdone ==  false){
		if((board.getAllColors(x , y) == 'C' ) ||(board.getAllColors(x , y) == 'X' ) ){
					
					
				    x = (int) (Math.random()*6);
		            y =  (int) (Math.random()*10);
				
				
			}
			
			if((board.getAllColors(x +1 , y) != 'B' ))
			{
                 board.setColorscoordinate(x+1, y, 'X');
			    x = (int) (Math.random()*6);
	            y =  (int) (Math.random()*10);
	            
			}
			
			if((board.getAllColors(x +2 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+2, y, 'X');
			    x = (int) (Math.random()* 6);
	            y =  (int) (Math.random()*10);
	     
			}
			
			if((board.getAllColors(x +3 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+3, y, 'X');
			    x = (int) (Math.random()* 6);
	            y =  (int) (Math.random()*10);
	     
			}
			if((board.getAllColors(x +2 , y) == 'B' ) && (board.getAllColors(x +1 , y) == 'B' )&& (board.getAllColors(x +3 , y) == 'B' ))
			{
		
				shipdone =  true;
			}
				}
			
			
			
		     if(x != 0)
		 {
				  board.setColorscoordinate(x-1, y, 'X');
			  }
			
   			//randomnum.add(num);
   	    int []  point = {x,y};
   			 coords.add(point);
   			 board.setColorscoordinate(x, y, 'C');
   			///System.out.print("num = " + num + "x = " + x + " y =  " + y +  board.getAllColors(x, y) + " "); 
   			
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   		//	 randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   			// randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   			// randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   		     if(x != 9)
  			  {
   					  board.setColorscoordinate(x+1, y, 'X');
   			}
   			shipsList.add(new ships("Battleship",4));
   		    ship.coordinates.put("Battleship",coords);
   			noofShip++;
   			
   			randomnum.add(y);
   		}
		
        System.out.println();
        coords.clear();
		

        board.printColors(10);

        
        
        
        
        
        if(noofShip == 5) {
            

        	boolean shipdone =  false;
            
		     int  x = (int) (Math.random()*4);
	      	int y =  RandomNumbers(0,7, randomnum);

			while (shipdone ==  false){
		if((board.getAllColors(x , y) == 'C' ) ||(board.getAllColors(x , y) == 'X' ) ){
					
				    x = (int) (Math.random()*5);
		            y =  RandomNumbers(0,9, randomnum);
				
				
			}
			
			if((board.getAllColors(x +1 , y) != 'B' ))
			{
                 board.setColorscoordinate(x+1, y, 'X');
			    x = (int) (Math.random()*5);
	            y = RandomNumbers(0,9, randomnum);
	            
			}
			
			if((board.getAllColors(x +2 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+2, y, 'X');
			    x = (int) (Math.random()* 5);
	            y =  RandomNumbers(0,9, randomnum);
	     
			}
			
			if((board.getAllColors(x +3 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+3, y, 'X');
			    x = (int) (Math.random()* 5);
	            y = RandomNumbers(0,9, randomnum);
	     
			}
			
			if((board.getAllColors(x +4 , y) != 'B' ))
			{
		      board.setColorscoordinate(x+4, y, 'X');
			    x = (int) (Math.random()* 5);
	            y =  RandomNumbers(0,9, randomnum);
	     
			}
			if((board.getAllColors(x +2 , y) == 'B' ) && (board.getAllColors(x +1 , y) == 'B' )&& (board.getAllColors(x +3 , y) == 'B' )&&(board.getAllColors(x +4 , y) == 'B' ))
			{
		
				shipdone =  true;
			}
				}
			
			
			
		     if(x != 0)
		 {
				  board.setColorscoordinate(x-1, y, 'X');
			  }
			
   			
   			

   	    int []  point = {x,y};
   			 coords.add(point);
   			 board.setColorscoordinate(x, y, 'C');
   //			System.out.print("num = " + num + "x = " + x + " y =  " + y +  board.getAllColors(x, y) + " "); 
   			
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   	//		 randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   //			 randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   			 x += 1;
   			 board.setColorscoordinate(x, y, 'C');
   //			 randomnum.add(num);
   		       point[0] = x;
   		      coords.add(point);
   		     x += 1;
 			 board.setColorscoordinate(x, y, 'C');
 	//		 randomnum.add(num);
 		       point[0] = x;
 		      coords.add(point);
 		      
 		     if(x != 9)
 			 {
 	     board.setColorscoordinate(x+1, y, 'X');
 				  }
 				
   			shipsList.add(new ships("Carrier",5));
   		    ship.coordinates.put("Carrier",coords);
   			
   		}
        System.out.println();
        coords.clear();

        board.printColors(10);
        
        
        changeallcolor(board);
        board.printColors(10);
        
        if(noofShip == 5)
        {
        	
        	System.out.println("wohooo");
        	return true ;
        }
        
        else 
        {
        	System.out.println("wohooo");
        	return false;
        }
        		
		
        
        
        
        
        
        
	}

	
	



	
	/**
	 * exclude the numbers/ boxes that already ahve a ship 
	 * @param start
	 * @param end
	 * @param numbers
	 * @return
	 */
	public int RandomNumbers(int start, int end, ArrayList<Integer> numbers) {
	    Random rand = new Random();
	    int range = end - start + 1;
	    int random = 0;

	    boolean success = false;
	    while(!success) {
	        random = rand.nextInt(range) + 1;
	        for(Integer i:numbers) {
	            if(i == random) {
	                break;
	            } else if (i > random) {
	                success = true;
	                break;
	            }
	        }
	    }
	    return random;
	}
	
	
	

	   
	   
	   
	   
	   

	    public void AIattack(Player other) {
	    	
	    	
	    	
	    	if(other.gameover(other.board) == false)
	    	{
	    		int num = (int) (Math.random()*100);
	        	
	        	
	        	
	        	int x = (int) other.board.boxarray[num].getX();
	    		int y = (int) other.board.boxarray[num].getY();
	    		
	    		
	    		if(other.board.getAllColors(x, y) == 'A')
	    		{
	    			
	    			other.board.setColorscoordinate(x, y, 'X');
	    			
	    			
	    		}
	    		
	    		else if(other.board.getAllColors(x, y) == 'M' || other.board.getAllColors(x, y) == 'X')
	    		{
	    			num = (int) (Math.random()*100);
	    			 x = (int) other.board.boxarray[num].getX();
	        		 y = (int) other.board.boxarray[num].getY();
	    		}
	    		
	    		else {
	    			
	    			other.board.setColorscoordinate(x, y, 'M');
	    			System.out.println(" ohh computer misses");
	    			
	    			
	    		}
	    	}
	    	
	    	else {
	    		System.out.println(" computer won");
				
	    	}
	    	
	    	
	    	
	    	
	    }

//public void hit(int x,int y, Player other ){
//		
//    int[] num = {x,y};
//		if(other.board.getAllColors(x, y) == 'A')
//		{
//			
//			clickedbox(other.board,other);
//			for(int i = 0 ; i < other.shipsList.size() ; i ++) {
//				
//				if(containcoordinate(other.getShip().coordinates, i , num)) {
//					
//					int health = other.shipsList.get(i).getHealth();
//					other.shipsList.get(i).setHealth(health -1);
//					other.board.setColorscoordinate(x, y, 'X');
//				}
//				
//				
//				if(other.shipsList.get(i).getHealth() == 0) {
//					
//					
//					other.getShip().setNoofships(4);
//				}
//			}
//		}
//		
//		
//		else {
//			
//			clickedbox(other.board,other);
////			other.board.boxarray[1].setFill(Color.PURPLE);
////			
//			  other.board.setColorscoordinate(x, y, '0');
////			
////			
////			
////			System.out.println(board.boxarray[5].getX() + " " + board.boxarray[5].getY() );
//			
//			 other.board.printColors(10);
//			
//	
//		//	System.out.println
//			
//		System.out.println("you missed!!.");
//			
//			
//		}
//		
//		
//		
//	}
//
//
//
//
//public boolean containcoordinate( HashMap< String,ArrayList<int[]> > coords, int i, int num[] ) {
//	boolean contains = false;
//	
//	
//	for(Entry< String,ArrayList<int[]>> entry: coords.entrySet()) {
//	
//		
//		
//		String key = entry.getKey();
//		
//	    if(key == shipsList.get(i).getName()) {
//	    	
//	    	ArrayList<int[]> value = entry.getValue();
//	    	if(value.contains(num)) {
//	    		
//	    		contains = true;
//	    		
//	    		
//	    	}
//		
//		
//	}
//		
//		
//		
//	
//		
//	
//}
//	return contains;
//
//	
//	
//	
//	
//}
//




	
	
}

