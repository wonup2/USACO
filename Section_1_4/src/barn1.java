/*
ID: wonup21
LANG: JAVA
TASK: barn1
*/



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
		System.out.println(Arrays.toString(a));

		Arrays.sort(a);
		for(int i=1; i<c; i++) gap.add(a[i]-a[i-1]-1);	
		
		System.out.println(gap);
		Collections.sort(gap, Collections.reverseOrder());
		System.out.println(gap);

		int result=a[c-1]-a[0]+1;
		System.out.println(result);
		if(c<=m) return c;
		for(int i=0; i<m-1; i++) result -= gap.get(i);
		System.out.println(result);

		return result;
	}
}
