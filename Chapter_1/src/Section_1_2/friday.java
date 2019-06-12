package Section_1_2;
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
	static String result = "";

	static int[] list;
	static int[] dates = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	static int date = 13;

	public static void main(String[] args) {

		try {

			in = new Scanner(new File("friday.in"));
			out = new PrintWriter(new File("friday.out"));

			init();
			result = solve();

			out.println(result);

			out.close();
			in.close();

		} catch (Exception e) {	System.out.println(e); }

	}

	private static void init() {
		N = in.nextInt() + 1900;
		list = new int[7]; // MON - SUN
	}

	private static String solve() {
		for (int i = 1900; i < N; i++) {			
			for (int j = 1; j <= 12; j++) {
				
				list[date%7]++;				

				if(j == 2 && isLeaf(i))	date++;	 
				
				date += dates[j];					
			}
		}		
		result = list[6]+" "+list[0]+" "+list[1]+" "+list[2]+" "+list[3]+" "+list[4] +" "+list[5];
		return result;
	}

	private static boolean isLeaf(int y) {
		return y % 4 == 0 && ( y % 400 == 0 || y % 100 != 0);
	}	
}
