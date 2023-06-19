import java.io.*;
import java.util.*;

public class US17_DEC_BR_billboard {
	static Scanner in;
	static PrintWriter out;
	
	static int x1, y1, x2, y2, ans;
	static boolean a[][];
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("billboard.in"));
		out = new PrintWriter(new File("billboard.out"));
		
		solve();
		
		in.close();
		out.close();
	}

	static void solve() {
		
		a = new boolean[2001][2001];
		
		fill(true);
		fill(true);
		fill(false);
		
		for(int i=0; i<2001; i++) 
			for(int j=0; j<2001; j++) 
				if(a[i][j]) ans++;			
		
		out.println(ans);
	}
	
	static void fill(boolean b) {
		
		x1 = in.nextInt()+1000;
		y1 = in.nextInt()+1000;
		x2 = in.nextInt()+1000;
		y2 = in.nextInt()+1000;
		
		for(int i=x1; i<x2; i++) 
			for(int j=y1; j<y2; j++) 
				a[i][j] = b;			
	}
}
