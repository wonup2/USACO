import java.util.*;
import java.io.*;


public class loan {

    static BufferedReader in;
    static PrintWriter out;
    static String file = "loan";
    
    static long N, K, M;
    
    public static void main(String[] args) throws IOException {

        in = new BufferedReader(new FileReader(file+".in"));
        out = new PrintWriter(new File(file +".out"));
                
        init();
        solve();
        
        in.close();
        out.close();        
    }

    static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(in.readLine());
    	N = Long.parseLong(st.nextToken());
    	K = Long.parseLong(st.nextToken());
    	M = Long.parseLong(st.nextToken());
    }
    
    static void solve() {
        long low = 1;
        long high = N;
        long mid = 0;
        long ans = 0;
        
        while(low <= high) {
        	mid = (low + high) / 2;
        	
        	//System.out.println("mid: " + mid + " -- " + check(mid));
        	if(check(mid)) {
        		ans = mid;
        		low = mid + 1;
        	}
        	else {
        		high = mid - 1;
        	}
        }
        System.out.println(ans);
        out.println(ans);
        //1000000000000 100000 1
        //4825
    }
    
    static boolean check(long X) {
    	long days = 0;
    	long G = 0;
    	
    	for(long i = 0; i < K; i++) {

    		long Y = (N - G) / X;
    		//System.out.println(Y +" "+ (N-G) +" "+ X);
    		if(Y < M) {
    			days = (N - G + M - 1)/M;
    			System.out.println("days "+days);
    			return days <= K;
    		}
    		G += Y;
    	}
    	return G >= N;
    	
    	/*while(G < N) {
    		//System.out.println(G);
    		double Y = (N - G) * 1.0/X;
    		System.out.println(Y);
    		if(Y < M) {
    			days += Math.ceil((N - G) * 1.0/M);
    			break;
    		}
    		G += (long)Y;
    		days++;
    	}
    	return days <= K;*/
    }
    
}