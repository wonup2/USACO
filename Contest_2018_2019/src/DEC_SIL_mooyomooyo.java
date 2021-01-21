import java.util.*;
import java.io.*;

public class DEC_SIL_mooyomooyo {
	static int n, count;
	static int k;
	static char[][] a;
	static boolean changed = true, v[][];
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
			v = new boolean[n][10];
			
			for (int x = 0; x < n; x ++) 
				for (int y = 0; y < 10; y ++) 					
					if (a[x][y] != '0') {
						count = 0;
						floodFill(x, y, a[x][y]); 				
					}
				       
		
			for (int x = n - 1; x > 0; x--) 
				for (int y = 0; y < 10; y++)                     
					if (a[x][y] == '0') gravity(x, y);       					
		}		

		for (char[] c : a) out.println(c); 		
		System.out.println(); 		
	} 	

	
	static void floodFill(int x, int y, char c) { 	
		
		if (x >= n || y >= 10 || x < 0 || y < 0 || a[x][y] != c) return ; 
		
		if (count >= k ) {
			a[x][y] = '0';
			changed = true;
		} 
		else if (v[x][y]) return ;		
		
        if (!v[x][y]) count ++;        
		v[x][y] = true;
		
		floodFill(x + 1, y,  c);
		floodFill(x - 1, y,  c);
		floodFill(x, y + 1,  c);
		floodFill(x, y - 1,  c);		
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