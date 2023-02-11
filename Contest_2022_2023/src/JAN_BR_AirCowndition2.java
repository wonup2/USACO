import java.util.*;
import java.io.*;

public class JAN_BR_AirCowndition2 {
	
	static Scanner in;
	static int a, b, p, m, N, M, need[], ans;
	static List<String> mask;
	static data v[];
	
	static class data{
		int a, b, p, m;
		data(int i, int j,int k, int l){
			a = i;
			b = j;
			p = k;
			m = l;
		}
	}
    public static void main(String args[]) throws IOException {
        in = new Scanner(System.in);
        init();
        solve();
    }
        
    static void init() {
 	  
  	  N = in.nextInt();
  	  M = in.nextInt();
  	  
  	  need = new int[101];
  	  v = new data[11];  	

 	  for (int i = 0; i < N; i++) 
 	     Arrays.fill(need, in.nextInt(), in.nextInt(), in.nextInt());

  	  for (int i = 0; i < M; i++)
  	    v[i] = new data(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
  	
  	  ans = Integer.MAX_VALUE;
    }
    
    static void solve() {  
    	
    	int num = (int)Math.pow(2,M);
    	
    	for(int i=0; i<num; i++) {
    		
    		String bin = Integer.toBinaryString(i);
    		for(int j=bin.length(); j<M; j++) bin = "0"+bin;

    		check(bin);
    	}

    	System.out.println( ans ); 	     	   
    }
    
	static void check(String mask) {
		
		  int temp[] = need.clone();
		  		
		  int cost = 0;
		  for (int i = 0; i <M ; i++) {
		    if (mask.charAt(i)=='1') continue;
		
		    data cur = v[i];
		
		    for (int j = cur.a; j <= cur.b; j++) 
		    	temp[j] -= cur.p;
		   		
		    cost += cur.m;
		  }
		
		  for (int i = 0; i < 101; i++) if (temp[i] > 0) return;		    
		
		  ans = Math.min(ans, cost);
	}	
}