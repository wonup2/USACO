<<<<<<< HEAD
import java.util.*;

public class DEC_SIL_RP{
		
	static Scanner in;
	static int N, a[][];
	static TreeMap<Integer,Integer> xp, yp;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		
		init();
		solve();
		
		in.close();
	}
	
	static void init() {
		xp = new TreeMap<Integer, Integer>();
		yp = new TreeMap<Integer, Integer>();
		 
		N = in.nextInt();
		a = new int[N+1][N+1];
	  
		for (int i=1; i<=N; i++) {
		    int x = in.nextInt();
		    int y = in.nextInt();
		    xp.put(x, i);
		    yp.put(y, i);
		}
//		System.out.println(xp);
//		System.out.println(yp);
		
	}
	
	static void solve() {

		//ignore useless space 10^9 * 10^9 ---> n*n
		int x[] = new int[N];
		int y[] = new int[N];
		
		int rank=1;
		for(int i:xp.values())
			x[i-1]=rank++;
		rank=1;
		for(int i:yp.values())
			y[i-1]=rank++;
		
//		System.out.println("x: " + Arrays.toString(x));
//		System.out.println("y: " + Arrays.toString(y));
		
		for (int i=0; i<N; i++) 
			a[x[i]][y[i]]++;
//		print(a);

		for (int i=1; i<=N; i++)
		    for (int j=1; j<=N; j++)
		      a[i][j] += a[i-1][j] + a[i][j-1] - a[i-1][j-1];
		  
//		print(a);

		long ans = N+1;
		for (int i = 0; i < N; i++) {
            for (int  j= i + 1; j < N; j++) {
		      int min_x = Math.min(x[i], x[j]);
		      int max_x = Math.max(x[i], x[j]);
		      int min_y = Math.min(y[i], y[j]);
		      int max_y = Math.max(y[i], y[j]);
		      ans += sum(min_x, max_x, 1, min_y) * sum(min_x, max_x, max_y, N);
		      //System.out.println(ans);
            }	
		  }
	  System.out.println(ans);		
	}
	
	static int sum(int min_x, int max_x, int min_y, int max_y) {
        return a[max_x][max_y] - a[min_x - 1][max_y] - a[max_x][min_y - 1] + a[min_x - 1][min_y - 1];
    }
 
	
	static void print(int[][]a) {
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a[0].length; j++) {
    			System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	
    }
}
=======
import java.util.*;

public class DEC_SIL_RP{
		
	static Scanner in;
	static int N, a[][];
	static TreeMap<Integer,Integer> xp, yp;
	
	public static void main(String[] args) {
		in = new Scanner(System.in);
		xp = new TreeMap<Integer, Integer>();
		yp = new TreeMap<Integer, Integer>();
		 
		N = in.nextInt();
		a = new int[N+1][N+1];
	  
		for (int i=0; i<N; i++) {
		    int x = in.nextInt();
		    int y = in.nextInt();
		    xp.put(x, i);
		    yp.put(y, i);
		}
		System.out.println(xp);
		System.out.println(yp);

		int x[] = new int[N];
		int y[] = new int[N];
		
		int rank=1;
		for(int i:xp.values())
			x[i]=rank++;
		
		rank=1;
		for(int i:yp.values())
			y[i]=rank++;
		
		System.out.println(Arrays.toString(x));
		System.out.println(Arrays.toString(y));
		
		for (int i=0; i<N; i++) 
			a[x[i]][y[i]]++;
		print(a);

		for (int i=1; i<=N; i++)
		    for (int j=1; j<=N; j++)
		      a[i][j] += a[i-1][j] + a[i][j-1] - a[i-1][j-1];

		print(a);
		
		long ans = N+1;
		for (int i = 0; i < N; i++) {
            for (int  j= i + 1; j < N; j++) {
		      int min_x = Math.min(x[i], x[j]);
		      int max_x = Math.max(x[i], x[j]);
		      int min_y = Math.min(y[i], y[j]);
		      int max_y = Math.max(y[i], y[j]);
		      ans += sum(min_x, max_x, 1, min_y) * sum(min_x, max_x, max_y, N);
		    }	
		  }
	  System.out.println(ans);		
	}
	
	static int sum(int min_x, int max_x, int min_y, int max_y) {
        return a[max_x][max_y] - a[min_x - 1][max_y] - a[max_x][min_y - 1] + a[min_x - 1][min_y - 1];
    }
 
	
	static void print(int[][]a) {
    	for(int i=0; i<a.length; i++) {
    		for(int j=0; j<a[0].length; j++) {
    			System.out.print(a[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	
    }
}
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
