import java.io.*;
import java.util.*;

public class US_BR_evolution {
	
	static BufferedReader in;
	static PrintWriter out;
	static ArrayList<String>[] c = new ArrayList[25];
	static ArrayList<String> a = new ArrayList<String>();
	static int N;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("evolution.in"));
		out = new PrintWriter(new PrintWriter("evolution.out"));
		N = Integer.parseInt(in.readLine());

		HashSet<String> set = new HashSet<String>();
		for (int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
		    int K = Integer.parseInt(st.nextToken());
			String s;
			c[i] = new ArrayList<String>();
		    for (int j=0; j<K; j++) {		    	
		    	s = st.nextToken();
		    	c[i].add(s);		      
		    	set.add(s);     
		    }	   
		}  
		
		for(String temp: set) a.add(temp);
		
		int M = a.size();
		boolean ok = true;
		for (int a=0; a<M-1; a++) 
		    for (int b=a+1; b<M; b++) 
		      if (check(a, b)) ok = false;		    		  
		 
		if (ok) out.println("yes");
		else out.println("no"); 
		  
		in.close();
		out.close();
	}
 
	static boolean check(int x, int y){
	  int X=0, Y=0, XY=0;

	  for (int i=0; i<N; i++) {
	    boolean has_x = false, has_y = false;
	    for (String s: c[i]) {	    	
	    	if (s.equals(a.get(x))) has_x = true;
	    	if (s.equals(a.get(y))) has_y = true;
	    }
	 
	    if (has_x && has_y) XY++;
	    else if (has_x) X++;
	    else if (has_y) Y++;	    
	  }	
	  return XY>0 && X>0 && Y>0;
	}
}
 
