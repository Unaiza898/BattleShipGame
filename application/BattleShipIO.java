package application;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * saves the game
 * @author nizam
 *
 */
public class BattleShipIO {
public static void saveGame(Main bts) {
		
		try {
			ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("game.obj"));
			output.writeObject(bts);
			output.close();
			//End the game!
			System.out.println("Ending game.");
			System.exit(0);
		} catch (Exception e) {
			System.out.println("Something went wrong with the file write.");
			e.printStackTrace();
		}
		
	}
	
	public static Main loadGame() {
		Main btr = null;  
		try {
			ObjectInputStream input = new ObjectInputStream(new FileInputStream("game.obj"));
			btr = (Main)input.readObject();
			input.close();
		} catch (Exception e) {
			System.out.println("Something went wrong with the file write.");
			e.printStackTrace();
		}
		return btr;
	}
}
