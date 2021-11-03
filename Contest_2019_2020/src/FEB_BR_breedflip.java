import java.io.*;
import java.util.*;
public class FEB_BR_breedflip {
	
	static String a, b, c;
	static int n;
	static BufferedReader in;
	static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("breedflip.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("breedflip.out")));
		init();
		solve();
		in.close();
		out.close();
	}
  
	static void init() throws IOException {
		n = Integer.parseInt(in.readLine());
		a = in.readLine();
		b = in.readLine();	  
	}
  
	static void solve() {
		c = "";
		
		for(int i=0; i<n; i++) {
			if(a.charAt(i)!=b.charAt(i)) c+="1";
			else c+="0";
		}
		
		int ans = 0;
		for(int i=0; i<n; i++) {
			boolean flag = false;
			while(c.charAt(i)=='1') {
				i++;
				flag=true;
			}
			if(flag) {
				ans++; i--;
			}
		}
		out.println(ans);
	}
}


