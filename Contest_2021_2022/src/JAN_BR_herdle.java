import java.util.*;
import java.io.*;

public class JAN_BR_herdle {

	static BufferedReader in;
	static char a[][], b[][];
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}
	
	static void init() throws IOException {
		a = new char[3][3];
	    for (int i = 0; i < 3; i++)
           a[i]=in.readLine().toCharArray();	        
	        
	    b = new char[3][3];
	    for (int i = 0; i < 3; i++)
	    	b[i]=in.readLine().toCharArray();	  
	    
	}
	
	static void solve() {
		int ans[] = new int[26];
		int guess[] = new int[26];
		    
		int green = 0, yellow = 0;
		
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (a[i][j] == b[i][j]) green++;
	            else{	            
	            	ans[a[i][j] - 'A']++;
	            	guess[b[i][j] - 'A']++;
	            }
	        }
	    }
	    
	    for (int i = 0; i < 26; i++)
	    	yellow += Math.min(ans[i], guess[i]);
	    
	    System.out.println(Arrays.toString(ans));
	    System.out.println(Arrays.toString(guess));

	    System.out.println(green);
	    System.out.println(yellow);
	}
}