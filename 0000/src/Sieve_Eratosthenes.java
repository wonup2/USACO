import java.util.*;
public class Sieve_Eratosthenes {

	static ArrayList<Integer> prime;
	public static void main(String[] args) {
		prime = new ArrayList<Integer>();
		
		int N = 41;
		makePrime(N);
		System.out.println(prime);
	}

	static void makePrime(int n) {
		boolean a[] = new boolean[n+1];
		int end = (int)Math.sqrt(n); 
		for(int i=2; i<=end; i++) {
			if(!a[i]) {				
				for(int j=i+i; j<=n; j+=i) a[j]=true;
			}
		}
		
		for(int i=2; i<=n; i++) if(!a[i]) prime.add(i);
	}
}
