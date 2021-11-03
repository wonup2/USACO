import java.util.*;
 
public class US_BR_acow3  {
    static Scanner in;
    static int n, m, cnt;
    static char a[][];
    static int dx[]= {-1, 1, 0, 0};
    static int dy[]= {0, 0, -1, 1};
    static HashMap<Integer, Integer> map;
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
     	map = new HashMap<Integer, Integer>();
     	
     	for(int i=0; i<n; i++) 
     		a[i] = in.nextLine().toCharArray();
     	
    }
    
    static void solve() {    	
    	HashMap<Integer, Integer> temp;
    	for(int r=0; r<n; r++) {
    		for(int c=0; c<m; c++) {
    			
    			if(a[r][c]=='G') {
    				System.out.print("G " + r +" " + c+" ");

    				temp = new HashMap<Integer, Integer>();
    				for(int k=0; k<4; k++) {
    					int nr=r+dx[k];
    					int nc=c+dy[k];
    					if(nr<0||nr>=n||nc<0||nc>=m) continue;
    					if(a[nr][nc]=='C') temp.put(nr, nc);
    				}
    				System.out.println(temp);
    				if(temp.size()>2) cnt++;
    				
    				if(temp.size()==2) map.putAll(temp);
    			}
    		}
    	}
    	System.out.println(cnt);
    	System.out.println(cnt+(map.size()+1)/2);
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

