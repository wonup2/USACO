import java.util.*;

public class DEC_BR_CowCollege {

	
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		long a[] = new long[n];
		for(int i=0; i<n; i++) a[i] = in.nextLong();
		
		Arrays.sort(a);
		
		long money=0l;
		long cow=0;
		
		for(int i=0; i<n; i++) {
			long m = a[i] * (n-i);
			
			if(m > money) {
				money = m;
				cow = a[i];
			}
		}
		
		System.out.println(money+" "+cow);
	}

}
