import java.util.*;
import java.io.*;

public class US_PL_art {

	public static int n;
	public static int[][] grid;

	public static int[] minX;
	public static int[] minY;
	public static int[] maxX;
	public static int[] maxY;
	public static int[][] cumfreq;

	public static void main(String[] args) throws Exception {

		// Read in data.
		BufferedReader stdin = new BufferedReader(new FileReader("test.in"));
		n = Integer.parseInt(stdin.readLine().trim());

		grid = new int[n][n];
		minX = new int[n*n+1];
		maxX = new int[n*n+1];
		minY = new int[n*n+1];
		maxY = new int[n*n+1];
		Arrays.fill(minX, n*n+1);
		Arrays.fill(minY, n*n+1);
		Arrays.fill(maxX, -1);
		Arrays.fill(maxY, -1);

		// Read in the grid also getting the min and max x and y for each number.
		for (int i=0; i<n; i++) {
			StringTokenizer tok = new StringTokenizer(stdin.readLine());
			for (int j=0; j<n; j++) {
				grid[i][j] = Integer.parseInt(tok.nextToken());   	//data 넣기
				minX[grid[i][j]] = Math.min(minX[grid[i][j]], i);	//각 숫자별 모서리
				minY[grid[i][j]] = Math.min(minY[grid[i][j]], j);
				maxX[grid[i][j]] = Math.max(maxX[grid[i][j]], i);
				maxY[grid[i][j]] = Math.max(maxY[grid[i][j]], j);
			}
		}
		
		
		System.out.println("Read in data---------------------");
		for (int i=0; i<n; i++)
			System.out.println(Arrays.toString(grid[i]));
				
		System.out.println("vertax position");
		System.out.println(Arrays.toString(minX));
		System.out.println(Arrays.toString(minY));
		System.out.println(Arrays.toString(maxX));
		System.out.println(Arrays.toString(maxY));

		
		
		// For each rectangle, fill in the boundaries. 2D에 각 번호의 모서리 표시
		cumfreq = new int[n+2][n+2];
		for (int i=1; i<=n*n; i++) {

			// Have to skip rectangles that don't exist.
			if (maxX[i] == -1) continue;

			// Clever way to update frequencies for boundary of the window.
			cumfreq[minX[i]+1][minY[i]+1]++;
			cumfreq[maxX[i]+2][maxY[i]+2]++;
			cumfreq[minX[i]+1][maxY[i]+2]--;
			cumfreq[maxX[i]+2][minY[i]+1]--;
		}

		System.out.println("vertax");		
		for (int i=0; i<=n+1; i++)
			System.out.println(Arrays.toString(cumfreq[i]));
		
		
		
		// Make these cumulative frequency across the rows.
		for (int i=1; i<=n+1; i++)
			for (int j=2; j<=n+1; j++)
				cumfreq[i][j] += cumfreq[i][j-1];

		System.out.println("Now make these cumulative frequency for all boxes by doing the columns.");
		for (int i=0; i<cumfreq.length; i++)
			System.out.println(Arrays.toString(cumfreq[i]));
		
		
				
		// Now make these cumulative frequency for all boxes by doing the columns.
		for (int j=1; j<=n+1; j++)
			for (int i=2; i<=n+1; i++)
				cumfreq[i][j] += cumfreq[i-1][j];
		
		System.out.println("Now make these cumulative frequency for all boxes by doing the columns.");
		for (int i=0; i<cumfreq.length; i++)
			System.out.println(Arrays.toString(cumfreq[i]));
		
		
		
		
		// Initially all of these can be done.
		boolean[] possible = new boolean[n*n+1];
		Arrays.fill(possible, true);

		// For each square, if it's covered by more than 1 rectangle, the last color (showing) can't be it.
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				if (cumfreq[i+1][j+1] > 1)
					possible[grid[i][j]] = false;

		System.out.println();
		System.out.println(Arrays.toString(possible));
		
		
		// Here is our result.
		int res = 0;
		for (int i=1; i<=n*n; i++)
			if (possible[i])
				res++;

		System.out.println(res);

		
		// Count # of colors showing.
		int showing = 0;
		for (int i=1; i<=n*n; i++)
			if (maxX[i] != -1)
				showing++;

		System.out.println(showing);
		
		// Special case where one color covered all the previous ones.
		if (showing == 1) res = n*n-1;

		// Write result.
		PrintWriter out = new PrintWriter(new FileWriter("test.out"));
		out.println(res);
		out.close();
		stdin.close();
	}
}