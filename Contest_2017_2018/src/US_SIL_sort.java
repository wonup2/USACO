import java.io.*;
import java.util.*;
public class US_SIL_sort {
	static int[] A, B;
	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(new File("sort.in"));
	     PrintWriter out = new PrintWriter(new File("sort.out"));

	     int N = in.nextInt();
	     A = new int[N];
	     B = new int[N];

	     for(int i=0; i<N; i++){
	    	 A[i] = in.nextInt();
	    	 B[i] = A[i];
	     }
	     
	     Arrays.sort(B);
	     
	     int moo = 0; 
	     for(int i=0; i<A.length; i++){	   
	    	 moo = Math.max(moo, i-Arrays.binarySearch(B, A[i]));
	     }    
	     
	     out.println(moo+1);
	     out.close();
	     in.close();
	}
	
//	static int binarySearch(int target){
//		int first = 0; 
//		int end = B.length-1;
//		
//		while(first < end){
//			int mid = (first + end)/2;
//			//System.out.println(B[mid]);
//			if(target == B[mid]) return mid;
//			else if(target > B[mid]) first = mid+1;			
//			else end = mid - 1;
//		}
//		return end;
//	}
}
