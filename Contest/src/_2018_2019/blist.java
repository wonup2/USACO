package _2018_2019;

import java.util.*;
import java.io.*;

public class blist {
	static Scanner in;
	static PrintWriter out;
	static int n, s, e, b, a[];
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("blist.in"));
			out = new PrintWriter(new File("blist.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	static void init() {
		n=in.nextInt();	
		a=new int[1001];
	}
	static String solve() {
		int max=0;
		for(int i=0; i<n; i++) {
			s=in.nextInt();
			e=in.nextInt();
			b=in.nextInt();
			for(int j=s; j<e; j++) {
				a[j]+=b;
				max=Math.max(a[j], max);
			}
		}		
		return max+"";
	}	
}
