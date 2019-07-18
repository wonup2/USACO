package Section_1_3;
/*
ID: wonup21
LANG: JAVA
TASK: milk2
*/

//brute-force time over

import java.io.*;
import java.util.*;
public class milk2_1 {
	
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static Set<Integer> set;
	
	public static void main(String[] args) {
		try {
			in=new BufferedReader(new FileReader("milk2.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
			init();
			out.println(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	static void init() {
		try {
			set = new HashSet<Integer>();
			int n = Integer.parseInt(in.readLine());
			StringTokenizer st;
			for(int i=0; i<n; i++) {
				st=new StringTokenizer(in.readLine());
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				for(int j=s; j<e; j++) set.add(j);
			}			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	static String solve() {
		int milk=0, gap=0;
		int max_milk=0, max_gap=0;
		
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(set);
		Collections.sort(a);
		
		int cur=a.get(0);
		for(int num:a) {
			if(num-cur<=1) {
				gap=0;
				milk++;
			}
			else {
				milk=0;
				gap=num-cur-1;
			}
			max_milk=Math.max(milk, max_milk);
			max_gap=Math.max(max_gap, gap);
			cur=num;
		}
		return max_milk+" "+max_gap;
	}
}
