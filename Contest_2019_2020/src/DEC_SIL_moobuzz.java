import java.util.*;
import java.io.*;

public class DEC_SIL_moobuzz {
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("moobuzz.in"));
		PrintWriter out = new PrintWriter(new File("moobuzz.out"));
		
		int[] a = {14, 1, 2, 4, 7, 8, 11, 13};
		int n = in.nextInt();
		int ans = 0;
		
		int mult = n / 8;
		int mod = n % 8;
		
		if(mod==0) mult--;	  
	    
		ans = (mult * 15) + a[mod];
	    out.println(ans);
	    
		out.close();
		in.close();
	}

}
