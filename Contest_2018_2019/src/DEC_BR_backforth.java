
import java.io.*;
import java.util.*;
public class DEC_BR_backforth {
	static int a[], b[], a1[], b1[], n=10;
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new FileReader("backforth.in"));
			out = new PrintWriter(new FileWriter("backforth.out"));
			init();
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}	
	
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
		
	static int solve() {

		Set<Integer> set = new HashSet<Integer>();
		
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
						set.add(result); 
					}
				}			
				//reset
				a = a1.clone();
				b = b1.clone();
			}
		}	
		return set.size();
	}
}
