import java.util.*;
import java.io.*;


public class oldTeamplate {

	static Scanner in;
	static PrintWriter out;
	static String file = "test";
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
	}
	
	static void solve() {
		
	}
}
