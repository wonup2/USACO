import java.util.*;
import java.io.*;

public class DEC_BR_Feedcows {
	
	static Scanner in;
	static int t, n, k;
	static String s;
	
    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);
        int t = in.nextInt();
        
        while (t-->0) {
        	init();
        	solve();
        }
    }
    
    static void init() {
    	
    	n=in.nextInt();
    	k=in.nextInt();
    	s=in.next();
    }
    
    static void solve() {    	
            
    	int cnt = 0;
            
    	char[] output = new char[n];
            
    	for(int i=0; i<n; i++) output[i] = '.';
    	
    	int lastG = -k-1, lastH = -k-1;
    	
            
    	for (int i = 0; i < n; i++) {
            
    		if(s.charAt(i)=='G' && i-lastG > k) {
    			lastG = Math.min(i+k, n-1);
    			if(output[lastG] !='.') lastG--;
    			output[lastG] = 'G';
    			cnt++;    					
    		}
    		
    		else if(s.charAt(i)=='H' && i-lastH > k) {
    			lastH = Math.min(i+k, n-1);
    			if(output[lastH] !='.') lastH--;
    			output[lastH] = 'H';
    			cnt++;    					
    		} 
    	}

    	
        System.out.println(cnt);
       	System.out.println(output);
        
    }
}