import java.util.*;
import java.io.*;

public class US_BR_cownomics {

	static BufferedReader in;
	static PrintWriter out;
	static int n, m;
	static char s[][], p[][];
	static boolean hasGene[][];
	public static void main(String[] args) throws IOException {

		in = new BufferedReader(new FileReader("cownomics.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("cownomics.out")));
		init();
		solve();
		in.close();
		out.close();
	}

	static void init() throws IOException {
		StringTokenizer st = new StringTokenizer(in.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		s = new char[n][];
		p = new char[n][];
		for(int i=0; i<n; i++) s[i]=in.readLine().toCharArray();
		for(int i=0; i<n; i++) p[i]=in.readLine().toCharArray();
	}
	static void solve() {
		int ans = 0;
		for(int j=0; j<m; j++)
			if(check(j)) ans++;
		out.println(ans);
	}
	static boolean check(int j) {
		hasGene = new boolean[2][4];
		
		for(int i=0; i<n; i++) {
			if(s[i][j]=='A') hasGene[0][0] = true;
			if(s[i][j]=='C') hasGene[0][1] = true;
			if(s[i][j]=='G') hasGene[0][2] = true;
			if(s[i][j]=='T') hasGene[0][3] = true;
		}
		for(int i=0; i<n; i++) {
			if(p[i][j]=='A') hasGene[1][0] = true;
			if(p[i][j]=='C') hasGene[1][1] = true;
			if(p[i][j]=='G') hasGene[1][2] = true;
			if(p[i][j]=='T') hasGene[1][3] = true;
		}
		System.out.println(Arrays.deepToString(hasGene));
		for(int i=0; i<4; i++) {
			if(hasGene[0][i] && hasGene[1][i]) return false;
		}
		return true;
	}
}
