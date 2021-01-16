//https://cses.fi/problemset/task/1666

import java.io.*;
import java.util.*;
public class moocast {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n, x[], y[], p[], cnt;
	static boolean v[];
	
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("moocast.in"));
		out = new PrintWriter(new FileWriter("moocast.out"));
		init();
		solve();
		in.close();		
		out.close();
	}
	
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		
		x = new int[n];
		y = new int[n];
		p = new int[n];

		StringTokenizer st; 
		for(int i=0; i<n; i++){			
			st = new StringTokenizer(in.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}		
		
	}
	
	static void solve() {
		int ans = 0;

		for(int i=0; i<n; i++){
			v = new boolean[n];		

			dfs(i);
			//System.out.println("----------\n");
			int cnt = 0;
			for(int j=0; j<n; j++) if(v[j]) cnt++;
			ans = Math.max(ans, cnt);
		}		
		out.println(ans);		
	}
	
	static void dfs(int s){
		v[s]=true;
		for(int i=0; i<n; i++) {
			if (v[i]) continue;
			long dist = (long)(x[s]-x[i])*(x[s]-x[i])+(long)(y[s]-y[i])*(y[s]-y[i]);
			long power = (long)p[s]*p[s];
			//System.out.println(s+" "+ i+" "+dist+" "+ power);
			if(dist<=power) dfs(i);
		}			
	}	
}