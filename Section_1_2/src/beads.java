/*
ID: wonup21
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class beads {

	static Scanner in;
	static PrintWriter out;
	static String result = "";
	
	static int n;
	static String b;
	
	public static void main(String[] args) {
		
		try {			
			in = new Scanner(new File("beads.in"));
			out = new PrintWriter(new File("beads.out"));
			
			init();
			out.println(solve());
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = Integer.parseInt(in.nextLine());
		b = in.nextLine();	
		b += b;
	}

	private static int solve() {
		int max = 0;

		for(int i = 0; i < n; i++) {
			
			int key = b.charAt(i);
			int color = key=='w'? 0:1; 
			int collect=0;
			
			for(int j = i; j < i+n; j++) { 
				
				char c = b.charAt(j);

				if(c != 'w' && c != key) {				
					color++;
					key = c;
				}
				
				if(color==3) break;
				
				collect++;
			}
			
			max = Math.max(max, collect);						
		}				
		return max;		
	}	
}