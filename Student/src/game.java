import java.util.*;
import java.io.*;

public class game {
	
	static Scanner in;
	static PrintWriter out;
	static int[][] input;
	static ArrayList<String> output;
	static int players, games;
	
	public static void main(String[] args) {
		
		try {
			
			in = new Scanner(new File("game.in"));
			out = new PrintWriter(new File("game.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void init() {
		
		players = in.nextInt();
		games = in.nextInt();
		
		input = new int[players][games];
		for(int i = 0; i < players; i++) {
			
			for(int j = 0; j < games; j++) {
				
				input[i][j] = in.nextInt();
				System.out.println(input[i][j]);
				
			}
			
		}
		
		output = new ArrayList<String>();
		
	}
	
	public static void solve() {
		
		for(int i = 0; i < players; i++) {
			
			for(int j = 0; j < players; j++) {
				
				if(j > i) {
					
					int sum = 0;
					for(int x = 0; x < games; x++) {
						
						if(input[x][i] > input[x][j])
							sum++;
						
					}
					
					int temp = 4 - sum;
					output.add(sum + ":" + temp);
					
				}
				
			}
			
		}
		
		for(int i = 0; i < output.size(); i++) {
			
			System.out.println(output.get(i));
			
		}
		
	}

}
