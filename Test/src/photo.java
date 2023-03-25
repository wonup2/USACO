import java.util.*;
import java.io.*;


public class photo {

	static Scanner in;
	static PrintWriter out;
	static String file = "bphoto";
	
	static int n;
	static pair a[];
	static int[] bit;
	static class pair implements Comparable<pair>{

		int h, i;
		pair(int a, int b){
			h=a; i=b;
		}
		
		@Override
		public int compareTo(photo.pair o) {
			return o.h-this.h;
		}
		public String toString() {
			return h+" "+i;
		}
		
	}
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		n = in.nextInt();
		
		a = new pair[n];
		for(int i=0; i<n; i++) {
			a[i] = new pair(in.nextInt(), i+1);
		}
		Arrays.sort(a);

		bit = new int[n+1];
	}
	
	static void solve() {
		int seen = 0;
		int ans = 0;
		for(pair p: a) {
			int l = lcnt(p.i);
			int r = seen-l;
			
			if(Math.max(l, r) > 2*Math.min(l, r)) ans++;
			seen++;
			update(p.i);
		}
		
		out.println(ans);
	}
	
	static int lcnt(int i) {
		int cnt = 0;

		while(i>0) {
			cnt+= bit[i];
			i-=i&-i; 
		}
		
		return cnt;
	}
	
	static void update(int i) {
	
		while(i<=n) {			
			bit[i]++;
			i+=i&-i;
		}
	}
}
