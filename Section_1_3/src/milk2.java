/*
ID: wonup21
LANG: JAVA
TASK: milk2
*/

import java.util.*;
import java.io.*;
public class milk2 {

	static Scanner in;
	static PrintWriter out;
	static int n;
	static pair[] a;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("milk2.in"));
		out = new PrintWriter(new File("milk2.out"));
		init();
		solve();
		in.close();
		out.close();			
	}

	public static void init() {
		a = new pair[in.nextInt()];
		for(int i=0; i<a.length; i++) 
			a[i] = new pair(in.nextInt(), in.nextInt());
				
		Arrays.sort(a);			
	}
	public static void solve() {		
		int start = a[0].start;
		int end = a[0].end;
		int milking = end - start;
		int gap = 0;
		for(int i=1; i<a.length; i++) {
			if(a[i].start <= end) {
				if(end < a[i].end) end = a[i].end;
			}
			else {
				milking = Math.max(milking, end - start);
				gap = Math.max(gap, a[i].start - end);
				start = a[i].start;
				end = a[i].end;
			}			
		}
		milking = Math.max(milking, end - start);
		out.println(milking+" "+gap);
	}
	
	
	static class pair implements Comparable<pair>{
		int start;
		int end;
		pair(int s, int e){
			start=s;
			end=e;
		}
		@Override
		public int compareTo(pair that) {
			
			if(this.start < that.start) return -1;
			else if (this.start > that.start) return 1;
			else {
				if(this.end < that.end) return -1;
				else return 1;
			}			
		}
		
		public String toString() {
			return start +" "+end;
		}
	}
}

