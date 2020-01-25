/*
ID: wonup21
LANG: JAVA
TASK: ride
*/

import java.util.*;
import java.io.*;

public class ride {

	public static void main(String[] args) throws IOException {
			
		Scanner in = new Scanner(new File("ride.in"));
		PrintWriter out = new PrintWriter(new File("ride.out"));
		
		//input data
		String input[] = new String[2];
		input[0] = in.nextLine();
		input[1] = in.nextLine();
		
		//step 1 - convert input string to integer
		int n1 = convert(input[0]);
		int n2 = convert(input[1]);
				
		//step 2 - compare first input with input
		if(n1==n2) out.println("GO");
		else out.println("STAY");	
				
		out.close();	
	}
	
	static int convert(String s) {
		int result = 1;
		
		for(int i=0; i<s.length(); i++) {
			int n = s.charAt(i)-'A'+1;  //convert character to integer
			result = result * n;
		}
		
		result = result % 47;
		return result % 47;
	}
}
