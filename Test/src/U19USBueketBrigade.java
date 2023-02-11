import java.util.*;
import java.io.*;


public class U19USBueketBrigade {

	static Scanner in;
	static PrintWriter out;
	static String file = "buckets";
	
	static int br, bc, rr, rc, lr, lc, ans;
	
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		for(int i=0; i<10; i++) {
			String s = in.nextLine();
			
			if(s.contains("B")) {
				br = i;
				bc = s.indexOf("B");
			}
			if(s.contains("R")) {
				rr = i;
				rc = s.indexOf("R");
			}
			if(s.contains("L")) {
				lr = i;
				lc = s.indexOf("L");
			}
		}		
	}
	
	static void solve() {
		
		ans = Math.abs(br-lr) + Math.abs(bc-lc) - 1;
		
		if(  br==rr && rr==lr && (bc<rc && rc <lc || lc<rc && rc <bc)  ) ans +=2;
		
		else if( bc==rc && rc==lc && (br<rr && rr<lr || lr<rr && rr<br)  ) ans+=2;
		
		out.println(ans);
	}
}
