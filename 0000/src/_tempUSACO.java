import java.util.*;
import java.io.*;

public class _tempUSACO {

	static Scanner in;
	static PrintWriter out;
	static int N;
	static int ans;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("xxx.in"));
		out = new PrintWriter(new File("xxx.out"));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		//Initializing variables and read data
		
		N = in.nextInt();  //in.nextLine() is needed sometimes
		ans = 0;
		
	}
	static void solve() {
		//processing
				
		//output
		out.println(ans);
	}	
}
