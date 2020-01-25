import java.util.*;
import java.io.*;

public class JAN_BR_photo {

	static BufferedReader in;
	static PrintWriter out;
	static int n, a[];
	static String num="";
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("photo.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws NumberFormatException, IOException {
		n=Integer.parseInt(in.readLine());
		a=new int[n];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i=0; i<n-1; i++) {
			a[i]=Integer.parseInt(st.nextToken());
			num+=(i+1);
		}
		num+=n;
	}
	static void solve() {
		permute(num, "");
	}
	
	static boolean check(String s) {
		for(int i=1; i<n-1; i++) {
			int x = s.charAt(i)-'0';
			int y = s.charAt(i+1)-'0';
			if(x+y!=a[i]) return false;
		}
		return true;
	}
	
	private static void permute(String string, String result) {

	    if(string.length() == 0) {
	    	StringBuilder sb= new StringBuilder();
	    	sb.append(result.substring(0,1));
	    	if (check(result)){	    		
	    		for(int i=1; i<n; i++) {
	    			sb.append(" ").append(result.charAt(i)+"");
	    		}
	    		out.println(sb);
	    		return;
	    	}	    	
	    }
	    for(int i = 0; i < string.length(); i++) {
	    	char c = string.charAt(i);
	    	String s = string.substring(0, i) + string.substring(i + 1);
	    	result+=c;

	    	if(result.length()>1 && result.length()%2==0) {		
	    		System.out.println(string+" "+result);

				int x = result.charAt(result.length()-1)-'0';
				int y = result.charAt(result.length()-2)-'0';
				System.out.println(x+" "+y+" "+a[result.length()-2]);
				if(x+y!=a[result.length()-2]) {
					System.out.println("return");
					return;
			    }
			}	
	    	permute(s, result);

	    }
	}
}
