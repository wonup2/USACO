import java.io.*;
import java.util.*;
public class perimeter {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, ans, cnt, per, Mans, Mper;
	static char[][] a;
	static boolean v[][];
	static String prob = "perimeter";
	static StreamTokenizer st;

	public static void main(String[] args) throws IOException{
		in=new BufferedReader(new FileReader(prob + ".in"));
			st=new StreamTokenizer(in);
			out = new PrintWriter(new File(prob+ ".out"));
			
			
			init();
			solve();
			
			
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException{
		
		n = readInt();
		//in.readLine();
		a = new char[n][n];
		
		
		for(int i =0; i < n; i++) {
			a[i] = in.readLine().toCharArray();
		}
		
		//print2D(a);
	}
	
	static void solve() {
		ans = 0;  Mans =0; Mper=0;
		for(int i =0; i < n; i++) {
			for(int j =0; j < n; j++) {
				//System.out.println(a[i][j]);
				if(a[i][j] == '#') {
					cnt =0;per =0;
					floodfill(i , j);
					
					if(cnt == ans) Mper = Math.min(Mper, per);
					else Mper = Math.max(Mper, per);
					ans = Math.max(ans, cnt);
				}
			}
		}
		out.println(ans + " " + Mper);
	}
	
	static void floodfill(int x, int y) {
		if(x<0||x>=n|y<0||y>=n) {per++; return;}		// if outside grid
		if(a[x][y] == '.') {per++; return;}				// wrong color
		if(a[x][y] == '@') return;						// already visited this square
		
		a[x][y] = '@';
		cnt++;
		
		// recursively call floodfill for neighboring squares
		floodfill(x, y+1);
		floodfill(x, y-1);
		floodfill(x-1, y);
		floodfill(x+1, y);
	}
	
	public static void print2D(char[][] grid) {
		for(int i =0; i < grid.length; i++) {
			for(int j =0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
	static int readInt() throws IOException {
		st.nextToken();
		return (int)st.nval;
	}
	
}
/*
3 4
1 1 2 1
2 3 2 1
1 3 3 3
*/
