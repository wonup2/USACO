import java.util.*;
public class DEC_BR_daisy {
	static Scanner in;
	static int n, a[], ans;

	public static void main(String[] args) {
		in = new Scanner(System.in);
		init();
		solve();
		in.close();		
	}
	
	static void init() {
		n = in.nextInt();
		ans = 0;
		a = new int[n];
		for(int i=0; i<n; i++) a[i] = in.nextInt();		
	}
	
	/*
	 static void solve() {
		ArrayList<Double> b = new ArrayList<Double>();
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				double sum = 0;
				for(int k=i; k<=j; k++) {
					sum+=a[k];
					b.add(a[k]*1.0);
				}
				double ave = sum/b.size();
				if(b.contains(ave)) ans++;
				b.clear();
			}
		}		
		System.out.println(ans);
	}
	 */
	
	
	
	
	
	static void solve() {
	
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int sum = 0;
				for(int k=i; k<=j; k++) {
					sum+=a[k];
				}
				boolean check = false;
				for(int k=i; k<=j; k++) {
					if(a[k]*(j-i+1)==sum) check = true;
				}
				
				if(check) ans++;
			}
		}		
		System.out.println(ans);
	}
}
