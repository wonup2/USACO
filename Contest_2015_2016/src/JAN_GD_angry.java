import java.io.*;
import java.util.*;
public class JAN_GD_angry {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("angry.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("angry.out")));

		int n = Integer.parseInt(br.readLine());
		TreeSet<Long> set = new TreeSet<Long>();
		for(int i = 0; i < n; i++) {
			set.add(2L*Integer.parseInt(br.readLine()));
		}

		long min = 0;
		long max = 1000000000;
		while(min != max) {
			long mid = (min+max)/2;
			long l = set.first();
			long r = set.last();
			while(l < r) {
				long m = (l+r+1)/2;
				if(possibleFirst(set, m, mid)) {
					l = m;
				}
				else {
					r = m-1;
				}
			}
			if(possibleLast(set, l, mid)) {
				max = mid;
			}
			else {
				min = mid+1;
			}
		}
		
		pw.printf("%.1f\n", min / 2.0);
		pw.close();
	}

	public static boolean possibleFirst(TreeSet<Long> set, long start, long r) {
		if(set.first() < start - r) {
			long curr = set.ceiling(start - r);
			long currRadius = r-2;
			while(curr != set.first()) {
				long next = set.ceiling(curr - currRadius);
				if(next >= curr) {
					return false;
				}
				curr = next;
				currRadius-=2;
			}
		}
		return true;
	}
	
	public static boolean possibleLast(TreeSet<Long> set, long start, long r) {
		if(set.last() > start + r) {
			long curr = set.floor(start + r);
			long currRadius = r-2;
			while(curr != set.last()) {
				long next = set.floor(curr + currRadius);
				if(next <= curr) {
					return false;
				}
				curr = next;
				currRadius-=2;
			}
		}
		return true;
	}

}