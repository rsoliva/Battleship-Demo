import java.util.Random;

public class RandomSearch implements SearchStrategy {

	//generates a random pair of numbers between 0 and 24 
	//checks that spot in the 2d array
	//if its a 1 increment found and change that spot to 0 so it doesn't get found again
	public int Search(Integer[][] ar) {
		Random rand = new Random();
		int found = 0;
		int counter = 0;
		while (found < 8) {
			int i = rand.nextInt(25);
			int j = rand.nextInt(25);
			if(ar[i][j] == 1) {
				found++;
				ar[i][j] = 0;
			}
			counter++;
		}
		
		return counter;
	}

}
