/*
ID: wonup21
LANG: JAVA
TASK: 
*/

import java.io.*;
import java.util.*;

public class template {
	
	static Scanner in;
	static PrintWriter out;
	
	public static void main(String[] args) {
		try {
			in = new Scanner(new File("barn1.in"));
			out = new PrintWriter(new File("barn1.out"));
			init();
			out.println(solve());	
			in.close();
			out.close();		
		} 
		catch(Exception e) {
			e.printStackTrace();
		}		
	}
	
	static void init(){

	}
	
	static String solve() {
		return null;
	}

}
