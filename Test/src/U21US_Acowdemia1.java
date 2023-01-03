
import java.util.*;
public class U21US_Acowdemia1 {
    static Scanner in;
    static int n, l, ans;
    static Integer a[];
 
    public static void main(String[] args){
       in = new Scanner(System.in);
       init();
       solve();
    }
    
    static void init() {
    	n = in.nextInt();
    	l = in.nextInt();
    	a = new Integer[n];
    	
    	for(int i=0; i<n; i++) a[i] = in.nextInt();
    	Arrays.sort(a, Comparator.reverseOrder());    	
    }
    
    static void solve() {
    	
    	ans = 0;
    	for(int i=0; i<n; i++) {
    		if(a[i] >= ans + 1) ans++;
    		else break;
    	}

    	for(int i=ans; i>=0; i--) {
    		if(l==0) break;
    		l--;
    		a[i]++;    		
    	}
    	
    	Arrays.sort(a, Comparator.reverseOrder());
    	
    	ans=0;
    	for(int i=0; i<n; i++) {
    		if(a[i] >= ans + 1) ans++;
    		else break;
    	}
    	
    	System.out.println(ans);
    }
}