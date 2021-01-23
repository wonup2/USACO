import java.io.*;
import java.util.*;
/*
7 5
1 2
2 3
3 4
5 6
6 7
*/
public class _tempDFS {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	static int n, m, ans;
	static ArrayList<Integer> a[];
	static boolean v[];
	
	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new FileReader("xxx.in"));
		in = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedWriter(new FileWriter("xxx.out")));		
		init();
		solve();		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
			
		st = new StringTokenizer(in.readLine());		
		n = Integer.parseInt(st.nextToken());				
		m = Integer.parseInt(st.nextToken());		

		a = new ArrayList[n];
		
		for(int i = 0; i < n; i++) a[i] = new ArrayList<Integer>();	
				
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			a[x].add(y);
			a[y].add(x);
		}		
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() throws IOException {
		ans = 0;
		for(int i=0; i<n; i++) {
			if(!v[i]) {	
				dfs(i);	
				ans++;
			}	
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