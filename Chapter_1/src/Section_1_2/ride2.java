package Section_1_2;

import java.util.Scanner;
import java.io.*;
public class ride2 {

	public static void main(String[] args) {

		try {
			Scanner in = new Scanner(new File("ride.in"));
			PrintWriter out = new PrintWriter(new File("ride.out"));
			String s1=in.nextLine(), s2=in.nextLine();
			int r1=1, r2=1;
			for(int i=0; i<s1.length();i++) r1*=s1.charAt(i)-64;
			for(int i=0; i<s2.length();i++) r2*=s2.charAt(i)-64;
			out.println(r1%47==r2%47? "STAY":"GO");
			in.close();
			out.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
