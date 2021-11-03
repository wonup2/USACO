/*
ID: wonup21
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride1 {

	static Scanner in;
	static PrintWriter out;
	static String s1, s2;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("ride.in"));
		out = new PrintWriter(new File("ride.out"));
		
		init();
		solve();
			
		in.close();
		out.close();
	}
	
	static void init(){
		s1 = in.nextLine();
		s2 = in.nextLine();
		
		//System.out.println(s1+" " + s2);
	}
	
	static void solve() {
		
		if(convert(s1)==convert(s2)) out.println("GO");
		else out.println("STAY");
		
	}
	
	static int convert(String s) {
		int n = 1;
		for(int i=0; i<s.length(); i++) {
			n*=(s.charAt(i)-'A'+1);
		}
		return n%47;
	}
}
