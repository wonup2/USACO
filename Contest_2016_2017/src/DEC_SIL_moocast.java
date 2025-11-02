// Solution to 2016 December USACO Silver Problem: Moocast

import java.util.*;
import java.io.*;

public class DEC_SIL_moocast{

	public static int n, cnt;
	public static int[][] a;
	public static boolean[] v;
	
	public static void main(String[] args) throws Exception {

		Scanner in = new Scanner(new File("moocast.in"));
		PrintWriter out = new PrintWriter(new FileWriter("moocast.out"));
		//input
		n = in.nextInt();
		a = new int[n][3];
		for (int i=0; i<n; i++)
			for (int j=0; j<3; j++)
				a[i][j] = in.nextInt();
				
		//processing
		int res = 0;
		for (int i=0; i<n; i++) {
			
			v = new boolean[n]; 
			cnt=1;
			
			dfs(i);
			
			res = Math.max(res, cnt);
			
		}

		//output
		out.println(res);
		out.close();
		in.close();
	}

<<<<<<< HEAD
=======
//	public static int reach(int s) {
//
//		v = new boolean[n]; 
//
//		dfs(s);  
//		
//		int res = 0; 		// Count # of reached cows.
//		for (int i=0; i<n; i++)	if(v[i]) res++;
//		
//		return res;
//	}

>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
	public static void dfs(int s) {
		v[s] = true;

		for (int i=0; i<n; i++) {
			if (v[i]) continue;

			long dist = (a[s][0] - a[i][0])*(a[s][0] - a[i][0]) + (a[s][1] - a[i][1])*(a[s][1] - a[i][1]);
			long pow = a[s][2]*a[s][2];
			
			if (dist <= pow) { dfs(i); cnt++;}
		}
	}
}