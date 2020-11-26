import java.util.*;
import java.io.*;

public class convention2 {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N;
	static LinkedList<group> a;
	static PriorityQueue <group> pq;

	public static void main(String[] args) {

		try {
			init();
	        solve();
	        out.close();
	        in.close();
	    }
	    catch(Exception e) {
	        System.out.println("Error");
	        e.printStackTrace();
	    }

	}
	
	public static void init () throws NumberFormatException, IOException {
		
		in = new BufferedReader(new FileReader ("convention2.in"));
		out = new PrintWriter (new File ("convention2.out"));
		N = Integer.parseInt(in.readLine());
		a = new LinkedList <group>();
		pq = new PriorityQueue<group>();
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			a.add(new group(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		Collections.sort(a, new Comparator <group>() {

			@Override
			public int compare(group arg0, group arg1) {
				return arg0.a - arg1.a;
			}
			
		});	
	}
	
	static void solve () {
		
		int wait = 0;
		int maxWait = 0;
		int curTime = 0;
		
		while (!a.isEmpty()) {
			while (a.size() != 0 && a.get(0).a <= curTime) {
				//System.out.println(a.get(0));
				pq.add(a.remove(0)); 
			}
			//System.out.println("pq1: " +" "+pq);
			if (pq.isEmpty()) {
				wait = 0;
				curTime = a.get(0).a + a.get(0).t;
				a.remove(0);
			}
			else {
				group cow = pq.poll();
				wait = curTime - cow.a;
				curTime += cow.t;
			}
			maxWait = Math.max(wait, maxWait);
			//System.out.println("pq2: "+" "+pq);
			//System.out.println("a: " +" "+a);
			//System.out.println(curTime + " " + wait + " " + maxWait); 

		}
		
		System.out.println(maxWait);
		out.close();
		
	}

	static class group implements Comparable <group>{
		
		int s, a, t;
		group (int s, int a, int t){
			this.s = s;
			this.a = a;
			this.t = t;
		}
		public int compareTo (group that) {
			return this.s-that.s;
		}
		public String toString() {
			return s + " " + a + " " + t;
		}
	}

}
