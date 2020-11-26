/*
ID: wonup21
LANG: JAVA
TASK: friday
*/
import java.util.*;
import java.io.*;

public class friday {

	static Scanner in;
	static PrintWriter out;
	static int N;

	static int[] a;
	static int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	static int day = 13;

	public static void main(String[] args) throws IOException {

			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));

			init();
			solve();		

			out.close();
			in.close();
	}

	static void init() {
		N = in.nextInt() + 1900;
		a = new int[7]; // SUN - SAT.
	}

	static void solve() {
		
		for(int year = 1900; year < N; year++) {
			for(int month = 0; month < 12; month++) {
				
				int date = day % 7;
				
				a[date]++;
				
				day += d[month];
				
				if(month==1 && isLeap(year))
					day++;				
			}			
		}
		
		out.print(a[6]);
		
		for(int i=0; i < 6; i++)
			out.print(" " + a[i]);
		
		out.println();
	}
	
	static boolean isLeap(int n) {
	
		return n%4==0 && (n%100!=0 || n%400==0);
	}	
}
