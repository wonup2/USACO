import java.util.*;
import java.io.*;

public class JAN_SIL_loan {
	static BufferedReader in;
	static PrintWriter out;
	static long N,M,K;
	
	static long cdiv(long a, long b) {
		return (a+b-1)/b;
	}
	
	static long ok(long mid) {
		long res = 0;
		long lef = N;
		while (lef!=0) {
			long dif = lef/mid;
		    if (dif <= M) return res+cdiv(lef,M);
		    long need = lef/dif-mid+1;
		    res += need; lef -= dif*need;
		  }
		  return res;
		}
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("loan.in"));
		PrintWriter out = new PrintWriter(new File("loan.out"));
	    N = in.nextLong();
	    K = in.nextLong();
	    M = in.nextLong();
		long low = 1, high = N;
		while (low < high) {
		    long mid = (low + high + 1)/2;
		    if (ok(mid) <= K) low = mid;
		    else high = mid-1;
		}
		System.out.println(low);
	}
}
