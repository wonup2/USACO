import java.io.*;
import java.util.*;

public class US_SIL_sort1 {
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static pair a[];
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new FileReader("sort.in"));
		out = new PrintWriter(new FileWriter("sort.out"));
		init();
		solve();
		out.close();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		n = Integer.parseInt(in.readLine());
		a = new pair[n];
		
		for (int i=0; i<n; i++) 
			a[i] = new pair(Integer.parseInt(in.readLine()), i);
		
		Arrays.sort(a);
		//System.out.println(Arrays.toString(a));
	}
	
	static void solve() {
		int moo = 0;
		for (int i=0; i<a.length; i++)
			moo = Math.max(moo, a[i].i-i);

		out.println(moo+1);
	}
	
	static class pair implements Comparable<pair> {

		public int v;
		public int i;

		public pair(int v1, int i1) {
			v = v1;
			i = i1;
		}

		@Override
		public int compareTo(pair other) {
			if (this.v != other.v) return this.v - other.v;
			return this.i - other.i;
		}
		
		public String toString() {
			return v+" "+i;
		}
	}
}
