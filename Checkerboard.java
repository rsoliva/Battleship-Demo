
public class Checkerboard implements SearchStrategy {
	
	int cells = 0; 		//number of cells searched
	
	//searches all even paired coordinates first to cut search into quarters (0,0) (0,2) etc.
	//then checks adjacency if it hits a 1 
	//if it fails to find all 8 coordinates in the first pass, it begins to search the odd paired coordinates
	//i.e. (1,1) (1,3) etc.
	//and checks for adjacency as well
	public int Search(Integer[][] ar) {
		int count = 0; 	//counts number of ship coordinates found
		
		//checks even paired coordinates
		for(int i = 0; i <= 24; i+=2) {
			for(int j = 0; j <= 24; j+=2) {
				if(count < 8) {
					cells++;
					if(ar[i][j] == 1) { 
						count = checkAdj(ar,i,j,count+1);
					}
				}
			}
		}
		
		//checks odd paired coordinates
		for(int i = 1; i <= 23; i+=2) {
			for(int j = 1; j <= 23; j+=2) {
				if(count < 8) {
					cells++;
					if(ar[i][j] == 1)
						count = checkAdj(ar,i,j,count+1);
				}
			}
		}
		return cells;
	}
	
	//recursive function that increments count if more 'ships' are found
	//will only check adjacent squares if count is less than 8
	public int checkAdj(Integer[][] ar, int i, int j, int count) {
		
		//checks down
		if(count < 8) {
			if(i != 24) {
				cells++;
				if(ar[i+1][j] == 1) { 
					ar[i+1][j] = 0;
					count = checkAdj(ar,i+1,j,count+1);
				}
			}
		}
		
		//checks right
		if(count < 8) {
			if(j != 24) {
				cells++;
				if(ar[i][j+1] == 1) {
					ar[i][j+1] = 0;
					count = checkAdj(ar,i,j+1,count+1);
				}
			}
		}
		
		//checks above
		if(count < 8) {
			if(i != 0) {  
				cells++;
				if(ar[i-1][j] == 1) {
					ar[i-1][j] = 0;
					count = checkAdj(ar,i-1,j,count+1);
				}
			}
		}
		
		//checks below
		if(count < 8) {
			if(j != 0) { 
				cells++;
				if(ar[i][j-1] == 1) {
					ar[i][j-1] = 0;
					count = checkAdj(ar,i,j-1,count+1);
				}
			}
		}
		return count;
	}
}
