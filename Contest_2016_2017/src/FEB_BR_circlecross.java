import java.io.*;
import java.util.*;

public class FEB_BR_circlecross {
	
	static BufferedReader in;
	static PrintWriter out;
	static String a;
	static int ans;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("circlecross.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));	
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		
		a = in.readLine();
	}
	
	static void solve() {
		
		for(int i='A' ; i<='Z'; i++){
			
			int first = a.indexOf(i);
			int last = a.lastIndexOf(i);
			
			String sub = a.substring(first+1, last);	
			
			for(int j = 0; j<sub.length(); j++) {				
				char c = sub.charAt(j);
				if(sub.indexOf(c)==sub.lastIndexOf(c)) ans++;
			}
		}
				
		out.println(ans/2);
	}
}