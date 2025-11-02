<<<<<<< HEAD
import java.util.*;
import java.io.*;

public class JAN_SIL_dance {

	static BufferedReader in;
	static ArrayList<Integer>[] a;
	static HashSet<Integer> set;
	static StringTokenizer st;
	static int n, k, ans[], b[], d[][];

	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n];
		b = new int[n];

		ans = new int[n];
		d = new int[k][2];
		
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<Integer>();
			a[i].add(i);	
			b[i] = i;
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			d[i][0] = Integer.parseInt(st.nextToken())-1;
			d[i][1] = Integer.parseInt(st.nextToken())-1;
		}
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<k; i++) {			

			int x = d[i][0];
			int y = d[i][1];
					
			int f = b[x];
			int g = b[y];
			
			a[f].add(y);
			a[g].add(x);	
			
			int temp = b[x];
			b[x] = b[y];
			b[y] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> cycle = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(b[i]==-1) continue;
			
			int p = i;
			while(b[p] != -1) {
				cycle.add(p);
				int last = p;
				p = b[p];
				b[last] = -1;
			}

			set = new HashSet<Integer>();
			
			for(int c: cycle) set.addAll(a[c]);
			
			for(int c: cycle) ans[c] = set.size();
			
			cycle = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n; i++)
			sb.append(ans[i]).append("\n");
		
		System.out.print(sb.toString());
	}		
}
=======
import java.util.*;
import java.io.*;

public class JAN_SIL_dance {

	static BufferedReader in;
	static ArrayList<Integer>[] a;
	static HashSet<Integer> set;
	static StringTokenizer st;
	static int n, k, ans[], b[], d[][];

	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		a = new ArrayList[n];
		b = new int[n];

		ans = new int[n];
		d = new int[k][2];
		
		for(int i=0; i<n; i++) {
			a[i] = new ArrayList<Integer>();
			a[i].add(i);	
			b[i] = i;
		}
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(in.readLine());
			d[i][0] = Integer.parseInt(st.nextToken())-1;
			d[i][1] = Integer.parseInt(st.nextToken())-1;
		}
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<k; i++) {			

			int x = d[i][0];
			int y = d[i][1];
					
			int f = b[x];
			int g = b[y];
			
			a[f].add(y);
			a[g].add(x);	
			
			int temp = b[x];
			b[x] = b[y];
			b[y] = temp;
		}
		
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> cycle = new ArrayList<Integer>();
		
		for(int i=0; i<n; i++) {
			if(b[i]==-1) continue;
			
			int p = i;
			while(b[p] != -1) {
				cycle.add(p);
				int last = p;
				p = b[p];
				b[last] = -1;
			}

			set = new HashSet<Integer>();
			
			for(int c: cycle) set.addAll(a[c]);
			
			for(int c: cycle) ans[c] = set.size();
			
			cycle = new ArrayList<Integer>();
		}
		
		for(int i=0; i<n; i++)
			sb.append(ans[i]).append("\n");
		
		System.out.print(sb.toString());
	}		
}
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
