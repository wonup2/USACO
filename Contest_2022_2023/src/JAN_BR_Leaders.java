import java.util.*;
import java.io.*;

public class JAN_BR_Leaders {
	
	static Scanner in;
	static int n, a[];
	static String s;
	static boolean isLeaderFirstG, isLeaderFirstH;
	static HashSet<Integer> G, H; 
	
    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);
        init();
        solve();
    }
        
    static void init() {
    	n = in.nextInt();
    	s = in.next();
    	a = new int[n];
    	for(int i=0; i<n; i++) a[i] = in.nextInt()-1;
    	
    	G = new HashSet<Integer>();
    	H = new HashSet<Integer>();
    }
    
    static void solve() {          
    	   	
    	//Are first G and first H leaders? 
    	int fg = s.indexOf('G');
    	int fh = s.indexOf('H');
    	int lg = s.lastIndexOf('G');
    	int lh = s.lastIndexOf('H');
    	
    	if(a[fg] >= lg) G.add(fg);    
    	if(a[fh] >= lh) H.add(fh);

    	
    	//Current list has leaders?
    	for(int i=0; i<n; i++) {    		
    		char c = s.charAt(i);
    		if(c=='G' && H.size()==1 && i<=fh && fh<=a[i]) G.add(i);
    		else if(c=='H' && G.size()==1 && i<=fg && fg<=a[i]) H.add(i);    		
    	}
    	
    	System.out.println(G.size()*H.size());
    }
}