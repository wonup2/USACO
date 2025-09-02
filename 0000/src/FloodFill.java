import java.util.*;

public class FloodFill {
	
	static Scanner in;
	
	static int[][] grid; // the grid itself
	static int n, m; // grid dimensions, rows and columns
	static boolean[][] visited; // keeps track of which nodes have been visited
	static int cnt; // reset to 0 each time we start a new component
	
	public static void main(String[] args){

		in = new Scanner(System.in);
		n = in.nextInt();
		m = in.nextInt();
		grid = new int[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				grid[i][j] = in.nextInt();
			}
		}
		
		//System.out.println(Arrays.deepToString(grid));
		
		visited = new boolean[n][m];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(!visited[i][j]){
					cnt = 0;
					floodfill(i, j, grid[i][j]);		
					System.out.println(cnt);

				}
			}
		}
	}
	
	static void floodfill(int r, int c, int color){

		if(r < 0 || r >= n || c < 0 || c >= m) return; // if outside grid

		if(grid[r][c] != color) return; // wrong color
		
		if(visited[r][c]) return; // already visited this square
		
		
		
		visited[r][c] = true; // mark current square as visited
		cnt++; // increment the size for each square we visit

		// recursively call floodfill for neighboring squares
		floodfill(r, c+1, color);
		floodfill(r, c-1, color);
		floodfill(r-1, c, color);
		floodfill(r+1, c, color);
	}
}


/*
3 4
1 1 2 1
2 3 2 1
1 3 3 3
*/
