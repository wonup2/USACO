import java.util.*;
import java.io.*;

public class U21Dec_WalkingHome {

	static Scanner in;
	static int t, n, k, ans;
	static char a[][];

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		t = in.nextInt();
		
		for(int i=0; i<t; i++) init();
		
		in.close();
	}

	static void init() {
		
		n = in.nextInt();
		k = in.nextInt();
		
		ans = 0;
		a = new char[n][];
		
		for(int i=0; i<n; i++) a[i] = in.next().toCharArray();
		
		solve(0, 0, 0, true);
		solve(0, 0, 0, false);
			
		System.out.println(ans/2);
	}
	
	static void solve(int r, int c, int turn, boolean d) {
		
		if(r==n-1 && c==n-1) {
			ans++;
			return;
		}		
		if(r>=n || c>=n || turn>k) return;
		if(a[r][c]=='H') return;
		
		if(d) c++;
		else r++;
		
		solve(r, c, turn, d);
		solve(r, c, turn+1, !d);
	}	
}
