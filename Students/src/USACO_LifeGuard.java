import java.util.*;
import java.io.*;

public class USACO_LifeGuard {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static triple a[];
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("lifeguards.in"));
		out = new PrintWriter(new File("lifeguards.out"));
		init();
		solve();
	}
	
	public static void init() {
		n = in.nextInt();
		a = new triple[n*2];
		for(int i=0; i<n; i++) {
			a[i*2] = new triple(in.nextInt(), i, true);
			a[i*2+1] = new triple(in.nextInt(), i, false);			
		}
		
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));

	}

	public static void solve() {
		int curTime = a[0].t;
		int pastTime = a[0].t;
		int guard = 0;
		int totalGuarding = 0;
		boolean arrival = false;
		Set<Integer> pool = new HashSet<Integer>();
		int[] alone = new int[n];
		
		for(triple g: a) {
			curTime = g.t;
			guard = g.g;
			arrival = g.ar;
			
			if(pool.size()!=0) totalGuarding += curTime-pastTime;
			
			if(pool.size()==1) alone[pool.hashCode()] = curTime-pastTime;
			
			if(arrival) pool.add(guard);
			else pool.remove(guard);
			
			pastTime = curTime;
		}
		
		System.out.println(totalGuarding);
		System.out.println(Arrays.toString(alone));
		
		Arrays.sort(alone);
		
		System.out.println(totalGuarding-alone[0]);		
	}
			
	static class triple implements Comparable<triple>{

		int p;
		int m;
		int t;
		
		triple(int p, int m, int t){
			this.p=p;
			this.m=m;
			this.t=t;
		}
		@Override
		public int compareTo(triple that) {	
			if(this.t==that.t) 
				return this.m-that.m;

			return this.t - that.t;
		}
		
		public String toString() {
			return p + " " + m + " " + t;
		}
	}
}
