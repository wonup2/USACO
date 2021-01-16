import java.io.*;
import java.util.*;

public class _tempDFS {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	static int n, m, ans;
	static LinkedList<Integer>[] a;
	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("mootube.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("mootube.out")));		
		init();
		solve();		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
			
		st = new StringTokenizer(in.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		a = new LinkedList[n];
		
		for(int i = 0; i < n; i++) a[i] = new LinkedList<Integer>();	
				
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}		
	}
	
	static void solve() throws IOException {
		
		for(int i=0; i<n; i++)
			if(!v[i]) {
				dfs(i);
				ans++;
			}	
	}
	
	static void dfs(int i) {
		v[i] = true;
		
		for(int e:a[i]) {
			if(!v[e]) {
				dfs(e);
			}
		}
	}		
}