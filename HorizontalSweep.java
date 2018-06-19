
public class HorizontalSweep implements SearchStrategy{

	//goes line by line and searches for 1's
	//no need to set 1's to 0's since there is no chance of
	//checking the same spot twice
	public int Search(Integer[][] ar) {
		int found = 0; 		//found 'ship'
		int searched = 625; //total number of cells 25X25
		int counter = 0;	//counts cells searched
		for(int i = 0; i <= 24; i++) {
			for(int j = 0; j <= 24; j++) {
				counter++;
				if(ar[i][j] == 1)
					found++;
				if(found == 8) 
					return counter;
			}
		}
		return searched;
		
		
	}

}
