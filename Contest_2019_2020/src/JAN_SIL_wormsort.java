import java.io.*;
import java.util.*;

public class JAN_SIL_wormsort {
  
	static BufferedReader in;
    static PrintWriter out;

	static StringTokenizer st;
	static int n, m;
	static int[] loc, lhs, rhs, weight;
	static LinkedList<Edge>[] a;
	static int[] v;
	  
	public static void main(String[] args) throws IOException{
		in = new BufferedReader(new FileReader("wormsort.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("wormsort.out")));
		st = new StringTokenizer(in.readLine());
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		loc = new int[n];
		v = new int[n];
		a = new LinkedList[n];
    
		for(int i = 0; i < n; i++) a[i] = new LinkedList<>();
    
		lhs = new int[m];
		rhs = new int[m];
		weight = new int[m];
		st = new StringTokenizer(in.readLine());
		
		for(int i = 0; i < n; i++) 
			loc[i] = Integer.parseInt(st.nextToken())-1;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int x = Integer.parseInt(st.nextToken())-1;
			int y = Integer.parseInt(st.nextToken())-1;
			int w = Integer.parseInt(st.nextToken());
			a[x].add(new Edge(y, w));
			a[y].add(new Edge(x, w));
		}
	}
	
	static void solve() {
		
		int low = 0;
		int high = 1000000001;
		
		while(low != high) {
			int mid = (low + high + 1) / 2;
			if(check(mid)) low = mid;
			else high = mid-1;
		}
		
		if(low > 1e9) low = -1;
		out.println(low);
  }
  
  static boolean check(int w) {
	  
    Arrays.fill(v, -1);
    
    int num = 0;
    
    for(int i = 0; i < v.length; i++) {
    	
      if(v[i] < 0) {
    		System.out.println(i+" "+num+" "+ w);  

        dfs(i, num++, w);
      }
      
    }
	System.out.println("hello " + Arrays.toString(v));  
	System.out.println("hello " + Arrays.toString(loc));  

    for(int i = 0; i < loc.length; i++) {
      if(v[i] != v[loc[i]]) return false;
    }
    
    return true;
  }
  

  static void dfs(int curr, int label, int minW) {
    if(v[curr] == label) return;
	System.out.println(Arrays.toString(v));  

	System.out.println("dfs: "+curr+" "+label+" "+ minW);  

    v[curr] = label;
    for(Edge child: a[curr]) 
    	if(child.w >= minW) 
    		dfs(child.d, label, minW);
  }
  
  
  static class Edge {
    int d, w;
    public Edge(int d, int w) {
      this.d = d;
      this.w = w;
    }
  }
}