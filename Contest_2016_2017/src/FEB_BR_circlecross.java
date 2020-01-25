import java.io.*;
import java.util.*;
public class FEB_BR_circlecross {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new FileReader("circlecross.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("circlecross.out")));
		
		String a = in.readLine();
		
		int first = 0;
		int last = 0;
		int result = 0;
		HashSet<Character> letter = new HashSet<Character>();
		for(int i='A' ; i<='Z'; i++){
			first = a.indexOf(i);
			last = a.lastIndexOf(i);			
			String t = a.substring(first+1, last);			
			for(int j=0; j<t.length(); j++)	letter.add(t.charAt(j));
			result+=letter.size()-(t.length()-letter.size());
			letter.clear();
		}
				
		out.println(result/2);
		out.close();
		in.close();
	}
}