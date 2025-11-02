import java.io.*;
import java.util.*;
public class JAN_SIL_hps2 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new FileReader("hps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
		
		int n = Integer.parseInt(in.readLine());
		char c[] = new char[n];
		for(int i=0; i<n; i++) c[i] = in.readLine().charAt(0);		
		
		int[][] pre = new int[n][3];
		int[][] suf = new int[n][3];

		for(int i = 0; i < n; i++) {
			if(i>0) {
				for(int j=0; j<3; j++) {
					pre[i][j] = pre[i-1][j];
					suf[n-1-i][j] = suf[n-i][j];	
				}
			}
			if(c[i]=='P') pre[i][0]++;
			else if(c[i]=='H')pre[i][1]++; 
			else pre[i][2]++; 	
			
			if(c[n-1-i]=='P') suf[n-1-i][0]++;
			else if(c[n-1-i]=='H')suf[n-1-i][1]++; 
			else suf[n-1-i][2]++; 	
		}
				
		int ans = 0;
		int maxPre = Math.max(pre[0][0], Math.max(pre[0][1], pre[0][2]));
		int maxSuf = 0;
		
		for(int i = 1; i < n; i++) {
			maxSuf = Math.max(suf[i][0], Math.max(suf[i][1], suf[i][2]));
			ans = Math.max(maxPre+maxSuf, ans);
			maxPre = Math.max(pre[i][0], Math.max(pre[i][1], pre[i][2]));
		}
		
		out.println(ans);
		out.close();
		in.close();
	}	
}