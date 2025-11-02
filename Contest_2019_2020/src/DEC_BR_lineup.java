import java.io.*;
import java.util.*;

public class DEC_BR_lineup {
	static Scanner in;
	static PrintWriter out;
	
	static int n;
	static HashMap<String, Integer> cow_id;	
	static String[] cows = {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
	static ArrayList<String> permutation, pairs;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new FileReader("lineup.in"));
		out = new PrintWriter(new PrintWriter("lineup.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() throws NumberFormatException, IOException {
		
		cow_id = new HashMap<String, Integer>();
		for(int i = 0; i < 8; i++) cow_id.put(cows[i], i);   
			
		permutation = new ArrayList<String>();
		permute(""); 					
		
		n = in.nextInt(); 
		
		pairs = new ArrayList<String>();
		for(int i = 0; i < n; i++) {
			String c1 = in.next(); 
			in.next(); in.next(); in.next(); in.next();
			String c2 = in.next(); 
			
			pairs.add(cow_id.get(c1) + "" + cow_id.get(c2));
			pairs.add(cow_id.get(c2) + "" + cow_id.get(c1));
		}
	}
	
	static void solve() throws IOException {
		
		String ans = "";
		boolean ok = true;
		
		for(String s:permutation) {
			
			ok = true;
			
			for(int i=0; i<pairs.size(); i++) {
				String p1 = pairs.get(i++);
				String p2 = pairs.get(i);
				if(!s.contains(p1)&&!s.contains(p2)) { ok=false; break; }
			}
			
			if(ok) { ans = s; break; }
		}

		for(int i=0; i<ans.length(); i++)
			out.println(cows[ans.charAt(i)-'0']);
	}
		
	static void permute(String s) {
		
		if(s.length()==8) permutation.add(s); 			
		
		for(int i=0; i<8; i++) 
			if(!s.contains(i+"")) permute(s+i);
	}
}

