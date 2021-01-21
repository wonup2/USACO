
import java.io.*;
import java.util.*;

public class JAN_SIL_cowdance {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N;
	static int TMax;
	static int ans;
	static int [] cows;

	public static void main(String[] args) {

		try {
			init();
	        solve();
	        out.close();
	        in.close();
	    }
	    catch(Exception e) {
	        e.printStackTrace();
	    }

	}
	
	public static void init () throws IOException {
		
		in = new BufferedReader(new FileReader ("cowdance.in"));
		out = new PrintWriter (new File ("cowdance.out"));
		StringTokenizer st = new StringTokenizer (in.readLine());
		N = Integer.parseInt(st.nextToken());
		TMax = Integer.parseInt(st.nextToken());
		cows = new int [N];
		for (int i = 0; i < N; i++) {
			cows[i] = Integer.parseInt(in.readLine());
		}
		
	}
	
	public static void solve () {
		int low = 1;
		int high = N;
		int mid = 0;
		while (low <= high) {
			mid = (low + high)/2;
			if (check (mid)) {
				high = mid - 1;
				ans = mid;
			}
			else {
				low = mid + 1;
			}
		}
		out.println(ans);
	}
	
	public static boolean check (int mid) {
		
		PriorityQueue <Integer> q = new PriorityQueue<Integer>();
		for (int i = 0; i < mid; i++) {
			q.add(cows[i]);
		}
		for (int i = mid; i < N; i++) {
			int n = q.peek();
			if (n + cows[i] > TMax) {
				return false;
			}
			q.poll();
			q.add(cows[i]+n);//<----
		}
		return true;
		
	}

}
