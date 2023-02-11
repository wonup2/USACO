import java.util.*;

public class JAN_BR_drought {
	
	static Scanner in;
	static int t, n;
	static long a[];
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		t=in.nextInt();
		while(t-->0) {
			init();
			solve();
		}
	}
	
	static void init() {
        n = in.nextInt();
        n += 2;
        a = new long[n];
        for (int i = 1; i < n - 1; i++)
            a[i] = in.nextLong();	        
    }
	       
	static void solve() {
		
		long change = 0, diff=0;
	    boolean works = true;
	        
	    for (int i = 2; i < n - 1; i++) {
	        	
	        if (a[i - 1] < a[i]){
	            diff = a[i] - a[i - 1];
	            a[i] -= diff;
	            a[i + 1] -= diff;
	                
	            if (a[i + 1] < 0) works = false;
	                
	            change += diff * 2;
	        }
	        
	        else if (a[i - 1] > a[i]) {
	        	diff = a[i - 1] - a[i];
	            change += diff * (i - 1);
	                
	            works = i % 2 == 1; 
	        }
	            
	        if(!works) break;
	    }	        
	        
	    if (works) System.out.println(change);
	    else System.out.println(-1);	    
	}
}
