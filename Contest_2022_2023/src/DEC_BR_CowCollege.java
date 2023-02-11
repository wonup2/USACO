import java.io.*;
import java.util.*;

public class DEC_BR_CowCollege {

	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		long a[] = new long[n];
		
		StringTokenizer st = new StringTokenizer(in.readLine()); //1 6 4 6
		for(int i=0; i<n; i++) a[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(a);
		
		long max_money=0l;
		long smallest_optimal_tuition=0;
		
		for(int i=0; i<n; i++) {
			long m = a[i] * (n-i);
			
			if(m > max_money) {
				max_money = m;
				smallest_optimal_tuition = a[i];
			}
		}
		
		System.out.println(max_money+" "+smallest_optimal_tuition);
	}
}
