import java.util.*;
import java.io.*;
public class JAN_SIL_cowcode {

	static BufferedReader in;
	static PrintWriter out;
	static String word;
	static Long n;
	static ArrayList<Long> list;
	
	public static void main(String[] args) throws IOException {
		in = new BufferedReader(new FileReader(new File("cowcode.in")));
		out = new PrintWriter(new BufferedWriter(new FileWriter("cowcode.out")));
		try {
			init();
			out.println(solve());
			in.close();
			out.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void init() throws IOException {
		StringTokenizer br = new StringTokenizer(in.readLine());
		word = br.nextToken();
		n = Long.parseLong(br.nextToken()) - 1;
		list = new ArrayList<Long>();
		list.add((long)word.length());
	}
	
	public static char solve() {
		long temp = word.length();
		while (temp * 2 < n) {
			temp *= 2;
			list.add(temp);
		}
		Collections.reverse(list);
		while (n >= word.length()) {
			if (list.get(0) < n)
				n = n - list.remove(0) - 1;
			else if (list.get(0) == n)
				n -= 1;
			else
				list.remove(0);
		}
		
		return word.charAt(Integer.parseInt(n+""));		
	}
}
