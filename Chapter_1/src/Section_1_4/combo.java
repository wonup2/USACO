/*
ID: wonup21
LANG: JAVA
TASK: combo
*/

package Section_1_4;

import java.io.*;
import java.util.*;

public class combo {
	
	static Scanner in;
	static PrintWriter out;
	static int n, f1, f2, f3, m1, m2, m3;;
	
	public static void main(String[] args) throws Exception {
		try {
			in=new Scanner(new File("combo.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
			init();
			out.println(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	static void init() throws IOException {
		n=in.nextInt();
		f1=in.nextInt();
		f2=in.nextInt();
		f3=in.nextInt();
		m1=in.nextInt();
		m2=in.nextInt();
		m3=in.nextInt();
	}
	
	static int solve() {
		int total = 0;
		for (int n1=1; n1<=n; n1++)
		for (int n2=1; n2<=n; n2++)
		for (int n3=1; n3<=n; n3++)
		  	if (close_enough(n1,n2,n3,f1,f2,f3) ||
				close_enough(n1,n2,n3,m1,m2,m3))
		    	total++;
		return total;
	}
	static boolean close_enough(int n1, int n2, int n3, int c1, int c2, int c3)	{
		  return close(n1,c1) && close(n2,c2) && close(n3,c3);
	}
	
	static boolean close(int a, int b){
	  if (Math.abs(a-b) <= 2) return true;
	  if (Math.abs(a-b) >= n-2) return true;
	  return false;
	}	
}
