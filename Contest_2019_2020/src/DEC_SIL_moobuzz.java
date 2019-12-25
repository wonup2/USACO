import java.util.*;
import java.io.*;

public class DEC_SIL_moobuzz {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("moobuzz.in"));
		PrintWriter out = new PrintWriter(new File("moobuzz.out"));
		
		//input
		int[] a = {0, 1, 3, 6, 7, 10, 12, 13, 15};
		int n = in.nextInt();
		
		int line = n/8;	if(n % 8 == 0) line--;		
		int first = 15 * line + 1; 
		int index = 8 * line + 1;  
		
		//System.out.println(line+" "+first+" "+index +" " + (n-index));
				
		out.println(first + a[n-index]);

		out.close();
		in.close();
	}

}
