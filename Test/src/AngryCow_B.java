import java.util.*;
import java.io.*;

public class AngryCow_B {
	
	static Scanner in;
	static PrintWriter out;
	static int n, cnt, a[];
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		in = new Scanner(new File("test.in"));
		out = new PrintWriter(new File("test.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			System.out.println("Start: "+a[i]);

			int cnt = cntCow(i, true) + cntCow(i, false) + 1;
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
		
	}
	
	static int cntCow(int cur, boolean left) {
		
		int t = 1;
		int cnt = 0;
		int d = left? -1:1;
		while(cur>=0 && cur < n) {
			
			int next = cur;
			
			while(true) {
				if(next+d<0 || next+d>=n) break;
				if(Math.abs(a[cur]-a[next+d]) > t) break;
				
				next+=d; System.out.print(a[next]+" ");
				cnt++;
			}
			
			if(cur==next) break;
			t++;
			cur = next;
		}
		System.out.println();
		return cnt;
	}
}
