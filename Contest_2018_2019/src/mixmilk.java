import java.util.*;
import java.io.*;

public class mixmilk {

	static Scanner in;
	static PrintWriter out;
	static int c1, c2, c3, m1, m2, m3;
	
	public static void main(String[] args) {

		try {
			init();
			solve();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	private static void init() throws IOException {
		
		in = new Scanner(new File("mixmilk.in"));
		
		c1 = in.nextInt(); m1 = in.nextInt();
		c2 = in.nextInt(); m2 = in.nextInt();
		c3 = in.nextInt(); m3 = in.nextInt();	
		
		in.close();		
	}
	
	private static void solve() throws IOException {
		
		for(int i =0; i<1; i++) {
			//c1->c2
			int space = c2-m2;
			if(m1 <= space) {
				m2=m2+m1;
				m1=0;				
			}
			else {
				m1=m1-space;
				m2=c2;
			}
			
			//c2->c3
			space = c3-m3;
			if(m2 <= space) {
				m3=m3+m2;
				m2=0;				
			}
			else {
				m2=m2-space;
				m3=c3;
			}
						
			//c3->c1	
			space = c1-m1;
			if(m3 <= space) {
				m1=m1+m3;
				m3=0;				
			}
			else {
				m3=m3-space;
				m1=c1;
			}
		}
		
		//c1->c2
		int space = c2-m2;
		if(m1 <= space) {
			m2=m2+m1;
			m1=0;				
		}
		else {
			m1=m1-space;
			m2=c2;
		}
		
		out = new PrintWriter(new File("mixmilk.out"));
		out.printf("%d\n%d\n%d\n", m1, m2, m3);
		out.close();
	}
}
