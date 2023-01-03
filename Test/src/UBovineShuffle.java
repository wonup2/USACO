import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class UBovineShuffle {
	
	static String file = "cownomics";
	static Scanner in;
	static PrintWriter out;
	static int n, m;
	static char p[][], s[][];

	public static void main(String[] args) throws FileNotFoundException {
		
		in = new Scanner(new File(file + ".in"));
		out = new PrintWriter(new File(file + ".out"));
		
		init();
		solve();
		
		in.close();
		out.close();

	}
	
	static void init() {
		
		n = in.nextInt();
		
		m = in.nextInt();
	
		p = new char[n][];
		for(int i=0; i<n; i++) p[i] = in.next().toCharArray();
		
		s = new char[n][];
		for(int i=0; i<n; i++) s[i] = in.next().toCharArray();		
	}
	
	static void solve() {
		
		int cnt = 0;
		
		for(int i=0; i<m; i++) {
			
			boolean ok = true;
			
			for(int j=0; j<n; j++) {
				char key = p[j][i];
				
				for(int k=0; k<n; k++) {
					if(key==s[k][i]) ok = false;
				}
			}
			
			if(ok) cnt++;
		}

		out.println(cnt);
	}

}