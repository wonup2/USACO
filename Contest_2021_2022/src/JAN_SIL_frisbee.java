import java.util.*;
import java.io.*;

public class JAN_SIL_frisbee{
	static BufferedReader in;
	static int n, a[];
	static long ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	    in = new BufferedReader(new InputStreamReader(System.in));
	    n = Integer.parseInt(in.readLine());
	    a = new int[n];
	    StringTokenizer st = new StringTokenizer(in.readLine());
	    for(int i=0; i<n; i++) a[i] = Integer.parseInt(st.nextToken());
	    
	    solve();
	    int b[] = a.clone();
	    for(int i=0; i<n; i++) a[i] = b[n-1-i];
	    solve();

	    System.out.println(ans);
	    
	    in.close();
	}
	
	static void solve() {
		
	   Stack<Integer> st = new Stack<Integer>();
	   
	   for(int i=0; i<n; i++) {
		   
		   while(!st.empty() && a[st.peek()] < a[i]) st.pop(); 
		   
		   if(!st.empty()) ans+=i-st.peek()+1; 	
		   
		   st.push(i);
	   }
	}
}