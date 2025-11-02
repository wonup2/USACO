import java.util.*;
import java.io.*;

public class FEB_SIL_TestTarget2_3 {

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

		in = new BufferedReader(new InputStreamReader(System.in));
		//in = new BufferedReader(new FileReader("in.txt"));
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
				
		long max_y = max_y();
		long min_y = min_y();
		//System.out.println(min_y + " "+max_y);

		long ans = max_y-min_y;
		System.out.println(ans);
	}
	
	static boolean check(long y_inter, ArrayList<Long> slope1, ArrayList<pair> needs) {
		Collections.sort(slope1, Collections.reverseOrder());

		ArrayList<Long> slope2 = new ArrayList<Long>();
		for(pair p: needs) {
			long temp = (p.y-y_inter)/p.x;
			slope2.add(temp);
		}
		Collections.sort(slope2, Collections.reverseOrder());

		for(int i=0; i<slope1.size(); i++) {
			if(slope1.get(i)<0 && slope1.get(i)<slope2.get(i)) return false;
			if(slope1.get(i)>0 && slope1.get(i)>slope2.get(i)) return false;
		}
		return true;
	}
		
	static long min_y() {
		long ans = 0l;
		long low = 1000000000l-1000000000000000000l;
		long high = 1000000000l;
		
		while(low<=high) {
			long mid = (low+high)/2; //System.out.println(mid);
			if(check(mid, ps, needs_pos)) {
				ans = mid;
				low = mid+1;
			}
			else high = mid-1;
		}
		
		return ans;
	}
	
	static long max_y() {
		long ans = 0l;
		long high = 1000000000000000000l;
		long low = 0l;
		
		while(low<=high) {
			long mid = (low+high)/2;
			if(check(mid, ns, needs_neg)) {
				ans = mid;
				high = mid-1;
			}
			else low = mid+1;
		}
		
		return ans;
	}
}
