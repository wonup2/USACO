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
    static String input;
	
	public static void main(String[] args) {
		try {
			in = new BufferedReader(new FileReader("namenum.in"));
			input = in.readLine();
			in.close();
			in = new BufferedReader(new FileReader("dict.txt"));
			//init();
			
			out = new PrintWriter(new File("namenum.out"));
			out.println();
			in.close();
			out.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}

	static void solve() throws IOException {
		
		
	}
}
