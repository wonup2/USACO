
import java.util.*;
import java.io.*;
public class dualpal {
	static Scanner in;
	static PrintWriter out;
	static int N, S;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("dualpal.in"));
		out = new PrintWriter(new File("dualpal.out"));
		
		init();
		solve();
		
		in.close();
		out.close();
		
		

	}
	static void init() {
		N= in.nextInt();
		S = in.nextInt()+1;
		
	}
	static void solve() {
		int countN = 0;
		int countbase = 0;
		StringBuilder ans = new StringBuilder();
		
		while(true) {
			for(int j=2; j<11; j++) {
				String a = Integer.toString(S, j);				
				String a1 = new StringBuilder(a).reverse().toString();
				
				if(a.equals(a1)) countbase++;
				
                if(countbase==2) {
					ans.append(S).append("\n");
					countN++;
					break;
				}
			}			
			if(countN==N) break;
			countbase=0;
			S++;
		}
		
		out.print(ans.toString());		
	}
}