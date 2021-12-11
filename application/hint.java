package application;

public class hint implements Item {
	// item that user can use
	public void use(Board p) {
		p.getBoard();
		// get the board 
	}
	
	/**
	 * get the hint
	 * @param p
	 * @return
	 */
	public int[] hint(Board p) {
		
		
int count = 0; // when count 1 for loop stop 


	int[] num = {};
	// checks if the for loop have any 
	for(int row = 0; row < 10; row++) {
		for(int col = 0; col < 10 ;col++) {
			if(p.getAllColors(row, col) == 'D') {
				
			num[0] = row;
			num[1] =col;
				count ++;
				break;
		}
		System.out.println();
	}
	System.out.println();
}
	
		return num;
		
		
	}

	
}
