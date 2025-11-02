import java.util.*;
import java.io.*;


public class _18US_BR_tttt {

	static Scanner in;
	//static BufferedReader in;
	//static StringTokenizer st;
	static PrintWriter out;
	static String file = "tttt";
	static char[][] a;
	static TreeSet<Character>[] b;
	
	public static void main(String[] args) throws IOException {

		//in = new BufferedReader(new FileReader(file + ".in"));
		
		in = new Scanner(new File(file+".in"));
		out = new PrintWriter(new File(file+".out"));
		
		init();
		solve();
		
		in.close();
		out.close();
	}

	static void init() {
		
		a = new char[3][3];
		
		for(int i=0;i<3;i++) a[i] = in.next().toCharArray();
		
		b = new TreeSet[8];
		for(int i=0; i<8; i++) b[i] = new TreeSet<Character>();
	}
	
	static void solve() {
		
		int idx = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				b[idx].add(a[i][j]);
				b[idx+3].add(a[j][i]);
			}
			idx++;
			b[6].add(a[i][i]);
			b[7].add(a[i][2-i]);
		}
		
		//System.out.println(Arrays.toString(b));
		
		HashSet<Character> one = new HashSet<Character>();
		HashSet<String> two = new HashSet<String>();
		
		for(int i=0; i<8; i++) {
			if(b[i].size()==1) one.add(b[i].first());
			else if(b[i].size()==2) two.add(b[i].first()+""+b[i].last());
		}
		
		out.println(one.size());
		out.println(two.size());

	}
}
