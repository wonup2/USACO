package Section_1_3;
/*
ID: wonup21
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;

public class namenum {

	static BufferedReader in;
	static PrintWriter out;
    static int[] a = {2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,9,9,9};
    static String input;
	
	public static void main(String[] args) {
		try {
			in = new BufferedReader(new FileReader("namenum.in"));
			input = in.readLine();
			in.close();
			in = new BufferedReader(new FileReader("dict.txt"));
			//init();
			
			out = new PrintWriter(new File("namenum.out"));
			out.println(solve());
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	static void solve() throws IOException {
		
		
	}
}
