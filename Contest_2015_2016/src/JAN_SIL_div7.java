//2016 January Contest, Silver Problem 2. Subsequences Summing to Sevens

import java.util.*;
import java.io.*;

public class JAN_SIL_div7 {

	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n, ans, position[], div[];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("div7.in"));
		out = new PrintWriter(new File("div7.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		position = new int[n+1];
		div = new int[n+1];
		ans = 0;
	}

	static void solve() throws NumberFormatException, IOException {
		
		for(int i=1; i<=n; i++) {
						
			div[i] = (div[i-1] + Integer.parseInt(in.readLine())) % 7;
			
			if(position[div[i]] == 0) position[div[i]] = i;
			else ans = Math.max(ans, i-position[div[i]]);
		}
		
		out.println(ans);
	}
}
