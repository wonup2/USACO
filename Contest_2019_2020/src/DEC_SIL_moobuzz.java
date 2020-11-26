import java.util.*;
import java.io.*;

public class DEC_SIL_moobuzz {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("moobuzz.in"));
		PrintWriter out = new PrintWriter(new File("moobuzz.out"));
		
		//input
		int[] a = {0, 1, 3, 6, 7, 10, 12, 13, 15};
		int n = in.nextInt();
		/*
		int line = n/8;	if(n % 8 == 0) line--;		
		int first = 15 * line + 1; 
		int index = 8 * line + 1;  
		
		System.out.println(line+" "+first+" "+index +" " + (n-index));
				
		out.println(first + a[n-index]);
*/
		int ans = 0;
	    int mult = n / 8;
	    int mod = n % 8;
	    switch(mod){
	      case 0: ans = 14; mult--;break;
	      case 1: ans = 1; break;
	      case 2: ans = 2; break;
	      case 3: ans = 4; break;
	      case 4: ans = 7; break;
	      case 5:ans = 8; break;
	      case 6:ans = 11; break;
	      case 7:ans = 13; break;
	    }
	    ans += (mult * 15);
	    System.out.println(ans);
		out.close();
		in.close();
	}

}
