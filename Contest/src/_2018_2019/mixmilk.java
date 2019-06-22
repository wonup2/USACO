package _2018_2019;
import java.util.*;
import java.io.*;

public class mixmilk {
	static Scanner in;
	static PrintWriter out;
	static int c[]=new int[3], m[]=new int[3];
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("mixmilk.in"));
			out = new PrintWriter(new File("mixmilk.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	static void init() {
		
		for(int i=0; i<3; i++) {
			c[i] = in.nextInt();
			m[i] = in.nextInt();
		}
	}
	static String solve() {
		for(int i=0; i<33; i++) {
			pour(0,1);//System.out.println(Arrays.toString(m));
			pour(1,2);//System.out.println(Arrays.toString(m));
			pour(2,0);//System.out.println(Arrays.toString(m));
		}
		pour(0,1);
		return m[0]+"\n"+m[1]+"\n"+m[2];
	}
	static void pour(int _1, int _2) {
		int temp = Math.min(c[_2]-m[_2], m[_1]);
		m[_1]-=temp;
		m[_2]+=temp;
	}
}
