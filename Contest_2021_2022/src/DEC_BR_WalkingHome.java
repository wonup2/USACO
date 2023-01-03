import java.util.*;
import java.io.*;

public class DEC_BR_WalkingHome {

	static BufferedReader in;
	static StringTokenizer st;
	static StringBuilder sb;
	static int t, n, k, ans, cnt;
	static char a[][];
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		sb = new StringBuilder();
		
		for(int i=0; i<t; i++) {
			init();
		}
		
		System.out.print(sb.toString());
		
		in.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new char[n][];

		for(int i=0; i<n; i++) a[i] = in.readLine().toCharArray();				
		
		ans = 0;	

		solve(0, 0, 0, true);
		solve(0, 0, 0, false);
		
		sb.append(ans/2).append("\n");
	}	
	
	static void solve(int i, int j, int turn, boolean d) {
		
		if(i==n-1 && j==n-1) { 
			ans++; 
			return;
		}		
		if(i>=n || j >=n) return;
		if(a[i][j]=='H') return;
		if(turn > k) return;
				
		
		if(d) j = j + 1;
		else i = i + 1;		
		
		solve(i, j, turn, d);
		solve(i, j, turn+1, !d);
	}
}

/*
1
3 1
...
...
...
*/