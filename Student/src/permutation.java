import java.util.*;
import java.io.*;

public class permutation {
	
	static Scanner in;
	static PrintWriter out;
	static ArrayList<String> output;
	
	public static void main(String[] args) {
		
		try {
			
		//	in = new Scanner(new File("permutation.in"));
		//	out = new PrintWriter(new File("permutation.out"));
			
			init();
			System.out.println(solve());
			//out.print(solve());
			//out.close();
			//in.close();
			
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public static void init() {
		
		output = new ArrayList<String>();
		
	}
	
	public static int solve() {
		
		for(int a = 0; a < 4; a++) {
			
			for(int b = 0; b < 4; b++) {
				
				if(a != b) {
				
					for(int c = 0; c < 4; c++) {
					
						if(a != c && b != c) {
						
							for(int d = 0; d < 4; d++) {
						
								if(d != a && d != b && d != c) {
								
									System.out.println(a + " " + b + " " + c + " " + d);
									output.add(a + " " + b + " " + c + " " + d);
								
								}
						
							}
						}
					
					}
				
				}
				
			}
			
		}
		
		return output.size();

	}
	
}
