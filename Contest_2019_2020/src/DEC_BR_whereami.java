import java.util.*;
import java.io.*;
public class DEC_BR_whereami {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static String s;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("whereami.in"));
		out = new PrintWriter(new File("whereami.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n = in.nextInt(); 
		s = in.next();		
	}
	
	static void solve() {
		
		int ans = 0;
		boolean ok = true;

		for(int i=1; i<=n; i++) {	
			for(int j=0; j<=n-i; j++) {
				
				String temp = s.substring(j, j+i);
				if(s.indexOf(temp) != s.lastIndexOf(temp)) { 
					ok=false; 
					break; 
				}
			}
			
			if(ok) { 
				ans = i; 
				break;
			}
			ok=true;
		}		
		
		out.println(ans);
	}
}
