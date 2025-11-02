<<<<<<< HEAD
import java.util.*;
import java.io.*;

public class DEC_SIL_cowntagion {
	
	static BufferedReader in;
	static StringTokenizer st;
    static int n, a[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
		in.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n=Integer.parseInt(in.readLine());
		a = new int[n];
		
		for(int i=0;i<n-1;i++)	{    
			st = new StringTokenizer(in.readLine());
    		a[Integer.parseInt(st.nextToken())-1]++; 
    		a[Integer.parseInt(st.nextToken())-1]++;
    	}
	}
	
	static void solve() {
		
		int ans = n-1;  //total path 
    	ans += (int)(Math.ceil(Math.log(a[0]+1) / Math.log(2)));  // total Cowid-19 of farm 1  cow 1 + children
    	
    	for(int i=1;i<n;i++) 
    		ans += (int)(Math.ceil(Math.log(a[i]) / Math.log(2))); //자식만큼만 있으면 됨
    	
    	System.out.println(ans);
	}
}
=======
import java.util.*;
import java.io.*;

public class DEC_SIL_cowntagion {
	
	static BufferedReader in;
	static StringTokenizer st;
    static int n, a[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		in = new BufferedReader(new InputStreamReader(System.in));
		init();
		solve();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		n=Integer.parseInt(in.readLine());
		a = new int[n];
		
		for(int i=0;i<n-1;i++)	{    
			st = new StringTokenizer(in.readLine());
    		a[Integer.parseInt(st.nextToken())-1]++; 
    		a[Integer.parseInt(st.nextToken())-1]++;
    	}
	}
	
	static void solve() {
		
    	int ans = n-1;  //total path 
    	ans += (int)(Math.ceil(Math.log(a[0]+1) / Math.log(2)));  // total Cowid-19 of farm 1  cow 1 + children
    	
    	for(int i=1;i<n;i++) 
    		ans += (int)(Math.ceil(Math.log(a[i]) / Math.log(2))); //자식만큼만 있으면 됨
    		
    	System.out.println(ans);
	}
}






>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
