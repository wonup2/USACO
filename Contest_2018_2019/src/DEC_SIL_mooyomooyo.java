import java.util.*;
import java.io.*;

public class DEC_SIL_mooyomooyo {
	static int n;
	static int k;
	static char[][] a;
	static boolean changed = true;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException {
		in = new Scanner(new File("mooyomooyo.in"));
		out = new PrintWriter(new File("mooyomooyo.out")); 		
		init();
		solve();
		in.close();
		out.close();
	}
		
	static void init() {
		
		n = in.nextInt();
		k = in.nextInt(); in.nextLine();
		
		a = new char[n][];
		for (int i = 0; i < n; i ++) a[i] = in.nextLine().toCharArray();		
	}
	
	static void solve() {
		
		while (changed) {
			
			changed = false;
			boolean[][] visited = new boolean[n][10];
			
			for (int x = 0; x < n; x ++) 
				for (int y = 0; y < 10; y ++) 					
					if (a[x][y] != '0') floodFill(x, y, visited, 0, a[x][y]); 				
				       
		
			for (int x = n - 1; x > 0; x--) 
				for (int y = 0; y < 10; y++)                     
					if (a[x][y] == '0') gravity(x, y);       					
		}		

		for (char[] c : a) out.println(c); 		
		System.out.println(); 		
	} 	

	
	static int floodFill(int x, int y, boolean[][] visited, int count, char c) { 	
		
		if (x >= n || y >= 10 || x < 0 || y < 0 || a[x][y] != c) return count; 
		
		System.out.println(x+" "+y+" "+a[x][y] + " "+count);

		if (count >= k ) {
			a[x][y] = '0';
			changed = true;
		} 
		else if (visited[x][y]) return count;		
		
        if (!visited[x][y]) count ++;        
		visited[x][y] = true;
		
		count = floodFill(x + 1, y, visited, count, c);
		count = floodFill(x - 1, y, visited, count, c);
		count = floodFill(x, y + 1, visited, count, c);
		count = floodFill(x, y - 1, visited, count, c);
		
        return count;
	}
	
	static void gravity(int start, int j) {
		for (int i = start; i < n; i ++) {
			if (a[i][j] == '0' && a[i - 1][j] != '0') {
				a[i][j] = a[i - 1][j];
				a[i - 1][j] = '0';
			}
		}
	}
	
	static void printA(char[][] c1) {
		char[][] chars = {{'1','2'}};
		for (char[] c : chars) System.out.println(c);
		System.out.println();
	}
}