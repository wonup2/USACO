import java.util.*;
import java.io.*;


public class AngryCow_Bronze {

	static Scanner in;
	static PrintWriter out;
	static int n, a[];
	
	
	public static void main(String[] args) throws IOException {

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
	}
	
	static void solve() {
		
		int ans = 0;
		
		for(int i=0; i<n; i++) {
			
			int left = getIdx(i, true);
			int right = getIdx(i, false);
			
			int d = right-left + 1; System.out.println(i+" "+d);
			ans = Math.max(ans, d);
		}
		
		out.println(ans);
	}

	static int getIdx(int cur, boolean left) {
		
		int d = left? -1:1;
		int r = 1;
		
		while(cur>=0 && cur<n) {
			
			int next = cur;
			
			while(true) {
				if(next+d<0||next+d>=n||Math.abs(a[cur]-a[next+d])>r) break;
				next = next+d;
			}
			
			if(next==cur) break;
			cur = next;
			r++;			
		}
		
		return cur;
		
	}
}
