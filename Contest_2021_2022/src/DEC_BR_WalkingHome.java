import java.util.*;
import java.io.*;

public class DEC_BR_WalkingHome {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, k, ans;
	static char a[][];
	static ArrayList<Character> l;
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(in.readLine());
		
		for(int i=0; i<t; i++) 
			init();
		
		in.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new char[n][];

		for(int i=0; i<n; i++)
			a[i] = in.readLine().toCharArray();		
		
		ans = 0;	
		
		solve(0, 0, 0, true);
		solve(0, 0, 0, false);
		
		System.out.println(ans/2);
	}	
	
	static void solve(int i, int j, int turn, boolean d) {
		
		if(i==n-1 && j==n-1) {
			ans++;		
			return;
		}
		if(i>=n || j >=n) return;
		if(turn > k) return;
		if(a[i][j]=='H') return;
		
		if(d) i = i + 1;
		else j = j + 1;
					
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