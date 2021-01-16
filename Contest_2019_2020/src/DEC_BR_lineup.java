import java.io.*;
import java.util.*;

public class DEC_BR_lineup {
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer st;
	static int n;
	static HashMap<String, Integer> x;	
	static String[] y = {"Beatrice","Belinda","Bella","Bessie","Betsy","Blue","Buttercup","Sue"};
	static ArrayList<String> p;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader("lineup.in"));
		out = new PrintWriter(new PrintWriter("lineup.out"));
		init();
		solve();
		in.close();
		out.close();
	}
	static void init() throws NumberFormatException, IOException {
		x=new HashMap<String, Integer>();
		for(int i=0; i<8; i++) x.put(y[i], i);
			
		p=new ArrayList<String>();
		permute("01234567", ""); 
		n = Integer.parseInt(in.readLine());		
	}
	
	static void solve() throws IOException {
		ArrayList<String> pairs = new ArrayList<String>();
		for(int i=0; i<n; i++) {
			String cow[] = in.readLine().split(" ");		
			pairs.add(x.get(cow[0]) + "" + x.get(cow[5]));
			pairs.add(x.get(cow[5]) + "" + x.get(cow[0]));
		}
		System.out.println(pairs);
		
		ArrayList<String> list = new ArrayList<String>();
		boolean ok = true;
		for(String s:p) {
			for(int i=0; i<pairs.size(); i++) {
				String p1 = pairs.get(i++);
				String p2 = pairs.get(i);
				if(!s.contains(p1)&&!s.contains(p2)) {ok=false; break;}
			}
			if(ok) list.add(s); 
			ok=true;
		}
		
		Collections.sort(list);

		String order = list.get(0); 
		StringBuilder ans = new StringBuilder();
		for(int i=0; i<order.length(); i++)
			ans.append(y[order.charAt(i)-'0']).append("\n");
		
		out.print(ans);		
	}
		
	private static void permute(String s, String result) {
    	if(s.length() == 0) {
    		p.add(result);
    		return;
    	}
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		String t = s.substring(0, i) + s.substring(i + 1);
    		permute(t, result + c);
    	}
    }
}

