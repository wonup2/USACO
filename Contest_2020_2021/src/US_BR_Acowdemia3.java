
import java.util.*;
public class US_BR_Acowdemia3 {
    static Scanner in;
    static int n, m, ans;
    static char a[][];
    static int dx[] = {0,0,-1,1};
    static int dy[]= {-1,1,0,0};
    public static void main(String[] args){
       in = new Scanner(System.in);
       init();
       solve();
    }
    
    static void init() {
    	n = in.nextInt();
    	m = in.nextInt();
    	a = new char[n][]; 
    	
    	for(int i=0; i<n; i++) a[i] = in.next().toCharArray();

    }
    
    static void solve() {
		HashSet<String> pair = new HashSet<String>();

    	for(int i=0; i<n; i++) {
    		for(int j=0; j<m; j++) {
    			if(a[i][j] =='G') {
    				
    				HashSet<String> v = new HashSet<String>();
    				for(int k=0; k<4; k++) {
    					int nx = i+dx[k]; //System.out.println(nx);
    					int ny = j+dy[k]; //System.out.println(ny);
    					if(nx>=n || ny>=m || nx <0 || ny < 0) continue;
    					if(a[nx][ny]=='C') v.add(nx +":"+ny);
    				}
    				System.out.println(i+" "+j+" "+v);
    				
    				if(v.size()>2) {ans++; continue;}
    				
    				if(v.size()==2) pair.addAll(v);
    			}
    		}
    	}
    	
    	System.out.println(pair);
    	System.out.println(ans);
    	System.out.println(pair.size());
    }
}