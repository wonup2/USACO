import java.util.*;
import java.io.*;

public class lifeGuard {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n;
	static triple a[];
	
	static class triple implements Comparable<triple>{
		
		int time, id, status;
		triple(int t, int i, int s){
			time = t; id = i; status = s;
		}
		
		public String toString() {
			return time +" "+id+" "+status;
		}

		@Override
		public int compareTo(lifeGuard.triple o) {
			
			return this.time-o.time;
		}
	}
	
	
	
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("test.in"));
		out = new PrintWriter(new File("test.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() throws NumberFormatException, IOException {
		
		n = Integer.parseInt(in.readLine());
		
		a = new triple[n*2];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			
			int come = Integer.parseInt(st.nextToken());
			int go = Integer.parseInt(st.nextToken());

			a[i*2] = new triple(come, i, 1);
			a[i*2+1] = new triple(go, i, 0);
		}
		
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		
		
		HashSet<Integer> pool = new HashSet<Integer>();
		int cur = a[0].time;
		int pre = a[0].time;
		int total = 0;
		int [] alone = new int[n];
		int id, status;
		
		for(int i=0; i<n*2; i++) {
			
			cur = a[i].time;
			id = a[i].id;
			status = a[i].status;
			
			if(pool.size()!=0) total += cur-pre;
			
			if(pool.size()==1) alone[pool.hashCode()] += cur-pre;
			
			if(status==1) pool.add(id);
			else pool.remove(id);	
			
			pre = cur;
		}
		
		Arrays.sort(alone);
		System.out.println(Arrays.toString(alone));
		System.out.println(total);
		out.println(total - alone[0]);	
		
	}
}

