import java.util.*;
public class ReverseEngineering {
	static Scanner in;
	static boolean ok;
	static int n, m, t, b[];
	static char a[][];
	static boolean split, c[];
	
	public static void main(String[] args) {

		in = new Scanner(System.in);
		t = in.nextInt(); in.nextLine();
		
		while(t-->0) {
			init();
			solve();
		}
	}

	static void init() {
		n = in.nextInt();
		m = in.nextInt();

		a = new char[m][];
		b = new int[m];
		c = new boolean[n];
		for(int i = 0; i<m; i++) {
			a[i] = in.next().toCharArray();
			b[i] = in.nextInt();
		}
		split = false;
	}
	static void solve() {

		while(true) {
			split = false;
			
			for(int i=0; i<n; i++) {
				if(
				split(i, '0', 0) ||
				split(i, '0', 1) ||
				split(i, '1', 0) ||
				split(i, '1', 1))
				split = true;
			}
			
			if(!split) {
				System.out.println("LIE");
				break;
			}
			
			if(allSame(0) || allSame(1)) {
				System.out.println("OK");
				break;
			}
			
		}
		
		
		
	}	
	
	static boolean allSame(int test_out) {
		
		for(int i=0; i<m; i++) {
			if(b[i]!=test_out) return false;
		}
		return true;
	}
	
	static boolean split(int i, char ch, int out) {
		
		if(c[i]) return false;
		
		for(int j=0; j<m; j++) {
			if(a[j][i]!=' ' && a[j][i]==ch && b[i] !=out) return false;
		}
		
		c[i] = true;
		
		for(int j=0; j<m; j++)
			if(a[j][i]!=' ' && a[j][i]==ch) Arrays.fill(a[j], ' ');
		
		return true;
	}
}

/*
4

1 3
0 0
0 0
1 1

2 4
00 0
01 1
10 1
11 1

1 2
0 1
0 0

2 4
00 0
01 1
10 1
11 0

*/
