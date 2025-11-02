import java.util.*;
import java.io.*;

public class US_BR_art {

    static Scanner in;        
    static PrintWriter out;
    static String filename = "art";
    static int n, a[][], minX[], minY[], maxX[], maxY[], ans;
    static boolean possible[];
    
    public static void main(String[] args) throws IOException {

        in = new Scanner(new File(filename+".in"));        
        out = new PrintWriter(new File(filename+".out")); 
        init();
        solve();
        
        in.close();
        out.close();
    }
    
    static void init() throws IOException {    

    	n = in.nextInt();
    	a = new int[n][n];
    	minX = new int[n*n+1];
    	minY = new int[n*n+1];
    	maxX = new int[n*n+1];
    	maxY = new int[n*n+1];
    	possible = new boolean[n*n+1];
    	
    	Arrays.fill(minX, n*n+1);
    	Arrays.fill(maxX, -1);
    	Arrays.fill(minY, n*n+1);
    	Arrays.fill(maxY, -1);
    	
    	for(int i=0; i<n; i++) {
    		char c[] = in.next().toCharArray();
    		for(int j=0; j<n; j++) {
    			int num = c[j]-'0';
    			a[i][j] = num;
    			minX[num] = Math.min(minX[num], i);
    			maxX[num] = Math.max(maxX[num], i);
    			minY[num] = Math.min(minY[num], j);
    			maxY[num] = Math.max(maxY[num], j);
    			if(!possible[num] && num!=0)ans++;
    			possible[num] = true; 
    		
    		}
    	}
    }
    
    static void solve() throws IOException {
    	
    	for(int k=1; k<n*n+1; k++) {
    		
    		if(maxX[k]==-1) continue;
    	
    		for(int i=minX[k]; i<=maxX[k]; i++) {
    			for(int j=minY[k]; j<=maxY[k]; j++) {    				
    				if(a[i][j]!=k && possible[a[i][j]]) {
    					possible[a[i][j]] = false;
    					ans--;
    				}
    			}    			
    		}
    	}
    	
    	out.println(ans);    	
    }
}