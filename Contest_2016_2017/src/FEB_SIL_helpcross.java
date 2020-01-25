import java.util.*;
import java.io.*;

public class FEB_SIL_helpcross {

	public static void main(String[] args) throws Exception {

		// Read input.
		BufferedReader in = new BufferedReader(new FileReader("helpcross.in"));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		feb[] all = new feb[m+n];

		// chickens
		for (int i=0; i<n; i++) {
			int t = Integer.parseInt(in.readLine());   
			all[i] = new feb(t, t, false);
		}

		// cows
		for (int i=n; i<n+m; i++) {
			st = new StringTokenizer(in.readLine());
			all[i] = new feb(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),true);		
		}
			

		Arrays.sort(all);  //System.out.println(Arrays.toString(all));
		
		int res = 0;
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (int i=0; i<all.length; i++) {
			
			// cows waiting room
			if (all[i].isCow) pq.offer(all[i].end); 

			// the chicken! cross time
			else {
				while (!pq.isEmpty() && pq.peek() < all[i].start) pq.poll(); 

				// This chicken can help a cow!
				if (!pq.isEmpty()) {
					res++;
					pq.poll();
				}
			}
		}

		// Output the result.
		PrintWriter out = new PrintWriter(new FileWriter("helpcross.out"));
		out.println(res);
		out.close();
		in.close();
	}
}

class feb implements Comparable<feb> {
	public int start;
	public int end;
	public boolean isCow;

	public feb(int s, int e, boolean b) {
		start = s;
		end = e;
		isCow = b;
	}

	public int compareTo(feb that) {
		if (this.start == that.start) {
			if (this.isCow && !that.isCow) return -1;
			if (!this.isCow && that.isCow) return 1;
		}
		return this.start - that.start;
	}
	
	public String toString() {
		return start+" "+end+" "+isCow;
	}
}