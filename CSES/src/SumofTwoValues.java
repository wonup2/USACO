import java.util.*;
import java.io.*;


public class SumofTwoValues {

	//static Scanner in;
	static BufferedReader in;
	static StringTokenizer st;
	static int n, x;
	static HashMap<Integer, Integer> m;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));

		init();
		solve();
		
		in.close();
	}

	static void init() throws IOException {
		
		st = new StringTokenizer(in.readLine());		
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());		
		m = new HashMap<Integer, Integer>();
	}
	
	static void solve() throws IOException {
	
		st = new StringTokenizer(in.readLine());

		boolean found = false;
		
		for(int i=1; i<=n; i++) {
			int cur = Integer.parseInt(st.nextToken());
			int seek = x-cur;
			
			if(m.containsKey(seek)) {
				System.out.println(m.get(seek) + " " + i);
				found = true;
				break;
			}
			else
				m.put(cur, i);
		}
		
		if(!found) System.out.println("IMPOSSIBLE");
	}
}
