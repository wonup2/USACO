import java.util.*;
import java.io.*;

public class Main {
    
    static Scanner in;
    static int n, m, v[], w[], dp[];
            
    //w = money and v = calories, m = max money
    
    
    public static void main(String[] args) throws IOException{
        in = new Scanner(System.in);

        while(true) {
            n = in.nextInt();
            m = (int)Math.round(in.nextDouble()*100);
            if(n==0 && m==0.0) {
                break;
            }
            w = new int[n];
            v = new int[n];
            for(int i = 0; i < n; i++) {
                v[i] = in.nextInt();
                w[i] = (int)Math.round(in.nextDouble()*100);
            }
            dp = new int[m+1];
            solve();
        }        
    }   
    
    static void solve() {
        for(int i = 1; i <= m; i++) {
            for(int j = 0; j < n; j++) {
                if(w[j]<=i) {
                    dp[i] = Math.max(dp[i], dp[i-w[j]] + v[j]);
                }
            }
        }
        System.out.println(dp[600]);
    }

}