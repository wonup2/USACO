import java.io.*;
import java.util.*;
public class US_SIL_sort {
	static double[] A, B;
	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new File("sort.in"));
	     PrintWriter out = new PrintWriter(new File("sort.out"));

	     int N = in.nextInt();
	     A = new double[N];
	     B = new double[N];

	     for(int i=0; i<N; i++){
	    	 A[i] = in.nextInt();
	    	 B[i] = A[i];
	     }
	     
	     Arrays.sort(B);
	     
	     int moo = 0; 
	     double num = 0.1;
	     for(int i=0; i<A.length; i++){	   

	    	 int index = Arrays.binarySearch(B, A[i]);
	    	 moo = Math.max(moo, i-index);
	    	// A[i] = A[i]-0.1;
	    	 if(index<B.length-1 && B[index]==B[index+1]) B[index] = B[index]-num;
	    	 else if(index>0&& B[index]==B[index-1]) B[index] = B[index]+num;

	    	 num*=num;
	    	// System.out.println(Arrays.toString(B));
	    	 
	     }    
	     
	     out.println(moo+1);
	     out.close();
	     in.close();
	}
}
