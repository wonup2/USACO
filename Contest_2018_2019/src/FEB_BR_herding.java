import java.util.*;
import java.io.*;
public class FEB_BR_herding {

	static Scanner in;
	static PrintWriter out;
	static StringTokenizer st;
	static int[] a;
	
	public static void main(String[] args) throws IOException {
		in = new Scanner(new File("herding.in"));
		out = new PrintWriter(new File("herding.out"));
		init();
		solve();					
		in.close();
		out.close();
	}
	
	static void init() throws IOException {		
		
		a=new int[3];
		a[0]=in.nextInt();
		a[1]=in.nextInt();
		a[2]=in.nextInt();
		
		Arrays.sort(a);
	}
	
	static void solve() throws IOException {
		
		if(a[2] == a[0]+2) out.println(0);
		
		else if(a[1] == a[0]+2 || a[2] == a[1]+2) out.println(1);
		
		else out.println(2);
		
		out.println(Math.max(a[1]-a[0], a[2]-a[1])-1);
	}	
}