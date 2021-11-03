import java.io.*;
import java.util.*;
 
public class US_SIL_acow {
	static BufferedReader in;
    static StringTokenizer st;
    static int n, k, l;
    static Integer[] a;
    public static void main(String[] args) throws IOException {
    	in = new BufferedReader(new InputStreamReader(System.in));
    	st = new StringTokenizer(in.readLine());
    	
    	init();
    	solve();
    }
    
    static void init() throws IOException {
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        a = new Integer[n];
        st = new StringTokenizer(in.readLine());
        for (int j = 0; j < n; j++) {
            a[j] = Integer.parseInt(st.nextToken());
        }        
        Arrays.sort(a, Comparator.reverseOrder());

    }
    
    static void solve() {
        int high = n;
        int low = 0;
        int ans = 0;
        while (low <= high) {
            int mid = (high + low) / 2;
            
            if(check(mid)) {
            	ans = mid;
            	low = mid + 1;
            }
            else high = mid - 1;          
            
        }
        System.out.println(ans);
    }
    
    static boolean check(int mid) {    	
    
    	 long s = 0l;
         
         for (int j = 0; j < mid; j++) {
             s += mid - a[j] > 0 ? mid - a[j]:0;
         }
         
         return (s <= ((long) k) * ((long) l) && a[mid - 1] + k >= mid) ;
    }
}