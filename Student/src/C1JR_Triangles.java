import java.util.*;
import java.io.*;

public class C1JR_Triangles {
	static Scanner in;
	static String s;
	
	public static void main(String[] args) throws IOException{
		
		in = new Scanner(new File("0708C1JR.in"));
		
		for(int i = 0; i<5; i++) {
			try{
				init();
				solve(i);
			}catch(Exception e) {
				//e.printStackTrace();
				System.out.println("Error");
			}
		}
		in.close();
	}
	public static void init() {	
		
		s = in.nextLine();

	}
	
	public static void solve(int i) {
		if(i==0) System.out.println(s.length());
		else if(i==1) {
			int sum = 0;
			for(int j=0; j<s.length(); j++) {
				sum += s.charAt(j) - '0';
			}
		}
	}
}
