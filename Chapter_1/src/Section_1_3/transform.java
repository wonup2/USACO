package Section_1_3;
/*
ID: wonup21
LANG: JAVA
TASK: transform
*/
import java.io.*;
import java.util.*;

public class transform {
	static BufferedReader in;
	static PrintWriter out;
	static int n;
	static String before[], after[];

	public static void main(String[] args) {
		try {
			in=new BufferedReader(new FileReader("transform.in"));
			out=new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
			init();
			out.println(solve());
			in.close();
			out.close();

		}catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	static void init() {
		try {
			n = Integer.parseInt(in.readLine());
			before=new String[n];
			after=new String[n];
			for(int i=0; i<n; i++) before[i] = in.readLine();
			for(int i=0; i<n; i++) after[i] = in.readLine();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	static int solve() {		
		int res = 7;
		
		if (Arrays.equals(after,_90(before))) res = 1;
		else if (Arrays.equals(after,_90(_90(before)))) res = 2;
		else if (Arrays.equals(after,_90(_90(_90(before))))) res = 3;
		else if (Arrays.equals(after,flip(before))) res = 4;
		else if (Arrays.equals(after,_90(flip(before)))) res = 5;
		else if (Arrays.equals(after,_90(_90(flip(before))))) res = 5;
		else if (Arrays.equals(after,_90(_90(_90(flip(before)))))) res = 5;
		else if (Arrays.equals(after,before)) res = 6;

		return res;
	}

	//[123, 456, 789]  --> [741, 852, 963]
	static String[] _90(String[] s) {

		String result[]=new String[n];
		Arrays.fill(result, "");
		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--)
				result[i] += s[j].charAt(i);
		}
		return result;
	}
	
	static String[] flip(String[] s) {
		String result[]=new String[n];
		Arrays.fill(result, "");

		for(int i=0; i<n; i++) {
			for(int j=n-1; j>=0; j--)
				result[i] += s[i].charAt(j);
		}
		return result;
	}
}
