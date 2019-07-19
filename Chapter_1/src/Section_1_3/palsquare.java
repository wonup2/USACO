package Section_1_3;
/*
ID: wonup21
LANG: JAVA
TASK: palsquare
*/
import java.io.*;
import java.util.*;

public class palsquare {
	static Scanner in;
	static PrintWriter out;
	static int b;

	public static void main(String[] args) {
		try {
			in=new Scanner(new FileReader("palsquare.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
			init();
			out.print(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	static void init() {
		b=in.nextInt();
	}
	
	static String solve() {	
		int i=1;
		StringBuilder sb = new StringBuilder();
		while(i<=300) {
			int squre = i*i;
			String a = Integer.toString(i, b).toUpperCase();
			String s = Integer.toString(squre, b).toUpperCase();
			if(s.equals(new StringBuilder(s).reverse().toString()))
				sb.append(a).append(" ").append(s).append("\n");
			i++;
		}
	
		return sb.toString();
	}
}
