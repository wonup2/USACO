import java.util.*;
import java.io.*;

public class DEC_SIL_ConnectingTwoBarns {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, m, dis[];
	static HashSet<Integer>[] a, b;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));

		t = Integer.parseInt(in.readLine());

		for(int i=0; i<t; i++) {
			init();
			solve();
		}
	}
	
	public static void init() throws NumberFormatException, IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		a = new HashSet[n+1];
		b = new HashSet[n+1];
		
		dis = new int[n+1];
		for(int i=0; i<=n; i++) {
			a[i] = new HashSet<Integer>();
			b[i] = new HashSet<Integer>();
			dis[i] = i;
		}
//		System.out.println(Arrays.toString(dis));

		for(int i=0; i<m; i++) {
			st = new StringTokenizer(in.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());

			a[n1].add(n2);
			a[n2].add(n1);	
		}

		for(int i=1; i<=n; i++) {
			if(dis[i]==i) dfs(i, i);
		}		
		
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(dis));
	}
	
	static void dfs(int i, int p) {
		for(int e:a[i]) {
			if(dis[e] != p) {
				dis[e] = p;
				dfs(e, p);
			}			
		}
	}
		
	public static void solve() {
		//
		if(dis[0]==dis[n]) {
			System.out.println(0);
			return;
		}
		
		//
		for(int i=1; i<=n; i++) {
			b[dis[i]].add(i);
		}
		
//		System.out.println("b: "+Arrays.toString(b));

		//
		long[] barn1 = new long[n+1];
		long[] barnN = new long[n+1];
		Arrays.fill(barn1, Long.MAX_VALUE);
		Arrays.fill(barnN, Long.MAX_VALUE);

		for(int i=1; i<=n; i++) {
			for(int e:b[dis[1]]) {
				barn1[dis[i]] = Math.min(barn1[dis[i]], Math.abs(i-e));
			}
			for(int e:b[dis[n]]) {
				barnN[dis[i]] = Math.min(barnN[dis[i]], Math.abs(i-e));
			}
		}
//		System.out.println(Arrays.toString(barn1));
//		System.out.println(Arrays.toString(barnN));
//		
		//
		
		long ans = Long.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			long temp = barn1[i]*barn1[i] + barnN[i]*barnN[i];
			ans = Math.min(ans, temp);
		}
		
		System.out.println(ans);
	}
}
