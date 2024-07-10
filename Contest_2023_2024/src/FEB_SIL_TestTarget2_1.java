import java.util.*;
import java.io.*;

public class FEB_SIL_TestTarget2_1 {

	static BufferedReader in;
	static StringTokenizer st;
	static int t, n;
	static long x1, y1[], x2[], y2[];
	static ArrayList<Integer>ns, ps;
	public static void main(String[] args) throws IOException {

		//in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new FileReader("in.txt"));
		t = Integer.parseInt(in.readLine());
		while(t-->0) {
			init();
			solve();
		}
		in.close();
	}

	static void init() throws IOException {
		st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		x1 = Integer.parseInt(st.nextToken());
		y1 = new long[n];
		x2 = new long[n];
		y2 = new long[n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			y1[i] = Long.parseLong(st.nextToken());
			y2[i] = Long.parseLong(st.nextToken());
			x2[i] = Long.parseLong(st.nextToken());
		}
	
		ns = new ArrayList<Integer>();
		ps = new ArrayList<Integer>();
		st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp<0) ps.add(temp);
			else ns.add(temp);
		}
	}
	
	static void solve() {
		if(ps.size()<n || ns.size()<n) {
			System.out.println(-1);
			return;
		}
		
		int slope = Math.abs(ns.get(0));
		
		long min_y = Long.MAX_VALUE;
		long max_y = Long.MIN_VALUE;

		for(int i=0; i<n; i++ ) {
			min_y = Math.min(y1[i]-slope*x2[i], min_y);
			max_y = Math.max(y2[i]+slope*x2[i], max_y);
		}
		
		System.out.println(min_y+" "+ max_y);
		long ans = max_y-min_y;
		System.out.println(ans);
	}
}
