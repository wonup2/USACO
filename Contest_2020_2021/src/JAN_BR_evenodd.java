import java.util.*;
import java.io.*;

public class JAN_BR_evenodd {

	static Scanner in;
	static int n, e, o, ans;

	
	public static void main(String[] args) throws IOException {

		in = new Scanner(System.in);
		init();
		solve();
		in.close();
	}

	static void init() throws IOException {
		
		n = in.nextInt();
		e = 0;
		o = 0;
		
		for(int i=0; i<n; i++) {
			if(in.nextInt()%2==0) e++;
			else o++;
		}		
	}
	
	static void solve() {
		ans = 0;
		if(e==o) ans = e + o;
		else if(e>o) ans = o*2 + 1;
		else {
			ans = e*2;
			int x = o-e;
			int y = x/3;
			
			if(x%3==1) ans += y*2-1;
			else if(x%3==2) ans += (y+1)*2-1;
			else ans += y*2;
		}
		if(ans<0) ans = 1;
		System.out.println(ans);
	}	
}
