package Section_1_2;
import java.util.*;
import java.io.*;

public class ride {

	static Scanner in;
	static PrintWriter out;
	static String input[];
	
	static String result; 
	
	public static void main(String[] args) {

		try {
			
			in = new Scanner(new File("ride.in"));
			out = new PrintWriter(new File("ride.out"));
			
			init();
			result = solve();
			
			out.println(result);
			
			in.close();
			out.close();
		
		} 
		catch(Exception e) {
			System.out.println(e);
		}		
	}
	

	static void init(){
		input = new String[2];
		input[0] = in.nextLine();
		input[1] = in.nextLine();
	}
	
	static String solve() {
		
		//step 1 - convert input string to integer
		int n1 = convert(input[0]);
		int n2 = convert(input[1]);
		
		//step 2 - compare first input with input
		if(n1==n2) return "GO";
		else return "STAY";		
	}
	
	static int convert(String s) {
		int n = 1;
		for(int i=0; i<s.length(); i++) {
			n*=(s.charAt(i)-'A'+1);
		}
		return n%47;
	}
}
