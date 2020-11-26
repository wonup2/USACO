
/*
ID: wonup21
LANG: JAVA
TASK: dualpal
*/

import java.io.*;
import java.util.*;

public class dualpal1 {
	static Scanner in;
	static PrintWriter out;
	static int n,s;

	public static void main(String[] args) throws IOException {
		in=new Scanner(new FileReader("dualpal.in"));
		out=new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		n=in.nextInt();
		s=in.nextInt();
	}
	
	static void solve() {	
		int i=s+1;
		int len=0;

		StringBuilder sb = new StringBuilder();
		while(true) {
			int b=2;
			int count=0;
			while(b<=10) {
				System.out.println();

				String s = Integer.toString(i, b);  System.out.print(i+" "+b +" "+s);
				if(s.equals(new StringBuilder(s).reverse().toString())) {
					count++;				System.out.print("<-----");}
				if(count==2) {
					sb.append(i+"\n"); 
					len++; 
					break;
				}
				b++;
			}

			if(len==n) break;
			i++;				System.out.println();

		}	
		out.print(sb.toString());
	}
}
