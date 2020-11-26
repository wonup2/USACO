/*
ID: wonup21
LANG: JAVA
TASK: beads
*/
import java.util.*;
import java.io.*;

public class beads1 {

	static Scanner in;
	static PrintWriter out;
	
	static int n;
	static String necklace;
	
	public static void main(String[] args) {
		
		try {			
			in = new Scanner(new File("beads.in"));
			out = new PrintWriter(new File("beads.out"));
			
			init();
			solve();
			
			out.close();
			in.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void init() {
		n = Integer.parseInt(in.nextLine());
		necklace= in.nextLine();	
		necklace += necklace;
	}

	private static void solve() {
			
		int max = 0;
		
		for(int i=0; i<n; i++) {
			
			char key = necklace.charAt(i);
			int collect = 0;
			int color = 1;
			
			if(key=='w') color = 0;
			
			
			for(int j = i; j < i+n; j++) {
				
				char curr =  necklace.charAt(j);
				
				if(key != curr && curr != 'w') {				
					color++;
					key = curr;
				}
				
				if(color == 3) break;
				
				collect++;
			}
			
			max = Math.max(max, collect);
		}
		
		out.println(max);
	}	
}