import java.util.*;
 
public class US_BR_Acowdemia2 {
 
	static Scanner in;
	static int n, k;
	static char ans[][];
	static String a[];
	static HashMap<String, Integer> m;
	
    public static void main(String[] args) {       
        
        in = new Scanner(System.in);
        init();
        solve();
    }
    
    static void init() {
    	k = in.nextInt();
    	n = in.nextInt();
    	ans = new char[n][n];
    	
    	for(int i=0; i<n; i++) {
    		Arrays.fill(ans[i], '?');
    		ans[i][i] = 'B';
    	}
    	
    	m = new HashMap<String, Integer>();
    	for(int i=0; i<n; i++) m.put(in.next(), i);
    	
		//System.out.println(m);
		in.nextLine();
    }
    
    static void solve() {    	
    	
    	for(int x=0; x<k; x++) {
    		a = in.nextLine().split(" ");
    		//System.out.println(Arrays.toString(a));
    		
    		for(int i=0; i<n; i++) {
    			boolean sort = true;     
    			
        		for(int j=i+1; j<n; j++) {   

        			if(a[j-1].compareTo(a[j]) >0) sort=false;
        			if(!sort) {
        				int c1 = m.get(a[i]);
        				int c2 = m.get(a[j]);
        				//System.out.println(c1+" "+c2);
        				ans[c1][c2] = '0';
        				ans[c2][c1] = '1';
        			}
        		}
        	}
    	}
    	
    	//System.out.println(Arrays.deepToString(ans));
    	
    	for(int i=0; i<n; i++) {
    		for(int j=0; j<n; j++) {
    			System.out.print(ans[i][j]);
    		}
    		System.out.println();
    	}
    
    	
    	
    }
}

/*
2 3
elsie mildred dean
elsie mildred dean
elsie dean mildred
*/