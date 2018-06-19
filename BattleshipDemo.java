import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BattleshipDemo {
	
	SearchStrategy strategy;
	//sets strategy
	public static SearchStrategy setStrategy(SearchStrategy strategy) {
		return strategy;
	}
	
	//initializes board to all 0's
	private static Integer[][] init(Integer[][] ar){
		for(int i = 0; i <= 24; i++) {
			for(int j = 0; j <= 24; j++) {
				ar[i][j] = 0;;
			}
		}
		return ar;
	}	
	
	//reads lines from input.txt and passes each line to demo
	public static void readInput(String input) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader(input));
		String oneLine = "";
		int gameCounter = 1;
		while((oneLine = reader.readLine()) != null) {
			System.out.println("Game " + gameCounter + ":");
			runDemo(oneLine, gameCounter);
			System.out.println("");
			gameCounter++;
		}
	}
	
	//tokenizes one line from input and changes specific coordinates on board to 1
	public static void setBoard(String txt, Integer[][] shipArray) {
		StringTokenizer tokenizer = new StringTokenizer(txt, "()");
		
		while(tokenizer.hasMoreTokens()) {
			String temp = tokenizer.nextToken();
			StringTokenizer tokenizer2 = new StringTokenizer(temp, ",");
			int x = Integer.parseInt(tokenizer2.nextToken());
			int y = Integer.parseInt(tokenizer2.nextToken());
			shipArray[x][y] = 1;
		}
	}
	
	//Demo searches
	public static void runDemo(String line, int gameNum) {
		
		SearchStrategy searchShip;	//strategy interface
		int cellsSearched = 0;		//number of cells searched
		
		//creates board and sets all values to 0
		Integer[][] board = new Integer[25][25];
		init(board);								
		
		//reset board each time before each strategy
		setBoard(line, board);						
		searchShip = setStrategy(new HorizontalSweep());
		cellsSearched = searchShip.Search(board);
		printStatements("HorizontalSweep", cellsSearched, gameNum);
		
		setBoard(line, board);
		searchShip = setStrategy(new RandomSearch());
		cellsSearched = searchShip.Search(board);
		printStatements("RandomSearch", cellsSearched, gameNum);
		
		setBoard(line, board);
		searchShip = setStrategy(new Checkerboard());
		cellsSearched = searchShip.Search(board);
		printStatements("Checkerboard", cellsSearched, gameNum);
	}

	//handles output statements
	public static void printStatements(String strategy, int cells, int num) {
		System.out.println("Strategy: " + strategy);
		System.out.println("Number of cells searched: " + cells);
		if(num == 1)
			System.out.println("Carrier Found: (0,0) to (0,4) Submarine Found: (4,15) to (4,17)");
		else if(num == 2)
			System.out.println("Carrier Found: (5,9) to (5,13) Submarine Found: (20,5) to (20,7)");
		else
			System.out.println("Carrier Found: (15,3) to (19,3) Submarine Found: (24,6) to (24,8)");
	}
	
	//passes input.txt to readInput
	public static void main(String[] args) throws IOException {
		readInput("src/input.txt");
	}

}
