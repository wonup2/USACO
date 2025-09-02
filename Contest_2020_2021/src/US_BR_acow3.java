import java.util.*;
 
public class US_BR_acow3  {
    static Scanner in;
    static int n, m, cnt;
    static char a[][];
    static int dx[]= {-1, 1, 0, 0};
    static int dy[]= {0, 0, -1, 1};
    static HashSet<ArrayList<String>> set;
    public static void main(String[] args) {
    	
    	init();
    	solve();    	
    }
    
    static void init() {
    	in = new Scanner(System.in);
     	n = in.nextInt(); 
     	m = in.nextInt(); in.nextLine(); 
     	cnt = 0;
     	a = new char[n][];
     	set = new HashSet<ArrayList<String>>();
     	
     	for(int i=0; i<n; i++) 
     		a[i] = in.nextLine().toCharArray();     	
    }
    
    static void solve() {    	
    	
    	for(int r=0; r<n; r++) {
    		for(int c=0; c<m; c++) {
    			ArrayList<String> temp;
    			if(a[r][c]=='G') {

					temp = new ArrayList<String>();
    				for(int k=0; k<4; k++) {
    					int nr=r+dx[k];
    					int nc=c+dy[k];
    					
    					if(nr<0||nr>=n||nc<0||nc>=m) continue;
    					if(a[nr][nc]=='C') {
    						//System.out.println(nr+" "+nc);
    						temp.add(nr+" "+nc);
    					}
    				}
    				//System.out.println(r+" "+ c + " " +temp);
    				if(temp.size()>2) cnt++;
    				
    				if(temp.size()==2) {
    					Collections.sort(temp);
    					set.add(temp);
    				}
    			}
    		}
    	}
    	
    	//System.out.println(set);
    	System.out.println(cnt+ set.size());
    }
    
    static class pair {
    	int r,c;
    	pair(int x, int y){
    		r=x; y=c;
    	}
    	public String toString() {
    		return r+" "+c;
    	}
    }
}

