import java.io.*;
import java.util.*;

public class US_BR_evolution {
	
	static Scanner in;
	static PrintWriter out;
    static String filename = "evolution";

	static ArrayList<String>[] c;
	static ArrayList<String> a = new ArrayList<String>();
	static HashSet<String> set;
	static int n;

	static void init(){
		n = in.nextInt();
		
		set = new HashSet<String>();		
		c = new ArrayList[n];
		
		for (int i=0; i<n; i++) {
			
		    int K = in.nextInt();
			c[i] = new ArrayList<String>();
		    for (int j=0; j<K; j++) c[i].add(in.next());
		    set.addAll(c[i]);
		}  
		a.addAll(set);	
		
		//System.out.println(Arrays.toString(c));
		//System.out.println(a);		
	}
	
	static void solve() {
		
			
		boolean ok = true;
		
		for (int i=0; i<a.size(); i++) 
		    for (int j=i+1; j<a.size(); j++) 
		      if (check(i, j)) ok = false;		    		  
		 
		if (ok) out.println("yes");
		else out.println("no"); 
	}
 
	static boolean check(int x, int y){
		
		int X=0, Y=0, XY=0;
		
		for (int i=0; i<n; i++) {
		  
			boolean has_x = false, has_y = false;
	    
			for (String s: c[i]) {	    	
				if (s.equals(a.get(x))) has_x = true;
				if (s.equals(a.get(y))) has_y = true;
			}
	 
			if (has_x && has_y) XY++;
			else if (has_x) X++;
			else if (has_y) Y++;	    
		}	
	  
		System.out.println(a.get(x)+" "+a.get(y)+" "+XY+" "+X+" "+Y);
		return XY>0 && X>0 && Y>0;
	}
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader(filename+".in"));
		out = new PrintWriter(new PrintWriter(filename+".out"));

		init();
		solve();	
		in.close();
		out.close();			
	}
}
 
