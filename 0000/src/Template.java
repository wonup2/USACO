import java.util.*;
import java.io.*;

public class Template {

	static Scanner in;
	static String s;
	public static void main(String[] args) throws IOException {

		in = new Scanner(new File("temp.in"));
		
		for(int i=0; i<5; i++) {
			
			try {
				init();
				solve(i);
			}
			catch(Exception e) {
				System.out.println("Error");
				//e.printStackTrace();
			}
			
		}		
		in.close();
	}
	
	static void init() {	
		s=in.nextLine();
	}
	
	static void solve(int i) {
		if(i==0) System.out.println(s.length());
		else if(i==1) {
			
		}
	}

}
