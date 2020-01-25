
import java.util.*;
import java.io.*;

public class countcross {

	final public static int[] DX = {-1,0,0,1};
	final public static int[] DY = {0,-1,1,0};

	public static int n;
	public static boolean[][][] grid;
	public static int[][] cows;
	public static boolean[][] cowLocGrid;

	public static void main(String[] args) throws Exception {

		// Read input.
		Scanner stdin = new Scanner(new File("countcross.in"));
		n = stdin.nextInt();
		grid = new boolean[n][n][4];
		cowLocGrid = new boolean[n][n];
		setDefault();

		int numC = stdin.nextInt();
		cows = new int[numC][2];

		int numR = stdin.nextInt();

		// Get each road.
		for (int i=0; i<numR; i++) {
			int x1 = stdin.nextInt()-1;
			int y1 = stdin.nextInt()-1;
			int x2 = stdin.nextInt()-1;
			int y2 = stdin.nextInt()-1;

			// Get the delta.
			int mydx = x2-x1;
			int mydy = y2-y1;

			// Find its match and block this road.
			for (int j=0; j<4; j++) {
				if (mydx == DX[j] && mydy == DY[j])
					grid[x1][y1][j] = false;
				if (-mydx == DX[j] && -mydy == DY[j])
					grid[x2][y2][j] = false;
			}
		}

		// Read in cow locations.
		for (int i=0; i<numC; i++) {
			cows[i][0] = stdin.nextInt()-1;
			cows[i][1] = stdin.nextInt()-1;
			cowLocGrid[cows[i][0]][cows[i][1]] = true;
		}

		int res = 0;

		// Try a bfs from each cow to the rest.
		for (int i=0; i<numC; i++) {
			int total = bfs(cows[i][0], cows[i][1]);
			res += (numC-total);
		}

		// Output the result, divide by 2 since we counted each unreachable pair twice.
		PrintWriter out = new PrintWriter(new FileWriter("countcross.out"));
		out.println(res/2);
		out.close();
		stdin.close();
	}

	public static int bfs(int x, int y) {

		// Set up BFS.
		int cnt = 0;
		LinkedList<Integer> q = new LinkedList<Integer>();
		q.offer(x*n+y);
		boolean[][] used = new boolean[n][n];
		used[x][y] = true;

		// Run BFS.
		while (q.size() > 0) {

			// Get next in queue.
			int cur = q.poll();
			int curX = cur/n;
			int curY = cur%n;

			// Count it, if necessary.
			if (cowLocGrid[curX][curY]) cnt++;

			// Try each new direction - add in queue if can cross and unused.
			for (int i=0; i<4; i++) {
				if (grid[curX][curY][i] && !used[curX+DX[i]][curY+DY[i]]) {
					q.offer(n*(curX+DX[i])+curY+DY[i]);
					used[curX+DX[i]][curY+DY[i]] = true;
				}
			}
		}

		return cnt;
	}

	// Set outside boundaries.
	public static void setDefault() {
		for (int i=0; i<n; i++)
			for (int j=0; j<n; j++)
				for (int k=0; k<DX.length; k++)
					grid[i][j][k] = inbounds(i+DX[k], j+DY[k]);
	}

	public static boolean inbounds(int x, int y) {
		return x >= 0 && x < n && y >= 0 && y < n;
	}
}