
import java.util.*;
import java.io.*;
public class MazeTacToe {
	static int n, maxCommands;
	static String maze[][];
	static Set<char[][]> ans = new HashSet<char[][]>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		maze = new String[n][n];
		maxCommands = 0;
		int bessieX = 0;
		int bessieY = 0;
		for(int i = 0; i < n; i++) {
			String input = br.readLine();
			for(int j = 0; j < input.length(); j += 3) {
				if(input.substring(j, j + 3).equals("BBB")) {
					bessieX = i;
					bessieY = j / 3;
				}
				else if(input.charAt(j) == 'O' || input.charAt(j) == 'M')
					++maxCommands;
				maze[i][j / 3] = input.substring(j, j + 3);
			}
		}
		boolean[][] visited = new boolean[n][n];
		Set<String> commandSet = new HashSet<String>();
		char[][] ticTacToe = {{'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}, {'.', '.', '.', '.'}};
		findPaths(bessieX, bessieY, visited, commandSet, ticTacToe);
		System.out.println(ans.size());
		br.close();
	}
	public static void findPaths(int x, int y, boolean[][] v, Set<String> set, char[][] grid) {
		boolean isTrue = false;
		if(x < 0 || y < 0 || x >= n || y >= n || v[x][y] || maze[x][y].equals("###") || set.size() == maxCommands)
			return;
		if(maze[x][y].charAt(0) == 'M' && !set.contains(maze[x][y])) {
			set.add(maze[x][y]);
			isTrue = true;
			int n1 = Integer.parseInt(maze[x][y].substring(1, 2));
			int n2 = Integer.parseInt(maze[x][y].substring(2));
			if(grid[n1][n2] == '.') {
				grid[n1][n2] = 'M';
			}
			boolean b = false;
			for(String str : set) {
				if(str.substring(1).equals(maze[x][y].substring(1))) {
					b = true;
					break;
				}
			}
			if(!b)
				v = new boolean[n][n];
		}
		if(maze[x][y].charAt(0) == 'O' && !set.contains(maze[x][y])) {
			isTrue = true;
			int n1 = Integer.parseInt(maze[x][y].substring(1, 2));
			int n2 = Integer.parseInt(maze[x][y].substring(2));
			if(grid[n1][n2] == '.') {
				grid[n1][n2] = 'O';
			}
			boolean b = false;
			for(String str : set) {
				if(str.substring(1).equals(maze[x][y].substring(1))) {
					b = true;
					break;
				}
			}
//			System.out.println(b);
			if(!b)
				v = new boolean[n][n];
			set.add(maze[x][y]);
		}
		v[x][y] = true;
//		for(int i = 1; i <= 3; i++)
//			System.out.println(grid[i][1] + "" + grid[i][2] + "" + grid[i][3]);
//		System.out.println(x + " " + y + " " + set.toString() + " " + maze[x][y]);
//		for(int i = 0; i < n; i++)
//			System.out.println(Arrays.toString(v[i]));
//		System.out.println();
		if(grid[1][1] == 'M' && grid[1][2] == 'O' && grid[1][3] == 'O' || grid[1][1] == 'O' && grid[1][2] == 'O' && grid[1][3] == 'M' ||
				grid[2][1] == 'M' && grid[2][2] == 'O' && grid[2][3] == 'O' || grid[2][1] == 'O' && grid[2][2] == 'O' && grid[2][3] == 'M' ||
				grid[3][1] == 'M' && grid[3][2] == 'O' && grid[3][3] == 'O' || grid[3][1] == 'O' && grid[3][2] == 'O' && grid[3][3] == 'M' ||
				grid[1][1] == 'M' && grid[2][1] == 'O' && grid[3][1] == 'O' || grid[1][1] == 'O' && grid[2][1] == 'O' && grid[3][1] == 'M' ||
				grid[1][2] == 'M' && grid[2][2] == 'O' && grid[3][2] == 'O' || grid[1][2] == 'O' && grid[2][2] == 'O' && grid[3][2] == 'M' ||
				grid[1][3] == 'M' && grid[2][3] == 'O' && grid[3][3] == 'O' || grid[1][3] == 'O' && grid[2][3] == 'O' && grid[3][3] == 'M' ||
				grid[1][1] == 'M' && grid[2][2] == 'O' && grid[3][3] == 'O' || grid[1][1] == 'O' && grid[2][2] == 'O' && grid[3][3] == 'M' ||
				grid[1][3] == 'M' && grid[2][2] == 'O' && grid[3][1] == 'O' || grid[1][3] == 'O' && grid[2][2] == 'O' && grid[3][1] == 'M') {
			ans.add(grid);
			return;
		}
		findPaths(x - 1, y, v, set, grid);
		findPaths(x + 1, y, v, set, grid);
		findPaths(x, y + 1, v, set, grid);
		findPaths(x, y - 1, v, set, grid);
		v[x][y] = false;
		if(isTrue)
			set.remove(maze[x][y]);
	}
}