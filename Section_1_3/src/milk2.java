

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
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("milk2.in"));
			out = new PrintWriter(new File("milk2.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	public static void init() {
		n = in.nextInt();
		a = new pair[n];
		for(int i=0; i<n; i++) {
			a[i] = new pair(in.nextInt(), in.nextInt());
		}
	}
	public static String solve() {		
		Arrays.sort(a);
		int milking=0;
		int gap=0;
		int s=a[0].start, e=a[0].end;

		for(int i=1; i<n; i++) {
			int curStart = a[i].start;
			int curEnd = a[i].end;
			if(curStart > e) {
				gap = Math.max(gap, curStart - e);
				s = curStart;
				e = curEnd;
			}
			else if(curEnd > e){
				e = curEnd;
			}
			milking = Math.max(milking, e-s);
		}
		return milking+" "+gap;
	}
}

class pair implements Comparable<pair>{
	int start;
	int end;
	pair(int s, int e){
		start=s;
		end=e;
	}
	@Override
	public int compareTo(pair that) {
		if(this.start==that.end) return this.end-that.end;
		return this.start - that.end;
	}
}