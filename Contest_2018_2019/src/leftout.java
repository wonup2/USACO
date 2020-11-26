import java.util.*;
import java.io.*;

public class leftout {

	public static int n;
	public static boolean[][] grid;
	
	public static void main(String[] args) throws Exception {
		
		// Read in the grid.
		Scanner stdin = new Scanner(new File("leftout.in"));
		n = stdin.nextInt();
		grid = new boolean[n][n];
		for (int i=0; i<n; i++) {
			String tmp = stdin.next();
			for (int j=0; j<n; j++)
				if (tmp.charAt(j) == 'R')
					grid[i][j] = true;
		}
		
		// Identify the bad row.
		int myRow = getBadRow();
		System.out.println(myRow);
		
		// Transpose.
		for (int i=0; i<n; i++) {
			for (int j=i+1; j<n; j++) {
				boolean tmp = grid[i][j];
				grid[i][j] = grid[j][i];
				grid[j][i] = tmp;
			}
		}
		
		System.out.println(Arrays.deepToString(grid));

		
		// We can reuse the code with the transpose to get the bad column.
		int myCol = getBadRow();
		System.out.println(myCol);

		// Solve and print out the result.
		PrintWriter out = new PrintWriter(new FileWriter("leftout.out"));
		
		if (myRow == -1 || myCol == -1) out.println(-1);
		else out.println( (myRow+1) +" "+(myCol+1) );
		
		out.close();		
		stdin.close();
	}	
	
	public static int getBadRow() {
		
		// Check each row against row 0.
		int[] freq = new int[n+1];
		int[] res = new int[n];
		for (int i=1; i<n; i++) {
			
			// Count matches for row i vs row 0.
			for (int j=0; j<n; j++)
				if (grid[0][j] == grid[i][j])
					res[i]++;
				
			freq[res[i]]++;
		}
		System.out.println(Arrays.toString(res));
		System.out.println(Arrays.toString(freq));
		
		int badrow = -1;
		
		// This means we are the correct row.
		if (freq[0] + freq[n] == n-2) {
			for (int i=1; i<n; i++)
				if (res[i] == 1 || res[i] == n-1)
					return i;
		}
		
		// We are the offending row.
		if (freq[1] + freq[n-1] == n-1) return 0;
		
		// If we get here it's not possible.
		return -1;
	}
}