
// Solution to 2016 December USACO Silver Problem: Moocast

import java.util.*;
import java.io.*;

public class DEC_SIL_moocast{

	public static int n;
	public static int[][] a;
	public static boolean[] v;
	public static void main(String[] args) throws Exception {

		// Read in the points and range.
		Scanner stdin = new Scanner(new File("moocast.in"));
		n = stdin.nextInt();
		a = new int[n][3];
		for (int i=0; i<n; i++)
			for (int j=0; j<3; j++)
				a[i][j] = stdin.nextInt();
		
		//System.out.println(Arrays.deepToString(a));
		
		// Try each starting vertex.
		int res = 0;
		for (int i=0; i<n; i++)
			res = Math.max(res, reach(i));

		// Write out the answer.
		PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
		out.println(res);
		out.close();
		stdin.close();
	}

	// Returns the number of cows reached from cow v.
	public static int reach(int s) {

		// Run flood fill.
		v = new boolean[n];  
		floodfill(s);  
		// Count # of reached cows.
		int res = 0;
		for (int i=0; i<n; i++)	if (v[i])res++;
		
		return res;
	}

	// Run a flood fill from v. used stores nodes already visited in the fill.
	public static void floodfill(int s) {
		v[s] = true;

		// Try each neighbor.
		for (int i=0; i<n; i++) {
			if (v[i]) continue;

			// We can do the transmission from v to i.
			if ((a[i][0]-a[s][0])*(a[i][0]-a[s][0]) 
			  + (a[i][1]-a[s][1])*(a[i][1]-a[s][1]) <= (long)a[s][2]*a[s][2])
				floodfill(i);
		}
	}
}