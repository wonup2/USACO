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
<<<<<<< HEAD

	     for(int i=0; i<A.size(); i++){	 
	    	 int n = A.get(i);
	    	 int indA = A.lastIndexOf(n);
	    	 int indB = B.lastIndexOf(n);
	    	 moo = Math.max(moo, indA-indB);	    
=======
	     double num = 0.1;
	     for(int i=0; i<A.length; i++){	   

	    	 int index = Arrays.binarySearch(B, A[i]);
	    	 moo = Math.max(moo, i-index);
	    	// A[i] = A[i]-0.1;
	    	 if(index<B.length-1 && B[index]==B[index+1]) B[index] = B[index]-num;
	    	 else if(index>0&& B[index]==B[index-1]) B[index] = B[index]+num;

	    	 num*=num;
	    	// System.out.println(Arrays.toString(B));
	    	 
>>>>>>> 388f3d499ba7c96f308eccd4184b945931759f27
	     }    
	     
	     out.println(moo+1);
	     out.close();
	     in.close();
	}
}
