/*
ID: wonup21
LANG: JAVA
TASK: milk
*/

import java.io.*;
import java.util.*;

public class milk {
	
	static BufferedReader in;
	static PrintWriter out;
	static int N, M, P, A;
	static pair[] a;
	
	public static void main(String[] args) throws Exception {
		in=new BufferedReader(new FileReader("milk.in"));
		out=new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		init();
		solve();
		in.close();
		out.close();	
	}
	
	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		a = new pair[M];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine());
			P = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			a[i] = new pair(P, A);
		}
		System.out.println(Arrays.toString(a));
	}
	static void solve() {		
	}
	
	static class pair implements Comparable<pair>{
		int price;
		int amount;
		
		pair(int p, int a){
			price = p;
			amount = a;
		}

		public String toString() {
			return price +" "+amount;
		}
		
		@Override
		public int compareTo(pair that) {
			return this.price - that.price;
		}		
	}
}
