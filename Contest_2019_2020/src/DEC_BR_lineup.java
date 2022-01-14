import java.io.*;
import java.util.*;

public class DEC_BR_lineup {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n;
	static HashMap<String, Integer> m1;	
	static String[] m2 = {"0", "Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
	static ArrayList<String> permutation, pairs;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("lineup.in"));
		out = new PrintWriter(new PrintWriter("lineup.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	static void init() throws NumberFormatException, IOException {
		m1=new HashMap<String, Integer>();
		for(int i=1; i<=8; i++) m1.put(m2[i], i);   
		//System.out.println(m1); 
		//{Sue=8, Belinda=2, Blue=6, Betsy=5, Buttercup=7, Bessie=4, Beatrice=1, Bella=3}
			
		permutation = new ArrayList<String>();
		permute("12345678", ""); 					//System.out.println(permutation.size()); //40320
		
		n = Integer.parseInt(in.readLine());		
		pairs = new ArrayList<String>();
		for(int i=0; i<n; i++) {
			String cow[] = in.readLine().split(" ");		
			pairs.add(m1.get(cow[0]) + "" + m1.get(cow[5]));
			pairs.add(m1.get(cow[5]) + "" + m1.get(cow[0]));
		}
		//System.out.println(pairs);  //27, 72, 63, 36, 18, 81
	}
	
	static void solve() throws IOException {
		
		ArrayList<String> list = new ArrayList<String>();
		boolean ok = true;
		
		for(String s:permutation) {
			ok = true;
			for(int i=0; i<pairs.size(); i++) {
				String p1 = pairs.get(i++);
				String p2 = pairs.get(i);
				if(!s.contains(p1)&&!s.contains(p2)) {ok=false; break;}
			}
			if(ok) { list.add(s); break; }
		}
		
		String order = list.get(0); 
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<order.length(); i++)
			ans.append(m2[order.charAt(i)-'0']).append("\n");
		
		out.print(ans);		
	}
		
	private static void permute(String s, String result) {
    	if(s.length() == 0) {
    		permutation.add(result); 		
    		return;
    	}
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		String t = s.substring(0, i) + s.substring(i + 1);
    		permute(t, result + c);
    	}
    }
}

