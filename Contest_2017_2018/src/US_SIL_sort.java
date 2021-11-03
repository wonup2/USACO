import java.io.*;
import java.util.*;
public class US_SIL_sort {
	static LinkedList<Integer> A, B;
	public static void main(String[] args) throws IOException {
		 BufferedReader in = new BufferedReader(new FileReader("sort.in"));
	     PrintWriter out = new PrintWriter(new File("sort.out"));

	     int N = Integer.parseInt(in.readLine());
	     A = new LinkedList<Integer>();
	     B = new LinkedList<Integer>();

	     for(int i=0; i<N; i++){
	    	 int temp = Integer.parseInt(in.readLine());
	    	 A.add(temp);
	    	 B.add(temp);
	     }
	     
	     Collections.sort(B);
	     
	     int moo = 0; 

	     for(int i=0; i<A.size(); i++){	 
	    	 int n = A.get(i);
	    	 int indA = A.lastIndexOf(n);
	    	 int indB = B.lastIndexOf(n);
	    	 moo = Math.max(moo, indA-indB);	    
	     }    
	     
	     out.println(moo+1);
	     out.close();
	     in.close();
	}
}
