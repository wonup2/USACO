import java.io.*;
import java.util.*;
/*
5 8
########
#..#...#
####.#.#
#..#...#
########

3
*/
public class cses1192 {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	
	static int n, m, ans;
	static char a[][];
	static boolean v[][];
	
	public static void main(String[] args) throws IOException {
		//in = new BufferedReader(new FileReader("xxx.in"));
		in = new BufferedReader(new InputStreamReader(System.in));
		//out = new PrintWriter(new BufferedWriter(new FileWriter("xxx.out")));		
		init();
		solve();		
		in.close();
		//out.close();
	}
	
	static void init() throws IOException {
			
		st = new StringTokenizer(in.readLine());		
		n = Integer.parseInt(st.nextToken());				
		m = Integer.parseInt(st.nextToken());		

		a = new char[n][];
		v = new boolean[n][m];
		
		for(int i = 0; i < n; i++) a[i] = in.readLine().toCharArray();					
	}
	
	static void solve() throws IOException {
		ans = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(a[i][j]=='.') {	
					dfs(i, j);	
					ans++;
				}	
			}
		}
		//System.out.println(Arrays.deepToString(a));
		System.out.println(ans);
	}
	
	static void dfs(int i, int j) {
		if(i<0||i>=n||j<0||j>=m||a[i][j]=='#') return;
		
		a[i][j] = '#';		
		dfs(i, j+1);
		dfs(i, j-1);
		dfs(i+1, j);
		dfs(i-1, j);

	}		
}