import java.util.*;
import java.io.*;

public class AngryCow_B {
	
	static Scanner in;
	static PrintWriter out;
	static int n;
	static boolean a[];
	static HashSet<Integer> e;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		in = new Scanner(new File("angry.in"));
		out = new PrintWriter(new File("angry.out"));

		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		n = in.nextInt();
		a = new boolean[100];
		for(int i=0; i<n; i++)a[in.nextInt()] = true;
		e = new HashSet<Integer>();

	}
	
	static void solve() {
		int ans = 0;


		for(int i=0; i<100; i++) {
			
			if(a[i]) {
				left(i); 
				right(i);
				ans = Math.max(ans, e.size());
				e = new HashSet<Integer>();

			}

		}
		out.println(ans);
	}
	
	static void left(int p) {
		int x = 1;
		while(true) {
			int target = p-x; //System.out.println("target :" + target);

			for(int i=target; i>=target; i--) if(i>=0&&a[i]) e.add(i+1);
			if(target<0||target>100||!a[target]) break;
			
			p = target;
			x++;
		}			
	}
	
	static void right(int p) {
		int x = 1;
		while(true) {
			int target = p+x; //System.out.println("target :" + target);

			for(int i=p; i<=target; i++) if(target<=target&&a[i]) e.add(i+1);
			if(target<0||target>100||!a[target]) break;
			
			p = target;
			x++;
		}			
	}
}
