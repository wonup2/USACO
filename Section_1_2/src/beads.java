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
	}

	private static int solve() {
		int max = 0;
		b += b;
		for(int i = 0; i < n; i++) {
			int cur = i;
			int key = b.charAt(cur);
			int change = key=='w'? 0:1; 
			int beads=0;
			while(true) {
				char c = b.charAt(cur);

				if(c != 'w' && c != key) {				
					change++;
					key = c;
				}
				beads++;
				cur++;
				if(change>2 || cur>i+n-1) break;
			}
			max = Math.max(max, beads);						
		}				
		return max;		
	}	
}