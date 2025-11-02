import java.io.*;
import java.util.*;
 
public class US_BR_acow1 {

    static BufferedReader in;
	static StringTokenizer st;
	static int n, l;
	static ArrayList<Integer> a;
	
    public static void main(String[] args) throws IOException {
        in = new BufferedReader(new InputStreamReader(System.in));
        init();
        solve();
    }
    
    static void init() throws IOException {
        
    	st = new StringTokenizer(in.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        
        a = new ArrayList<Integer>();
        st = new StringTokenizer(in.readLine());
        for (int j = 0; j < n; j++) {
            a.add(Integer.parseInt(st.nextToken()));
        }
    }
    
    static void solve() {
        Collections.sort(a, Comparator.reverseOrder());
        
        int h = hIndex();

        if (h != n && l != 0) {
            for (int j = h; j >= 0; j--) {
            	a.set(j, a.get(j)+1);
                l--;
                if(l==0) break;
            }
        }

        Collections.sort(a, Comparator.reverseOrder());
        System.out.println(hIndex());
    }
    
    
    static int hIndex() {
     	       
        for(int i=0; i<a.size(); i++) {
        	if(a.get(i)<i+1) return i;
        }
        return a.size();
    }    
}