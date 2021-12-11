package application;

import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;

import javafx.event.EventHandler;
	 public class box extends Rectangle {
 /// get x coordinate of box
   	  private int x;
   	
   	/// gety coordinate of box

	private int y;
 	private Board board;
 	  
   private boolean clicked = false;
  
  
/**
 * create a box
 */
	public box() {
   		super(30, 30);
   	  }
	
	/**
	 * create a box at position x and y 
	 * @param x
	 * @param y
	 */
   		public box(int x, int y) {
   			super(30, 30);
	            this.x = x;
	            this.y = y;
   		}
   		
   		/**
   		 * create box on position x , y on board.
   		 * @param x
   		 * @param y
   		 * @param board
   		 */
   		
   		public box(int x, int y, Board board) {
   	            super(30, 30);
   	            this.x = x;
   	            this.y = y;
   	            this.board = board;
   	            setFill(Color.BLUE);
   	            setStroke(Color.BLACK);
   	        }

   	
	/**
	 * getters and setters
	 * @return
	 */
		public Board getBoard() {
   			return board;
   		}
   		
		/**
		 * plays music for miss
		 * @param play
		 */
		public void playMiss(boolean play)
		{ URL thing = getClass().getResource("MISS.mp3");
	    Media audioFile = new Media( thing.toString() ); 
	    MediaPlayer player;                                 
	    player = new MediaPlayer(audioFile);
			
			if(play == true)
			{
			 
				    try
				    {    
				        player.play();
				     
				    }
				    catch (Exception e)
				    {
				        System.out.println( e.getMessage() );
				        System.exit(0);
				    }        
			}
			else {
			  player.setMute(true);
			}
		   
		}
		
		
		
		/**
		 * 
		 * play music 
		 * @param play
		 */
		
		public void playhit(boolean play)
		{ URL thing = getClass().getResource("HIT.mp3");
	    Media audioFile = new Media( thing.toString() ); 
	    MediaPlayer player;                                 
	    player = new MediaPlayer(audioFile);
			
			if(play == true)
			{
			 
				    try
				    {    
				        player.play();
				     
				    }
				    catch (Exception e)
				    {
				        System.out.println( e.getMessage() );
				        System.exit(0);
				    }        
			}
			else {
			  player.setMute(true);
			}
		   
		}
	/**
	 * change colors on click
	 */
   		public void clickAble()
   		{

            		if (board.getAllColors(y, x) == 'D') {
           			 
           			
           					setFill(Color.GREY);
           					
                				board.setColorscoordinate(y, x, 'X');
                				board.printColors(10);
                				 playMiss(true);
                				
                				
                				
                				

                
        				
        				
        				} 
           		 
         
           	 
           	 else if(board.getAllColors(y, x) == 'C')
           	 {
//           		 if (clicked  == false) {
         				setFill(Color.RED);
         				playhit(true);
         			//	clicked  = true;
         				board.setColorscoordinate(y, x, 'M');
         				board.printColors(10);
         				board.attackedships(y , x);
         			
//         				} 
           		 
           	 }
       
         
            		 
            		 
            	 if(board.getAllColors(x, y)  == 'A' ||board.getAllColors(x, y) == 'B'){
            		 
            		 if (clicked ) {
         				setFill(Color.AQUA);
         				clicked  = false;
         				board.setColorscoordinate(y, x, 'A');
         				board.printColors(10);
         				} else {
         				setFill(Color.BLUE);
         				board.setColorscoordinate(y, x, 'B');
         				clicked  = true;
      	         	  board.printColors(10);
         				}
     			
            		 
  
            
            		
             }
   		
   			
   		}
   		
   		
	 }
