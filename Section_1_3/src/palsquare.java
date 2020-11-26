/*
ID: roypark1
LANG: JAVA
TASK: palsquare
 */
import java.util.*;
import java.io.*;

public class palsquare {
	
	static Scanner in;
	static PrintWriter out;
	static int base;
	
	public static void main(String[] args) throws IOException{
		in = new Scanner(new File("palsquare.in"));
		out = new PrintWriter(new File("palsquare.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	public static void init() {
		base = in.nextInt();
	}
	
	public static void solve() {
		StringBuilder arr = new StringBuilder();

		for(int i = 1;i<=300;i++) {
			
			String a = Integer.toString(i, base);
			
			if(base > 10) {
				a = a.toUpperCase();
			}
			
			String a1 = new StringBuilder(a).reverse().toString();
			
					
			String b = Integer.toString(i*i, base);
			
			if(base > 10) {
				b = b.toUpperCase();
			}
			
			String b1 = new StringBuilder(b).reverse().toString();
			

			if( b.equals(b1)) {
				arr.append(a).append(" ").append(b).append("\n");
			}
			
		}
		System.out.print(arr.toString());

	}
}