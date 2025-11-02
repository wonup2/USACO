import java.io.*;
import java.util.*;
public class FEB_BR_SwapitySwapSwap {
	
	static BufferedReader in;
	static StringTokenizer st;
	static PrintWriter out;
	static int n, k, a1, a2, b1, b2, ar[];
	
	public static void main(String[] args) throws IOException {
	    in = new BufferedReader(new FileReader("swap.in"));
	    out = new PrintWriter(new BufferedWriter(new FileWriter("swap.out")));
	    init();
	    solve();
	    in.close();
	    out.close();
	}
  
	static void init() throws IOException {
    
	    st = new StringTokenizer(in.readLine());
	    n = Integer.parseInt(st.nextToken());
	    k = Integer.parseInt(st.nextToken());
	    
	    st = new StringTokenizer(in.readLine());
	    a1 = Integer.parseInt(st.nextToken())-1;
	    a2 = Integer.parseInt(st.nextToken())-1;
	    
	    st = new StringTokenizer(in.readLine());
	    b1 = Integer.parseInt(st.nextToken())-1;
	    b2 = Integer.parseInt(st.nextToken())-1;
	}
  
	static void solve() {
	    int cycle = 0;
	    ar = new int[n];
	    for(int i = 0; i < n; i++) ar[i] = i;
	    boolean sorted = true;
	    
	    while(true) {
	      cycle++;
	      reverse(a1, a2);
	      reverse(b1, b2);
	      sorted = true;
	      for(int i = 0; sorted && i < n; i++) {
	    	  if(ar[i] != i) sorted = false;    	  
	      }
	      if(sorted) break;
	    }
	    System.out.println(cycle);
	    k %= cycle;
	    
	    for(int i = 0; i < n; i++) ar[i] = i+1;
	    
	    for(int i = 0; i < k; i++) {
	      reverse(a1, a2);
	      reverse(b1, b2);
	    }
	    
	    StringBuilder sb = new StringBuilder();
	    for(int v: ar) sb.append(v).append("\n");
	    out.print(sb.toString());
	    
	}
	
	static void reverse(int a, int b) {
	    while(a < b) {
	      int t = ar[a];
	      ar[a] = ar[b];
	      ar[b] = t;
	      a++;
	      b--;
	    }
	}
}