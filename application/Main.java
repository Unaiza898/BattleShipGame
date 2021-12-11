package application;
	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.swing.text.View;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;




/** 
 * make a new grid plane it acts like an human grid
 * @author nizam
 *
 */

public class Main extends Application {
	
	Alert alert = new Alert(AlertType.INFORMATION);
	
	HumanPlayer player = new HumanPlayer() ;
	
	Board Humanplayer = player.createBoard();
	char currentplayer = 'H';
	
	Computer player2 = new Computer() ;
	Board Computerplayer = player2.createBoard();
	
	ships computerships = new ships();
	
//	
//	player2.initializeShip(computerships);
	 
	
	
	boolean playermove;
	boolean enemymove;
	ships ships = new ships();

	
	boolean clicked = false;

	
	String musicFile = "battleship.mp3";     // For example


	 
	Button confirm = new Button("Confirm");
	
	Button start = new Button("START");

	Button save = new Button("save");
	Button savedgame = new Button("save");
	public String text = "Place your Carrier (5 squares no diagonal)";
	@Override
	public void start(Stage primaryStage) {
			try {
				VBox root = new VBox();
		        root.setId("pane");
		        Scene scene1 = new Scene(root);
		       root.getChildren().addAll(start,savedgame);
		        scene1.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
	
		        
		        play(true);
		        
		     	
						
//		        
//				confirm.setOnMouseClicked(new clicked());
			VBox box1 = new VBox();
//				VBox box2 = new VBox();
//  VBox box1 = new VBox(10, new Label(text),Humanplayer,confirm,Computerplayer);
				
				Scene scene = new Scene(box1,400,400);
				
			
				
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	//			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				  Label label1 = new Label("This is the First Scene");
			        Label label2 = new Label("This is the Second Scene");
			        
     	   //     box1.getChildren().addAll(label1,Humanplayer,confirm,Computerplayer);
			
//
//			    	 box1.getChildren().addAll(label1,Humanplayer,confirm);
			    	 
			    	 savedgame.setOnAction(e -> {
							savedgame.setDisable(true);
						//	Humanplayer.setBoardfreeze("disable");
			    
			    		 Player player;
			    		 Player player2;
			    		 Board boardhuman;
			    		 Board boardAI;
			    		 char currentPlayer;
							try {
								ObjectInputStream input = new ObjectInputStream(new FileInputStream("game.obj"));
								 player = (Player)input.readObject();
								 player2 = (Player)input.readObject();
								 boardhuman = (Board )input.readObject();
								 boardAI = (Board )input.readObject();
								 currentPlayer = (char )input.readObject();
								input.close();
								 box1.getChildren().addAll(label1,boardhuman);
							} catch (Exception e1) {
								System.out.println("Something went wrong with the file write.");
								e1.printStackTrace();
							}  
							
				 	
						  
						  
								primaryStage.setScene(scene);
								

				
							
						
							});
			    	 
	       	
			    	 
			    	 start.setOnAction(e -> {
//							confirm.setDisable(true);
						//	Humanplayer.setBoardfreeze("disable");
			    		 play(false);
							start.setDisable(true);
							start.setVisible(false);
								
							 
							
				 	 box1.getChildren().addAll(label1,Humanplayer,confirm);
						  
						  
								primaryStage.setScene(scene);
								

				
							
						
							});
		        
				confirm.setOnAction(e -> {
//					confirm.setDisable(true);
				//	Humanplayer.setBoardfreeze("disable");
					if((player.initializeShip(ships)) == true) {
						confirm.setDisable(true);
						confirm.setVisible(false);
						
						System.out.println("created tda ");
					player2.initializeShip(computerships);

					box1.getChildren().addAll(label2,Computerplayer, save);
				  
					
					
				  
						primaryStage.setScene(scene);
						
//					while()
//       				startgame(Humanplayer,Computerplayer,player,player2) ;
         				
					}
					else {
//						System.out.println(player.initializeShip(ships));
						alert.setTitle("Error message");
						alert.setHeaderText("ERROROOORRRR!!!");
						alert.setContentText(player.errormessage);
						alert.showAndWait();
						
						
					}
					
				
					});
				
				save.setOnAction(e -> {

					//let's save the game
					try {
						ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("game.obj"));
						output.writeObject(player);
						output.writeObject(player2);
						output.writeObject(Computerplayer);
						output.writeObject(Humanplayer);
						output.writeObject("currentplayer");
						output.close();
						//End the game!
						System.out.println("Ending game.");
						System.exit(0);
					} catch (Exception e1) {
						System.out.println("Something went wrong with the file write.");
						e1.printStackTrace();
					} });
					
					
					
				

			 
				primaryStage.setScene(scene1);
				primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
		// play the music 
	
	public void play(boolean play)
	{ URL thing = getClass().getResource("battleship.mp3");
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
	
	//change the clickable to truw or false 
	public void clickAble()
		{
			if (clicked) {
				clicked = false;
				} else {
				clicked = true;
				}
		}
	

// when class clicked it implemets it 
	class clicked implements EventHandler<MouseEvent>
	{
		public void handle(MouseEvent arg0) {
	        System.out.println("confirm cliked");
			Button ct = (Button) arg0.getSource();
			clickAble();

			System.out.println(clicked );
	
			
	
		}
	}
}
