package Section_1_3;
/*
ID: wonup21
LANG: JAVA
TASK: dualpal
*/
import java.io.*;
import java.util.*;

public class dualpal {
	static Scanner in;
	static PrintWriter out;
	static int n,s;

	public static void main(String[] args) {
		try {
			in=new Scanner(new FileReader("dualpal.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));
			init();
			out.print(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	static void init() {
		n=in.nextInt();
		s=in.nextInt();
	}
	
	static String solve() {	
		int i=s+1;
		int len=0;

		StringBuilder sb = new StringBuilder();
		while(true) {
			int b=2;
			int count=0;
			while(b<=10) {
				String s = Integer.toString(i, b);
				if(s.equals(new StringBuilder(s).reverse().toString()))
					count++;				
				if(count==2) {
					sb.append(i+"\n"); 
					len++; 
					break;
				}
				b++;
			}

			if(len==n) break;
			i++;
		}	
		return sb.toString();
	}
}
