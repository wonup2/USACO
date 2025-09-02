import java.util.*;
import java.io.*;

public class FEB_BR_sleepy {
	
	static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);
	    int t = in.nextInt(); 
	    while (t-->0) solve();
	}
	
	static void solve() {

		int n = in.nextInt();
		int[] a = new int[n];
		int sum = 0;
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
			sum+=a[i];
		}

		for(int i=n; i>=1; i--) {
			
			if(sum % i == 0) {  //<---
			
				int goal = sum/i;  //<---
				int sub = 0;
				boolean ok = true;
				
				for(int j=0; j<n; j++) {
					sub += a[j];
					if(sub > goal) {
						ok=false;
						break;
					}
					if (sub==goal) {
						sub=0;
					}
				}
				
				if(ok) {
					System.out.println(n-i); //<---
					return;
				}
			}
		}
	}
}


