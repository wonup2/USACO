import java.util.*;
import java.io.*;

public class DEC_SIL_mooyomooyo {
	static int n, k, count, dx[]= {0,0,-1,1}, dy[]= {-1,1,0,0};
	static char a[][], c;
	static boolean visited[][], changed = true;
	
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("mooyomooyo.in"));
		out = new PrintWriter(new File("mooyomooyo.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	
	public static void init() throws IOException {		

		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
			
		a = new char[n][10];
		for (int i = 0; i < n; i ++) 
			a[i] = in.readLine().toCharArray();
	}
	
	public static void solve() {
		//System.out.println(Arrays.deepToString(a));
		while (changed) {
			changed = false;
            visited = new boolean[n][10];
			for (int x = 0; x < n; x ++) {
				for (int y = 0; y < 10; y ++) { 					
					if (a[x][y] == '0') continue; 	
					count = 0;
					c=a[x][y];
					dfs(x, y); 				
				} 			
			}             
			
			for (int x = n - 1; x > 0; x--) 
                for (int y = 0; y < 10; y++) 
                	if (a[x][y] == '0') applyGravity(x, y);                
		} 		 		
		
		for (char[] c : a) out.println(c);
		out.close();
	}
	
	static int dfs(int x, int y) {
		
		if (x >= n || y >= 10 || x < 0 || y < 0 || a[x][y] != c) return count;
		
		if (count >= k ) {
			a[x][y] = '0';
			changed = true;
		} 
		else if (visited[x][y]) return count;		
						
		if (!visited[x][y]) count ++;        
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) 
			count = dfs(x + dx[i], y + dy[i]);
			
		 return count;
	}
	
	static void applyGravity(int start, int column) {
		for (int row = start; row < n; row ++) {
			if (a[row][column] == '0' && a[row - 1][column] != '0') {
				a[row][column] = a[row - 1][column];
				a[row - 1][column] = '0';
			}
		}
	}
	
	static void printA(char[][] chars) {
		for (char[] c : chars) System.out.println(c);
		System.out.println();
	}
}