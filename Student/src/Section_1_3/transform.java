/*
ID: ckandre1
LANG: JAVA
TASK: transform
 */
package Section_1_3;

import java.util.*;
import java.io.*;

public class transform {

	static int n, ans;
	static String[] org, cha, newa;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("transform.in"));
			out = new PrintWriter(new File("transform.out"));
			
			init();
			solve();
			
			in.close();
			out.close();
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	static void init() {
		ans = 7;
		n = in.nextInt(); in.nextLine();
		org = new String[n];
		cha = new String[n];
	    newa = new String[n];
	    String temp = "";
		for(int i = 0; i < n; i++) {
			temp = in.nextLine();
			org[i] = temp;
			cha[i] = temp;
		}
//		for(int i = 0; i < n; i++) {
//			newa[i] = in.nextLine();
//		}
	}
	static void solve() {
		String temp[] = ni(org).clone();
		System.out.println(Arrays.toString(temp));
	}
	static String[] ni(String[] cha) {
		String [] ans = new String[n];
		for(int i = 0; i <n; i++) {
			String s = "";
			for(int j = n-1; j >=0; j--) {
				s += cha[j].charAt(i)+"";
				System.out.println(s);
			}
			ans[i] = s;
		}
		return ans;
	}
	
	static String[] re(String[] cha) {
		String[] ans = new String[n];
		for(int i = 0; i < n; i++) {
			ans[i] = new StringBuilder(cha[i]).reverse().toString();
		}
		return ans;
		
	}
	static String ArrToStr(String[] cha) {
		String ans = "";
		for(int i = 0; i < n; i++) {
			ans += cha[i];
		}
		return ans;
	}
}
