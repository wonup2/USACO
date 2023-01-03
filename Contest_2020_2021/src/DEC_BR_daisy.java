import java.util.*;
public class DEC_BR_daisy {
    static Scanner in;
    static int n, a[], ans;

    public static void main(String[] args) {
        in = new Scanner(System.in);
        init();
        solve();
        in.close();        
    }
    
    static void init() {
        n = in.nextInt();
        ans = 0;
        a = new int[n];
        for(int i=0; i<n; i++) a[i] = in.nextInt();        
    }    
    
    static void solve() {
    
        for(int start=0; start<n; start++) {
            for(int end=0; end<n; end++) {
                
                double sum = 0;
                for(int k=start; k<=end; k++) sum+=a[k];    
                
                boolean check = false;
                sum /= (end-start+1);
                for(int k=start; k<=end; k++) 
                    if(a[k]==sum) check = true;                
                
                if(check) ans++;
            }
        }        
        System.out.println(ans);
    }
}