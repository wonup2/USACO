/*
 ID: syk
 LANG: JAVA
 TASK: beads
 */
import java.util.*;
import java.io.*;
public class beads {
	static Scanner in;
	static PrintWriter out;
	static String ncklce;
	static int len;
	static int cnt, ans;
	public static void main(String [] args) {
		try {
			in = new Scanner(new File("beads.in"));
			out = new PrintWriter(new File("beads.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	static void init() {	
		len = in.nextInt();
		ncklce = in.next();
		cnt = 0;
		ans =0;
	}
	static int solve() {
		ncklce = ncklce + ncklce;
		for(int i = 0; i < len; i++) {
cnt = 0;
			int index = i;
			int end = i+len;
			int color = ncklce.charAt(index) == 'w' ? 0:1;
			char key = ncklce.charAt(index);
//debugging
			





for(int j = i; j < end; j++) {
				char c = ncklce.charAt(j);
				if(c!= key && c != 'w') {
					color ++;
					key = c;
				}
				if(color>2) break;
				cnt++;				
			}
		ans = Math.max(ans, cnt);
		}
		return ans;
	}
}


