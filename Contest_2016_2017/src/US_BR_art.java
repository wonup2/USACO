import java.util.*;
import java.io.*;

public class US_BR_art {

    static Scanner in;        
    static PrintWriter out;
    static String filename = "test";
    static int n, a[][], minX[], minY[], maxX[], maxY[], ans;
    static HashSet<Integer> paint;
    
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
    	minX = new int[10];
    	minY = new int[10];
    	maxX = new int[10];
    	maxY = new int[10];
    	paint = new HashSet<Integer>();
    	
    	Arrays.fill(minX, 10);
    	Arrays.fill(maxX, -1);
    	Arrays.fill(minY, 10);
    	Arrays.fill(maxY, -1);
    	
    	for(int i=0; i<n; i++) {
    		char c[] = in.next().toCharArray();
    		
    		for(int j=0; j<n; j++) {
    			int num = c[j]-'0';
    			a[i][j] = num;
    			//2: (0,0) - (0,1)
    			//3: (0,2) - (1,2)
    			//7: (1,1) - (2,3)
    			minX[num] = Math.min(minX[num], i);
    			maxX[num] = Math.max(maxX[num], i);
    			minY[num] = Math.min(minY[num], j);
    			maxY[num] = Math.max(maxY[num], j);
    			
    			if(num!=0) paint.add(num);    		
    		}
    	}
    	
    	/*
    	System.out.println(Arrays.toString(minX));    	
    	System.out.println(Arrays.toString(minY));
    	System.out.println(Arrays.toString(maxX));
    	System.out.println(Arrays.toString(maxY));
    	*/

    }
    
    static void solve() throws IOException {
    	
    	for(int k=1; k<=9; k++) {
    		
    		if(maxX[k]==-1) continue;
    	
    		for(int i=minX[k]; i<=maxX[k]; i++) 
    			for(int j=minY[k]; j<=maxY[k]; j++)    	
    				
    				if(a[i][j]!=k && paint.contains(a[i][j])) 
    					paint.remove(a[i][j]);    				
    			
    	}    	

    	out.println(paint.size());    	
    }
}