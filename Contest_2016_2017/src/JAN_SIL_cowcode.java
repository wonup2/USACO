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
		n = Long.parseLong(br.nextToken());
		list = new ArrayList<Long>();
		//list.add((long)word.length()+1);
	}
	
	public static char solve() {
		long temp = word.length()+1;
		list.add(temp);
		int i = 1;
		while (temp < n) {
			temp += word.length()*i;
			list.add(temp);
			i++;
		}
		//System.out.println(list);
		Collections.reverse(list);
		//System.out.println(list);
		//System.out.println(n);
		if(n==list.get(0)) {list.remove(0); n--;}
		//System.out.println(list);
		//System.out.println(n);
		
		while (n > word.length()) {
			//System.out.println(n);
			if (list.get(0) < n)
				n = n - list.remove(0);
			else if (list.get(0) == n)
				n -= 1;
			else
				list.remove(0);
		}
		n--;
		//System.out.println(n);

		return word.charAt(Integer.parseInt(n+""));		
	}
}
