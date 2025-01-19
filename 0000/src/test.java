/*
ID: wonup21
LANG: JAVA
TASK: test
*/
import java.io.*;
import java.util.*;

public class test {
	
	static BufferedReader in;
	static PrintWriter out;
	static String file = "test";
	static StringTokenizer st;
	
	static int n, a[];
	
	public static void main (String [] args) throws IOException {
		
		in = new BufferedReader(new FileReader(file+".in"));
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