import java.io.*;
import java.util.*;

public class DEC_BR_backforth {
	static int a[], b[], a1[], b1[], n=10;
	static Scanner in;
	static PrintWriter out;		
	
	static void init() {
		a = new int[n];
		b = new int[n];
		a1 = new int[n];
		b1 = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
			a1[i] = a[i];
		}
		
		for(int i=0; i<n; i++) {
			b[i] = in.nextInt();
			b1[i] = b[i];
		}		
	}
		
	static void solve() {

		Set<Integer> ans = new HashSet<Integer>();
		
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				
				//Tue, Wed
				int first = 1000 - a[i] + b[j];
				int temp = a[i];
				a[i]=b[j];
				b[j]=temp;			
				
				//Thur, Fri
				for(int k=0; k<n; k++){
					for(int m=0; m<n; m++){
						int result = first - a[k] + b[m] ;			
						ans.add(result); 
					}
				}			
				
				//reset
				a = a1.clone();
				b = b1.clone();
			}
		}	
		out.println (ans.size());
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("backforth.in"));
		out = new PrintWriter(new FileWriter("backforth.out"));
		init();
		solve();
		in.close();
		out.close();
	}	
}
