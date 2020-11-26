
import java.util.*;
import java.io.*;

public class FEB_SIL_paintbarn {
	
	final public static int MAX = 1001;

	public static int n;
	public static int k;
	public static int[][] a;
	
	public static void main(String[] args) throws Exception {
	
		// Get basic info.
		BufferedReader stdin = new BufferedReader(new FileReader("paintbarn.in"));
		StringTokenizer tok = new StringTokenizer(stdin.readLine());
		n = Integer.parseInt(tok.nextToken());
		k = Integer.parseInt(tok.nextToken());
		
		// Store info for cumulative frequency array. (Currently it's not one.)
		a = new int[MAX][MAX];
		for (int j=0; j<n; j++) {
			tok = new StringTokenizer(stdin.readLine());
			int x1 = Integer.parseInt(tok.nextToken());
			int y1 = Integer.parseInt(tok.nextToken());
			int x2 = Integer.parseInt(tok.nextToken());
			int y2 = Integer.parseInt(tok.nextToken());
			for(int i=x1; i<x2; i++) {
				a[i][y1]++;
				a[i][y2]--;
			}
		}

		int res = 0;
		
		for(int i=0; i<MAX-1; i++) {
			for(int j=0; j<MAX-1; j++) {
				if(a[i][j]==k) res++;
				a[i][j+1] += a[i][j];
			}
		}
				
		// Output results.
		PrintWriter out = new PrintWriter(new FileWriter("paintbarn.out"));
		out.println(res);
		out.close();
		stdin.close();	
	}
	
}