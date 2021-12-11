package application;



import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.Parent;
public class ships extends Parent{
	public HashMap< String, ArrayList<int[]>> coordinates = new HashMap<String, ArrayList<int[]> >();
	private String Name;
	private int health; // actuall length 
	private boolean enemy;
	
	//private Map<box> map = new HashMap<box>();
   private int noofships = 5;
	
	/**
	 * the ship constructor
	 */
	//conctructors
	public ships()
	{
		Name = " ";
		health = 0;	
	}
	// addd ships 
	/**
	 * the ship constructor takes in name and health
	 */
	public ships(String n,int h)
	{
		Name = n;
		health = h; 

		
	}
	
	/**
	 * get ship name
	 * @return
	 */
	//method get name of ship
	public String getName() {
		return Name;
	}
   /**
    * set ship name
    */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * get health
	 * @return
	 */
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}
	
/**
 * get no of ship
 * @return
 */
	public int getNoofships() {
		return noofships;
	}
	/**
	 * set no of ship
	 * @param noofships
	 */
	public void setNoofships(int noofships) {
		this.noofships = noofships;
	}

	
	

}