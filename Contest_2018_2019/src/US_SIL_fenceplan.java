import java.util.*;
import java.io.*;

public class US_SIL_fenceplan {

	static Scanner in;
	static PrintWriter out;
	static int N, M, ans, x[], y[], MX, mx, MY, my;
	static ArrayList<Integer>[] a;
	static boolean[] v;	
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("fenceplan.in"));
		out = new PrintWriter(new File("fenceplan.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		
		N = in.nextInt(); 
		M = in.nextInt(); 
		x = new int[N];
		y = new int[N];
		a = new ArrayList[N];
		v = new boolean[N];
		
		for(int i=0; i<N; i++) {
			x[i] = in.nextInt();
			y[i] = in.nextInt();
			a[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			int x = in.nextInt()-1;
			int y = in.nextInt()-1;
			a[x].add(y);
			a[y].add(x);
		}
//		System.out.println(Arrays.toString(x));
//		System.out.println(Arrays.toString(y));
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(v));

		ans = Integer.MAX_VALUE;
		
	}
	static void solve() {
		
		for(int i=0; i<N; i++) {
			if(!v[i]) {
				MX = mx = x[i];
				MY = my = y[i];
				dfs(i);
				//System.out.printf("%d, %d, %d, %d, %d\n",i, MX, mx, MY,my );
				ans = Math.min(ans, ((MX-mx) + (MY-my))*2);
			}
		}

		out.println(ans);
	}	
	
	static void dfs(int i) {
		
		if(v[i]) return;
		
		MX = Math.max(MX, x[i]);
		mx = Math.min(mx, x[i]);
		MY = Math.max(MY, y[i]);
		my = Math.min(my, y[i]);
		v[i] = true;
		
		for(int n: a[i]) {
			if(v[n]) continue;

			dfs(n);
		}
	}
}
