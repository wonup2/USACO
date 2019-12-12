import java.util.*;
import java.io.*;

public class JAN_BR_shell {

	static Scanner in;
	static PrintWriter out;
	static int a[], b[], g[], n;
	public static void main(String[] args) {
		init();
		solve();
		in.close();
		out.close();
	}
	
	static void init() {
		try {
			in=new Scanner(new File("shell.in"));
			out=new PrintWriter(new File("shell.out"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		n=in.nextInt();
		a=new int[n]; b=new int[n]; g=new int[n];
		
		for(int i=0;i<n;i++) {
			a[i]=in.nextInt();
			b[i]=in.nextInt();
			g[i]=in.nextInt();
		}
	}

	static void solve() {
		int max = point(1);
		max=Math.max(max,point(2));
		max=Math.max(max,point(3));
		out.println(max);
	}
	
	static int point(int sh) {
		int p=0;
		for(int i=0;i<n;i++) {
			if(a[i]==sh) sh=b[i];
			else if(b[i]==sh) sh=a[i];
			p+= (sh==g[i])?1:0;
		}
		return p;
	}
}
