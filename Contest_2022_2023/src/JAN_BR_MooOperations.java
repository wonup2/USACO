import java.util.*;
import java.io.*;

public class JAN_BR_MooOperations {
	
	static Scanner in;
	static int n, ans;
	static String s;
	
    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);
    	n=in.nextInt();    	
    	while(n-->0) solve();        
    }
        
    static void solve() {    	
            
    	ans = 0;
    	s = in.next();
    	if(s.indexOf("MOO")!=-1) ans = s.length()-3;
    	else if(s.indexOf("OOO")!=-1 || s.indexOf("MOM")!=-1)
    		ans = s.length()-3+1;
    	else if(s.indexOf("OOM")!=-1) ans = s.length()-3+2;
    	else ans = -1;
    	
        System.out.println(ans);        
    }
}