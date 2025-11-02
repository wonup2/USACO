import java.util.*;
import java.io.*;

public class FEB_SIL_TestTarget2_2 {

	static class pair {
		long x, y;
		pair(long x, long y){
			this.x = x;
			this.y = y;
		}
		public String toString() {
			return "(" + x+", "+y +")";
		}
	}
	
	static BufferedReader in;
	static StringTokenizer st;
	static int t, n, x;
	static long x1[];
	static ArrayList<pair> needs_neg, needs_pos;
	static ArrayList<Long>ns, ps;
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
		x = Integer.parseInt(st.nextToken());
		x1 = new long[2*n];
		needs_neg = new ArrayList<pair>();
		needs_pos = new ArrayList<pair>();
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			long y1 = Long.parseLong(st.nextToken());
			long y2 = Long.parseLong(st.nextToken());
			long x2 = Long.parseLong(st.nextToken());
			x1[i*2] = y1;
			x1[i*2+1] = y2;
			needs_neg.add(new pair(x2, y2));
			needs_pos.add(new pair(x2, y1));
		}
	
		ns = new ArrayList<Long>();
		ps = new ArrayList<Long>();
		st = new StringTokenizer(in.readLine());
		while(st.hasMoreTokens()) {
			long temp = Long.parseLong(st.nextToken());
			if(temp>0) ps.add(temp);
			else ns.add(temp);
		}
		
		Arrays.sort(x1);
		for(long y:x1) {
			if(needs_neg.size() < ns.size()) needs_neg.add(new pair(x, y));
			else needs_pos.add(new pair(x, y));
		}

	}
	
	static void solve() {
		if(ps.size()<n || ns.size()<n) {
			System.out.println(-1);
			return;
		}
				
		//System.out.println(min_y()+" "+ max_y());
		long ans = max_y()-min_y();
		System.out.println(ans);
	}
	
	static long max_y() {
		Collections.sort(ns); //System.out.println(ns);
		long maxY = Long.MIN_VALUE;
		int minIdx = 0;
		for(long s:ns) {
			long min = Long.MAX_VALUE;
			int idx = 0;
			for(pair p:needs_neg) {
				long y_inter = p.y-p.x*s;
				if(min>y_inter) {
					minIdx = idx;
					min = y_inter;
				}
				idx++;				
			}
			maxY = Math.max(maxY, min); //System.out.println(maxY); 
			//if(maxY>400000000000000000l) break;
			if(needs_neg.size()>0)  needs_neg.remove(minIdx);
		}
		
		return maxY;
	}
	
	static long min_y() {
		Collections.sort(ps, Collections.reverseOrder());
		long minY = Long.MAX_VALUE;
		int maxIdx = 0;
		for(long s:ps) {
			long max = Long.MIN_VALUE;
			int idx = 0;
			for(pair p:needs_pos) {
				long y_inter = p.y-p.x*s;
				if(max<y_inter) {
					maxIdx = idx;
					max = y_inter;
				}
				idx++;				
			}
			minY = Math.min(minY, max);
			if(needs_pos.size()>0)   needs_pos.remove(maxIdx); 
		}
		
		return minY;
	}
}
