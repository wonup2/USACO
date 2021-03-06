import java.util.*;
import java.io.*;

public class JAN_SIL_loan {
	static BufferedReader in;
	static PrintWriter out;
	static long N,M,K;
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("loan.in"));
		PrintWriter out = new PrintWriter(new File("loan.out"));
	    N = in.nextLong();
	    K = in.nextLong();
	    M = in.nextLong();
		long low = 1, high = N, ans = 0;
		while (low <= high) {
		    long mid = (low + high)/2;
		    if (check(mid)) {
		    	ans = mid;
		    	low = mid + 1; 
		    }
		    else high = mid-1;
		}		
		out.println(ans);
		out.close();
	}
	
	static boolean check(long x) {
		long days = K;
		long left = N;
		while (left > 0 && days >0) {
			long y = left/x;
		    if (y <= M) return M * days >= left; // y 는 계속 작아질테니까... 남은날 * M 이 left 보다 크면 ok

		    //long endPoint = y*x;
		    long passDays = (left % x)/y + 1;  // left = 28, x = 11, y = 2 --->  reduce 2 during 4 days 
		    days -= passDays;
		    left -= y*passDays;
		}
		return left <= 0;
	}
}
