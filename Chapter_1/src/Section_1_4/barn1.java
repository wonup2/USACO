/*
ID: wonup21
LANG: JAVA
TASK: barn1
*/

package Section_1_4;

import java.io.*;
import java.util.*;

public class barn1 {
	
	static Scanner in;
	static PrintWriter out;
	static int a[], m, s, c;
	static ArrayList<Integer> gap;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
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
		m=in.nextInt();
		s=in.nextInt();
		c=in.nextInt();
		a = new int[c];
		gap = new ArrayList<Integer>();
		
		a[0] = in.nextInt();
		for(int i=1; i<c; i++) a[i]=in.nextInt();		
	}
	
	static int solve() {
		Arrays.sort(a);
		for(int i=1; i<c; i++) gap.add(a[i]-a[i-1]-1);		
	
		Collections.sort(gap, Collections.reverseOrder());
		
		int result=a[c-1]-a[0]+1;
		
		if(c<=m) return c;
		for(int i=0; i<m-1; i++) result -= gap.get(i);
		
		return result;
	}
}
