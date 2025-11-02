import java.util.*;
import java.io.*;

public class JAN_BR_angry {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;	
	static String f = "angry";
	static int n, a[];

	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(f+".in"));
		out = new PrintWriter(new FileWriter(f+".out"));
		init();
		solve();
		
		in.close();
		out.close();
	}
	
	static void init() throws IOException {
		n = in.nextInt();

		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();
		
		Arrays.sort(a);
	}
	
	static void solve() {
		
		int cnt = 0; 
		
		for(int i=0; i<n; i++) {
			
			int left =check(i, -1);  //System.out.println(left);
			int right = check(i, 1); //System.out.println(right);
			
			cnt = Math.max(cnt, left + right +1);
		}
		out.println(cnt);
	}
	
	//3 4 5 6 8 13
	static int check(int cur, int d) {
		
		int r = 1;
		int cnt =0;
		while(cur >=0 && cur <n) {
			
			int next = cur;
			
			while(true) {
				if(next+d <0|| next+d >=n || Math.abs(a[next+d]-a[cur]) > r) break;
				cnt++;
				next+=d;
			}
			
			if(cur==next) break;
			cur = next;
			r++;
		}
		
		return cnt;
	}	
}