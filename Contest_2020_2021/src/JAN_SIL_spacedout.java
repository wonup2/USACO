import java.util.*;
import java.io.*;

public class JAN_SIL_spacedout {
	static BufferedReader in;
	static int n, col[][], row[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

	static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		row = new int[n][2];
		col = new int[n][2];
		StringTokenizer st; 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine()); 
			for(int j=0; j<n; j++) {
				
				int t = Integer.parseInt(st.nextToken());
				row[i][j%2] += t;
				col[j][i%2] += t;
			}
		}
		
		print2d(row);
		print2d(col);

	}
	
	static void solve() {
		
		int ans1 = 0;
		for(int i=0; i<n; i++)
			ans1 += Math.max(row[i][0], row[i][1]);
		
		int ans2 = 0;
		for(int i=0; i<n; i++)
			ans2 += Math.max(col[i][0], col[i][1]);
		
		System.out.println(Math.max(ans1, ans2));
	}
	
	public static void print2d(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
		    for (int j = 0; j < grid[i].length; j++) {
		        System.out.print(grid[i][j] + " ");
		    }
		    System.out.println();
		}
	}	
}
