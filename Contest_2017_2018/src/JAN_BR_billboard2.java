import java.util.*;
import java.io.*;

public class JAN_BR_billboard2 {

	static Scanner in;
	static PrintWriter out;
	static boolean a[][];
	static int x1, y1, x2, y2;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() {
		
		a = new boolean[2001][2001];
			 
		fill(true);
		fill(false);		
	}

	
	static void fill(boolean s) {
		 x1 = in.nextInt() + 1000;
		 y1 = in.nextInt() + 1000;
		 x2 = in.nextInt() + 1000;
		 y2 = in.nextInt() + 1000;
		 
		for(int i=x1; i<x2; i++) {
			for(int j=y1; j<y2; j++) {
				a[i][j] = s;
			}
		}
	}
	
	static void solve() {
		
		int minX = 2001;
		int maxX = 0;
		int minY = 2001;
		int maxY = 0;
		
		boolean flag = false;
		
		for(int i=0; i<2001; i++) {
			for(int j=0; j<2001; j++) {
				if(a[i][j]) {
					minX = Math.min(minX, i);
					maxX = Math.max(maxX, i);
					minY = Math.min(minY, j);
					maxY = Math.max(maxY, j);
					flag = true;
				}
			}
		}		
	}
		
}