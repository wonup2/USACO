import java.util.*;
import java.io.*;

public class USACOEqualSumSubarrays {
	
	static int n;
	static int[] a;
	static int[] p;
	static HashMap<pair, Integer> sums;
	static TreeSet<Integer> include, exclude;
	static BufferedReader in;
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		
		in = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(in.readLine());
		
		a = new int[n];
		sums = new HashMap<pair, Integer>();
		include = new TreeSet<Integer>();
		exclude = new TreeSet<Integer>();
		
		st = new StringTokenizer(in.readLine());
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		p = new int[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = p[i-1]+a[i-1];
		}
		
		for(int s=0; s<n; s++) {
			for(int e=s; e<n; e++) {
				sums.put(new pair(s, e), p[e+1]-p[s]);
				exclude.add(sums.get(new pair(s, e)));
			}
		}
		System.out.println(sums);
		//init include
		for(int e=0; e<n; e++) {
			include.add(sums.get(new pair(0, e)));
			exclude.remove(sums.get(new pair(0, e)));
		}
		System.out.println(include);
		System.out.println(exclude);
		
		for(int i=0; i<n; i++) {
			for(int s=0; s<i; s++) {
				include.remove(sums.get(new pair(s, i)));
			}
		}
		
	}
	
	
	static class pair {
		int s, e;
		int hashCode;
		
		public pair(int a, int b) {
			s = a;
			e = b;
			hashCode = Objects.hash(s, e);
		}
		
		public String toString() {
			return s+"-"+e;
		}
		
		@Override
		public boolean equals(Object o) {
			if(this==o) return true;
			if(o==null || getClass() != o.getClass()) return false;
			pair that = (pair) o;
			return this.s==that.s && this.e==that.e;
		}
		
		@Override
		public int hashCode() {
			return this.hashCode;
		}
	}
}
