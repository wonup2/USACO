

import java.util.*;
import java.io.*;

public class revegetate {

	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static String[] field, grass;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("revegetate.in"));
			out = new PrintWriter(new File("revegetate.out"));
			
			init();
			out.println(solve());
			
			in.close();
			out.close();
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void init() {
		n = in.nextInt();
		m = in.nextInt();
		
		field = new String[n];
		for(int i = 0; i < n; i++) {
			field[i] = "1234";
		}
		
		grass = new String[n];
		Arrays.fill(grass, "");
		for(int i = 1; i <= m; i++) {
			int t1 = in.nextInt()-1;
			int t2 = in.nextInt()-1;
			
			grass[t1] += Integer.toString(i);
			grass[t2] += Integer.toString(i);
		}	
		
		System.out.println(Arrays.toString(grass));
		//[237, 510, 910, 349, 168, 248, 7, 56, 1]
	}
	
	private static String solve() { 
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < grass[i].length(); j++) {
				String temp = Character.toString(grass[i].charAt(j));				
				for(int k = i+1; k < n; k++) {
					System.out.println(Arrays.toString(field));
					if(grass[k].indexOf(temp)>=0) {				
						String t = field[i].charAt(0)+"";
						field[k] = field[k].replace(t , "");						
					}					
				}
			}	
		}		
		
		String ans = "";
		for(int i = 0; i < n; i++) {
			ans += field[i].charAt(0)+"";
		}
		
		return ans;
		
	}

}
