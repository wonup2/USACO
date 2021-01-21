import java.util.*;
import java.io.*;

public class _tempUSACO {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static pair a[];

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("cowqueue.in"));
		out = new PrintWriter(new File("cowqueue.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		a = new pair[n];
		
		for(int i = 0; i<n; i++) {
			a[i] = new pair(in.nextInt(), in.nextInt());
		}
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		int ans = 0;
		
		int s = a[0].x;
		int e = a[0].y + s;
		
		for(int i=1; i<n; i++) {
			if(e < a[i].x) {
				s = a[i].x;
				e = s + a[i].y;
			}
			else {
				e = e + a[i].y;
			}
			
		}
		
		System.out.println(e);

	}	
	
	static class pair implements Comparable<pair>{

		int x;
		int y;
		
		pair(int a, int b){
			x = a;
			y = b;
		}
		
		public String toString() {
			return x+" "+y;
		}
		
		@Override
		public int compareTo(pair that) {
			
			if(this.x < that.x) return -1;
			else return 1;
		}		
	}
}

