import java.util.*;
import java.io.*;
public class DigitReassembly {
	static Scanner in;
	static PrintWriter out;
	
	static String[] input;
	static int groups;
	static int sum;
	
	public static void main(String[] args)throws IOException{
		
		in = new Scanner(new File ("sendr"));
		// Do not use output file. You can use System.out.println();

		for(int i=0; i<5; i++) {
			try {
				init();
				solve();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}	
		in.close();
	}
	
	public static void init() {
		input = in.nextLine().split(" ");
		groups = Integer.parseInt(input[1]);
	}
	
	public static void solve() {
		for(int i = 0; i < input[0].length();i+= groups) {
			
			
			if(i + groups > input[0].length()) {
				String zero = "";
				
				for(int k = 0; k < i+groups- input[0].length();k++) {
					zero += "0";
				}
				
				sum += Integer.parseInt(input[0].substring(i,input[0].length()) + zero );
				
			}else {
				sum += Integer.parseInt(input[0].substring(i,i+groups));
			
			}
		
		}
		System.out.println(sum);
	}
	
	
}
