import java.util.*;
import java.io.*;

public class US_SIL_closing {

	static Scanner in;
	static PrintWriter out;
	static int N, M, dist[];
	static ArrayList<Integer> a[];
	static boolean closed[];

	public static void main(String[] args) throws IOException {
		
		in = new Scanner(new File("closing.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("closing.out")));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		N = in.nextInt();
		M = in.nextInt();
		
		a = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) a[i] = new ArrayList<Integer>();
				
	    for(int i=0; i<M; i++){
	        int x = in.nextInt();
	        int y = in.nextInt();
	        a[x].add(y);
	        a[y].add(x);
	    }
	    
	    closed = new boolean[N+1];
	    dist = new int[N*M];
	    Arrays.fill(dist, -1);
	}
	
	static void solve() {
		
	    if (dfs(1)) System.out.println("YES");

	    for(int i=0; i<=N-2; i++) {
	    	int closedB = in.nextInt();
            closed[closedB] = true;

	        int start = 1;
	        
	        for(int j=1; j<=N - 1; j++) {
	           if (! closed[j]) {
	                start = j;
	                break;
	            }
	        }

	        if (dfs(start)) System.out.println("YES");
	        else System.out.println("NO");
	    }

	}
	

	static boolean dfs(int start){
	    // fill distance array with -1's
		
	    Stack <Integer> st = new Stack<Integer>();
	    dist[start] = 0;

	    st.push(start);
	    
	    while(!st.empty()){
	        int node = st.pop();

	        for(int next : a[node]){
	            if(dist[next] == -1 && (! closed[next])) {
	                dist[next] = dist[node] + 1;
	                st.push(next);
	            }
	        }
	    }

	    for(int i=1; i<N; i++) {
	        if (dist[i] == -1 && (! closed[i])) {
	            return false;
	        }
	    }
	    return true;
	}
}


