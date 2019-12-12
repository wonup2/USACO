import java.util.*;
import java.io.*;
public class digitreassemblysen_Hemosoo {
	static Scanner in;
	static String s;
	static int l;
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("sendr"));
		for(int i = 0; i < 5; i++) {
			try {
				init();
				solve();
			}
			catch(Exception e) {
				System.out.println("Error");
			}
		}
		in.close();
	}
	public static void init() {
		s = in.next();
		l = in.nextInt();
	}
	public static void solve() {
		Integer sum = 0;
		int count  = 0;
		 while (count < l) {
		   s += "0";
		   count++;
		 }
		for(int i = 0; i < s.length() - l; i+=l) {
			sum += Integer.parseInt(s.substring(i, i + l));
			
		}
		System.out.println(sum);
		
	}
}
