import java.util.*;
import java.io.*;

public class stuff3 {
	static Scanner in;
	static PrintWriter out;
	static int n,m;
	static int end;
	public static void main(String[] args) {
		try {
			init();
			solve();
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void init() {
		try {
			in = new Scanner(new File("race.in"));
			out = new PrintWriter(new File("race.out"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		n = in.nextInt();
		m = in.nextInt();
	}
	public static void solve() {
		for(int j=0; j<m; j++) {
		
		end = in.nextInt();

		int count = 0;
		int sum = 0;
		int add = end;
		for(int i = 1; i <= end; i++) {
			sum += i;
			count++;
			if(sum >= n) {
				break;
			}
		}
		if(sum >= n) {
			out.println(count);
		}else {
			sum += end;
			count++;
			if(sum >= n) {
				out.println(count);
			}
			while(sum < n) {	
				//   여기서 무조건 add++  하면 안되지. 
				// if end is 4
				// 1, 2, 3 <--- until 3 use one number
				// 4 부터는 두번씩 해야지
				// 1 2 3 4 4 5 5 
				sum += add;
				count++;
				add++;
			}
			out.println(count);
		}
		}
	}
}
