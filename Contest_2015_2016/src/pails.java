import java.util.*;
import java.io.*;

public class pails {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static int ans;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("pails.in"));
		out = new PrintWriter(new File("pails.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		//Initialize variables and read data -- Copy and paste data on console window
		
		N = in.nextInt();  //in.nextLine() is needed sometimes
		ans = 0;
		
	}
	static void solve() {
		//processing
		
		
		//output
		out.println(ans);
	}	
}
