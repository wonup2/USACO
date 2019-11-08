import java.util.*;
import java.io.*;
public class C1JR_Asterisk {

	static String s;
	static int n1,n2;
	static Scanner in;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("C1JR.in"));
		for(int i = 0; i < 9; i++) {
			try {
				init();
				solve();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		in.close();
	}
	static void init() {
		s = in.next();
		n1 = in.nextInt();
		if(s.equals("B")) n2 = in.nextInt();
	}
	
	static void solve() {
		if(s.equals("S")) square();
		else if(s.equals("H")) h();
		else if(s.equals("L")) l();
		else if(s.equals("B")) b();
	}
	static void square() {
		for(int i = 0; i<n1; i++) {
			for(int j = 0; j<n1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void b() {
		for(int i = 0; i<n2; i++) {
			for(int j = 0; j<n1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void l() {
		for(int i = 0; i<n1; i++) {
			for(int j = 0; j<=i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	static void h() {
		for(int i = 0; i<n1; i++) {
			for(int j = 0; j<i; j++) {
				System.out.print(" ");
			}
			for(int j = 0; j<n1-i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}