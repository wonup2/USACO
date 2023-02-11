import java.util.*;
import java.io.*;

public class JAN_BR_Leaders {
	
	static Scanner in;
	static int n, a[];
	static String s;
	
    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);
        init();
        solve();
    }
        
    static void init() {
    	n = in.nextInt();
    	s = in.next();
    	a = new int[n];
    	for(int i=0; i<n; i++) a[i] = in.nextInt();
    }
    static void solve() {    	
         
    	ArrayList<Integer> allG = new ArrayList<Integer>();
    	ArrayList<Integer> allH = new ArrayList<Integer>();
    	
    	 
    	   
    }
}