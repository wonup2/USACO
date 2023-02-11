import java.util.*;
import java.io.*;

public class JAN_BR_angry {

	static Scanner in;
	static PrintWriter out;
	static int a[], n, ans;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("angry.in"));
		out = new PrintWriter(new File("angry.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();			
		a = new int[n];		
		for(int i=0; i<n; i++) a[i] = in.nextInt();		
		Arrays.sort(a);		
		ans = 1;		
	}
	
	static void solve() {
		
		for(int i=0; i<n; i++) 
			ans = Math.max(check(i, 1) + check(i, -1), ans);
		
		out.println(ans);
	}	
	
	static int check(int cur, int d) {
		
		int p = 1;
		int cnt = 0;
		
		while(cur >=0 && cur < n) {
			int next = cur;
			
			while(true) {
				if(next+d < 0 || next+d >= n || Math.abs(a[next+d]-a[cur]) > p) break;
				next = next + d;
				cnt++;
			}
			
			if(cur==next) break;
			cur = next;
			p++;
		}
		
		return cnt;
	}
}
