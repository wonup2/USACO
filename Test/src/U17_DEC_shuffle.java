import java.util.*;
import java.io.*;


public class U17_DEC_shuffle{

	static Scanner in;
	//static BufferedReader in;
	//static StringTokenizer st;
	static PrintWriter out;
	static String file = "test";
	static int n, a[], b[], c[];
	
	public static void main(String[] args) throws IOException {

		//in = new BufferedReader(new FileReader(file + ".in"));
		
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		a = new int[n];
		for(int i=0; i<n; i++) {
			a[in.nextInt()-1] = i;
		}
		
		System.out.println(Arrays.toString(a));
		
		b = new int[n];
		for(int i=0; i<n; i++) b[i] = in.nextInt();
		
		c = new int[n];
		for(int i=0; i<n; i++) 
			c[a[a[a[i]]]] = b[i];
		
		System.out.println(Arrays.toString(c));
	}
	
	static void solve() {
		
	}
}
