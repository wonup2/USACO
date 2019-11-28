import java.io.*;
import java.util.*;
public class JAN_hps_silver {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("hps.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		int n = Integer.parseInt(br.readLine());
		int[] l = new int[n];
		int[] lReverse = new int[n];
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.equals("P")) l[i] = 1;
			else if(s.equals("S")) l[i] = 2;
			lReverse[l.length-1-i] = l[i];
		}
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(lReverse));

		int[][] matchPrefix = getMatch(l); print(matchPrefix);
		int[][] matchSuffix = getMatch(lReverse);  print(matchSuffix);
		//System.out.println(Arrays.deepToString(matchPrefix));
		//System.out.println(Arrays.deepToString(matchSuffix));


		int ret = 0;
		for(int a = 0; a <= n; a++) {
			for(int i = 0; i < 3; i++) {
				for(int j = 0; j < 3; j++) {
					//System.out.println(i+" "+ a+" "+ " "+j +" " + (n-a) +" : " + (matchPrefix[i][a] + matchSuffix[j][n-a]) );
					ret = Math.max(ret, matchPrefix[i][a] + matchSuffix[j][n-a]);
				}
			}
		}
		
		pw.println(ret);
		pw.close();
	}
	
	public static int[][] getMatch(int[] l) {
		int[][] matches = new int[3][l.length+1];
		for(int i = 0; i < l.length; i++) {
			for(int j = 0; j < 3; j++) {
				matches[j][i+1] = matches[j][i];
			}
			matches[l[i]][i+1]++;
		}
		return matches;
	}
	
	
	static void print(int[][]a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j]);
			}
			System.out.println();
		}
			
		
	}
}