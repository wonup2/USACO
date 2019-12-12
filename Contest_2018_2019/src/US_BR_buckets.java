import java.io.*;

public class US_BR_buckets {

	static BufferedReader in;
	static PrintWriter out;
	static int bi, bj, ri, rj, li, lj;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("buckets.in"));
		out = new PrintWriter(new PrintWriter("buckets.out"));

		init();
		solve();	
		in.close();
		out.close();			
	}
	
	static void init() throws IOException{
		int n=10;
		while(n-->0) {
			String s = in.readLine();
			int m=10;
			while(m-->0) {
				if(s.charAt(m)=='B') {bi=n; bj=m;}
				else if(s.charAt(m)=='R') {ri=n; rj=m;}
				else if(s.charAt(m)=='L') {li=n; lj=m;}
			}
		}
	}
	static void solve() {
		
		int bl = Math.abs(bi-li) + Math.abs(bj-lj);
		int br = Math.abs(bi-ri) + Math.abs(bj-rj);
		int rl = Math.abs(ri-li) + Math.abs(rj-lj);
		
		if((bi==li || bj==lj) && (bl==br+rl)) out.println(bl+1);
		else out.println(bl-1);		
	}	
}
