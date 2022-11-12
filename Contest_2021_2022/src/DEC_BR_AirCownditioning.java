import java.util.*;
import java.io.*;

public class DEC_BR_AirCownditioning {
    static Scanner in;
    static int n, a[], ans;
    static String s;
    public static void main(String[] args)throws IOException {
        in = new Scanner(System.in);        
        init();
        solve();
    }
    
    static void init() throws IOException {
    	
        n = in.nextInt();
        a = new int[n+2];
        
        for(int i=1; i<=n; i++) 
        	a[i] = in.nextInt();
        
        for(int i=1; i<=n; i++) 
        	a[i] = a[i]-in.nextInt();
        
        ans = 0;
        
        System.out.println(Arrays.toString(a));
    }
    
    static void solve() {

        for(int i = 0; i <= n; i++) {
        	ans+= Math.abs(a[i]-a[i+1]);
        	System.out.println(Math.abs(a[i]-a[i+1])+" ");
        }
        
        System.out.println(ans/2);
    }
}