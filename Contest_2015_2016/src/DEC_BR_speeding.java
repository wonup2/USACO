import java.util.*;
import java.io.*;

public class DEC_BR_speeding {

	static Scanner in;
	static PrintWriter out;
	static int N, M;
	static ArrayList<Integer> a, b;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("speeding.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		N = in.nextInt();
		M = in.nextInt();		
		
		a = new ArrayList<Integer>();
		b = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			int ind = in.nextInt();
			int speed = in.nextInt();
			for(int j=0; j<ind; j++) a.add(speed);
		}
		
		for(int i=0; i<M; i++) {
			int ind = in.nextInt();
			int speed = in.nextInt();
			for(int j=0; j<ind; j++) b.add(speed);
		}
	
//		System.out.println(a);
//		System.out.println(b);
		
	}
	static void solve() {
		
		int max = 0;
		
		for(int i = 0; i<100; i++) 
			max = Math.max(max, b.get(i)-a.get(i));		
		
		out.println(max);
	}	
}
