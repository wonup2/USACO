import java.util.*;
import java.io.*;

public class circlecross {

	static BufferedReader in;
	static PrintWriter out;
	static String s;
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("circlecross.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		s = in.readLine();
	}
	static void solve() {
		int ans = 0;
		
		for(int i='A'; i<='Z'; i++) {
			char c1 = (char)i;
			int s1 = s.indexOf(c1);
			int e1 = s.lastIndexOf(c1);
			
			for(int j=s1+1; j<e1; j++) {
				char c2 = s.charAt(j);
				int s2 = s.indexOf(c2);
				int e2 = s.lastIndexOf(c2);
				if(s2 < s1 || e2 > e1) ans++;
			}			
		}		
		out.println(ans/2);
	}
}
