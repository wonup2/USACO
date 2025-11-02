import java.util.*;
import java.io.*;

public class DEC_BR_LonelyPhoto {
    static Scanner in;
    static int n, cnt;
    static char c[];
    static String s;
    public static void main(String[] args)throws IOException {
        in = new Scanner(System.in);        
        init();
        solve();
    }
    
    static void init() throws IOException {
        n = in.nextInt();
        s = in.next();
        cnt = 0;
    }
    
    static void solve() {

        for(int i = 0; i < n; i++) {
        	int g=0, h=0;
        	for(int j = i; j<n; j++) {
         		if(s.charAt(j)=='G') g++;
         		else h++;
         		      		         		
         		if(j-i<2) continue;
        		if(g==1 || h==1) cnt++;  
        		if(g>1 && h>1) break;
        	} 
        }
        
        System.out.println(cnt);
    }
}