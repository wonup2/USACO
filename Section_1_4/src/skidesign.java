/*
ID: wonup21
LANG: JAVA
TASK: skidesign
*/

import java.io.*;
import java.util.*;

public class skidesign {
	
	static Scanner in;
	static PrintWriter out;
	static int n, a[];
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("skidesign.in"));
			out = new PrintWriter(new File("skidesign.out"));
			init();
			out.println(solve());	
			in.close();
			out.close();		
		} 
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static void init(){
		n=in.nextInt();
		a=new int[n];
		while(n-->0) a[n]=in.nextInt();
		Arrays.sort(a);
	}
	
	static int solve() {
		
		int min=Integer.MAX_VALUE;
		int max=a[a.length-1]-17;
		for(int i=a[0]; i<=max; i++) {
			int change=0;
			for(int j=0; j<a.length; j++) {
				int low = a[j] - i;
				int high = i + 17 - a[j];
				if(low<0) change+=low*low;
				if(high<0) change+=high*high;
			}
			//System.out.println(i+" "+change);
			
			min=Math.min(min, change);
		}
		
		return min;
	}
}
